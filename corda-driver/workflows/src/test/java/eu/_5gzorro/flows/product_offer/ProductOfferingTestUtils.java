package eu._5gzorro.flows.product_offer;

import eu._5gzorro.flows.product_offer.PublishProductOfferFlow.PublishProductOfferInitiator;
import eu._5gzorro.states.ProductOffering;
import java.util.concurrent.ExecutionException;
import net.corda.core.concurrent.CordaFuture;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.testing.node.MockNetwork;
import net.corda.testing.node.StartedMockNode;

public class ProductOfferingTestUtils {
  public static UniqueIdentifier generateProductOffering(StartedMockNode proposer, MockNetwork network, ProductOffering offering)
      throws ExecutionException, InterruptedException {
    PublishProductOfferInitiator flow = new PublishProductOfferInitiator(offering);
    CordaFuture<UniqueIdentifier> future = proposer.startFlow(flow);

    network.runNetwork();

    return future.get();
  }
}
