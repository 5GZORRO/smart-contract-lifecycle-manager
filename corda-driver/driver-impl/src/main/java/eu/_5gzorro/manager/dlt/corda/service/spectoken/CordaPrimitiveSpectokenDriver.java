package eu._5gzorro.manager.dlt.corda.service.spectoken;

import com.r3.corda.lib.tokens.workflows.flows.rpc.RedeemNonFungibleTokens;
import eu._5gzorro.manager.dlt.corda.flows.spectoken.CreatePrimitiveSpecTokenTypeFlow;
import eu._5gzorro.manager.dlt.corda.flows.spectoken.GetPrimitiveSpecTokensFlow;
import eu._5gzorro.manager.dlt.corda.flows.spectoken.IssuePrimitiveSpecTokenToHolderFlow;
import eu._5gzorro.manager.dlt.corda.flows.spectoken.RedeemPrimitiveSpecTokenFlow;
import eu._5gzorro.manager.dlt.corda.service.rpc.NodeRPC;
import eu._5gzorro.manager.dlt.corda.service.rpc.RPCSyncService;
import eu._5gzorro.manager.dlt.corda.states.PrimitiveSpecTokenType;
import eu._5gzorro.manager.domain.events.enums.UpdateType;
import eu._5gzorro.manager.service.PrimitiveSpectokenDriver;
import eu._5gzorro.manager.service.identity.DIDToDLTIdentityService;
import eu._5gzorro.tm_forum.models.spectoken.GetPrimitiveSpectokenResponse;
import io.reactivex.rxjava3.core.Observable;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CordaPrimitiveSpectokenDriver extends RPCSyncService<PrimitiveSpecTokenType> implements PrimitiveSpectokenDriver {
    private final DIDToDLTIdentityService didToDLTIdentityService;
    private final CordaRPCOps rpcClient;
    private final ReplaySubject<UpdateWrapper> subject = ReplaySubject.create();

    private final List<String> governanceNodeNames;

    private final Party ourIdentity;

    private static final Logger log = LoggerFactory.getLogger(CordaPrimitiveSpectokenDriver.class);

    public CordaPrimitiveSpectokenDriver(DIDToDLTIdentityService didToDLTIdentityService, NodeRPC nodeRPC, List<String> governanceNodeNames) {
        super(nodeRPC, PrimitiveSpecTokenType.class);
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

    private void handleUpdate(Vault.Update<PrimitiveSpecTokenType> primitiveSpecTokenTypeUpdate) {
    }

    @Override
    public void createPrimitiveSpectoken(
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
        final String ownerDid,
        @NotNull final String license
    ) {
        String x500Name = didToDLTIdentityService.resolveIdentity(ownerDid);
        Party provider = rpcClient.wellKnownPartyFromX500Name(CordaX500Name.parse(x500Name));
//        Party provider = rpcClient.wellKnownPartyFromX500Name(CordaX500Name.parse("O=OperatorB,OU=Zurich,L=47.38/8.54/Zurich,C=CH"));
        PrimitiveSpecTokenType primitiveSpecTokenType =
            new PrimitiveSpecTokenType(
                Collections.singletonList(ourIdentity),
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
                license,
                ownerDid
            );
        CompletableFuture<SignedTransaction> completableFuture = rpcClient.startFlowDynamic(CreatePrimitiveSpecTokenTypeFlow.class, primitiveSpecTokenType).getReturnValue().toCompletableFuture();
        try {
            PrimitiveSpecTokenType resolvedPrimitiveSpecTokenType = completableFuture.get().getTx().outputsOfType(PrimitiveSpecTokenType.class).get(0);
            rpcClient.startFlowDynamic(IssuePrimitiveSpecTokenToHolderFlow.class, resolvedPrimitiveSpecTokenType, ourIdentity, provider);
        } catch (InterruptedException | ExecutionException e) {
            log.error(e.getMessage());
        }
    }

    public Observable<PrimitiveSpecTokenType> primitiveSpecTokenTypeObservable() {
        return subject.map(
            updateWrapper -> {
                StateAndRef<PrimitiveSpecTokenType> stateAndRef = updateWrapper.getPrimitiveSpecTokenTypeStateAndRef();
                return stateAndRef.getState().getData();
            });
    }

    @Override
    public List<GetPrimitiveSpectokenResponse> getPrimitiveSpectokens() throws ExecutionException, InterruptedException {
        List<StateAndRef<PrimitiveSpecTokenType>> statesAndRefs = rpcClient.startFlowDynamic(
            GetPrimitiveSpecTokensFlow.class
        ).getReturnValue().toCompletableFuture().get();
        List<GetPrimitiveSpectokenResponse> primitiveSpectokens = new ArrayList<>();
        for (StateAndRef<PrimitiveSpecTokenType> stateAndRef : statesAndRefs) {
            primitiveSpectokens.add(convertToResponse(stateAndRef.getState().getData()));
        }
        return primitiveSpectokens;
    }

    @Override
    public void redeemPrimitiveSpectoken(String licenseId) {
        Party issuer = rpcClient.wellKnownPartyFromX500Name(CordaX500Name.parse("O=OperatorC,OU=Barcelona,L=41.39/2.15/Barcelona,C=ES"));
        rpcClient.startFlowDynamic(RedeemPrimitiveSpecTokenFlow.class, licenseId, issuer);
    }

    private GetPrimitiveSpectokenResponse convertToResponse(PrimitiveSpecTokenType primitiveSpecTokenType) {
        return new GetPrimitiveSpectokenResponse(
            primitiveSpecTokenType.getLinearId().toString(),
            primitiveSpecTokenType.getStartDl(),
            primitiveSpecTokenType.getEndDl(),
            primitiveSpecTokenType.getStartUl(),
            primitiveSpecTokenType.getEndUl(),
            primitiveSpecTokenType.getStartDate(),
            primitiveSpecTokenType.getEndDate(),
            primitiveSpecTokenType.getDuplexMode(),
            primitiveSpecTokenType.getBand(),
            primitiveSpecTokenType.getTechnology(),
            primitiveSpecTokenType.getCountry(),
            primitiveSpecTokenType.getOwnerDid(),
            primitiveSpecTokenType.getLicense()
        );
    }

    public static class UpdateWrapper {
        private StateAndRef<PrimitiveSpecTokenType> primitiveSpecTokenTypeStateAndRef;
        private UpdateType updateType;

        public StateAndRef<PrimitiveSpecTokenType> getPrimitiveSpecTokenTypeStateAndRef() {
            return primitiveSpecTokenTypeStateAndRef;
        }

        public UpdateWrapper setSpectokenStateAndRef(
            StateAndRef<PrimitiveSpecTokenType> primitiveSpecTokenTypeStateAndRef) {
            this.primitiveSpecTokenTypeStateAndRef = primitiveSpecTokenTypeStateAndRef;
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
