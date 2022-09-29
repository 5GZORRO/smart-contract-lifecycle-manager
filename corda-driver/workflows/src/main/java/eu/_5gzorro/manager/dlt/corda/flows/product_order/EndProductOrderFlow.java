package eu._5gzorro.manager.dlt.corda.flows.product_order;

import co.paralleluniverse.fibers.Suspendable;
import eu._5gzorro.manager.dlt.corda.contracts.ProductOrderContract;
import eu._5gzorro.manager.dlt.corda.flows.spectoken.RedeemDerivativeSpecTokenFlow;
import eu._5gzorro.manager.dlt.corda.flows.utils.ExtendedFlowLogic;
import eu._5gzorro.manager.dlt.corda.models.types.OfferType;
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
public class EndProductOrderFlow extends ExtendedFlowLogic<UniqueIdentifier> {
    private final StateAndRef<ProductOrder> prevStateAndRef;
    private final Set<FlowSession> sessions;
    private final String offerDid;

    public EndProductOrderFlow(StateAndRef<ProductOrder> prevStateAndRef, Set<FlowSession> sessions, String offerDid) {
        this.prevStateAndRef = prevStateAndRef;
        this.sessions = sessions;
        this.offerDid = offerDid;
    }

    @Suspendable
    @Override
    public UniqueIdentifier call() throws FlowException {
        ProductOrder productOrder = prevStateAndRef.getState().getData();
        List<PublicKey> requiredSigners = productOrder.getRequiredSigners();

        Command<ProductOrderContract.ProductOrderCommand.EndOrder> command =
            new Command<>(new ProductOrderContract.ProductOrderCommand.EndOrder(), requiredSigners);

        TransactionBuilder txBuilder =
            new TransactionBuilder(firstNotary()).addCommand(command).addInputState(prevStateAndRef);

        txBuilder.verify(getServiceHub());

        // Signing the transaction.
        SignedTransaction signedTransaction = getServiceHub().signInitialTransaction(txBuilder);

        signedTransaction = subFlow(new CollectSignaturesFlow(signedTransaction, sessions));

        subFlow(new FinalityFlow(signedTransaction, sessions));

        if (productOrder.getOfferType() == OfferType.SPECTRUM && getOurIdentity().equals(productOrder.getBuyer())) {
            subFlow(new RedeemDerivativeSpecTokenFlow(offerDid, productOrder.getSeller()));
        }

        return prevStateAndRef.getState().getData().getLinearId();
    }

    @InitiatingFlow
    @StartableByRPC
    public static class EndProductOrderInitiator extends ExtendedFlowLogic<UniqueIdentifier> {
        private final String productOrderId;
        private final String offerDid;

        public EndProductOrderInitiator(String productOrderId, String offerDid) {
            this.productOrderId = productOrderId;
            this.offerDid = offerDid;
        }

        @Suspendable
        @Override
        public UniqueIdentifier call() throws FlowException {
            StateAndRef<ProductOrder> prevStateAndRef = findOrderByCatalogId(ProductOrder.class, productOrderId);

            ProductOrder productOrder = prevStateAndRef.getState().getData();
            Set<FlowSession> sessions;
            if (OfferType.SPECTRUM.equals(productOrder.getOfferType())) {
                sessions = initiateFlows(SetsKt.setOf(productOrder.getSeller(), productOrder.getGovernanceParty(), productOrder.getSpectrumRegulator()));
            } else {
                sessions = initiateFlows(SetsKt.setOf(productOrder.getSeller(), productOrder.getGovernanceParty()));
            }

            return subFlow(new EndProductOrderFlow(prevStateAndRef, sessions, offerDid));
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
                                boolean empty = stx.getCoreTransaction().getOutputs().isEmpty();

                                return null;
                            });
                    }
                });
            return subFlow(new ReceiveFinalityFlow(counterParty));
        }
    }
}
