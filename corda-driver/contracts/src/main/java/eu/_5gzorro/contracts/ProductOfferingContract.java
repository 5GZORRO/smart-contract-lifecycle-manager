package eu._5gzorro.contracts;

import static net.corda.core.contracts.ContractsDSL.requireSingleCommand;

import java.security.PublicKey;
import java.util.List;
import net.corda.core.contracts.CommandData;
import net.corda.core.contracts.CommandWithParties;
import net.corda.core.contracts.Contract;
import net.corda.core.transactions.LedgerTransaction;
import org.jetbrains.annotations.NotNull;

public class ProductOfferingContract implements Contract {
  public static final String ID = "eu._5gzorro.contracts.ProductOfferingContract";
  
  public static class ProductOfferingCommand implements CommandData {
    public static class Publish extends ProductOfferingCommand {
      @Override
      public boolean equals(Object obj) {
        return obj instanceof Publish;
      }
    }
    static class Update extends ProductOfferingCommand {
      @Override
      public boolean equals(Object obj) {
        return obj instanceof Update;
      }
    }
    static class Retire extends ProductOfferingCommand {
      @Override
      public boolean equals(Object obj) {
        return obj instanceof Retire;
      }
    }
  }

  @Override
  public void verify(@NotNull LedgerTransaction tx) {
    CommandWithParties<CommandData> cmd
        = requireSingleCommand(tx.getCommands(), CommandData.class);
    ProductOfferingCommand productOfferingCommand = (ProductOfferingCommand) cmd.getValue();

    if(productOfferingCommand instanceof ProductOfferingCommand.Publish) {
      verifyPublish(tx, cmd.getSigners());
    } else if(productOfferingCommand instanceof ProductOfferingCommand.Update) {
      verifyUpdate(tx, cmd.getSigners());
    } else if(productOfferingCommand instanceof ProductOfferingCommand.Retire) {
      verifyRetire(tx, cmd.getSigners());
    } else {
      throw new UnsupportedOperationException();
    }
  }

  private void verifyRetire(LedgerTransaction tx, List<PublicKey> signers) {
  }

  private void verifyUpdate(LedgerTransaction tx, List<PublicKey> signers) {
  }

  private void verifyPublish(LedgerTransaction tx, List<PublicKey> signers) {

  }
}
