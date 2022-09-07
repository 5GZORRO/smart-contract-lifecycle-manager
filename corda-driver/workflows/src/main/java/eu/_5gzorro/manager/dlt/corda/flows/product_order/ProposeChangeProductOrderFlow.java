package eu._5gzorro.manager.dlt.corda.flows.product_order;

import co.paralleluniverse.fibers.Suspendable;
import eu._5gzorro.manager.dlt.corda.contracts.ProductOrderContract;
import eu._5gzorro.manager.dlt.corda.flows.utils.ExtendedFlowLogic;
import eu._5gzorro.manager.dlt.corda.models.types.OfferType;
import eu._5gzorro.manager.dlt.corda.models.types.OrderState;
import eu._5gzorro.manager.dlt.corda.states.ProductOrder;
import eu._5gzorro.manager.domain.Invitation;
import eu._5gzorro.tm_forum.models.TimePeriod;
import kotlin.collections.SetsKt;
import net.corda.core.contracts.Command;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.crypto.SecureHash;
import net.corda.core.flows.*;
import net.corda.core.identity.Party;
import net.corda.core.transactions.SignedTransaction;
import net.corda.core.transactions.TransactionBuilder;

import java.security.PublicKey;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.corda.core.contracts.ContractsDSL.requireThat;

@InitiatingFlow
public class ProposeChangeProductOrderFlow extends ExtendedFlowLogic<UniqueIdentifier> {
  private final StateAndRef<ProductOrder> stateAndRef;
  private final Set<FlowSession> sessions;

  private final Party spectrumRegulator;
  private final OfferType offerType;
  private final TimePeriod validFor;
  private final Map<String, Invitation> didInvitations;

  public ProposeChangeProductOrderFlow(
      StateAndRef<ProductOrder> stateAndRef,
      Set<FlowSession> sessions,
      Party spectrumRegulator,
      OfferType offerType,
      TimePeriod validFor,
      Map<String, Invitation> didInvitations) {
    this.stateAndRef = stateAndRef;
    this.sessions = sessions;
    this.spectrumRegulator = spectrumRegulator;
    this.offerType = offerType;
    this.validFor = validFor;
    this.didInvitations = didInvitations;
  }

  @Suspendable
  @Override
  public UniqueIdentifier call() throws FlowException {
    ProductOrder inputOrder = stateAndRef.getState().getData();

    // Apply any modifications
    ProductOrder outputOrder =
        new ProductOrder(inputOrder)
            .setState(OrderState.CHANGE_ACTIVE)
            .setSpectrumRegulator(spectrumRegulator)
            .setDidInvitations(didInvitations)
            .setOfferType(offerType)
            .setValidFor(validFor);

    List<PublicKey> requiredSigners = outputOrder.getRequiredSigners();

    Command<ProductOrderContract.ProductOrderCommand.ProposeChange> command =
        new Command<>(
            new ProductOrderContract.ProductOrderCommand.ProposeChange(), requiredSigners);

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
  public static class ProposeChangeProductOrderInitiator
      extends ExtendedFlowLogic<UniqueIdentifier> {
    private final UniqueIdentifier productOrderId;
    private final Party spectrumRegulator;
    private final OfferType offerType;
    private final TimePeriod validFor;
    private final Map<String, Invitation> didInvitations;

    public ProposeChangeProductOrderInitiator(
        UniqueIdentifier productOrderId,
        Party spectrumRegulator,
        OfferType offerType,
        TimePeriod validFor,
        Map<String, Invitation> didInvitations) {
      this.productOrderId = productOrderId;
      this.spectrumRegulator = spectrumRegulator;
      this.offerType = offerType;
      this.validFor = validFor;
      this.didInvitations = didInvitations;
    }

    @Suspendable
    @Override
    public UniqueIdentifier call() throws FlowException {
      StateAndRef<ProductOrder> prevStateAndRef =
          findStateWithLinearId(ProductOrder.class, productOrderId);

      Set<FlowSession> sessions =
          initiateFlows(
              SetsKt.setOf(
                  prevStateAndRef.getState().getData().getSeller(),
                  prevStateAndRef.getState().getData().getGovernanceParty()));

      return subFlow(
          new ProposeChangeProductOrderFlow(
              prevStateAndRef,
              sessions,
              spectrumRegulator,
              offerType,
              validFor,
              didInvitations));
    }
  }

  @InitiatedBy(ProposeChangeProductOrderInitiator.class)
  public static class ProposeChangeProductOrderResponder
      extends ExtendedFlowLogic<SignedTransaction> {
    private final FlowSession counterParty;

    public ProposeChangeProductOrderResponder(FlowSession counterParty) {
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
