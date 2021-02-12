package eu._5gzorro.manager.dlt.corda.service.product_offering;

import eu._5gzorro.manager.dlt.corda.flows.product_offer.PublishProductOfferFlow.PublishProductOfferInitiator;
import eu._5gzorro.manager.dlt.corda.flows.product_offer.RetireProductOfferFlow.RetireProductOfferInitiator;
import eu._5gzorro.manager.dlt.corda.flows.product_offer.UpdateProductOfferFlow.UpdateProductOfferInitiator;
import eu._5gzorro.manager.domain.Invitation;
import eu._5gzorro.manager.domain.VerifiableCredential;
import eu._5gzorro.manager.service.ProductOfferingDriver;
import eu._5gzorro.manager.dlt.corda.models.types.OfferType;
import eu._5gzorro.manager.dlt.corda.service.rpc.NodeRPC;
import eu._5gzorro.manager.dlt.corda.states.ProductOffering;
import java.util.Collection;
import java.util.Map;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.Party;
import net.corda.core.messaging.CordaRPCOps;
import org.springframework.stereotype.Service;

@Service
public class ProductOfferingDriverImpl implements ProductOfferingDriver {
  private final CordaRPCOps rpcClient;

  public ProductOfferingDriverImpl(NodeRPC nodeRPC) {
    this.rpcClient = nodeRPC.getClient();
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

  private Party findGovernanceNode() {
    return null; // TODO add method to obtain a governance node party
  }
}
