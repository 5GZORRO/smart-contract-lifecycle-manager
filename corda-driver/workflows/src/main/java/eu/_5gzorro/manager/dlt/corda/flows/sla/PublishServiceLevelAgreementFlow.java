package eu._5gzorro.manager.dlt.corda.flows.sla;

import co.paralleluniverse.fibers.Suspendable;
import eu._5gzorro.manager.dlt.corda.contracts.ServiceLevelAgreementContract;
import eu._5gzorro.manager.dlt.corda.flows.utils.ExtendedFlowLogic;
import eu._5gzorro.manager.dlt.corda.states.ServiceLevelAgreementState;
import kotlin.collections.SetsKt;
import net.corda.core.contracts.Command;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.flows.*;
import net.corda.core.transactions.SignedTransaction;
import net.corda.core.transactions.TransactionBuilder;
import org.jetbrains.annotations.NotNull;

import java.security.PublicKey;
import java.util.List;
import java.util.Set;

public class PublishServiceLevelAgreementFlow {

    @InitiatingFlow
    public static class PublishServiceLevelAgreementFlowInitiator extends ExtendedFlowLogic<UniqueIdentifier> {

        private final ServiceLevelAgreementState serviceLevelAgreementState;

        public PublishServiceLevelAgreementFlowInitiator(ServiceLevelAgreementState serviceLevelAgreementState) {
            this.serviceLevelAgreementState = serviceLevelAgreementState;
        }

        @Suspendable
        @Override
        public UniqueIdentifier call() throws FlowException {
            Set<FlowSession> sessions = initiateFlows(SetsKt.setOf(serviceLevelAgreementState.getSeller(),
                    serviceLevelAgreementState.getGovernanceParty()));
            List<PublicKey> requiredSigners = serviceLevelAgreementState.getRequiredSigners();

            Command<ServiceLevelAgreementContract.ServiceLevelAgreementCommand.Publish> cmd =
                    new Command<>(new ServiceLevelAgreementContract.ServiceLevelAgreementCommand.Publish(),
                            requiredSigners);
            TransactionBuilder txBuilder =
                    new TransactionBuilder(firstNotary()).addCommand(cmd).addOutputState(serviceLevelAgreementState);

            txBuilder.verify(getServiceHub());

            SignedTransaction signedTransaction = getServiceHub().signInitialTransaction(txBuilder);

            signedTransaction = subFlow(new CollectSignaturesFlow(signedTransaction, sessions));

            subFlow(new FinalityFlow(signedTransaction, sessions));

            return serviceLevelAgreementState.getLinearId();
        }
    }

    @InitiatedBy(PublishServiceLevelAgreementFlowInitiator.class)
    public static class PublishServiceLevelAgreementFlowInitiatorResponder
            extends ExtendedFlowLogic<SignedTransaction> {

        private final FlowSession counterParty;

        public PublishServiceLevelAgreementFlowInitiatorResponder(FlowSession counterParty) {
            this.counterParty = counterParty;
        }

        @Suspendable
        @Override
        public SignedTransaction call() throws FlowException {
            subFlow(new SignTransactionFlow(counterParty) {
                @Override
                protected void checkTransaction(@NotNull SignedTransaction stx) {}});

            return subFlow(new ReceiveFinalityFlow(counterParty));
        }
    }
}
