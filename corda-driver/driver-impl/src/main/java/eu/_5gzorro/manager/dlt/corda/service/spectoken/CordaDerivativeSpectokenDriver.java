package eu._5gzorro.manager.dlt.corda.service.spectoken;

import eu._5gzorro.manager.dlt.corda.flows.spectoken.CreateDerivativeSpecTokenTypeFlow;
import eu._5gzorro.manager.dlt.corda.flows.spectoken.CreatePrimitiveSpecTokenTypeFlow;
import eu._5gzorro.manager.dlt.corda.flows.spectoken.IssueDerivativeSpecTokenToHolderFlow;
import eu._5gzorro.manager.dlt.corda.service.rpc.NodeRPC;
import eu._5gzorro.manager.dlt.corda.service.rpc.RPCSyncService;
import eu._5gzorro.manager.dlt.corda.states.DerivativeSpecTokenType;
import eu._5gzorro.manager.domain.events.enums.UpdateType;
import eu._5gzorro.manager.service.DerivativeSpectokenDriver;
import eu._5gzorro.manager.service.identity.DIDToDLTIdentityService;
import io.reactivex.rxjava3.subjects.ReplaySubject;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.CordaX500Name;
import net.corda.core.identity.Party;
import net.corda.core.messaging.CordaRPCOps;
import net.corda.core.node.services.Vault;
import net.corda.core.node.services.Vault.StateStatus;
import net.corda.core.node.services.vault.QueryCriteria.VaultQueryCriteria;
import net.corda.core.transactions.SignedTransaction;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CordaDerivativeSpectokenDriver extends RPCSyncService<DerivativeSpecTokenType> implements DerivativeSpectokenDriver {
    private final DIDToDLTIdentityService didToDLTIdentityService;
    private final CordaRPCOps rpcClient;
    private final ReplaySubject<UpdateWrapper> subject = ReplaySubject.create();

    private final List<String> governanceNodeNames;

    private final Party ourIdentity;

    private static final Logger log = LoggerFactory.getLogger(CordaDerivativeSpectokenDriver.class);

    public CordaDerivativeSpectokenDriver(DIDToDLTIdentityService didToDLTIdentityService, NodeRPC nodeRPC, List<String> governanceNodeNames) {
        super(nodeRPC, DerivativeSpecTokenType.class);
        this.didToDLTIdentityService = didToDLTIdentityService;
        this.rpcClient = nodeRPC.getClient();
        this.governanceNodeNames = governanceNodeNames;
        this.ourIdentity = rpcClient.nodeInfo().getLegalIdentities().get(0);
        setup();
    }

    @Override
    public void setup() {
        VaultQueryCriteria criteria = new VaultQueryCriteria(StateStatus.UNCONSUMED);

        this.beginTracking(
                criteria,
                this::handleUpdate,
                stateAndRef ->
                        subject.onNext(
                                new UpdateWrapper()
                                        .setSpectokenStateAndRef(stateAndRef)
                                        .setUpdateType(UpdateType.CREATE_UPDATE)));
    }

    private void handleUpdate(Vault.Update<DerivativeSpecTokenType> derivativeSpecTokenTypeUpdate) {
    }

    @Override
    public void createDerivativeSpectoken(
            @NotNull final Double startDl,
            @NotNull final Double endDl,
            @NotNull final Double startUl,
            @NotNull final Double endUl,
            @NotNull final Date startDate,
            @NotNull final Date endDate,
            @NotNull final String duplexMode,
            @NotNull final Integer band,
            @NotNull final String technology,
            @NotNull final String country,
            @NotNull final String ownerDid,
            @NotNull final String primitiveDid,
            final Float price
    ) {
        String x500Name = didToDLTIdentityService.resolveIdentity(ownerDid);
        Party provider = rpcClient.wellKnownPartyFromX500Name(CordaX500Name.parse(x500Name));
        DerivativeSpecTokenType derivativeSpecTokenType =
                new DerivativeSpecTokenType(
                        Collections.singletonList(provider),
                        new UniqueIdentifier(),
                        startDl,
                        endDl,
                        startUl,
                        endUl,
                        startDate,
                        endDate,
                        duplexMode,
                        band,
                        technology,
                        country,
                        ownerDid,
                        primitiveDid,
                        price
                );


        CompletableFuture<SignedTransaction> completableFuture = rpcClient.startFlowDynamic(CreateDerivativeSpecTokenTypeFlow.class, derivativeSpecTokenType).getReturnValue().toCompletableFuture();
        try {
            DerivativeSpecTokenType resolvedDerivativeSpecTokenType = completableFuture.get().getTx().outputsOfType(DerivativeSpecTokenType.class).get(0);
            rpcClient.startFlowDynamic(IssueDerivativeSpecTokenToHolderFlow.class, resolvedDerivativeSpecTokenType, ourIdentity, provider);
        } catch (InterruptedException | ExecutionException e) {
            log.error(e.getMessage());
        }
    }

    public static class UpdateWrapper {
        private StateAndRef<DerivativeSpecTokenType> derivativeSpecTokenTypeStateAndRef;
        private UpdateType updateType;

        public StateAndRef<DerivativeSpecTokenType> getDerivativeSpecTokenTypeStateAndRef() {
            return derivativeSpecTokenTypeStateAndRef;
        }

        public UpdateWrapper setSpectokenStateAndRef(
                StateAndRef<DerivativeSpecTokenType> derivativeSpecTokenTypeStateAndRef) {
            this.derivativeSpecTokenTypeStateAndRef = derivativeSpecTokenTypeStateAndRef;
            return this;
        }

        public UpdateType getUpdateType() {
            return updateType;
        }

        public UpdateWrapper setUpdateType(UpdateType updateType) {
            this.updateType = updateType;
            return this;
        }
    }
}
