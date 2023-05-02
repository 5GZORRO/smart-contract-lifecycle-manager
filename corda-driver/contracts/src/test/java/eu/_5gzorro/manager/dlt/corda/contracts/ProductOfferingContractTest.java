package eu._5gzorro.manager.dlt.corda.contracts;

import eu._5gzorro.manager.dlt.corda.contracts.ProductOfferingContract.ProductOfferingCommand.Publish;
import eu._5gzorro.manager.dlt.corda.contracts.ProductOfferingContract.ProductOfferingCommand.Retire;
import eu._5gzorro.manager.dlt.corda.contracts.ProductOfferingContract.ProductOfferingCommand.Update;
import eu._5gzorro.manager.dlt.corda.models.types.OfferType;
import eu._5gzorro.manager.dlt.corda.states.ProductOffering;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.Party;
import net.corda.testing.core.DummyCommandData;
import org.junit.jupiter.api.Test;

import static net.corda.testing.node.NodeTestUtils.ledger;

public class ProductOfferingContractTest extends ContractTestHarness {
  @Test
  public void publish_offer_contract_test() {
    ProductOffering productOffering = getProductOffering(megaCorp.getParty(), governor.getParty());

    ledger(ledgerServices, l -> {
      l.transaction(tx -> {
        tx.output(ProductOfferingContract.ID, productOffering);

        tx.tweak(tw -> {
          tw.command(megaCorp.getPublicKey(), new Publish());
          return tw.failsWith("All required signers must sign");
        });

        tx.command(
            CollectionsKt.listOf(megaCorp.getPublicKey(), governor.getPublicKey()),
            new Publish()
        );

        return tx.verifies();
      });
      return Unit.INSTANCE;
    });
  }

  @Test
  public void update_offer_contract_test() {
    ProductOffering productOffering = getProductOffering(megaCorp.getParty(), governor.getParty());
    ledger(ledgerServices, l -> {
      // Setup product offer
      l.unverifiedTransaction(tx -> {
        tx.output(ProductOfferingContract.ID, productOffering);
        return Unit.INSTANCE;
      });

      // update offer
      l.transaction(tx -> {
        tx.input(ProductOfferingContract.ID, productOffering);
        ProductOffering newOffer = productOffering.copy()
            .setName("newName");
        tx.output(ProductOfferingContract.ID, newOffer);

        tx.tweak(tw -> {
          tw.command(megaCorp.getPublicKey(), new Update());
          return tw.failsWith("All required signers must sign");
        });

        tx.command(
            CollectionsKt.listOf(megaCorp.getPublicKey(), governor.getPublicKey()),
            new Update()
        );

        return tx.verifies();
      });
      return Unit.INSTANCE;
    });
  }

  @Test
  public void retire_offer_contract_test() {
    ProductOffering productOffering = getProductOffering(megaCorp.getParty(), governor.getParty());
    ledger(ledgerServices, l -> {

      // Setup product offer
      l.unverifiedTransaction(tx -> {
        tx.output(ProductOfferingContract.ID, "initial offer", productOffering);
        return Unit.INSTANCE;
      });

      // update offer
      l.transaction(tx -> {
        tx.input("initial offer");

        tx.tweak(tw -> {
          tw.command(governor.getPublicKey(), new Retire());
          return tw.failsWith("Owner has signed");
        });

        tx.command(
            CollectionsKt.listOf(megaCorp.getPublicKey()),
            new Retire()
        );

        return tx.verifies();
      });
      return Unit.INSTANCE;
    });
  }

  @Test
  public void must_be_product_offer_command() {
    ProductOffering productOffering = getProductOffering(megaCorp.getParty(), governor.getParty());
    ledger(ledgerServices, l -> {
      l.transaction(tx -> {
        tx.output(ProductOfferingContract.ID, productOffering);

        tx.command(
            CollectionsKt.listOf(megaCorp.getPublicKey(), governor.getPublicKey()),
            DummyCommandData.INSTANCE
        );

        return tx.fails();
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
        null
    );
  }
}
