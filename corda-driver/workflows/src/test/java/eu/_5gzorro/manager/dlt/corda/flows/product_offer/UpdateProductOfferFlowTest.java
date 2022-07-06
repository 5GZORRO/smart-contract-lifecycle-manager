package eu._5gzorro.manager.dlt.corda.flows.product_offer;

import eu._5gzorro.manager.dlt.corda.states.ProductOffering;
import eu._5gzorro.manager.dlt.corda.utils.PublishedProductOfferTestCase;
import net.corda.core.contracts.StateAndRef;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class UpdateProductOfferFlowTest extends PublishedProductOfferTestCase {

  @Test
  public void update_existing_offer() throws ExecutionException, InterruptedException {
    String newName = "newName";
    offering.setName(newName);

    ProductOfferingTestUtils.updateProductOffering(operator1, network, offering);

    network.runNetwork();

    StateAndRef<ProductOffering> stateAndRef = operator2.getServices().getVaultService()
        .queryBy(ProductOffering.class)
        .getStates()
        .stream()
        .findAny()
        .get();
    ProductOffering productOffering = stateAndRef.getState().getData();

    assertThat(productOffering.getName(), is(newName));
  }
}
