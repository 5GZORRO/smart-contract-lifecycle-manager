package eu._5gzorro.manager.dlt.corda.utils;


import static kotlin.collections.MapsKt.mapOf;

import eu._5gzorro.manager.domain.Invitation;
import eu._5gzorro.manager.dlt.corda.flows.product_offer.ProductOfferingTestUtils;
import eu._5gzorro.manager.dlt.corda.states.ProductOffering;
import eu._5gzorro.manager.dlt.corda.models.types.OfferType;
import java.util.concurrent.ExecutionException;
import kotlin.Pair;
import net.corda.core.contracts.UniqueIdentifier;
import org.junit.jupiter.api.BeforeAll;

public class PublishedProductOfferTestCase extends TwoOperatorTestCase {
  public ProductOffering offering;

  @BeforeAll
  public void setupOffer() throws ExecutionException, InterruptedException {
    offering = new ProductOffering(
        new UniqueIdentifier("233"),
        OfferType.GENERAL,
        "testName",
        operator1Party,
        null,
        null,
        null,
        null,
        mapOf(new Pair<>("something", new Invitation())),
        governanceParty,
        null
    );

    network.runNetwork();
    UniqueIdentifier offeringId =
        ProductOfferingTestUtils.publishProductOffering(operator1, network, offering);
    network.runNetwork();
  }
}
