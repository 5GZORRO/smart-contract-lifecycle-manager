package eu._5gzorro.manager.dlt.corda.service.spectoken;

import com.r3.corda.lib.tokens.contracts.states.NonFungibleToken;
import eu._5gzorro.manager.dlt.corda.flows.spectoken.*;
import eu._5gzorro.manager.dlt.corda.service.rpc.NodeRPC;
import eu._5gzorro.manager.dlt.corda.service.rpc.RPCSyncService;
import eu._5gzorro.manager.dlt.corda.states.DerivativeSpecTokenType;
import eu._5gzorro.manager.domain.ProductOfferDetails;
import eu._5gzorro.manager.domain.events.enums.UpdateType;
import eu._5gzorro.manager.exception.SpectokenException;
import eu._5gzorro.manager.service.DerivativeSpectokenDriver;
import eu._5gzorro.manager.service.identity.DIDToDLTIdentityService;
import eu._5gzorro.tm_forum.models.spectoken.DerivativeSpectokenDto;
import eu._5gzorro.tm_forum.models.spectoken.GetDerivativeSpectokenResponse;
import io.reactivex.rxjava3.subjects.ReplaySubject;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.identity.CordaX500Name;
import net.corda.core.identity.Party;
import net.corda.core.messaging.CordaRPCOps;
import net.corda.core.messaging.FlowHandle;
import net.corda.core.node.services.Vault;
import net.corda.core.node.services.Vault.StateStatus;
import net.corda.core.node.services.vault.QueryCriteria.VaultQueryCriteria;
import net.corda.core.transactions.SignedTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CordaDerivativeSpectokenDriver extends RPCSyncService<DerivativeSpecTokenType> implements DerivativeSpectokenDriver {
    private final DIDToDLTIdentityService didToDLTIdentityService;
    private final CordaRPCOps rpcClient;
    private final ReplaySubject<UpdateWrapper> subject = ReplaySubject.create();

    private final List<String> regulatorNodeNames;

    private final Party ourIdentity;

    private static final Logger log = LoggerFactory.getLogger(CordaDerivativeSpectokenDriver.class);

    public CordaDerivativeSpectokenDriver(DIDToDLTIdentityService didToDLTIdentityService, NodeRPC nodeRPC, List<String> regulatorNodeNames) {
        super(nodeRPC, DerivativeSpecTokenType.class);
        this.didToDLTIdentityService = didToDLTIdentityService;
        this.rpcClient = nodeRPC.getClient();
        this.regulatorNodeNames = regulatorNodeNames;
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
    public boolean issueDerivativeSpectoken(String offerDid, String ownerDid) throws ExecutionException, InterruptedException, SpectokenException {
        StateAndRef<DerivativeSpecTokenType> derivativeSpecTokenTypeStateAndRef = getDerivativeStateAndRef(offerDid);
        if (derivativeSpecTokenTypeStateAndRef.getState().getData().isIssued()) {
            throw new SpectokenException("DerivativeSpectokenType already issued.");
        }

        String x500Name = didToDLTIdentityService.resolveIdentity(ownerDid);
        Party consumer = rpcClient.wellKnownPartyFromX500Name(CordaX500Name.parse(x500Name));
//        Party consumer = rpcClient.wellKnownPartyFromX500Name(CordaX500Name.parse("O=OperatorB,OU=Zurich,L=47.38/8.54/Zurich,C=CH"));
//        Party consumer = rpcClient.wellKnownPartyFromX500Name(CordaX500Name.parse("O=OperatorC,OU=Barcelona,L=41.39/2.15/Barcelona,C=ES"));
//        Party consumer = rpcClient.wellKnownPartyFromX500Name(CordaX500Name.parse("CN=OperatorA,OU=DLT,O=OperatorA,L=51.50/-0.11/London,C=GB"));
        NonFungibleToken derivativeNft = rpcClient.startFlowDynamic(
            IssueDerivativeSpecTokenToHolderFlow.class,
            derivativeSpecTokenTypeStateAndRef.getState().getData(),
            ourIdentity,
            consumer
        ).getReturnValue().toCompletableFuture().get().getTx().outputsOfType(NonFungibleToken.class).get(0);

        FlowHandle<SignedTransaction> signedTransactionFlowHandle;
        if (derivativeNft != null) {
            signedTransactionFlowHandle = rpcClient.startFlowDynamic(UpdateIssuedDerivativeSpectokensFlow.class, derivativeSpecTokenTypeStateAndRef, true);
        } else {
            throw new SpectokenException("Derivative Spectoken not issued");
        }
        return signedTransactionFlowHandle.getReturnValue().get().getTx().outputsOfType(DerivativeSpecTokenType.class).get(0) != null;
    }

    @Override
    public boolean issueDerivativeSpectoken(String offerDid) throws ExecutionException, InterruptedException, SpectokenException {
        StateAndRef<DerivativeSpecTokenType> derivativeSpecTokenTypeStateAndRef = getDerivativeStateAndRef(offerDid);

        if (derivativeSpecTokenTypeStateAndRef.getState().getData().isIssued()) {
            throw new SpectokenException("DerivativeSpectokenType already issued.");
        }

        NonFungibleToken derivativeNft = rpcClient.startFlowDynamic(
            IssueDerivativeSpecTokenToHolderFlow.class,
            derivativeSpecTokenTypeStateAndRef.getState().getData(),
            ourIdentity,
            ourIdentity
        ).getReturnValue().toCompletableFuture().get().getTx().outputsOfType(NonFungibleToken.class).get(0);

        FlowHandle<SignedTransaction> signedTransactionFlowHandle;
        if (derivativeNft != null) {
            signedTransactionFlowHandle = rpcClient.startFlowDynamic(UpdateIssuedDerivativeSpectokensFlow.class, derivativeSpecTokenTypeStateAndRef, true);
        } else {
            throw new SpectokenException("Derivative Spectoken not issued");
        }

        return signedTransactionFlowHandle.getReturnValue().toCompletableFuture().get().getTx().outputsOfType(DerivativeSpecTokenType.class).get(0) != null;
    }

    @Override
    public boolean createDerivativeSpectokenFromOffer(ProductOfferDetails productOfferDetails, String offerDid) throws ExecutionException, InterruptedException {
        CompletableFuture<SignedTransaction> completableFuture = rpcClient.startFlowDynamic(
            CreateDerivativeSpecTokenTypeFromOfferFlow.class, productOfferDetails, offerDid, findRegulatorNode()
        ).getReturnValue().toCompletableFuture();
        DerivativeSpecTokenType resolvedDerivativeSpecTokenType = completableFuture.get().getTx().outputsOfType(DerivativeSpecTokenType.class).get(0);
        return resolvedDerivativeSpecTokenType != null;
    }

    @Override
    public List<GetDerivativeSpectokenResponse> getDerivativeSpectokens() throws ExecutionException, InterruptedException {
        List<StateAndRef<DerivativeSpecTokenType>> statesAndRefs = rpcClient.startFlowDynamic(
            GetDerivativeSpecTokensFlow.class
        ).getReturnValue().toCompletableFuture().get();
        List<GetDerivativeSpectokenResponse> derivativeSpectokens = new ArrayList<>();
        for (StateAndRef<DerivativeSpecTokenType> stateAndRef : statesAndRefs) {
            derivativeSpectokens.add(convertToResponse(stateAndRef.getState().getData()));
        }
        return derivativeSpectokens;
    }

    @Override
    public boolean redeemDerivativeSpectoken(String offerDid, String sellerName, boolean needIssuedUpdate) throws ExecutionException, InterruptedException, SpectokenException {
        Party seller = rpcClient.wellKnownPartyFromX500Name(CordaX500Name.parse(sellerName));
        FlowHandle<SignedTransaction> signedTransactionFlowHandle = rpcClient.startFlowDynamic(RedeemDerivativeSpecTokenFlow.class, offerDid, seller);
        if (needIssuedUpdate) {
            StateAndRef<DerivativeSpecTokenType> derivativeSpecTokenTypeStateAndRef = getDerivativeStateAndRef(offerDid);
            rpcClient.startFlowDynamic(UpdateIssuedDerivativeSpectokensFlow.class, derivativeSpecTokenTypeStateAndRef, false);
        }
        return signedTransactionFlowHandle.getReturnValue().toCompletableFuture().get().getTx().outputsOfType(NonFungibleToken.class).isEmpty();
    }

    @Override
    public DerivativeSpectokenDto getDerivativeSpectokenDto(String id) {
        Vault.Page<DerivativeSpecTokenType> derivativeSpecTokenTypePage = rpcClient.vaultQuery(DerivativeSpecTokenType.class);
        DerivativeSpectokenDto derivativeSpectokenDto = null;
        for (StateAndRef<DerivativeSpecTokenType> derivativeSpecTokenTypeStateAndRef : derivativeSpecTokenTypePage.getStates()) {
            DerivativeSpecTokenType derivativeSpecTokenType = derivativeSpecTokenTypeStateAndRef.getState().getData();
            if (derivativeSpecTokenType.getLinearId().toString().equals(id)) {
                derivativeSpectokenDto = convertToDto(derivativeSpecTokenType);
                break;
            }
        }
        return derivativeSpectokenDto;
    }

    @Override
    public boolean invalidateDerivativeSpectoken(String id) throws ExecutionException, InterruptedException {
        CompletableFuture<String> derivativeCompletableFuture = rpcClient.startFlowDynamic(InvalidateDerivativeSpectokenFlow.class, id).getReturnValue().toCompletableFuture();
        return id.equals(derivativeCompletableFuture.get());
    }

    @Override
    public List<DerivativeSpectokenDto> getOwnValidDerivativeSpectokens() {
        Vault.Page<DerivativeSpecTokenType> derivativeSpecTokenTypePage = rpcClient.vaultQuery(DerivativeSpecTokenType.class);
        List<DerivativeSpectokenDto> derivativeSpectokenDtos = new ArrayList<>();
        for (StateAndRef<DerivativeSpecTokenType> derivativeSpecTokenTypeStateAndRef : derivativeSpecTokenTypePage.getStates()) {
            if (derivativeSpecTokenTypeStateAndRef.getState().getData().getMaintainers().contains(ourIdentity) && derivativeSpecTokenTypeStateAndRef.getState().getData().isValid()) {
                derivativeSpectokenDtos.add(convertToDto(derivativeSpecTokenTypeStateAndRef.getState().getData()));
            }
        }
        return derivativeSpectokenDtos;
    }

    private Party findRegulatorNode() {
        return regulatorNodeNames.stream()
            .map(CordaX500Name::parse)
            .map(rpcClient::wellKnownPartyFromX500Name)
            .findAny()
            .orElseThrow(() -> new RuntimeException("No regulator node was found"));
    }

    private GetDerivativeSpectokenResponse convertToResponse(DerivativeSpecTokenType derivativeSpecTokenType) {
        return new GetDerivativeSpectokenResponse(
            derivativeSpecTokenType.getLinearId().toString(),
            derivativeSpecTokenType.getStartDl(),
            derivativeSpecTokenType.getEndDl(),
            derivativeSpecTokenType.getStartUl(),
            derivativeSpecTokenType.getEndUl(),
            derivativeSpecTokenType.getStartDate(),
            derivativeSpecTokenType.getEndDate(),
            derivativeSpecTokenType.getDuplexMode(),
            derivativeSpecTokenType.getBand(),
            derivativeSpecTokenType.getTechnology(),
            derivativeSpecTokenType.getCountry(),
            derivativeSpecTokenType.getPrice(),
            derivativeSpecTokenType.getPrimitiveId(),
            derivativeSpecTokenType.getOfferDid(),
            derivativeSpecTokenType.isValid());
    }

    private DerivativeSpectokenDto convertToDto(DerivativeSpecTokenType derivativeSpecTokenType) {
        return new DerivativeSpectokenDto(derivativeSpecTokenType.isValid(), derivativeSpecTokenType.getOfferDid(), derivativeSpecTokenType.getLinearId().toString(), derivativeSpecTokenType.getEndDate());
    }

    private StateAndRef<DerivativeSpecTokenType> getDerivativeStateAndRef(String offerDid) throws SpectokenException {
        List<StateAndRef<DerivativeSpecTokenType>> states = rpcClient.vaultQuery(DerivativeSpecTokenType.class).getStates();
        StateAndRef<DerivativeSpecTokenType> derivativeSpecTokenTypeStateAndRef = null;

        for (StateAndRef<DerivativeSpecTokenType> stateAndRef : states) {
            DerivativeSpecTokenType derivativeSpecTokenType = stateAndRef.getState().getData();
            if (derivativeSpecTokenType.getOfferDid().equals(offerDid) && derivativeSpecTokenType.isValid()) {
                derivativeSpecTokenTypeStateAndRef = stateAndRef;
                break;
            }
        }

        if (derivativeSpecTokenTypeStateAndRef == null) {
            throw new SpectokenException("Valid DerivativeSpectokenType not found for offerDid " + offerDid);
        }

        return derivativeSpecTokenTypeStateAndRef;
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
