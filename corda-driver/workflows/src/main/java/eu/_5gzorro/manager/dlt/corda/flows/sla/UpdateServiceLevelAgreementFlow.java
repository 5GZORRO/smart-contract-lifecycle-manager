package eu._5gzorro.manager.dlt.corda.flows.sla;

import co.paralleluniverse.fibers.Suspendable;
import eu._5gzorro.manager.dlt.corda.contracts.ServiceLevelAgreementContract;
import eu._5gzorro.manager.dlt.corda.flows.utils.ExtendedFlowLogic;
import eu._5gzorro.manager.dlt.corda.models.types.SLAState;
import eu._5gzorro.manager.dlt.corda.states.ServiceLevelAgreementState;
import eu._5gzorro.manager.dlt.corda.states.schemes.ServiceLevelAgreementSchemaV1;
import kotlin.collections.SetsKt;
import net.corda.core.contracts.Command;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.flows.*;
import net.corda.core.node.services.Vault;
import net.corda.core.node.services.vault.Builder;
import net.corda.core.node.services.vault.FieldInfo;
import net.corda.core.node.services.vault.PageSpecification;
import net.corda.core.node.services.vault.QueryCriteria;
import net.corda.core.transactions.SignedTransaction;
import net.corda.core.transactions.TransactionBuilder;
import org.jetbrains.annotations.NotNull;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static net.corda.core.node.services.vault.QueryCriteriaUtils.*;

public class UpdateServiceLevelAgreementFlow {

    @InitiatingFlow
    @StartableByRPC
    public static class UpdateServiceLevelAgreementFlowInitiator extends ExtendedFlowLogic<UniqueIdentifier> {

        private final String productOrderDID;
        private final String serviceLevelAgreementDID;
        private final SLAState state;

        public UpdateServiceLevelAgreementFlowInitiator(String productOrderDID,
                                                        String serviceLevelAgreementDID,
                                                        SLAState state) {
            this.productOrderDID = productOrderDID;
            this.serviceLevelAgreementDID = serviceLevelAgreementDID;
            this.state = state;
        }

        @Suspendable
        @Override
        public UniqueIdentifier call() throws FlowException {

            QueryCriteria criteria = new QueryCriteria.VaultQueryCriteria(Vault.StateStatus.UNCONSUMED);

            try {
                FieldInfo productOrderDIDField =
                        getField("productOrderDID", ServiceLevelAgreementSchemaV1.ServiceLevelAgreement.class);
                criteria = criteria.and(new QueryCriteria.VaultCustomQueryCriteria(Builder.equal(productOrderDIDField,
                        productOrderDID)));

                FieldInfo serviceLevelAgreementDIDField =
                        getField("serviceLevelAgreementDID",
                                ServiceLevelAgreementSchemaV1.ServiceLevelAgreement.class);
                criteria = criteria.and(new QueryCriteria.VaultCustomQueryCriteria(Builder.equal(serviceLevelAgreementDIDField,
                        serviceLevelAgreementDID)));
            } catch(NoSuchFieldException e) {
                throw new IllegalArgumentException(e);
            }

            int pageNumber = DEFAULT_PAGE_NUM;
            List<StateAndRef<ServiceLevelAgreementState>> states = new ArrayList<>();
            long totalResults;
            do {
                PageSpecification pageSpecification = new PageSpecification(pageNumber, DEFAULT_PAGE_SIZE);
                Vault.Page<ServiceLevelAgreementState> results =
                        getServiceHub().getVaultService()
                                .queryBy(ServiceLevelAgreementState.class, criteria, pageSpecification);
                totalResults = results.getTotalStatesAvailable();
                states.addAll(results.getStates());
                pageNumber++;
            } while(((long) DEFAULT_PAGE_SIZE * (pageNumber - 1) <= totalResults));

            if(states.isEmpty())
                throw new FlowException("Service Level Agreement State not found for product order DID "
                        + productOrderDID + " and SLA DID " + serviceLevelAgreementDID);

            if(states.size() > 1)
                throw new FlowException("More than one Service Level Agreement State found for product order DID "
                        + productOrderDID + " and SLA DID " + serviceLevelAgreementDID);

            ServiceLevelAgreementState sla = states.get(0).getState().getData();

            if(getOurIdentity().equals(sla.getBuyer()))
                throw new FlowException("SLA State updated transaction must be initiated by the Seller");

            Set<FlowSession> sessions = initiateFlows(SetsKt.setOf(sla.getBuyer(), sla.getGovernanceParty()));
            List<PublicKey> requiredSigners = sla.getRequiredSigners();

            Command<?> cmd;
            if(state == SLAState.VIOLATED)
                 cmd = new Command<>(new ServiceLevelAgreementContract.ServiceLevelAgreementCommand.Update(), requiredSigners);
            else if(state == SLAState.RETIRED)
                cmd = new Command<>(new ServiceLevelAgreementContract.ServiceLevelAgreementCommand.Retire(), requiredSigners);
            else
                throw new FlowException("Invalid State specified for update.");

            TransactionBuilder txBuilder =
                    new TransactionBuilder(firstNotary()).addCommand(cmd).addInputState(states.get(0))
                            .addOutputState(sla.serviceLevelAgreementState(state));

            txBuilder.verify(getServiceHub());

            SignedTransaction signedTransaction = getServiceHub().signInitialTransaction(txBuilder);

            signedTransaction = subFlow(new CollectSignaturesFlow(signedTransaction, sessions));

            subFlow(new FinalityFlow(signedTransaction, sessions));

            return sla.getLinearId();
        }
    }

    @InitiatedBy(UpdateServiceLevelAgreementFlowInitiator.class)
    public static class UpdateServiceLevelAgreementFlowResponder extends ExtendedFlowLogic<SignedTransaction> {

        private final FlowSession counterParty;

        public UpdateServiceLevelAgreementFlowResponder(FlowSession counterParty) { this.counterParty = counterParty; }

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
