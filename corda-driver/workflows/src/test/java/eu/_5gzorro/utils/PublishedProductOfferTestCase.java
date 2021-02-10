package eu._5gzorro.utils;


import static eu._5gzorro.flows.product_offer.ProductOfferingTestUtils.publishProductOffering;
import static kotlin.collections.MapsKt.mapOf;

import eu._5gzorro.lifecycle.manager.domain.Invitation;
import eu._5gzorro.models.types.OfferType;
import eu._5gzorro.states.ProductOffering;
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
        publishProductOffering(operator1, network, offering);
    network.runNetwork();
  }
}
