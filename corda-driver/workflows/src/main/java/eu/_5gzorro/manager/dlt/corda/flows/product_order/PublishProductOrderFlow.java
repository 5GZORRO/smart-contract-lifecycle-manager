package eu._5gzorro.manager.dlt.corda.flows.product_order;

import co.paralleluniverse.fibers.Suspendable;
import eu._5gzorro.manager.dlt.corda.contracts.ProductOrderContract;
import eu._5gzorro.manager.dlt.corda.flows.utils.ExtendedFlowLogic;
import eu._5gzorro.manager.dlt.corda.models.types.OfferType;
import eu._5gzorro.manager.dlt.corda.states.ProductOrder;
import kotlin.collections.SetsKt;
import net.corda.core.contracts.Command;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.flows.*;
import net.corda.core.transactions.SignedTransaction;
import net.corda.core.transactions.TransactionBuilder;

import java.security.PublicKey;
import java.util.List;
import java.util.Set;

import static net.corda.core.contracts.ContractsDSL.requireThat;

@InitiatingFlow
public class PublishProductOrderFlow extends ExtendedFlowLogic<UniqueIdentifier> {
  private final ProductOrder productOrder;
  private final Set<FlowSession> sessions;

  public PublishProductOrderFlow(ProductOrder productOrder, Set<FlowSession> sessions) {
    this.productOrder = productOrder;
    this.sessions = sessions;
  }

  @Suspendable
  @Override
  public UniqueIdentifier call() throws FlowException {
    List<PublicKey> requiredSigners = productOrder.getRequiredSigners();

    Command<ProductOrderContract.ProductOrderCommand.Publish> command =
        new Command<>(new ProductOrderContract.ProductOrderCommand.Publish(), requiredSigners);

    TransactionBuilder txBuilder =
        new TransactionBuilder(firstNotary()).addCommand(command).addOutputState(productOrder);

    txBuilder.verify(getServiceHub());

    // Signing the transaction.
    SignedTransaction signedTransaction = getServiceHub().signInitialTransaction(txBuilder);

    // Add spectrum session if spectrum offer
    if (productOrder.getOfferType() == OfferType.SPECTRUM) {
      sessions.add(initiateFlow(productOrder.getSpectrumRegulator()));
    }

    signedTransaction = subFlow(new CollectSignaturesFlow(signedTransaction, sessions));

    subFlow(new FinalityFlow(signedTransaction, sessions));
    return productOrder.getLinearId();
  }

  @InitiatingFlow
  @StartableByRPC
  public static class PublishProductOrderInitiator extends ExtendedFlowLogic<UniqueIdentifier> {
    private final ProductOrder productOrder;

    public PublishProductOrderInitiator(ProductOrder productOrder) {
      this.productOrder = productOrder;
    }

    @Suspendable
    @Override
    public UniqueIdentifier call() throws FlowException {
      // Open sessions with all other nodes as we want to share product offering with them
      Set<FlowSession> sessions =
          initiateFlows(SetsKt.setOf(productOrder.getSeller(), productOrder.getGovernanceParty()));

      return subFlow(new PublishProductOrderFlow(productOrder, sessions));
    }
  }

  @InitiatedBy(PublishProductOrderInitiator.class)
  public static class PublishProductOrderResponder extends ExtendedFlowLogic<SignedTransaction> {
    private final FlowSession counterParty;

    public PublishProductOrderResponder(FlowSession counterParty) {
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

                    // TODO perfrom various checks here i.e if spectrum party then check operator
                    // authorised on this spectrum

                    return null;
                  });
            }
          });

      return subFlow(new ReceiveFinalityFlow(counterParty));
    }
  }
}
