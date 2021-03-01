package eu._5gzorro.manager.dlt.corda.service.product_offering;

import eu._5gzorro.manager.dlt.corda.flows.product_offer.PublishProductOfferFlow.PublishProductOfferInitiator;
import eu._5gzorro.manager.dlt.corda.flows.product_offer.RetireProductOfferFlow.RetireProductOfferInitiator;
import eu._5gzorro.manager.dlt.corda.flows.product_offer.UpdateProductOfferFlow.UpdateProductOfferInitiator;
import eu._5gzorro.manager.dlt.corda.models.types.OfferType;
import eu._5gzorro.manager.dlt.corda.service.rpc.NodeRPC;
import eu._5gzorro.manager.dlt.corda.service.rpc.RPCSyncService;
import eu._5gzorro.manager.dlt.corda.states.ProductOffering;
import eu._5gzorro.manager.domain.Invitation;
import eu._5gzorro.manager.domain.VerifiableCredential;
import eu._5gzorro.manager.service.ProductOfferingDriver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import java.util.Collection;
import java.util.Map;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.contracts.TransactionState;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.Party;
import net.corda.core.messaging.CordaRPCOps;
import net.corda.core.node.services.Vault;
import net.corda.core.node.services.Vault.StateStatus;
import net.corda.core.node.services.vault.QueryCriteria.VaultQueryCriteria;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class CordaProductOfferingDriver extends RPCSyncService<ProductOffering> implements
    ProductOfferingDriver {
  private final CordaRPCOps rpcClient;
  PublishSubject<ProductOffering> subject = PublishSubject.create();

  public CordaProductOfferingDriver(NodeRPC nodeRPC) {
    super(nodeRPC, ProductOffering.class);
    this.rpcClient = nodeRPC.getClient();
  }

  @Override
  public void setup() {
    VaultQueryCriteria criteria = new VaultQueryCriteria(StateStatus.UNCONSUMED);

    this.beginTracking(
        criteria,
        this::handleUpdate,
        productOfferingStateAndRef -> {
          subject.onNext(productOfferingStateAndRef.getState().getData());
        }
    );
  }

  private void handleUpdate(@NotNull final Vault.Update<ProductOffering> update) {
    update.getProduced()
        .stream()
        .map(StateAndRef::getState)
        .map(TransactionState::getData)
        .forEach(offer -> subject.onNext(offer));
  }

  @Override
  public void publishProductOffering(
      eu._5gzorro.manager.domain.ProductOffering offer,
      Map<String, Invitation> invitations,
      Collection<VerifiableCredential> verifiableCredentials,
      VerifiableCredential identityCredential) {
    Party ourIdentity = rpcClient.nodeInfo().getLegalIdentities().get(0);

    ProductOffering productOfferingState = new ProductOffering(
        new UniqueIdentifier(),
        OfferType.GENERAL,
        offer.getName(),
        ourIdentity,
        offer,
        invitations,
        findGovernanceNode(),
        null
    );

    rpcClient.startFlowDynamic(PublishProductOfferInitiator.class, productOfferingState);
  }

  @Override
  public void updateProductOffer(
      eu._5gzorro.manager.domain.ProductOffering offer,
      VerifiableCredential identityCredential) {
    // Stub
    Party ourIdentity = rpcClient.nodeInfo().getLegalIdentities().get(0);

    ProductOffering productOfferingState = new ProductOffering(
        new UniqueIdentifier(),
        OfferType.GENERAL,
        offer.getName(),
        ourIdentity,
        offer,
        null, // TODO how will we update these?
        findGovernanceNode(),
        null
    );

    rpcClient.startFlowDynamic(UpdateProductOfferInitiator.class, productOfferingState);
  }

  @Override
  public void removeProductOffer(String offerId, VerifiableCredential identityCredential) {
    rpcClient.startFlowDynamic(RetireProductOfferInitiator.class, new UniqueIdentifier(offerId));
  }

  @Override
  public Observable<eu._5gzorro.manager.domain.ProductOffering> productOfferObservable() {
    return subject
        .map(offerState -> new eu._5gzorro.manager.domain.ProductOffering()
            .setName(offerState.getName())
            .setProductOfferTerms(offerState.getProductOfferTerms())
            .setPlaces(offerState.getPlaces())
            .setServiceCandidate(offerState.getServiceCandidate())
            .setServiceLevelAgreements(offerState.getServiceLevelAgreements())
    );
  }

  private Party findGovernanceNode() {
    return null; // TODO add method to obtain a governance node party
  }
}
