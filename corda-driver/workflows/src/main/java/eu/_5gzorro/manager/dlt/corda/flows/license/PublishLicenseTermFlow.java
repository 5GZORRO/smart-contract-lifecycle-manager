package eu._5gzorro.manager.dlt.corda.flows.license;

import co.paralleluniverse.fibers.Suspendable;
import eu._5gzorro.manager.dlt.corda.contracts.LicenseTermContract;
import eu._5gzorro.manager.dlt.corda.flows.utils.ExtendedFlowLogic;
import eu._5gzorro.manager.dlt.corda.states.LicenseTermState;
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

public class PublishLicenseTermFlow {

    @InitiatingFlow
    public static class PublishLicenseTermFlowInitiator extends ExtendedFlowLogic<UniqueIdentifier> {

        private final LicenseTermState licenseTermState;

        public PublishLicenseTermFlowInitiator(LicenseTermState licenseTermState) {
            this.licenseTermState = licenseTermState;
        }

        @Suspendable
        @Override
        public UniqueIdentifier call() throws FlowException {

            Set<FlowSession> sessions =
                    initiateFlows(SetsKt.setOf(licenseTermState.getSeller(), licenseTermState.getGovernanceParty()));
            List<PublicKey> requiredSigners = licenseTermState.getRequiredSigners();

            Command<LicenseTermContract.LicenseTermCommand.Publish> cmd =
                    new Command<>(new LicenseTermContract.LicenseTermCommand.Publish(), requiredSigners);
            TransactionBuilder txBuilder =
                    new TransactionBuilder(firstNotary()).addCommand(cmd).addOutputState(licenseTermState);

            txBuilder.verify(getServiceHub());

            SignedTransaction signedTransaction = getServiceHub().signInitialTransaction(txBuilder);
            signedTransaction = subFlow(new CollectSignaturesFlow(signedTransaction, sessions));

            subFlow(new FinalityFlow(signedTransaction, sessions));

            return licenseTermState.getLinearId();
        }
    }

    @InitiatedBy(PublishLicenseTermFlowInitiator.class)
    public static class PublishLicenseTermFlowResponder extends ExtendedFlowLogic<SignedTransaction> {

        private final FlowSession counterParty;

        public PublishLicenseTermFlowResponder(FlowSession counterParty) {
            this.counterParty = counterParty;
        }

        @Suspendable
        @Override
        public SignedTransaction call() throws FlowException {
            subFlow(new SignTransactionFlow(counterParty) {
                @Override
                protected void checkTransaction(@NotNull SignedTransaction stx) {}
            });

            return subFlow(new ReceiveFinalityFlow(counterParty));
        }
    }
}
