package eu._5gzorro.manager.dlt.corda.utils;


import eu._5gzorro.manager.dlt.corda.flows.product_offer.ProductOfferingTestUtils;
import eu._5gzorro.manager.dlt.corda.models.types.OfferType;
import eu._5gzorro.manager.dlt.corda.states.ProductOffering;
import eu._5gzorro.manager.domain.Invitation;
import kotlin.Pair;
import net.corda.core.contracts.UniqueIdentifier;
import org.junit.jupiter.api.BeforeAll;

import java.util.concurrent.ExecutionException;

import static kotlin.collections.MapsKt.mapOf;

public class PublishedProductOfferTestCase extends TwoOperatorTestCase {
  public ProductOffering offering;

  @BeforeAll
  public void setupOffer() throws ExecutionException, InterruptedException {
    offering = new ProductOffering(
        new UniqueIdentifier("233"),
        OfferType.GENERAL,
        "testName",
        operator1Party,
        mapOf(new Pair<>("something", new Invitation())),
        null,
        governanceParty,
        null,
        null
    );

    network.runNetwork();
    UniqueIdentifier offeringId =
        ProductOfferingTestUtils.publishProductOffering(operator1, network, offering);
    network.runNetwork();
  }
}
