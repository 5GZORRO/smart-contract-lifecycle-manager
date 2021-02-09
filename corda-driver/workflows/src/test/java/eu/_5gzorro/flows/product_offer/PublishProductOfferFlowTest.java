package eu._5gzorro.flows.product_offer;


import static eu._5gzorro.flows.product_offer.ProductOfferingTestUtils.generateProductOffering;
import static kotlin.collections.CollectionsKt.listOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import eu._5gzorro.models.types.OfferStatus;
import eu._5gzorro.models.types.OfferType;
import eu._5gzorro.states.ProductOffering;
import eu._5gzorro.utils.TwoOperatorTestCase;
import java.util.concurrent.ExecutionException;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.contracts.UniqueIdentifier;
import org.junit.jupiter.api.Test;

public class PublishProductOfferFlowTest extends TwoOperatorTestCase {

  @Test
  public void publish_offering_ensure_other_nodes_receive() throws ExecutionException, InterruptedException {
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

    // Check operator 2 received a copy of the offer
    StateAndRef<ProductOffering> stateAndRef = operator2.getServices().getVaultService()
        .queryBy(ProductOffering.class)
        .getStates()
        .stream()
        .findAny()
        .get();
    ProductOffering productOffering = stateAndRef.getState().getData();

    verifyOffer(productOffering);

    // Check notary received a copy of the offer
    stateAndRef = network.getDefaultNotaryNode()
        .getServices()
        .getVaultService()
        .queryBy(ProductOffering.class)
        .getStates()
        .stream()
        .findAny()
        .get();
    productOffering = stateAndRef.getState().getData();

    verifyOffer(productOffering);
  }

  private void verifyOffer(ProductOffering productOffering) {
    assertThat(productOffering.getOwner(), is(operator1Party));
    assertThat(productOffering.getOfferType(), is(OfferType.GENERAL));
    assertThat(productOffering.getDidInvitations(), is(nullValue()));
    assertThat(productOffering.getParticipants(), is(listOf(operator1Party, governanceParty)));
    assertThat(productOffering.getGovernanceOracle(), is(governanceParty));
    assertThat(productOffering.getPlaces(), is(nullValue()));
    assertThat(productOffering.getName(), is("testName"));
    assertThat(productOffering.getProductOfferTerms(), is(nullValue()));
  }
}
