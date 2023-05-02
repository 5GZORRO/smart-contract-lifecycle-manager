package eu._5gzorro.manager.dlt.corda.service.product_offering;

import eu._5gzorro.manager.dlt.corda.flows.product_offer.PublishProductOfferFlow.PublishProductOfferInitiator;
import eu._5gzorro.manager.dlt.corda.flows.product_offer.RetireProductOfferFlow.RetireProductOfferInitiator;
import eu._5gzorro.manager.dlt.corda.flows.product_offer.UpdateProductOfferFlow.UpdateProductOfferInitiator;
import eu._5gzorro.manager.dlt.corda.models.types.OfferType;
import eu._5gzorro.manager.dlt.corda.service.rpc.NodeRPC;
import eu._5gzorro.manager.dlt.corda.service.rpc.RPCSyncService;
import eu._5gzorro.manager.dlt.corda.states.ProductOffering;
import eu._5gzorro.manager.domain.Invitation;
import eu._5gzorro.manager.domain.ProductOfferDetails;
import eu._5gzorro.manager.domain.VerifiableCredential;
import eu._5gzorro.manager.domain.events.ProductOfferingUpdateEvent;
import eu._5gzorro.manager.domain.events.enums.OrderUpdateType;
import eu._5gzorro.manager.domain.events.enums.UpdateType;
import eu._5gzorro.manager.exception.SpectokenException;
import eu._5gzorro.manager.service.DerivativeSpectokenDriver;
import eu._5gzorro.manager.service.ProductOfferingDriver;
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
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

