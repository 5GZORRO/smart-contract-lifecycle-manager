package eu._5gzorro.manager.dlt.corda.contracts;

import eu._5gzorro.manager.dlt.corda.models.types.OrderState;
import eu._5gzorro.manager.dlt.corda.states.ProductOrder;
import eu._5gzorro.manager.dlt.corda.states.RejectionReason;
import net.corda.core.contracts.CommandData;
import net.corda.core.contracts.CommandWithParties;
import net.corda.core.contracts.Contract;
import net.corda.core.contracts.Requirements;
import net.corda.core.transactions.LedgerTransaction;
import org.jetbrains.annotations.NotNull;

import java.security.PublicKey;
import java.util.List;

import static net.corda.core.contracts.ContractsDSL.requireSingleCommand;
import static net.corda.core.contracts.ContractsDSL.requireThat;

public class ProductOrderContract implements Contract {
  public static final String ID = "eu._5gzorro.manager.dlt.corda.contracts.ProductOrderContract";

  public static class ProductOrderCommand implements CommandData {
    private ProductOrderCommand() {}

    public static class Publish extends ProductOrderCommand {
      @Override
      public boolean equals(Object obj) {
        return obj instanceof Publish;
      }
    }

    public static class ProvisionedOrder extends ProductOrderCommand {
      @Override
      public boolean equals(Object obj) {
        return obj instanceof ApproveOrder;
      }
    }

    public static class ApproveOrder extends ProductOrderCommand {
      @Override
      public boolean equals(Object obj) {
        return obj instanceof ApproveOrder;
      }
    }

    public static class ProposeChange extends ProductOrderCommand {
      @Override
      public boolean equals(Object obj) {
        return obj instanceof ProposeChange;
      }
    }

    public static class EndOrder extends ProductOrderCommand {
      @Override
      public boolean equals(Object obj) {
        return obj instanceof EndOrder;
      }
    }

    public static class Reject extends ProductOrderCommand {
      @Override
      public boolean equals(Object obj) {
        return obj instanceof Reject;
      }
    }

    public static class RejectProposal extends ProductOrderCommand {
      @Override
      public boolean equals(Object obj) {
        return obj instanceof Reject;
      }
    }

    public static class AcceptProposal extends ProductOrderCommand {
      @Override
      public boolean equals(Object obj) {
        return obj instanceof Reject;
      }
    }
  }

  @Override
  public void verify(@NotNull LedgerTransaction tx) {
    CommandWithParties<CommandData> cmd = requireSingleCommand(tx.getCommands(), CommandData.class);

    if (cmd.getValue() instanceof ProductOrderCommand.Publish) {
      verifyPublish(tx, cmd.getSigners());
    } else if (cmd.getValue() instanceof ProductOrderCommand.ApproveOrder) {
      verifyApproveOrder(tx, cmd.getSigners());
    } else if (cmd.getValue() instanceof ProductOrderCommand.ProvisionedOrder) {
      verifyProvisionedOrder(tx, cmd.getSigners());
    } else if (cmd.getValue() instanceof ProductOrderCommand.ProposeChange) {
      verifyProposedChange(tx, cmd.getSigners());
    } else if (cmd.getValue() instanceof ProductOrderCommand.EndOrder) {
      verifyEndOrder(tx, cmd.getSigners());
    } else if (cmd.getValue() instanceof ProductOrderCommand.Reject) {
      verifyReject(tx, cmd.getSigners());
    } else if (cmd.getValue() instanceof ProductOrderCommand.RejectProposal) {
      verifyRejectProposal(tx, cmd.getSigners());
    } else if (cmd.getValue() instanceof ProductOrderCommand.AcceptProposal) {
      verifyAcceptProposal(tx, cmd.getSigners());
    } else {
      throw new UnsupportedOperationException();
    }
  }

  private void verifyAcceptProposal(LedgerTransaction tx, List<PublicKey> signers) {
    requireThat(
        requirements -> {
          oneInOut(tx, requirements, ProductOrder.class, ProductOrder.class);

          ProductOrder inputOrder = (ProductOrder) tx.getInputs().get(0).getState().getData();
          ProductOrder outputOrder = (ProductOrder) tx.getOutputs().get(0).getData();

          requirements.using(
              "Input state is CHANGE_ACTIVE",
              inputOrder.getState() == OrderState.CHANGE_ACTIVE);

          requirements.using(
              "Output state is APPROVED", outputOrder.getState() == OrderState.APPROVED);

          requirements.using(
              "Model has changed to proposal", inputOrder.getProposedModel().equals(outputOrder.getModel()));
          requirements.using(
              "Proposal model removed", outputOrder.getProposedModel() == null);

          requirements.using(
              "All required signers must sign",
              signers.containsAll(outputOrder.getRequiredSigners()));
          return null;
        });
  }

  private void verifyRejectProposal(LedgerTransaction tx, List<PublicKey> signers) {
    requireThat(
        requirements -> {
          oneInOut(tx, requirements, ProductOrder.class, ProductOrder.class);

          ProductOrder inputOrder = (ProductOrder) tx.getInputs().get(0).getState().getData();
          ProductOrder outputOrder = (ProductOrder) tx.getOutputs().get(0).getData();

          requirements.using(
              "Input state is CHANGE_ACTIVE",
              inputOrder.getState() == OrderState.CHANGE_ACTIVE);

          requirements.using(
              "Output state is ACTIVE", outputOrder.getState() == OrderState.ACTIVE);

          requirements.using(
              "Model hasn't changed", inputOrder.getModel().equals(outputOrder.getModel()));
          requirements.using(
              "Proposal model removed", outputOrder.getProposedModel() == null);

          requirements.using(
              "All required signers must sign",
              signers.containsAll(outputOrder.getRequiredSigners()));
          return null;
        });
  }

