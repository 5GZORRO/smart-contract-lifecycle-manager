package eu._5gzorro.manager.dlt.corda.flows.product_order;

import co.paralleluniverse.fibers.Suspendable;
import eu._5gzorro.manager.dlt.corda.contracts.ProductOrderContract;
import eu._5gzorro.manager.dlt.corda.flows.utils.ExtendedFlowLogic;
import eu._5gzorro.manager.dlt.corda.models.types.OrderState;
import eu._5gzorro.manager.dlt.corda.states.ProductOrder;
import kotlin.collections.SetsKt;
import net.corda.core.contracts.Command;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.flows.*;
import net.corda.core.transactions.SignedTransaction;
import net.corda.core.transactions.TransactionBuilder;

import java.security.PublicKey;
import java.util.List;
import java.util.Set;

@InitiatingFlow
public class ProvisionProductOrderFlow extends ExtendedFlowLogic<UniqueIdentifier> {
  private final StateAndRef<ProductOrder> stateAndRef;
  private final Set<FlowSession> sessions;

  public ProvisionProductOrderFlow(
      StateAndRef<ProductOrder> stateAndRef, Set<FlowSession> sessions) {
    this.stateAndRef = stateAndRef;
    this.sessions = sessions;
  }

  @Suspendable
  @Override
  public UniqueIdentifier call() throws FlowException {
    ProductOrder inputOrder = stateAndRef.getState().getData();
    ProductOrder outputOrder = new ProductOrder(inputOrder).setState(OrderState.ACTIVE);

    List<PublicKey> requiredSigners = inputOrder.getRequiredSigners();

    Command<ProductOrderContract.ProductOrderCommand.ApproveOrder> command =
        new Command<>(new ProductOrderContract.ProductOrderCommand.ApproveOrder(), requiredSigners);

    TransactionBuilder txBuilder =
        new TransactionBuilder(firstNotary())
            .addCommand(command)
            .addInputState(stateAndRef)
            .addOutputState(outputOrder);

    txBuilder.verify(getServiceHub());

    // Signing the transaction.
    SignedTransaction fullySignedTx = getServiceHub().signInitialTransaction(txBuilder);

    subFlow(new FinalityFlow(fullySignedTx, sessions));

    return outputOrder.getLinearId();
  }

  @InitiatingFlow
  @StartableByRPC
  public static class ProvisionProductOrderInitiator extends ExtendedFlowLogic<UniqueIdentifier> {
    private final String productOrderId;

    public ProvisionProductOrderInitiator(String productOrderId) {
      this.productOrderId = productOrderId;
    }

    @Suspendable
    @Override
    public UniqueIdentifier call() throws FlowException {
      StateAndRef<ProductOrder> prevStateAndRef =
          findOrderWithLinearId(ProductOrder.class, productOrderId);
      Set<FlowSession> sessions =
          initiateFlows(
              SetsKt.setOf(
                  prevStateAndRef.getState().getData().getBuyer(),
                  prevStateAndRef.getState().getData().getGovernanceParty()));

      return subFlow(new ProvisionProductOrderFlow(prevStateAndRef, sessions));
    }
  }

  @InitiatedBy(ProvisionProductOrderInitiator.class)
  public static class ProvisionProductOrderResponder extends ExtendedFlowLogic<SignedTransaction> {
    private final FlowSession counterParty;

    public ProvisionProductOrderResponder(FlowSession counterParty) {
      this.counterParty = counterParty;
    }

    @Suspendable
    @Override
    public SignedTransaction call() throws FlowException {
      return subFlow(new ReceiveFinalityFlow(counterParty));
    }
  }
}
