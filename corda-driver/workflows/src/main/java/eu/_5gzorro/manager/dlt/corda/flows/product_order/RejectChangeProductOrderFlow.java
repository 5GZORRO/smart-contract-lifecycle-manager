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
import net.corda.core.node.StatesToRecord;
import net.corda.core.transactions.SignedTransaction;
import net.corda.core.transactions.TransactionBuilder;

import java.security.PublicKey;
import java.util.List;
import java.util.Set;

@InitiatingFlow
public class RejectChangeProductOrderFlow extends ExtendedFlowLogic<UniqueIdentifier> {
  private final StateAndRef<ProductOrder> stateAndRef;
  private final Set<FlowSession> sessions;

  public RejectChangeProductOrderFlow(
      StateAndRef<ProductOrder> stateAndRef, Set<FlowSession> sessions) {
    this.stateAndRef = stateAndRef;
    this.sessions = sessions;
  }

  @Suspendable
  @Override
  public UniqueIdentifier call() throws FlowException {
    ProductOrder inputOrder = stateAndRef.getState().getData();

    ProductOrder outputOrder =
        new ProductOrder(inputOrder).setState(OrderState.ACTIVE).setProposedModel(null);

    List<PublicKey> requiredSigners = outputOrder.getRequiredSigners();

    Command<ProductOrderContract.ProductOrderCommand.RejectProposal> command =
        new Command<>(
            new ProductOrderContract.ProductOrderCommand.RejectProposal(), requiredSigners);

    TransactionBuilder txBuilder =
        new TransactionBuilder(firstNotary())
            .addCommand(command)
            .addInputState(stateAndRef)
            .addOutputState(outputOrder);

    txBuilder.verify(getServiceHub());

    // Signing the transaction.
    SignedTransaction fullySignedTx = getServiceHub().signInitialTransaction(txBuilder);

    // Add spectrum session if spectrum offer
    if (inputOrder.getOfferType() == OfferType.SPECTRUM) {
      sessions.add(initiateFlow(inputOrder.getSpectrumRegulator()));
    }

    subFlow(new FinalityFlow(fullySignedTx, sessions));

    return outputOrder.getLinearId();
  }

  @InitiatingFlow
  @StartableByRPC
  public static class RejectChangeProductOrderInitiator
      extends ExtendedFlowLogic<UniqueIdentifier> {
    private final UniqueIdentifier productOrderId;

    public RejectChangeProductOrderInitiator(UniqueIdentifier productOrderId) {
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
                  prevStateAndRef.getState().getData().getGovernanceParty()
              )
          );

      return subFlow(new RejectChangeProductOrderFlow(prevStateAndRef, sessions));
    }
  }

  @InitiatedBy(RejectChangeProductOrderInitiator.class)
  public static class RejectChangeProductOrderResponder
      extends ExtendedFlowLogic<SignedTransaction> {
    private final FlowSession counterParty;

    public RejectChangeProductOrderResponder(FlowSession counterParty) {
      this.counterParty = counterParty;
    }

    @Suspendable
    @Override
    public SignedTransaction call() throws FlowException {
      return subFlow(new ReceiveFinalityFlow(counterParty, null, StatesToRecord.ONLY_RELEVANT));
    }
  }
}
