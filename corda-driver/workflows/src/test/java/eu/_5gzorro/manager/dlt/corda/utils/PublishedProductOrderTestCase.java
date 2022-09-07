package eu._5gzorro.manager.dlt.corda.utils;

import eu._5gzorro.manager.dlt.corda.flows.product_order.ProductOrderTestUtils;
import eu._5gzorro.manager.dlt.corda.models.types.OfferType;
import eu._5gzorro.manager.dlt.corda.models.types.OrderState;
import eu._5gzorro.manager.dlt.corda.states.ProductOrder;
import eu._5gzorro.manager.domain.Invitation;
import eu._5gzorro.tm_forum.models.TimePeriod;
import kotlin.Pair;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.crypto.SecureHash;
import org.junit.jupiter.api.BeforeAll;

import java.util.concurrent.ExecutionException;

import static kotlin.collections.MapsKt.mapOf;

public class PublishedProductOrderTestCase extends TwoOperatorTestCase {
  public ProductOrder order;

  @BeforeAll
  public void setupOffer() throws ExecutionException, InterruptedException {

    order = new ProductOrder(
        new UniqueIdentifier("233"),
        operator1Party,
        operator2Party,
        governanceParty,
        null,
        null,
        null,
        OrderState.PROPOSED,
        OfferType.GENERAL,
        new TimePeriod(),
        mapOf(new Pair<>("something", new Invitation())),
        null,
        null,
        null
    );

    network.runNetwork();
    UniqueIdentifier offeringId =
        ProductOrderTestUtils.publishProductOrder(operator1, network, order);
    network.runNetwork();
  }
}
