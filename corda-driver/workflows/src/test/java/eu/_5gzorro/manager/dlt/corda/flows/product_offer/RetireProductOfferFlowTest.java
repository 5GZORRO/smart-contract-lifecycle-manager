package eu._5gzorro.manager.dlt.corda.flows.product_offer;

import com.google.common.collect.ImmutableList;
import eu._5gzorro.manager.dlt.corda.states.ProductOffering;
import eu._5gzorro.manager.dlt.corda.utils.PublishedProductOfferTestCase;
import net.corda.core.node.services.Vault.StateStatus;
import net.corda.core.node.services.vault.QueryCriteria;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

public class RetireProductOfferFlowTest extends PublishedProductOfferTestCase {


  @Test
  public void retire_existing_offer() throws ExecutionException, InterruptedException {
    ProductOfferingTestUtils.retireProductOffering(operator1, network, offering.getOfferDetails().getDid());
    network.runNetwork();

    QueryCriteria consumedAndLinearIdCriteria = new QueryCriteria.LinearStateQueryCriteria(
        null,   // List of Parties for the state
        ImmutableList.of(offering.getLinearId().getId()),
        null,
        StateStatus.CONSUMED,
        null    // Set of State types
    );

    Assertions.assertThat(
        operator2.getServices().getVaultService()
          .queryBy(ProductOffering.class, consumedAndLinearIdCriteria)
          .getStates()
          .stream()
          .findAny()
    ).isNotEmpty();
  }
}
