package eu._5gzorro.manager.dlt.corda.service.spectoken;

import eu._5gzorro.manager.dlt.corda.flows.spectoken.IssuePrimitiveSpecTokenTypeFlow.IssuePrimitiveSpecTokenTypeFlowInitiator;
import eu._5gzorro.manager.dlt.corda.service.rpc.NodeRPC;
import eu._5gzorro.manager.dlt.corda.service.rpc.RPCSyncService;
import eu._5gzorro.manager.dlt.corda.states.PrimitiveSpecTokenType;
import eu._5gzorro.manager.domain.events.enums.UpdateType;
import eu._5gzorro.manager.service.PrimitiveSpectokenDriver;
import eu._5gzorro.tm_forum.models.GeographicAddress;
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

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CordaPrimitiveSpectokenDriver extends RPCSyncService<PrimitiveSpecTokenType>
        implements PrimitiveSpectokenDriver {
    private final CordaRPCOps rpcClient;
    private final ReplaySubject<UpdateWrapper> subject = ReplaySubject.create();

    private final List<String> governanceNodeNames;

    public CordaPrimitiveSpectokenDriver(NodeRPC nodeRPC, List<String> governanceNodeNames) {
        super(nodeRPC, PrimitiveSpecTokenType.class);
        this.rpcClient = nodeRPC.getClient();
        this.governanceNodeNames = governanceNodeNames;
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
            @NotNull final String did,
            @NotNull final Double startDl,
            @NotNull final Double endDl,
            @NotNull final Double startUl,
            @NotNull final Double endUl,
            @NotNull final Date startDate,
            @NotNull final Date endDate,
            @NotNull final String duplexMode,
            @NotNull final Integer band,
            @NotNull final String technology,
            @NotNull final GeographicAddress geographicAddress,
            final String ownerDid
    ) {
        Party ourIdentity = rpcClient.nodeInfo().getLegalIdentities().get(0);

        PrimitiveSpecTokenType primitiveSpecTokenType =
                new PrimitiveSpecTokenType(
                        Collections.singletonList(ourIdentity),
                        new UniqueIdentifier(),
                        did,
                        startDl,
                        endDl,
                        startUl,
                        endUl,
                        startDate,
                        endDate,
                        duplexMode,
                        band,
                        technology,
                        geographicAddress,
                        ownerDid
                );

        rpcClient.startFlowDynamic(IssuePrimitiveSpecTokenTypeFlowInitiator.class, primitiveSpecTokenType);
    }

//  @Override
//  public void updateProductOffer(
//      ProductOfferDetails offerDetails, VerifiableCredential identityCredential) {
//    Party ourIdentity = rpcClient.nodeInfo().getLegalIdentities().get(0);
//
//    ProductOffering productOfferingState =
//        new ProductOffering(
//            new UniqueIdentifier(),
//            OfferType.GENERAL,
//            offerDetails.getProductOffering().getName(),
//            ourIdentity,
//            null, // TODO how will we update these?
//            null,
//            findGovernanceNode(),
//            null,
//            offerDetails
//        );
//
//    rpcClient.startFlowDynamic(UpdateProductOfferInitiator.class, productOfferingState);
//  }
//
//  @Override
//  public void removeProductOffer(String offerId, VerifiableCredential identityCredential) {
//    rpcClient.startFlowDynamic(RetireProductOfferInitiator.class, new UniqueIdentifier(offerId));
//  }
//
//  @Override
//  public Observable<ProductOfferingUpdateEvent> productOfferObservable() {
//    return subject.map(
//        updateWrapper -> {
//          StateAndRef<ProductOffering> stateAndRef = updateWrapper.getProductOfferingStateAndRef();
//          ProductOffering productOffering = stateAndRef.getState().getData();
//          ProductOfferDetails offerDetails = productOffering.getOfferDetails();
//          return new ProductOfferingUpdateEvent()
//              .setUpdateType(updateWrapper.getUpdateType())
//              .setDeduplicationId(stateAndRef.getRef().getTxhash().toString())
//              .setProductOffering(offerDetails.getProductOffering())
//              .setVerifiableCredentials(productOffering.getVerifiableCredentials())
//              .setDid(offerDetails.getDid())
//              .setProductSpecification(offerDetails.getProductSpecification())
//              .setProductOfferingPrices(offerDetails.getProductOfferingPrices())
//              .setResourceSpecifications(offerDetails.getResourceSpecifications())
//              .setServiceSpecifications(offerDetails.getServiceSpecifications())
//              .setGeographicAddresses(offerDetails.getGeographicAddresses())
//              .setInvitations(productOffering.getDidInvitations())
//              .setIdentifier(productOffering.getLinearId().getId().toString());
//        });
//  }

    private Party findGovernanceNode() {
        return governanceNodeNames.stream()
                .map(CordaX500Name::parse)
                .map(rpcClient::wellKnownPartyFromX500Name)
                .findAny()
                .orElseThrow(() -> new RuntimeException("No governance node was found"));
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
