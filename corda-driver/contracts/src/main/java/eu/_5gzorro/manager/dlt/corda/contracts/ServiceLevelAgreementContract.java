package eu._5gzorro.manager.dlt.corda.contracts;

import eu._5gzorro.manager.dlt.corda.models.types.SLAState;
import eu._5gzorro.manager.dlt.corda.states.ServiceLevelAgreementState;
import net.corda.core.contracts.CommandData;
import net.corda.core.contracts.CommandWithParties;
import net.corda.core.contracts.Contract;
import net.corda.core.transactions.LedgerTransaction;
import org.jetbrains.annotations.NotNull;

import java.security.PublicKey;
import java.util.List;
import java.util.Objects;

import static net.corda.core.contracts.ContractsDSL.requireSingleCommand;
import static net.corda.core.contracts.ContractsDSL.requireThat;

public class ServiceLevelAgreementContract implements Contract {

    public static final String ID = "eu._5gzorro.manager.dlt.corda.contracts.ServiceLevelAgreementContract";

    public static class ServiceLevelAgreementCommand implements CommandData {
        private ServiceLevelAgreementCommand() {}

        public static class Publish extends ServiceLevelAgreementCommand {
            @Override
            public boolean equals(Object obj) { return obj instanceof Publish; }
        }

        public static class Update extends ServiceLevelAgreementCommand {
            @Override
            public boolean equals(Object obj) { return obj instanceof Update; }
        }

        public static class Retire extends ServiceLevelAgreementCommand {
            @Override
            public boolean equals(Object obj) { return obj instanceof Retire; }
        }
    }

    @Override
    public void verify(@NotNull LedgerTransaction tx) throws IllegalArgumentException {
        CommandWithParties<CommandData> cmd = requireSingleCommand(tx.getCommands(), CommandData.class);

        if(cmd.getValue() instanceof ServiceLevelAgreementCommand.Publish)
            verifyPublish(tx, cmd.getSigners());
        else if(cmd.getValue() instanceof ServiceLevelAgreementCommand.Update)
            verifyUpdate(tx, cmd.getSigners());
        else if(cmd.getValue() instanceof ServiceLevelAgreementCommand.Retire)
            verifyRetire(tx, cmd.getSigners());
        else
            throw new UnsupportedOperationException();
    }

    private void verifyPublish(LedgerTransaction tx, List<PublicKey> signers) {
        requireThat(requirements -> {
            requirements.using("Zero Input State", tx.getInputs().isEmpty());
            requirements.using("Only one output state", tx.getOutputs().size() == 1);

            requirements.using("Output state is a ServiceLevelAgreementState",
                    tx.getOutputs().get(0).getData() instanceof ServiceLevelAgreementState);

            ServiceLevelAgreementState serviceLevelAgreementState =
                    (ServiceLevelAgreementState) tx.getOutputs().get(0).getData();

            requirements.using("ServiceLevelAgreementState state is IN_PLACE",
                    serviceLevelAgreementState.getServiceLevelAgreementState() == SLAState.IN_PLACE);

            requirements.using("All required signers must sign",
                    signers.containsAll(serviceLevelAgreementState.getRequiredSigners()));

            return null;
        });
    }

