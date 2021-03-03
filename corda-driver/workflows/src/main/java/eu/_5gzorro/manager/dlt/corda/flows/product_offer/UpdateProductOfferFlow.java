package eu._5gzorro.manager.dlt.corda.flows.product_offer;

import co.paralleluniverse.fibers.Suspendable;
import eu._5gzorro.manager.dlt.corda.contracts.ProductOfferingContract.ProductOfferingCommand.Update;
import eu._5gzorro.manager.dlt.corda.flows.governance.GatherGovernanceSignatureFlow;
import eu._5gzorro.manager.dlt.corda.flows.utils.ExtendedFlowLogic;
import eu._5gzorro.manager.dlt.corda.states.ProductOffering;
import java.security.PublicKey;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import net.corda.core.contracts.Command;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.flows.FinalityFlow;
import net.corda.core.flows.FlowException;
import net.corda.core.flows.FlowSession;
import net.corda.core.flows.InitiatedBy;
import net.corda.core.flows.InitiatingFlow;
import net.corda.core.flows.ReceiveFinalityFlow;
import net.corda.core.flows.StartableByRPC;
import net.corda.core.node.StatesToRecord;
import net.corda.core.transactions.SignedTransaction;
import net.corda.core.transactions.TransactionBuilder;

@InitiatingFlow
public class UpdateProductOfferFlow extends ExtendedFlowLogic<UniqueIdentifier> {
  private final ProductOffering productOffering;
  private final StateAndRef<ProductOffering> prevStateAndRef;
  private final Set<FlowSession> otherParties;

  public UpdateProductOfferFlow(ProductOffering productOffering,
      StateAndRef<ProductOffering> prevStateAndRef,
      Set<FlowSession> otherParties) {
    this.productOffering = productOffering;
    this.prevStateAndRef = prevStateAndRef;
    this.otherParties = otherParties;
  }

  @Suspendable
  @Override
  public UniqueIdentifier call() throws FlowException {
    List<PublicKey> requiredSigners = productOffering.getRequiredSigners();

    Command<Update> command = new Command<>(new Update(), requiredSigners);

    TransactionBuilder txBuilder = new TransactionBuilder(firstNotary())
        .addCommand(command)
        .addInputState(prevStateAndRef)
        .addOutputState(productOffering);

    txBuilder.verify(getServiceHub());

    // Signing the transaction.
    SignedTransaction signedTx = getServiceHub().signInitialTransaction(txBuilder);

    // TODO consider if governance is the one we want to sign this?
    SignedTransaction fullySignedTx
        = subFlow(new GatherGovernanceSignatureFlow(signedTx, productOffering.getGovernanceParty()));
    // TODO gather regulator signature if needed

    subFlow(new FinalityFlow(fullySignedTx, otherParties));

    return productOffering.getLinearId();
  }

  @InitiatingFlow
  @StartableByRPC
  public static class UpdateProductOfferInitiator extends ExtendedFlowLogic<UniqueIdentifier> {
    private final ProductOffering productOffering;

    public UpdateProductOfferInitiator(ProductOffering productOffering) {
      this.productOffering = productOffering;
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

      StateAndRef<ProductOffering> prevStateAndRef
          = findStateWithLinearId(ProductOffering.class, productOffering.getLinearId());

      return subFlow(new UpdateProductOfferFlow(productOffering, prevStateAndRef, allOtherParties));
    }
  }

  @InitiatedBy(UpdateProductOfferInitiator.class)
  public static class UpdateProductOfferResponder extends ExtendedFlowLogic<SignedTransaction> {
    private final FlowSession counterParty;

    public UpdateProductOfferResponder(FlowSession counterParty) {
      this.counterParty = counterParty;
    }

    @Suspendable
    @Override
    public SignedTransaction call() throws FlowException {
      return subFlow(new ReceiveFinalityFlow(counterParty, null, StatesToRecord.ALL_VISIBLE));
    }
  }

}
