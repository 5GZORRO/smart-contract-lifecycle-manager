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

import static net.corda.core.contracts.ContractsDSL.requireThat;

@InitiatingFlow
public class EndProductOrderFlow extends ExtendedFlowLogic<UniqueIdentifier> {
  private final StateAndRef<ProductOrder> prevStateAndRef;
  private final Set<FlowSession> sessions;

  public EndProductOrderFlow(StateAndRef<ProductOrder> prevStateAndRef, Set<FlowSession> sessions) {
    this.prevStateAndRef = prevStateAndRef;
    this.sessions = sessions;
  }

  @Suspendable
  @Override
  public UniqueIdentifier call() throws FlowException {
    ProductOrder productOrder = prevStateAndRef.getState().getData();
    List<PublicKey> requiredSigners = Collections.singletonList(getOurIdentity().getOwningKey());

    Command<ProductOrderContract.ProductOrderCommand.EndOrder> command =
        new Command<>(new ProductOrderContract.ProductOrderCommand.EndOrder(), requiredSigners);

    TransactionBuilder txBuilder =
        new TransactionBuilder(firstNotary()).addCommand(command).addInputState(prevStateAndRef);

    txBuilder.verify(getServiceHub());

    // Signing the transaction.
    // Signing the transaction.
    SignedTransaction signedTransaction = getServiceHub().signInitialTransaction(txBuilder);

    // Add spectrum session if spectrum offer
    if (productOrder.getOfferType() == OfferType.SPECTRUM) {
      sessions.add(initiateFlow(productOrder.getSpectrumRegulator()));
    }

    signedTransaction = subFlow(new CollectSignaturesFlow(signedTransaction, sessions));

    subFlow(new FinalityFlow(signedTransaction, sessions));

    return prevStateAndRef.getState().getData().getLinearId();
  }

  @InitiatingFlow
  @StartableByRPC
  public static class EndProductOrderInitiator extends ExtendedFlowLogic<UniqueIdentifier> {
    private final UniqueIdentifier productOrderId;

    public EndProductOrderInitiator(UniqueIdentifier productOrderId) {
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
                  findCounterParty(prevStateAndRef.getState().getData().getOrderBilateralParties()),
                  prevStateAndRef.getState().getData().getGovernanceParty()
              )
          );

      return subFlow(new EndProductOrderFlow(prevStateAndRef, sessions));
    }
  }

  @InitiatedBy(EndProductOrderInitiator.class)
  public static class EndProductOrderResponder extends ExtendedFlowLogic<SignedTransaction> {
    private final FlowSession counterParty;

    public EndProductOrderResponder(FlowSession counterParty) {
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
