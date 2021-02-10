package eu._5gzorro.flows.product_offer;

import static eu._5gzorro.flows.product_offer.ProductOfferingTestUtils.updateProductOffering;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import eu._5gzorro.states.ProductOffering;
import eu._5gzorro.utils.PublishedProductOfferTestCase;
import java.util.concurrent.ExecutionException;
import net.corda.core.contracts.StateAndRef;
import org.junit.jupiter.api.Test;

public class UpdateProductOfferFlowTest extends PublishedProductOfferTestCase {

  @Test
  public void update_existing_offer() throws ExecutionException, InterruptedException {
    String newName = "newName";
    offering.setName(newName);

    updateProductOffering(operator1, network, offering);

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
