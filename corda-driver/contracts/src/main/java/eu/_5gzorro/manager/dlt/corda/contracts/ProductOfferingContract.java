package eu._5gzorro.manager.dlt.corda.contracts;

import eu._5gzorro.manager.dlt.corda.states.ProductOffering;
import net.corda.core.contracts.CommandData;
import net.corda.core.contracts.CommandWithParties;
import net.corda.core.contracts.Contract;
import net.corda.core.transactions.LedgerTransaction;
import org.jetbrains.annotations.NotNull;

import java.security.PublicKey;
import java.util.List;

import static net.corda.core.contracts.ContractsDSL.requireSingleCommand;
import static net.corda.core.contracts.ContractsDSL.requireThat;

public class ProductOfferingContract implements Contract {
  public static final String ID = "eu._5gzorro.manager.dlt.corda.contracts.ProductOfferingContract";
  
  public static class ProductOfferingCommand implements CommandData {
    private ProductOfferingCommand() {}

    public static class Publish extends ProductOfferingCommand {
      @Override
      public boolean equals(Object obj) {
        return obj instanceof Publish;
      }
    }
    public static class Update extends ProductOfferingCommand {
      @Override
      public boolean equals(Object obj) {
        return obj instanceof Update;
      }
    }
    public static class Retire extends ProductOfferingCommand {
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

    if(cmd.getValue() instanceof ProductOfferingCommand.Publish) {
      verifyPublish(tx, cmd.getSigners());
    } else if(cmd.getValue() instanceof ProductOfferingCommand.Update) {
      verifyUpdate(tx, cmd.getSigners());
    } else if(cmd.getValue() instanceof ProductOfferingCommand.Retire) {
      verifyRetire(tx, cmd.getSigners());
    } else {
      throw new UnsupportedOperationException();
    }
  }

  private void verifyRetire(LedgerTransaction tx, List<PublicKey> signers) {
    requireThat(requirements -> {
      requirements.using("Zero output states", tx.getOutputs().isEmpty());
      requirements.using("One input state", tx.getInputs().size() == 1);

      requirements.using(
          "Input state is a ProductOffering ContractState",
          tx.getInputs().get(0).getState().getData() instanceof ProductOffering
      );

      ProductOffering oldOffering = (ProductOffering) tx.getInputs().get(0).getState().getData();

//      requirements.using(
//          "Owner has signed",
//          signers.contains(oldOffering.getOwner().getOwningKey())
//      );
      return null;
    });
  }

  private void verifyUpdate(LedgerTransaction tx, List<PublicKey> signers) {
    requireThat(requirements -> {
      requirements.using("Only one output state", tx.getOutputs().size() == 1);
      requirements.using("Only one input state", tx.getInputs().size() == 1);

      requirements.using(
          "Input state is a ProductOffering ContractState",
          tx.getInputs().get(0).getState().getData() instanceof ProductOffering
      );
      requirements.using(
          "Output state is a ProductOffering ContractState",
          tx.getOutputs().get(0).getData() instanceof ProductOffering
      );

      ProductOffering oldOffering = (ProductOffering) tx.getInputs().get(0).getState().getData();
      ProductOffering newOffering = (ProductOffering) tx.getOutputs().get(0).getData();
      requirements.using(
          "Owner, Governance and spectrum parties have not changed",
          newOffering.partiesNotChanged(oldOffering)
      );

      requirements.using(
          "Id of offering has not changed",
          oldOffering.getLinearId().equals(newOffering.getLinearId())
      );

      requirements.using(
          "All required signers must sign",
          signers.containsAll(oldOffering.getRequiredSigners())
      );
      return null;
    });
  }

  private void verifyPublish(LedgerTransaction tx, List<PublicKey> signers) {
    requireThat(requirements -> {
      requirements.using("Zero input state", tx.getInputs().isEmpty());
      requirements.using("Only one output state", tx.getOutputs().size() == 1);

      requirements.using(
          "Output command is a ProductOffering ContractState",
          tx.getOutputs().get(0).getData() instanceof ProductOffering
      );

      ProductOffering offering = (ProductOffering) tx.getOutputs().get(0).getData();

      requirements.using(
          "All required signers must sign",
          signers.containsAll(offering.getRequiredSigners())
      );
      return null;
    });
  }


}
