package eu._5gzorro.manager.dlt.corda.flows.product_offer;


import static kotlin.collections.CollectionsKt.listOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import eu._5gzorro.manager.dlt.corda.models.types.OfferType;
import eu._5gzorro.manager.dlt.corda.states.ProductOffering;
import eu._5gzorro.manager.dlt.corda.utils.PublishedProductOfferTestCase;
import kotlin.collections.CollectionsKt;
import net.corda.core.contracts.StateAndRef;
import org.junit.jupiter.api.Test;

public class PublishProductOfferFlowTest extends PublishedProductOfferTestCase {

  @Test
  public void publish_offering_ensure_other_nodes_receive() {
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
    assertThat(productOffering.getParticipants(), is(
        CollectionsKt.listOf(operator1Party, governanceParty)));
    assertThat(productOffering.getGovernanceParty(), is(governanceParty));
    assertThat(productOffering.getPlaces(), is(nullValue()));
    assertThat(productOffering.getName(), is("testName"));
    assertThat(productOffering.getProductOfferTerms(), is(nullValue()));
  }
}
