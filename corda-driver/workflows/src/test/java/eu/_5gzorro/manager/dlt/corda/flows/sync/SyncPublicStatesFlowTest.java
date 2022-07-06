package eu._5gzorro.manager.dlt.corda.flows.sync;

import eu._5gzorro.manager.dlt.corda.flows.product_offer.ProductOfferingTestUtils;
import eu._5gzorro.manager.dlt.corda.models.types.OfferType;
import eu._5gzorro.manager.dlt.corda.states.ProductOffering;
import eu._5gzorro.manager.dlt.corda.utils.TwoOperatorTestCase;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.testing.node.StartedMockNode;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.MatcherAssert.assertThat;

public class SyncPublicStatesFlowTest extends TwoOperatorTestCase {

  @Test
  public void add_node_after_product_offer_ensure_new_node_gets_old_product_offer()
      throws ExecutionException, InterruptedException {

    ProductOffering offering = new ProductOffering(
        new UniqueIdentifier("233"),
        OfferType.GENERAL,
        "testName",
        operator1Party,
        null,
        null,
        governanceParty,
        null,
        null
    );

    network.runNetwork();
    UniqueIdentifier offeringId =
        ProductOfferingTestUtils.publishProductOffering(operator1, network, offering);

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