public class CordaProductOfferingDriver extends RPCSyncService<ProductOffering>
    implements ProductOfferingDriver {
    private final CordaRPCOps rpcClient;
    private final ReplaySubject<UpdateWrapper> subject = ReplaySubject.create();

    private final List<String> regulatorNodeNames;
    private final DerivativeSpectokenDriver derivativeSpectokenDriver;

    public CordaProductOfferingDriver(NodeRPC nodeRPC, List<String> regulatorNodeNames, DerivativeSpectokenDriver derivativeSpectokenDriver) {
        super(nodeRPC, ProductOffering.class);
        this.rpcClient = nodeRPC.getClient();
        this.regulatorNodeNames = regulatorNodeNames;
        this.derivativeSpectokenDriver = derivativeSpectokenDriver;
        setup();
    }

    @Override
    public void setup() {
        VaultQueryCriteria unconsumedCriteria = new VaultQueryCriteria(StateStatus.UNCONSUMED);

        this.beginTracking(
            unconsumedCriteria,
            this::handleUpdate,
            stateAndRef ->
                subject.onNext(
                    new UpdateWrapper()
                        .setProductOfferingStateAndRef(stateAndRef)
                        .setUpdateType(UpdateType.CREATE_UPDATE)));

        VaultQueryCriteria consumedCriteria = new VaultQueryCriteria(StateStatus.CONSUMED);

        this.beginTracking(
            consumedCriteria,
            this::handleUpdate,
            stateAndRef ->
                subject.onNext(
                    new UpdateWrapper()
                        .setProductOfferingStateAndRef(stateAndRef)
                        .setUpdateType(UpdateType.RETIRE)));
    }

    private void handleUpdate(@NotNull final Vault.Update<ProductOffering> update) {
        // Agreement updates should only ever have one input and one output at most
        Optional<StateAndRef<ProductOffering>> optionalConsumed =
            update.getConsumed().stream().findAny();
        Optional<StateAndRef<ProductOffering>> optionalProduced =
            update.getProduced().stream().findAny();

        UpdateType updateType;
        if (optionalConsumed.isPresent()) { // Delete
            updateType = UpdateType.RETIRE;
        } else if (optionalProduced.isPresent()) { // Create/Update
            updateType = UpdateType.CREATE_UPDATE;
        } else {
            throw new RuntimeException("Invalid product offer update");
        }

        update
            .getProduced()
            .forEach(
                produced ->
                    subject.onNext(
                        new UpdateWrapper()
                            .setProductOfferingStateAndRef(produced)
                            .setUpdateType(updateType)));

        update
            .getConsumed()
            .forEach(
                consumed ->
                    subject.onNext(
                        new UpdateWrapper()
                            .setProductOfferingStateAndRef(consumed)
                            .setUpdateType(updateType)));
    }

    @Override
    public void publishProductOffering(
        ProductOfferDetails offerDetails,
        Map<String, Invitation> invitations,
        Collection<VerifiableCredential> verifiableCredentials,
        VerifiableCredential identityCredential,
        String did) throws ExecutionException, InterruptedException, SpectokenException {
        Party ourIdentity = rpcClient.nodeInfo().getLegalIdentities().get(0);

        String category = offerDetails.getProductOffering().getCategory().get(0).getName();

        ProductOffering productOfferingState =
            new ProductOffering(
                new UniqueIdentifier(),
                OfferType.GENERAL,
                offerDetails.getProductOffering().getName(),
                ourIdentity,
                invitations,
                verifiableCredentials,
                null,
                offerDetails
            );

        if ("Spectrum".equals(category)) {
            boolean isDerivativeSpectokenCreated = derivativeSpectokenDriver.createDerivativeSpectokenFromOffer(offerDetails, did);
            if (isDerivativeSpectokenCreated) {
                productOfferingState.setSpectrumOracle(findRegulatorNode());
                rpcClient.startFlowDynamic(PublishProductOfferInitiator.class, productOfferingState);
            }
        } else if ("Slice".equals(category)) {
            boolean isDerivativeSpectokenCreated = derivativeSpectokenDriver.createDerivativeSpectokenFromOffer(offerDetails, did);
            boolean isDerivativeSpectokenIssued = derivativeSpectokenDriver.issueDerivativeSpectoken(offerDetails.getDid());
            if (isDerivativeSpectokenCreated & isDerivativeSpectokenIssued) {
                rpcClient.startFlowDynamic(PublishProductOfferInitiator.class, productOfferingState);
            }
        } else {
            rpcClient.startFlowDynamic(PublishProductOfferInitiator.class, productOfferingState);
        }
    }

    @Override
    public void updateProductOffer(
        ProductOfferDetails offerDetails, VerifiableCredential identityCredential) {
        Party ourIdentity = rpcClient.nodeInfo().getLegalIdentities().get(0);

        ProductOffering productOfferingState =
            new ProductOffering(
                new UniqueIdentifier(),
                OfferType.GENERAL,
                offerDetails.getProductOffering().getName(),
                ourIdentity,
                null, // TODO how will we update these?
                null,
                null,
                offerDetails
            );

        rpcClient.startFlowDynamic(UpdateProductOfferInitiator.class, productOfferingState);
    }

    @Override
    public void removeProductOffer(String offerId) {
        rpcClient.startFlowDynamic(RetireProductOfferInitiator.class, offerId);
    }

    @Override
    public Observable<ProductOfferingUpdateEvent> productOfferObservable() {
        return subject.map(
            updateWrapper -> {
                StateAndRef<ProductOffering> stateAndRef = updateWrapper.getProductOfferingStateAndRef();
                ProductOffering productOffering = stateAndRef.getState().getData();
                ProductOfferDetails offerDetails = productOffering.getOfferDetails();
                return new ProductOfferingUpdateEvent()
                    .setUpdateType(updateWrapper.getUpdateType())
                    .setDeduplicationId(stateAndRef.getRef().getTxhash().toString())
                    .setProductOffering(offerDetails.getProductOffering())
                    .setVerifiableCredentials(productOffering.getVerifiableCredentials())
                    .setDid(offerDetails.getDid())
                    .setProductSpecification(offerDetails.getProductSpecification())
                    .setProductOfferingPrices(offerDetails.getProductOfferingPrices())
                    .setResourceSpecifications(offerDetails.getResourceSpecifications())
                    .setServiceSpecifications(offerDetails.getServiceSpecifications())
                    .setGeographicAddresses(offerDetails.getGeographicAddresses())
                    .setInvitations(productOffering.getDidInvitations())
                    .setIdentifier(productOffering.getLinearId().getId().toString())
                    .setDeleted(updateWrapper.getUpdateType().equals(UpdateType.RETIRE));
            });
    }

    private Party findRegulatorNode() {
        return regulatorNodeNames.stream()
            .map(CordaX500Name::parse)
            .map(rpcClient::wellKnownPartyFromX500Name)
            .findAny()
            .orElseThrow(() -> new RuntimeException("No regulator node was found"));
    }

    public static class UpdateWrapper {
        private StateAndRef<ProductOffering> productOfferingStateAndRef;
        private UpdateType updateType;

        public StateAndRef<ProductOffering> getProductOfferingStateAndRef() {
            return productOfferingStateAndRef;
        }

        public UpdateWrapper setProductOfferingStateAndRef(
            StateAndRef<ProductOffering> productOfferingStateAndRef) {
            this.productOfferingStateAndRef = productOfferingStateAndRef;
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
