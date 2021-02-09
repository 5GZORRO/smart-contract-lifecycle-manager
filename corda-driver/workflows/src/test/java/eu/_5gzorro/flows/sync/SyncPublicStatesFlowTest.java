package eu._5gzorro.flows.sync;

import static eu._5gzorro.flows.product_offer.ProductOfferingTestUtils.generateProductOffering;
import static org.hamcrest.MatcherAssert.assertThat;

import eu._5gzorro.models.types.OfferStatus;
import eu._5gzorro.models.types.OfferType;
import eu._5gzorro.states.ProductOffering;
import eu._5gzorro.utils.TwoOperatorTestCase;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.testing.node.StartedMockNode;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class SyncPublicStatesFlowTest extends TwoOperatorTestCase {

  @Test
  public void add_node_after_product_offer_ensure_new_node_gets_old_product_offer()
      throws ExecutionException, InterruptedException {

    ProductOffering offering = new ProductOffering(
        new UniqueIdentifier("233"),
        OfferStatus.ISSUED,
        OfferType.GENERAL,
        "testName",
        operator1Party,
        null,
        null,
        null,
        null,
        null,
        governanceParty,
        null
    );

    network.runNetwork();
    UniqueIdentifier offeringId =
        generateProductOffering(operator1, network, offering);

    StartedMockNode operator3 = network.createNode();
    network.runNetwork();

    // Check operator 2 received a copy of the offer
    Optional<StateAndRef<ProductOffering>> stateAndRef = operator3.getServices().getVaultService()
        .queryBy(ProductOffering.class)
        .getStates()
        .stream()
        .findAny();
    assertThat(stateAndRef.isPresent(), Matchers.is(true));
  }
}
