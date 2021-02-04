package eu._5gzorro.utils;

import static net.corda.testing.common.internal.ParametersUtilitiesKt.testNetworkParameters;

import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.corda.core.identity.CordaX500Name;
import net.corda.core.identity.Party;
import net.corda.core.node.NetworkParameters;
import net.corda.core.node.NotaryInfo;
import net.corda.testing.node.MockNetwork;
import net.corda.testing.node.MockNetworkParameters;
import net.corda.testing.node.StartedMockNode;
import net.corda.testing.node.TestCordapp;
import org.junit.After;
import org.junit.Before;

public class TwoOperatorTestCase {

  public StartedMockNode telstra;
  public StartedMockNode telefonica;
  public MockNetwork network;
  public Party notary;

  @Before
  public void setup() {
    Map<String, String> map = Stream.of(new String[][]{
        {"apiUrl", "http://localhost:8082"},
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

    List<NotaryInfo> notaryinfo = Arrays.asList();
    // minimum platform version of 4
    NetworkParameters myNetworkParameters = testNetworkParameters(notaryinfo, 4);

    network = new MockNetwork(
        new MockNetworkParameters(
          ImmutableList.of(
            TestCordapp.findCordapp("tech.bartr.contracts"),
            TestCordapp.findCordapp("tech.bartr.oracle").withConfig(map),
            TestCordapp.findCordapp("tech.bartr.flows").withConfig(map)
          )
        ).withNetworkParameters(myNetworkParameters));

    telstra = network.createNode(CordaX500Name.parse("O=Company1,L=Sydney,C=AU"));
    telefonica = network.createNode(CordaX500Name.parse("O=Company2,L=Madrid,C=ES"));

    notary = network.getDefaultNotaryIdentity();
    network.runNetwork();
  }

  @After
  public void tearDown() {
    network.stopNodes();
  }
}