    private void verifyUpdate(LedgerTransaction tx, List<PublicKey> signers) {
        requireThat(requirements -> {
            requirements.using("Only one input state", tx.getInputs().size() == 1);
            requirements.using("Only one output state", tx.getOutputs().size() == 1);

            requirements.using("Input state is a ServiceLevelAgreementState",
                    tx.getInputs().get(0).getState().getData() instanceof ServiceLevelAgreementState);
            requirements.using("Output state is a ServiceLevelAgreementState",
                    tx.getOutputs().get(0).getData() instanceof ServiceLevelAgreementState);

            ServiceLevelAgreementState oldServiceLevelAgreementState =
                    (ServiceLevelAgreementState) tx.getInputs().get(0).getState().getData();
            ServiceLevelAgreementState newServiceLevelAgreementState =
                    (ServiceLevelAgreementState) tx.getOutputs().get(0).getData();

            requirements.using("Unique Identifier unchanged",
                    Objects.equals(oldServiceLevelAgreementState.getLinearId(),
                            newServiceLevelAgreementState.getLinearId()));

            requirements.using("Buyer Party unchanged",
                    Objects.equals(oldServiceLevelAgreementState.getBuyer().getOwningKey(),
                            newServiceLevelAgreementState.getBuyer().getOwningKey()));
            requirements.using("Seller Party unchanged",
                    Objects.equals(oldServiceLevelAgreementState.getSeller().getOwningKey(),
                            newServiceLevelAgreementState.getSeller().getOwningKey()));
            requirements.using("Governance Party unchanged",
                    Objects.equals(oldServiceLevelAgreementState.getGovernanceParty().getOwningKey(),
                            newServiceLevelAgreementState.getGovernanceParty().getOwningKey()));

            requirements.using("Consumed ServiceLevelAgreementState is IN_PLACE",
                    oldServiceLevelAgreementState.getServiceLevelAgreementState() == SLAState.IN_PLACE);
            requirements.using("New ServiceLevelAgreementState state is VIOLATED",
                    newServiceLevelAgreementState.getServiceLevelAgreementState() == SLAState.VIOLATED);

            requirements.using("All required signers must sign",
                    signers.containsAll(newServiceLevelAgreementState.getRequiredSigners()));

            return null;
        });
    }

    private void verifyRetire(LedgerTransaction tx, List<PublicKey> signers) {
        requireThat(requirements -> {
            requirements.using("Only one input state", tx.getInputs().size() == 1);
            requirements.using("Only one output state", tx.getOutputs().size() == 1);

            requirements.using("Input state is a ServiceLevelAgreementState",
                    tx.getInputs().get(0).getState().getData() instanceof ServiceLevelAgreementState);
            requirements.using("Output state is a ServiceLevelAgreementState",
                    tx.getOutputs().get(0).getData() instanceof ServiceLevelAgreementState);

            ServiceLevelAgreementState oldServiceLevelAgreementState =
                    (ServiceLevelAgreementState) tx.getInputs().get(0).getState().getData();
            ServiceLevelAgreementState newServiceLevelAgreementState =
                    (ServiceLevelAgreementState) tx.getOutputs().get(0).getData();

            requirements.using("Unique Identifier unchanged",
                    Objects.equals(oldServiceLevelAgreementState.getLinearId(),
                            newServiceLevelAgreementState.getLinearId()));

            requirements.using("Buyer Party unchanged",
                    Objects.equals(oldServiceLevelAgreementState.getBuyer().getOwningKey(),
                            newServiceLevelAgreementState.getBuyer().getOwningKey()));
            requirements.using("Seller Party unchanged",
                    Objects.equals(oldServiceLevelAgreementState.getSeller().getOwningKey(),
                            newServiceLevelAgreementState.getSeller().getOwningKey()));
            requirements.using("Governance Party unchanged",
                    Objects.equals(oldServiceLevelAgreementState.getGovernanceParty().getOwningKey(),
                            newServiceLevelAgreementState.getGovernanceParty().getOwningKey()));

            requirements.using("Consumed ServiceLevelAgreementState is IN_PLACE or VIOLATED",
                    oldServiceLevelAgreementState.getServiceLevelAgreementState() == SLAState.IN_PLACE ||
                            oldServiceLevelAgreementState.getServiceLevelAgreementState() == SLAState.VIOLATED);
            requirements.using("New ServiceLevelAgreementState state is VIOLATED",
                    newServiceLevelAgreementState.getServiceLevelAgreementState() == SLAState.RETIRED);

            requirements.using("All required signers must sign",
                    signers.containsAll(newServiceLevelAgreementState.getRequiredSigners()));

            return null;
        });
    }
}
