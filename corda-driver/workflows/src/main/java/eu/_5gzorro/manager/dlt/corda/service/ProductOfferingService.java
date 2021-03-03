package eu._5gzorro.manager.dlt.corda.service;

import eu._5gzorro.manager.dlt.corda.flows.sync.SyncPublicStatesFlow.SyncPublicStatesInitiator;
import eu._5gzorro.manager.dlt.corda.states.ProductOffering;
import java.util.List;
import java.util.stream.Collectors;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import net.corda.core.node.AppServiceHub;
import net.corda.core.node.services.CordaService;
import net.corda.core.node.services.ServiceLifecycleEvent;
import net.corda.core.serialization.SingletonSerializeAsToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CordaService
public class ProductOfferingService extends SingletonSerializeAsToken {
  private static final Logger log = LoggerFactory.getLogger(ProductOfferingService.class);

  private final AppServiceHub serviceHub;

  public ProductOfferingService(AppServiceHub serviceHub) {
    this.serviceHub = serviceHub;

    // Optional: Express interest in receiving lifecycle events
    serviceHub.register(AppServiceHub.SERVICE_PRIORITY_NORMAL, event -> {
      // Lifecycle event handling code
      if(event == ServiceLifecycleEvent.STATE_MACHINE_STARTED) {
        log.info("[Syncing ProductOffers] finding notaries parties to request updates");
        List<Party> parties = serviceHub
            .getNetworkMapCache()
            .getNotaryIdentities();
        parties.forEach(this::syncProductOfferings);
      }
    });
  }

  public void syncAllProductOfferings() {
    log.info("[Syncing ProductOffers] finding nodes known in network map");
    List<Party> parties = serviceHub
        .getNetworkMapCache()
        .getAllNodes()
        .stream()
        .flatMap(x -> x.getLegalIdentities().stream())
        .filter(x -> !x.equals(serviceHub.getMyInfo().getLegalIdentities().get(0)))
        .collect(Collectors.toList());
    log.info("[Syncing ProductOffers] nodes known: {}", parties);

    parties.forEach(this::syncProductOfferings);
  }

  public void syncProductOfferings(AbstractParty party) {
    serviceHub.startFlow(new SyncPublicStatesInitiator(ProductOffering.class, party));
  }
}
