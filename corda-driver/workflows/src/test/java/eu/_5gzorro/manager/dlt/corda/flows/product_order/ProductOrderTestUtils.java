package eu._5gzorro.manager.dlt.corda.flows.product_order;

import eu._5gzorro.manager.dlt.corda.states.ProductOrder;
import net.corda.core.concurrent.CordaFuture;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.flows.FlowLogic;
import net.corda.testing.node.MockNetwork;
import net.corda.testing.node.StartedMockNode;

import java.util.concurrent.ExecutionException;

public class ProductOrderTestUtils {
  public static UniqueIdentifier publishProductOrder(StartedMockNode proposer, MockNetwork network, ProductOrder order)
      throws ExecutionException, InterruptedException {
    PublishProductOrderFlow.PublishProductOrderInitiator flow =
            new PublishProductOrderFlow.PublishProductOrderInitiator(order, null, null);
    CordaFuture<UniqueIdentifier> future = proposer.startFlow(flow);

    network.runNetwork();

    return future.get();
  }

  public static <T> T startFlow(StartedMockNode proposer, MockNetwork network, FlowLogic<T> flow)
      throws ExecutionException, InterruptedException {
    CordaFuture<T> future = proposer.startFlow(flow);

    network.runNetwork();

    return future.get();
  }
}
