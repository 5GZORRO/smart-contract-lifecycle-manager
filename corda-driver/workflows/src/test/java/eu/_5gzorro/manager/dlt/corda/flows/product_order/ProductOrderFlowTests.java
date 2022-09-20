package eu._5gzorro.manager.dlt.corda.flows.product_order;


import eu._5gzorro.manager.dlt.corda.models.types.OfferType;
import eu._5gzorro.manager.dlt.corda.models.types.OrderState;
import eu._5gzorro.manager.dlt.corda.states.ProductOrder;
import eu._5gzorro.manager.dlt.corda.utils.PublishedProductOrderTestCase;
import kotlin.collections.CollectionsKt;
import net.corda.core.contracts.StateAndRef;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ProductOrderFlowTests extends PublishedProductOrderTestCase {

    @Test
    public void publish() throws ExecutionException, InterruptedException {
        StateAndRef<ProductOrder> stateAndRef = operator2.getServices().getVaultService()
            .queryBy(ProductOrder.class)
            .getStates()
            .stream()
            .findAny()
            .get();
        ProductOrder productOrder = stateAndRef.getState().getData();

        verifyOrder(productOrder, OrderState.PROPOSED);
    }

    private void verifyOrder(ProductOrder productOrder, OrderState orderState) {
        assertThat(productOrder.getBuyer(), is(operator1Party));
        assertThat(productOrder.getSeller(), is(operator2Party));
        assertThat(productOrder.getGovernanceParty(), is(governanceParty));
        assertThat(productOrder.getOfferType(), is(OfferType.GENERAL));
        assertThat(productOrder.getParticipants(), is(
            CollectionsKt.listOf(operator1Party, operator2Party, governanceParty)));
        assertThat(productOrder.getState(), is(orderState));
    }
}
