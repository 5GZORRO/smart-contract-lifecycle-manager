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
import eu._5gzorro.manager.domain.events.ProductOfferingUpdateEvent;
import eu._5gzorro.manager.service.ProductOfferingDriver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.ReplaySubject;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.contracts.TransactionState;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.CordaX500Name;
import net.corda.core.identity.Party;
import net.corda.core.messaging.CordaRPCOps;
import net.corda.core.node.services.Vault;
import net.corda.core.node.services.Vault.StateStatus;
import net.corda.core.node.services.vault.QueryCriteria.VaultQueryCriteria;
import org.jetbrains.annotations.NotNull;

public class CordaProductOfferingDriver extends RPCSyncService<ProductOffering> implements
    ProductOfferingDriver {
  private final CordaRPCOps rpcClient;
  private final ReplaySubject<ProductOffering> subject = ReplaySubject.create();

  private final List<String> governanceNodeNames;

  public CordaProductOfferingDriver(NodeRPC nodeRPC, List<String> governanceNodeNames) {
    super(nodeRPC, ProductOffering.class);
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
        productOfferingStateAndRef -> subject.onNext(productOfferingStateAndRef.getState().getData())
    );
  }

  private void handleUpdate(@NotNull final Vault.Update<ProductOffering> update) {
    update.getProduced()
        .stream()
        .map(StateAndRef::getState)
        .map(TransactionState::getData)
        .forEach(subject::onNext);
  }

  @Override
  public void publishProductOffering(
      it.nextworks.tmf_offering_catalog.information_models.product.ProductOffering offer,
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
      it.nextworks.tmf_offering_catalog.information_models.product.ProductOffering offer,
      VerifiableCredential identityCredential) {
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
  public Observable<ProductOfferingUpdateEvent> productOfferObservable() {
    return subject
        .map(state -> new ProductOfferingUpdateEvent()
            .setProductOffering(state.getProductOffering())
            .setDidInvitations(state.getDidInvitations())
            .setIdentifier(state.getLinearId().getId().toString())
        );
  }

  private Party findGovernanceNode() {
    return governanceNodeNames.stream()
        .map(CordaX500Name::parse)
        .map(rpcClient::wellKnownPartyFromX500Name)
        .findAny()
        .orElseThrow(() -> new RuntimeException("No governance node was found"));
  }
}
