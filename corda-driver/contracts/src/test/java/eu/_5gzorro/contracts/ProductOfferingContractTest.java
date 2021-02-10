package eu._5gzorro.contracts;

import static net.corda.testing.node.NodeTestUtils.ledger;

import eu._5gzorro.contracts.ProductOfferingContract.ProductOfferingCommand;
import eu._5gzorro.models.types.OfferType;
import eu._5gzorro.states.ProductOffering;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.Party;
import org.junit.jupiter.api.Test;

public class ProductOfferingContractTest extends ContractTestHarness {
  @Test
  public void publish_offer_contract_test() {
    ProductOffering productOffering = getProductOffering(megaCorp.getParty(), governor.getParty());

    ledger(ledgerServices, l -> {
      l.transaction(tx -> {
        tx.output(ProductOfferingContract.ID, productOffering);

        tx.tweak(tw -> {
          tw.command(megaCorp.getPublicKey(), new ProductOfferingCommand.Publish());
          return tw.failsWith("All required signers must sign");
        });

        tx.command(
            CollectionsKt.listOf(megaCorp.getPublicKey(), governor.getPublicKey()),
            new ProductOfferingCommand.Publish()
        );

        return tx.verifies();
      });
      return Unit.INSTANCE;
    });
  }

  private ProductOffering getProductOffering(Party owner, Party governanceParty) {
    return new ProductOffering(
        new UniqueIdentifier("233"),
        OfferType.GENERAL,
        "testName",
        owner,
        null,
        null,
        null,
        null,
        null,
        governanceParty,
        null
    );
  }
}
