package eu._5gzorro.utils;

import static eu._5gzorro.flows.product_offer.ProductOfferingTestUtils.publishProductOffering;
import static net.corda.testing.common.internal.ParametersUtilitiesKt.testNetworkParameters;

import com.google.common.collect.ImmutableList;
import eu._5gzorro.models.types.OfferType;
import eu._5gzorro.states.ProductOffering;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.corda.core.contracts.UniqueIdentifier;
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
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
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
    Map<String, String> map = Stream.of(new String[][]{
        {"apiUrl", "http://localhost:8082"},
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

    List<NotaryInfo> notaryinfo = Arrays.asList();
    // minimum platform version of 4
    NetworkParameters myNetworkParameters = testNetworkParameters(notaryinfo, 4);

    network = new MockNetwork(
        new MockNetworkParameters(
          ImmutableList.of(
            TestCordapp.findCordapp("eu._5gzorro.contracts"),
            TestCordapp.findCordapp("eu._5gzorro.flows").withConfig(map)
          )
        ).withNetworkParameters(myNetworkParameters));

    operator1 = network.createNode(CordaX500Name.parse("O=Operator1,L=Sydney,C=AU"));
    operator2 = network.createNode(CordaX500Name.parse("O=Operator2,L=Madrid,C=ES"));
    governanceNode = network.createNode(CordaX500Name.parse("O=Governance,L=London,C=GB"));

    notary = network.getDefaultNotaryIdentity();
    operator1Party = operator1.getInfo().getLegalIdentities().get(0);
    operator2Party = operator2.getInfo().getLegalIdentities().get(0);
    governanceParty = governanceNode.getInfo().getLegalIdentities().get(0);
    network.runNetwork();
  }

  @AfterAll
  public void tearDown() {
    network.stopNodes();
  }

}