  private void verifyEndOrder(LedgerTransaction tx, List<PublicKey> signers) {
    requireThat(
        requirements -> {
          requirements.using("One input state", tx.getInputs().isEmpty());
          requirements.using("Zero output states", tx.getOutputs().isEmpty());

          requirements.using(
              "Input state is a ProductOrder ContractState",
              tx.getInputs().get(0).getState().getData() instanceof ProductOrder);

          ProductOrder inputOrder = (ProductOrder) tx.getInputs().get(0).getState().getData();

          requirements.using(
              "Input state is ACTIVE",
              inputOrder.getState() == OrderState.ACTIVE
                  || inputOrder.getState() == OrderState.APPROVED);

          requirements.using(
              "Buyer or seller must sign",
              signers.contains(inputOrder.getBuyer().getOwningKey())
                  || signers.contains(inputOrder.getSeller().getOwningKey()));
          return null;
        });
  }

  private void verifyProposedChange(LedgerTransaction tx, List<PublicKey> signers) {
    requireThat(
        requirements -> {
          oneInOut(tx, requirements, ProductOrder.class, ProductOrder.class);

          ProductOrder inputOrder = (ProductOrder) tx.getInputs().get(0).getState().getData();
          ProductOrder outputOrder = (ProductOrder) tx.getOutputs().get(0).getData();

          requirements.using(
              "Input state is PROPOSED or CHANGE_ACTIVE",
              inputOrder.getState() == OrderState.PROPOSED
                  || inputOrder.getState() == OrderState.CHANGE_ACTIVE);

          requirements.using("Output state is ACTIVE", outputOrder.getState() == OrderState.ACTIVE);

          requirements.using(
              "Active model hasn't changed", inputOrder.getModel().equals(outputOrder.getModel()));
          requirements.using("Proposed model is present", outputOrder.getProposedModel() != null);

          requirements.using(
              "All required signers must sign",
              signers.containsAll(outputOrder.getRequiredSigners()));
          return null;
        });
  }

  private void verifyApproveOrder(LedgerTransaction tx, List<PublicKey> signers) {
    requireThat(
        requirements -> {
          oneInOut(tx, requirements, ProductOrder.class, ProductOrder.class);

          ProductOrder inputOrder = (ProductOrder) tx.getInputs().get(0).getState().getData();
          ProductOrder outputOrder = (ProductOrder) tx.getOutputs().get(0).getData();

          requirements.using(
              "Input state is PROPOSED or CHANGE_ACTIVE",
              inputOrder.getState() == OrderState.PROPOSED
                  || inputOrder.getState() == OrderState.CHANGE_ACTIVE);

          requirements.using(
              "Output state is APPROVED", outputOrder.getState() == OrderState.APPROVED);

          requirements.using(
              "Model hasn't changed", inputOrder.getModel().equals(outputOrder.getModel()));

          requirements.using(
              "All required signers must sign",
              signers.containsAll(outputOrder.getRequiredSigners()));
          return null;
        });
  }

  private void verifyProvisionedOrder(LedgerTransaction tx, List<PublicKey> signers) {
    requireThat(
        requirements -> {
          oneInOut(tx, requirements, ProductOrder.class, ProductOrder.class);

          ProductOrder inputOrder = (ProductOrder) tx.getInputs().get(0).getState().getData();
          ProductOrder outputOrder = (ProductOrder) tx.getOutputs().get(0).getData();

          requirements.using("Input state is APPROVED", inputOrder.getState() == OrderState.ACTIVE);

          requirements.using("Output state is ACTIVE", outputOrder.getState() == OrderState.ACTIVE);

          requirements.using(
              "Model hasn't changed", inputOrder.getModel().equals(outputOrder.getModel()));

          requirements.using(
              "All required signers must sign",
              signers.containsAll(outputOrder.getRequiredSigners()));
          return null;
        });
  }

  private void verifyReject(LedgerTransaction tx, List<PublicKey> signers) {
    requireThat(
        requirements -> {
          oneInOut(tx, requirements, ProductOrder.class, RejectionReason.class);

          ProductOrder oldOrder = (ProductOrder) tx.getInputs().get(0).getState().getData();

          requirements.using(
              "Seller has signed", signers.contains(oldOrder.getSeller().getOwningKey()));
          return null;
        });
  }

  private void verifyPublish(LedgerTransaction tx, List<PublicKey> signers) {
    requireThat(
        requirements -> {
          requirements.using("Zero input state", tx.getInputs().isEmpty());
          requirements.using("Only one output state", tx.getOutputs().size() == 1);

          requirements.using(
              "Output state is a ProductOrder ContractState",
              tx.getOutputs().get(0).getData() instanceof ProductOrder);

          ProductOrder order = (ProductOrder) tx.getOutputs().get(0).getData();

          requirements.using(
              "All required signers must sign", signers.containsAll(order.getRequiredSigners()));
          return null;
        });
  }

  private void oneInOut(
      LedgerTransaction tx, Requirements requirements, Class<?> inType, Class<?> outType) {
    requirements.using("One input state", tx.getInputs().size() == 1);
    requirements.using("Only one output state", tx.getOutputs().size() == 1);

    requirements.using(
        "Input state is a ProductOrder ContractState",
        inType.isInstance(tx.getInputs().get(0).getState().getData()));

    requirements.using(
        "Output state is a ProductOrder ContractState",
        outType.isInstance(tx.getOutputs().get(0).getData()));
  }
}
