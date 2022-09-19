package eu._5gzorro.manager.dlt.corda.flows.product_offer;

import eu._5gzorro.manager.dlt.corda.flows.product_offer.PublishProductOfferFlow.PublishProductOfferInitiator;
import eu._5gzorro.manager.dlt.corda.flows.product_offer.RetireProductOfferFlow.RetireProductOfferInitiator;
import eu._5gzorro.manager.dlt.corda.flows.product_offer.UpdateProductOfferFlow.UpdateProductOfferInitiator;
import eu._5gzorro.manager.dlt.corda.states.ProductOffering;
import net.corda.core.concurrent.CordaFuture;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.testing.node.MockNetwork;
import net.corda.testing.node.StartedMockNode;

import java.util.concurrent.ExecutionException;

public class ProductOfferingTestUtils {
  public static UniqueIdentifier publishProductOffering(StartedMockNode proposer, MockNetwork network, ProductOffering offering)
      throws ExecutionException, InterruptedException {
    PublishProductOfferInitiator flow = new PublishProductOfferInitiator(offering);
    CordaFuture<UniqueIdentifier> future = proposer.startFlow(flow);

    network.runNetwork();

    return future.get();
  }

  public static UniqueIdentifier updateProductOffering(StartedMockNode proposer, MockNetwork network, ProductOffering offering)
      throws ExecutionException, InterruptedException {
    UpdateProductOfferInitiator flow = new UpdateProductOfferInitiator(offering);
    CordaFuture<UniqueIdentifier> future = proposer.startFlow(flow);

    network.runNetwork();

    return future.get();
  }

  public static UniqueIdentifier retireProductOffering(StartedMockNode proposer, MockNetwork network, String offeringDid)
      throws ExecutionException, InterruptedException {
    RetireProductOfferInitiator flow = new RetireProductOfferInitiator(offeringDid);
    CordaFuture<UniqueIdentifier> future = proposer.startFlow(flow);

    network.runNetwork();

    return future.get();
  }
}
