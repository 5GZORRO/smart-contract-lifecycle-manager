package eu._5gzorro.manager.dlt.corda.flows.license;

import co.paralleluniverse.fibers.Suspendable;
import eu._5gzorro.manager.dlt.corda.contracts.LicenseTermContract;
import eu._5gzorro.manager.dlt.corda.flows.utils.ExtendedFlowLogic;
import eu._5gzorro.manager.dlt.corda.models.types.LTState;
import eu._5gzorro.manager.dlt.corda.states.LicenseTermState;
import eu._5gzorro.manager.dlt.corda.states.schemes.LicenseTermSchemaV1;
import kotlin.collections.SetsKt;
import net.corda.core.contracts.Command;
import net.corda.core.contracts.CommandData;
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

public class UpdateLicenseTermFlow {

    @InitiatingFlow
    @StartableByRPC
    public static class UpdateLicenseTermFlowInitiator extends ExtendedFlowLogic<UniqueIdentifier> {

        private final String productOrderDID;
        private final String productOfferingDID;
        private final Integer current;
        private final LTState state;

        public UpdateLicenseTermFlowInitiator(String productOrderDID,
                                              String productOfferingDID,
                                              Integer current,
                                              LTState state) {
            this.productOrderDID    = productOrderDID;
            this.productOfferingDID = productOfferingDID;
            this.current            = current;
            this.state              = state;
        }

        @Suspendable
        @Override
        public UniqueIdentifier call() throws FlowException {

            QueryCriteria criteria = new QueryCriteria.VaultQueryCriteria(Vault.StateStatus.UNCONSUMED);

            try {
                FieldInfo productOrderDIDField =
                        getField("productOrderDID", LicenseTermSchemaV1.LicenseTerm.class);
                criteria = criteria.and(new QueryCriteria.VaultCustomQueryCriteria(Builder.equal(productOrderDIDField,
                        productOrderDID)));

                FieldInfo productOfferingDIDField =
                        getField("productOfferingDID", LicenseTermSchemaV1.LicenseTerm.class);
                criteria =
                        criteria.and(new QueryCriteria.VaultCustomQueryCriteria(Builder.equal(productOfferingDIDField,
                                productOfferingDID)));
            } catch (NoSuchFieldException e) {
                throw new IllegalArgumentException(e);
            }

            int pageNumber = DEFAULT_PAGE_NUM;
            List<StateAndRef<LicenseTermState>> states = new ArrayList<>();
            long totalResults;
            do {
                PageSpecification pageSpecification = new PageSpecification(pageNumber, DEFAULT_PAGE_SIZE);
                Vault.Page<LicenseTermState> results =
                        getServiceHub().getVaultService().queryBy(LicenseTermState.class, criteria, pageSpecification);
                totalResults = results.getTotalStatesAvailable();
                states.addAll(results.getStates());
                pageNumber++;
            } while(((long) DEFAULT_PAGE_SIZE * (pageNumber - 1) <= totalResults));

            if(states.isEmpty())
                throw new FlowException("License Term State not found for product order DID "
                        + productOrderDID + " and product offering DID " + productOfferingDID);

            if(states.size() > 1)
                throw new FlowException("More than one License Term State found for product order DID "
                        + productOrderDID + " and product offering DID " + productOfferingDID);

            LicenseTermState licenseTermState = states.get(0).getState().getData();

            if(getOurIdentity().equals(licenseTermState.getBuyer()))
                throw new FlowException("License Term State update cannot be initiated by the Buyer");

            Set<FlowSession> sessions = initiateFlows(SetsKt.setOf(licenseTermState.getBuyer(),
                    licenseTermState.getGovernanceParty()));
            List<PublicKey> requiredSigners = licenseTermState.getRequiredSigners();

            Command<?> cmd;
            if(state == LTState.VIOLATED || state == LTState.IN_PLACE)
                cmd = new Command<>(new LicenseTermContract.LicenseTermCommand.Update(), requiredSigners);
            else if(state == LTState.RETIRED)
                cmd = new Command<>(new LicenseTermContract.LicenseTermCommand.Retire(), requiredSigners);
            else
                throw new FlowException("Invalid State specified for update.");

            licenseTermState.setLicenseTermState(state);
            licenseTermState.getLicenseTerm().setCurrent(current);
            TransactionBuilder txBuilder =
                    new TransactionBuilder(firstNotary()).addCommand(cmd).addInputState(states.get(0))
                            .addOutputState(licenseTermState);
            txBuilder.verify(getServiceHub());

            SignedTransaction signedTransaction = getServiceHub().signInitialTransaction(txBuilder);
            signedTransaction = subFlow(new CollectSignaturesFlow(signedTransaction, sessions));

            subFlow(new FinalityFlow(signedTransaction, sessions));

            return licenseTermState.getLinearId();
        }

        @InitiatedBy(UpdateLicenseTermFlowInitiator.class)
        public static class UpdateLicenseTermFlowResponder extends ExtendedFlowLogic<SignedTransaction> {

            private final FlowSession counterParty;

            public UpdateLicenseTermFlowResponder(FlowSession counterParty) {
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
}
