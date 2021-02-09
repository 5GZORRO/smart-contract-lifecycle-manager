package eu._5gzorro.flows.product_offer;

import co.paralleluniverse.fibers.Suspendable;
import eu._5gzorro.contracts.ProductOfferingContract.ProductOfferingCommand.Publish;
import eu._5gzorro.flows.utils.ExtendedFlowLogic;
import eu._5gzorro.models.types.OfferStatus;
import eu._5gzorro.states.ProductOffering;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import net.corda.core.contracts.Command;
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
    productOffering.setOfferStatus(OfferStatus.ISSUED);
    List<PublicKey> requiredSigners = Arrays.asList(getOurIdentity().getOwningKey());

    Command<Publish> command = new Command<>(new Publish(), requiredSigners);

    TransactionBuilder txBuilder = new TransactionBuilder(firstNotary())
        .addCommand(command)
        .addOutputState(productOffering);

    txBuilder.verify(getServiceHub());

    // Signing the transaction.
    SignedTransaction signedTx = getServiceHub().signInitialTransaction(txBuilder);

    subFlow(new FinalityFlow(signedTx, otherParties));

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
