package eu._5gzorro.manager.dlt.corda.flows.product_order;

import co.paralleluniverse.fibers.Suspendable;
import eu._5gzorro.manager.dlt.corda.contracts.ProductOrderContract;
import eu._5gzorro.manager.dlt.corda.flows.utils.ExtendedFlowLogic;
import eu._5gzorro.manager.dlt.corda.models.types.OfferType;
import eu._5gzorro.manager.dlt.corda.states.ProductOrder;
import eu._5gzorro.manager.dlt.corda.states.RejectionReason;
import kotlin.collections.SetsKt;
import net.corda.core.contracts.Command;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.contracts.StaticPointer;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.flows.*;
import net.corda.core.node.StatesToRecord;
import net.corda.core.transactions.SignedTransaction;
import net.corda.core.transactions.TransactionBuilder;

import java.security.PublicKey;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@InitiatingFlow
public class RejectProductOrderFlow extends ExtendedFlowLogic<UniqueIdentifier> {
  private final StateAndRef<ProductOrder> prevStateAndRef;
  private final String rejectionReason;
  private final Set<FlowSession> sessions;

  public RejectProductOrderFlow(
      StateAndRef<ProductOrder> prevStateAndRef,
      String rejectionReason,
      Set<FlowSession> sessions) {
    this.prevStateAndRef = prevStateAndRef;
    this.rejectionReason = rejectionReason;
    this.sessions = sessions;
  }

  @Suspendable
  @Override
  public UniqueIdentifier call() throws FlowException {
    List<PublicKey> requiredSigners = Collections.singletonList(getOurIdentity().getOwningKey());

    ProductOrder productOrder = prevStateAndRef.getState().getData();
    StaticPointer<ProductOrder> orderStaticPointer =
        new StaticPointer<>(prevStateAndRef.getRef(), ProductOrder.class);
    RejectionReason rejectionReasonState =
        new RejectionReason(
            productOrder.getBuyer(),
            productOrder.getSeller(),
            prevStateAndRef.getState().getData().getLinearId(),
            orderStaticPointer,
            this.rejectionReason);

    Command<ProductOrderContract.ProductOrderCommand.Reject> command =
        new Command<>(new ProductOrderContract.ProductOrderCommand.Reject(), requiredSigners);

    TransactionBuilder txBuilder =
        new TransactionBuilder(firstNotary())
            .addCommand(command)
            .addInputState(prevStateAndRef)
            .addOutputState(rejectionReasonState);

    txBuilder.verify(getServiceHub());

    // Signing the transaction.
    SignedTransaction signedTx = getServiceHub().signInitialTransaction(txBuilder);

    // Add spectrum session if spectrum offer
    if (productOrder.getOfferType() == OfferType.SPECTRUM) {
      sessions.add(initiateFlow(productOrder.getSpectrumRegulator()));
    }


    subFlow(new FinalityFlow(signedTx, sessions));

    return prevStateAndRef.getState().getData().getLinearId();
  }

  @InitiatingFlow
  @StartableByRPC
  public static class RejectProductOrderInitiator extends ExtendedFlowLogic<UniqueIdentifier> {
    private final UniqueIdentifier productOrderId;
    private final String rejectionReason;

    public RejectProductOrderInitiator(UniqueIdentifier productOrderId, String rejectionReason) {
      this.productOrderId = productOrderId;
      this.rejectionReason = rejectionReason;
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

      return subFlow(new RejectProductOrderFlow(prevStateAndRef, rejectionReason, sessions));
    }
  }

  @InitiatedBy(RejectProductOrderInitiator.class)
  public static class RejectProductOrderResponder extends ExtendedFlowLogic<SignedTransaction> {
    private final FlowSession counterParty;

    public RejectProductOrderResponder(FlowSession counterParty) {
      this.counterParty = counterParty;
    }

    @Suspendable
    @Override
    public SignedTransaction call() throws FlowException {
      // Buyer does not need to sign just needs to be aware Order was rejected
      return subFlow(new ReceiveFinalityFlow(counterParty, null, StatesToRecord.ONLY_RELEVANT));
    }
  }
}
