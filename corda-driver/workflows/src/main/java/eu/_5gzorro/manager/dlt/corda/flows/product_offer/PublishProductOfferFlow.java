package eu._5gzorro.manager.dlt.corda.flows.product_offer;

import co.paralleluniverse.fibers.Suspendable;
import eu._5gzorro.manager.dlt.corda.contracts.ProductOfferingContract.ProductOfferingCommand.Publish;
import eu._5gzorro.manager.dlt.corda.flows.governance.GatherGovernanceSignatureFlow;
import eu._5gzorro.manager.dlt.corda.flows.utils.ExtendedFlowLogic;
import eu._5gzorro.manager.dlt.corda.states.ProductOffering;
import net.corda.core.contracts.Command;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.flows.*;
import net.corda.core.node.StatesToRecord;
import net.corda.core.transactions.SignedTransaction;
import net.corda.core.transactions.TransactionBuilder;

import java.security.PublicKey;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@InitiatingFlow
public class PublishProductOfferFlow extends ExtendedFlowLogic<UniqueIdentifier> {
  private final ProductOffering productOffering;
  private final Set<FlowSession> otherParties;

  public PublishProductOfferFlow(ProductOffering productOffering,
      Set<FlowSession> otherParties) {
    this.productOffering = productOffering;
    this.otherParties = otherParties;
  }

  @Suspendable
  @Override
  public UniqueIdentifier call() throws FlowException {
    List<PublicKey> requiredSigners = productOffering.getRequiredSigners();

    Command<Publish> command = new Command<>(new Publish(), requiredSigners);

    TransactionBuilder txBuilder = new TransactionBuilder(firstNotary())
        .addCommand(command)
        .addOutputState(productOffering);

    txBuilder.verify(getServiceHub());

    // Signing the transaction.
    SignedTransaction signedTx = getServiceHub().signInitialTransaction(txBuilder);
    // TODO gather regulator signatures
    SignedTransaction fullySignedTx
        = subFlow(new GatherGovernanceSignatureFlow(signedTx, productOffering.getGovernanceParty()));

    subFlow(new FinalityFlow(fullySignedTx, otherParties));

    return productOffering.getLinearId();
  }

  @InitiatingFlow
  @StartableByRPC
  public static class PublishProductOfferInitiator extends ExtendedFlowLogic<UniqueIdentifier> {
    private final ProductOffering productOffering;

    public PublishProductOfferInitiator(ProductOffering productOffering) {
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

      return subFlow(new PublishProductOfferFlow(productOffering, allOtherParties));
    }
  }

  @InitiatedBy(PublishProductOfferInitiator.class)
  public static class PublishProductOfferResponder extends ExtendedFlowLogic<SignedTransaction> {
    private final FlowSession counterParty;

    public PublishProductOfferResponder(FlowSession counterParty) {
      this.counterParty = counterParty;
    }

    @Suspendable
    @Override
    public SignedTransaction call() throws FlowException {
      return subFlow(new ReceiveFinalityFlow(counterParty, null, StatesToRecord.ALL_VISIBLE));
    }
  }
}
