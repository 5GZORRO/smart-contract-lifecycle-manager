package eu._5gzorro.flows.product_offer;

import static eu._5gzorro.flows.product_offer.ProductOfferingTestUtils.publishProductOffering;
import static eu._5gzorro.flows.product_offer.ProductOfferingTestUtils.retireProductOffering;
import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.ImmutableList;
import eu._5gzorro.models.types.OfferType;
import eu._5gzorro.states.ProductOffering;
import eu._5gzorro.utils.PublishedProductOfferTestCase;
import eu._5gzorro.utils.TwoOperatorTestCase;
import java.util.concurrent.ExecutionException;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.node.services.Vault.StateStatus;
import net.corda.core.node.services.vault.QueryCriteria;
import org.junit.jupiter.api.Test;

public class RetireProductOfferFlowTest extends PublishedProductOfferTestCase {


  @Test
  public void retire_existing_offer() throws ExecutionException, InterruptedException {
    retireProductOffering(operator1, network, offering.getLinearId());
    network.runNetwork();

    QueryCriteria consumedAndLinearIdCriteria = new QueryCriteria.LinearStateQueryCriteria(
        null,   // List of Parties for the state
        ImmutableList.of(offering.getLinearId().getId()),
        null,
        StateStatus.CONSUMED,
        null    // Set of State types
    );

    assertThat(
        operator2.getServices().getVaultService()
          .queryBy(ProductOffering.class, consumedAndLinearIdCriteria)
          .getStates()
          .stream()
          .findAny()
    ).isNotEmpty();
  }
}
