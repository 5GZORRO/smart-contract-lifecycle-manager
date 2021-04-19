package eu._5gzorro.manager.dlt.corda.utils;

import static net.corda.testing.common.internal.ParametersUtilitiesKt.testNetworkParameters;

import com.google.common.collect.ImmutableList;

import eu._5gzorro.manager.dlt.corda.utils.serialization.CustomSerializationEnvironment;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import net.corda.core.identity.CordaX500Name;
import net.corda.core.identity.Party;
import net.corda.core.node.NetworkParameters;
import net.corda.core.node.NotaryInfo;
import net.corda.testing.node.*;
import net.corda.testing.node.internal.TestCordappInternal;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class TwoOperatorTestCase {

  public StartedMockNode operator1;
  public StartedMockNode operator2;
  public StartedMockNode governanceNode;
  public StartedMockNode didOracle;
  public MockNetwork network;
  public Party notary;

  public Party operator1Party;
  public Party operator2Party;
  public Party governanceParty;

  @BeforeAll
  public void setup() {
    Map<String, String> map =
        Stream.of(
                new String[][] {
                  {"apiUrl", "http://localhost:8082"},
                })
            .collect(Collectors.toMap(data -> data[0], data -> data[1]));

    List<NotaryInfo> notaryinfo = Arrays.asList();
    // minimum platform version of 4
    NetworkParameters myNetworkParameters = testNetworkParameters(notaryinfo, 4);

    network =
        new ExtendedMockNetwork(
            new MockNetworkParameters(
                    ImmutableList.of(
                        TestCordapp.findCordapp("eu._5gzorro.manager.dlt.corda.contracts"),
                        TestCordapp.findCordapp("eu._5gzorro.manager.dlt.corda.flows")
                            .withConfig(map)))
                .withNetworkParameters(myNetworkParameters));

    operator1 = network.createNode(CordaX500Name.parse("O=Operator1,L=Sydney,C=AU"));
    operator2 = network.createNode(CordaX500Name.parse("O=Operator2,L=Madrid,C=ES"));
    governanceNode = network.createNode(CordaX500Name.parse("O=Governance,L=London,C=GB"));

    notary = network.getDefaultNotaryIdentity();
    operator1Party = operator1.getInfo().getLegalIdentities().get(0);
    operator2Party = operator2.getInfo().getLegalIdentities().get(0);
    governanceParty = governanceNode.getInfo().getLegalIdentities().get(0);
    network.runNetwork();
  }

  /**
   * Simply ensures that resetSerializationEnvironment(cordapps) is called after the main
   * mockNetwork is initialised to ensure that custom serializers are loaded correctly
   */
  public class ExtendedMockNetwork extends MockNetwork {
    public ExtendedMockNetwork(@NotNull MockNetworkParameters parameters) {
      super(parameters);

      resetSerializationEnvironment(parameters.getCordappsForAllNodes());
    }
  }

  /**
   * Corda 4.4 MockNetwork implementation does not handle custom CorDapp serializers so reload
   * SerializationEnvironment after MockNetwork is initialised with the correct ClassLoader
   * including the cordapps (this ensures the class whitelist is correctly loaded)
   *
   * @param cordapps List of cordapps that are being used in the MockNetwork so serializers can be
   *     loaded correctly
   * @see <a
   *     href="https://r3-cev.atlassian.net/browse/CORDA-3643">https://r3-cev.atlassian.net/browse/CORDA-3643</a>
   */
  public void resetSerializationEnvironment(@NotNull Collection<TestCordapp> cordapps) {
    URL[] urls =
        cordapps.stream()
            .map(
                app -> {
                  try {
                    return ((TestCordappInternal) app).getJarFile().toUri().toURL();
                  } catch (MalformedURLException e) {
                    e.printStackTrace();
                    return null;
                  }
                })
            .toArray(URL[]::new);

    new CustomSerializationEnvironment(new URLClassLoader(urls));
  }

  @AfterAll
  public void tearDown() {
    network.stopNodes();
  }
}
