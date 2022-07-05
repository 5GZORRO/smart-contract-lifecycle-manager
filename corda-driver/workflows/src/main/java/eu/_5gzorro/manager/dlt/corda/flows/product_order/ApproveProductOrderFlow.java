package eu._5gzorro.manager.dlt.corda.flows.product_order;

import co.paralleluniverse.fibers.Suspendable;
import eu._5gzorro.manager.dlt.corda.contracts.ProductOrderContract;
import eu._5gzorro.manager.dlt.corda.flows.utils.ExtendedFlowLogic;
import eu._5gzorro.manager.dlt.corda.models.types.OfferType;
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

import static net.corda.core.contracts.ContractsDSL.requireThat;

@InitiatingFlow
public class ApproveProductOrderFlow extends ExtendedFlowLogic<UniqueIdentifier> {
  private final StateAndRef<ProductOrder> stateAndRef;
  private final Set<FlowSession> sessions;

  public ApproveProductOrderFlow(StateAndRef<ProductOrder> stateAndRef, Set<FlowSession> sessions) {
    this.stateAndRef = stateAndRef;
    this.sessions = sessions;
  }

  @Suspendable
  @Override
  public UniqueIdentifier call() throws FlowException {
    ProductOrder inputOrder = stateAndRef.getState().getData();
    ProductOrder outputOrder = new ProductOrder(inputOrder).setState(OrderState.APPROVED);

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
    SignedTransaction signedTransaction = getServiceHub().signInitialTransaction(txBuilder);

    // Add spectrum session if spectrum offer
    if (outputOrder.getOfferType() == OfferType.SPECTRUM) {
      sessions.add(initiateFlow(outputOrder.getSpectrumRegulator()));
    }

    signedTransaction = subFlow(new CollectSignaturesFlow(signedTransaction, sessions));

    subFlow(new FinalityFlow(signedTransaction, sessions));

    return outputOrder.getLinearId();
  }

  @InitiatingFlow
  @StartableByRPC
  public static class ApproveProductOrderInitiator extends ExtendedFlowLogic<UniqueIdentifier> {
    private final UniqueIdentifier productOrderId;

    public ApproveProductOrderInitiator(UniqueIdentifier productOrderId) {
      this.productOrderId = productOrderId;
    }

    @Suspendable
    @Override
    public UniqueIdentifier call() throws FlowException {
      StateAndRef<ProductOrder> prevStateAndRef =
          findStateWithLinearId(ProductOrder.class, productOrderId);

      Set<FlowSession> sessions =
          initiateFlows(
              SetsKt.setOf(
                  prevStateAndRef.getState().getData().getBuyer(),
                  prevStateAndRef.getState().getData().getGovernanceParty()));

      return subFlow(new ApproveProductOrderFlow(prevStateAndRef, sessions));
    }
  }

  @InitiatedBy(ApproveProductOrderInitiator.class)
  public static class ApproveProductOrderResponder extends ExtendedFlowLogic<SignedTransaction> {
    private final FlowSession counterParty;

    public ApproveProductOrderResponder(FlowSession counterParty) {
      this.counterParty = counterParty;
    }

    @Suspendable
    @Override
    public SignedTransaction call() throws FlowException {
      subFlow(
          new SignTransactionFlow(counterParty) {
            @Override
            protected void checkTransaction(SignedTransaction stx) throws FlowException {
              requireThat(
                  require -> {
                    ProductOrder productOrder =
                        (ProductOrder) stx.getCoreTransaction().getOutput(0);

                    return null;
                  });
            }
          });
      return subFlow(new ReceiveFinalityFlow(counterParty));
    }
  }
}
