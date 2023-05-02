package eu._5gzorro.manager.dlt.corda.flows.product_offer;

import co.paralleluniverse.fibers.Suspendable;
import eu._5gzorro.manager.dlt.corda.contracts.ProductOfferingContract.ProductOfferingCommand.Retire;
import eu._5gzorro.manager.dlt.corda.flows.utils.ExtendedFlowLogic;
import eu._5gzorro.manager.dlt.corda.states.ProductOffering;
import net.corda.core.contracts.Command;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.flows.*;
import net.corda.core.node.StatesToRecord;
import net.corda.core.transactions.SignedTransaction;
import net.corda.core.transactions.TransactionBuilder;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@InitiatingFlow
public class RetireProductOfferFlow extends ExtendedFlowLogic<UniqueIdentifier> {
  private final StateAndRef<ProductOffering> prevStateAndRef;
  private final Set<FlowSession> otherParties;

  public RetireProductOfferFlow(
      StateAndRef<ProductOffering> prevStateAndRef,
      Set<FlowSession> otherParties) {
    this.prevStateAndRef = prevStateAndRef;
    this.otherParties = otherParties;
  }

  @Suspendable
  @Override
  public UniqueIdentifier call() throws FlowException {
    List<PublicKey> requiredSigners = Arrays.asList(getOurIdentity().getOwningKey());

    Command<Retire> command = new Command<>(new Retire(), requiredSigners);

    TransactionBuilder txBuilder = new TransactionBuilder(firstNotary())
        .addCommand(command)
        .addInputState(prevStateAndRef);

    txBuilder.verify(getServiceHub());

    // Signing the transaction.
    SignedTransaction signedTx = getServiceHub().signInitialTransaction(txBuilder);

    subFlow(new FinalityFlow(signedTx, otherParties));

    return prevStateAndRef.getState().getData().getLinearId();
  }

  @InitiatingFlow
  @StartableByRPC
  public static class RetireProductOfferInitiator extends ExtendedFlowLogic<UniqueIdentifier> {
    private final String offeringDid;

    public RetireProductOfferInitiator(String offeringDid) {
      this.offeringDid = offeringDid;
    }

    @Suspendable
    @Override
    public UniqueIdentifier call() throws FlowException {
      // Open sessions with all other nodes as we want to share product offering with them
      Set<FlowSession> allOtherParties = initiateFlows(
          getServiceHub()
              .getNetworkMapCache()
              .getAllNodes()
              .stream()
              .flatMap(c -> c.getLegalIdentities().stream())
              .filter(p -> !p.equals(getOurIdentity())) // Filter out own identity
              .collect(Collectors.toList())
      );

      StateAndRef<ProductOffering> prevStateAndRef = findOfferByDid(ProductOffering.class, offeringDid);

      return subFlow(new RetireProductOfferFlow(prevStateAndRef, allOtherParties));
    }
  }

  @InitiatedBy(RetireProductOfferInitiator.class)
  public static class RetireProductOfferResponder extends ExtendedFlowLogic<SignedTransaction> {
    private final FlowSession counterParty;

    public RetireProductOfferResponder(FlowSession counterParty) {
      this.counterParty = counterParty;
    }

    @Suspendable
    @Override
    public SignedTransaction call() throws FlowException {
      return subFlow(new ReceiveFinalityFlow(counterParty, null, StatesToRecord.ALL_VISIBLE));
    }
  }

}
