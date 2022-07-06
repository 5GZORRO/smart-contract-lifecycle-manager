package eu._5gzorro.manager.dlt.corda.flows.product_order;


import eu._5gzorro.manager.dlt.corda.models.types.OfferType;
import eu._5gzorro.manager.dlt.corda.models.types.OrderState;
import eu._5gzorro.manager.dlt.corda.states.ProductOrder;
import eu._5gzorro.manager.dlt.corda.states.RejectionReason;
import eu._5gzorro.manager.dlt.corda.utils.PublishedProductOrderTestCase;
import kotlin.collections.CollectionsKt;
import net.corda.core.contracts.StateAndRef;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

import static java.time.LocalDateTime.now;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ProductOrderFlowTests extends PublishedProductOrderTestCase {

  @Test
  public void publish_approve() throws ExecutionException, InterruptedException {
    StateAndRef<ProductOrder> stateAndRef = operator2.getServices().getVaultService()
        .queryBy(ProductOrder.class)
        .getStates()
        .stream()
        .findAny()
        .get();
    ProductOrder productOrder = stateAndRef.getState().getData();

    verifyOrder(productOrder, OrderState.PROPOSED);

    ApproveProductOrderFlow.ApproveProductOrderInitiator flow
        = new ApproveProductOrderFlow.ApproveProductOrderInitiator(productOrder.getLinearId());
    ProductOrderTestUtils.startFlow(operator2, network, flow);

    productOrder = operator1.getServices().getVaultService()
        .queryBy(ProductOrder.class)
        .getStates()
        .stream()
        .findAny()
        .get()
        .getState()
        .getData();
    verifyOrder(productOrder, OrderState.APPROVED);
  }

  @Test
  public void publish_approve_provision_propose_change_accept_change_end() throws ExecutionException, InterruptedException {
    StateAndRef<ProductOrder> stateAndRef = operator2.getServices().getVaultService()
        .queryBy(ProductOrder.class)
        .getStates()
        .stream()
        .findAny()
        .get();
    ProductOrder productOrder = stateAndRef.getState().getData();

    verifyOrder(productOrder, OrderState.PROPOSED);

    ApproveProductOrderFlow.ApproveProductOrderInitiator approveFlow
        = new ApproveProductOrderFlow.ApproveProductOrderInitiator(productOrder.getLinearId());
    ProductOrderTestUtils.startFlow(operator2, network, approveFlow);


    ProvisionProductOrderFlow.ProvisionProductOrderInitiator provisionFLow =
        new ProvisionProductOrderFlow.ProvisionProductOrderInitiator(productOrder.getLinearId());
    ProductOrderTestUtils.startFlow(operator2, network, provisionFLow);
    productOrder = operator1.getServices().getVaultService()
        .queryBy(ProductOrder.class)
        .getStates()
        .stream()
        .findAny()
        .get()
        .getState()
        .getData();
    verifyOrder(productOrder, OrderState.ACTIVE);

    String newEndDateTime = now().plusDays(10).toString();
    ProposeChangeProductOrderFlow.ProposeChangeProductOrderInitiator changeFlow
        = new ProposeChangeProductOrderFlow.ProposeChangeProductOrderInitiator(
            productOrder.getLinearId(),
            productOrder.getModel(),
            productOrder.getSpectrumRegulator(),
            productOrder.getOfferType(),
            productOrder.getValidFor().endDateTime(newEndDateTime),
            productOrder.getDidInvitations()
    );
    ProductOrderTestUtils.startFlow(operator1, network, changeFlow);

    productOrder = operator1.getServices().getVaultService()
        .queryBy(ProductOrder.class)
        .getStates()
        .stream()
        .findAny()
        .get()
        .getState()
        .getData();
    verifyOrder(productOrder, OrderState.CHANGE_ACTIVE);
    assertThat(productOrder.getValidFor().getEndDateTime(), is(newEndDateTime));


    AcceptChangeProductOrderFlow.AcceptChangeProductOrderInitiator acceptChangeFlow =
        new AcceptChangeProductOrderFlow.AcceptChangeProductOrderInitiator(productOrder.getLinearId());
    ProductOrderTestUtils.startFlow(operator2, network, changeFlow);
    productOrder = operator1.getServices().getVaultService()
        .queryBy(ProductOrder.class)
        .getStates()
        .stream()
        .findAny()
        .get()
        .getState()
        .getData();
    verifyOrder(productOrder, OrderState.APPROVED);

    EndProductOrderFlow.EndProductOrderInitiator endFlow =
        new EndProductOrderFlow.EndProductOrderInitiator(productOrder.getLinearId());
    ProductOrderTestUtils.startFlow(operator2, network, changeFlow);
  }

  @Test
  public void publish_reject() throws ExecutionException, InterruptedException {
    StateAndRef<ProductOrder> stateAndRef = operator2.getServices().getVaultService()
        .queryBy(ProductOrder.class)
        .getStates()
        .stream()
        .findAny()
        .get();
    ProductOrder productOrder = stateAndRef.getState().getData();

    verifyOrder(productOrder, OrderState.PROPOSED);

    String rejectionString = "Test";
    RejectProductOrderFlow.RejectProductOrderInitiator flow
        = new RejectProductOrderFlow.RejectProductOrderInitiator(productOrder.getLinearId(), rejectionString);
    ProductOrderTestUtils.startFlow(operator2, network, flow);

    StateAndRef<RejectionReason> stateAndRefRejection = operator1.getServices().getVaultService()
        .queryBy(RejectionReason.class)
        .getStates()
        .stream()
        .findAny()
        .get();

    assertThat(stateAndRefRejection.getState().getData().getRejectionReason(), is(rejectionString));
  }

  private void verifyOrder(ProductOrder productOrder, OrderState orderState) {
    assertThat(productOrder.getBuyer(), is(operator1Party));
    assertThat(productOrder.getSeller(), is(operator2Party));
    assertThat(productOrder.getGovernanceParty(), is(governanceParty));
    assertThat(productOrder.getOfferType(), is(OfferType.GENERAL));
    assertThat(productOrder.getParticipants(), is(
        CollectionsKt.listOf(operator1Party, operator2Party,governanceParty)));
    assertThat(productOrder.getState(), is(orderState));
  }
}
