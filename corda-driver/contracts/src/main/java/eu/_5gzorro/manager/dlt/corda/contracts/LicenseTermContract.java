package eu._5gzorro.manager.dlt.corda.contracts;

import eu._5gzorro.manager.dlt.corda.models.types.LTState;
import eu._5gzorro.manager.dlt.corda.states.LicenseTermState;
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

public class LicenseTermContract implements Contract {

    public static final String ID = "eu._5gzorro.manager.dlt.corda.contracts.LicenseTermContract";

    public static class LicenseTermCommand implements CommandData {
        private LicenseTermCommand() {}

        public static class Publish extends LicenseTermCommand {
            @Override
            public boolean equals(Object obj) { return obj instanceof Publish; }
        }

        public static class Update extends LicenseTermCommand {
            @Override
            public boolean equals(Object obj) { return obj instanceof Update; }
        }

        public static class Retire extends LicenseTermCommand {
            @Override
            public boolean equals(Object obj) { return obj instanceof Retire; }
        }
    }

    @Override
    public void verify(@NotNull LedgerTransaction tx) throws IllegalArgumentException {

        CommandWithParties<CommandData> cmd = requireSingleCommand(tx.getCommands(), CommandData.class);

        if(cmd.getValue() instanceof LicenseTermCommand.Publish)
            verifyPublish(tx, cmd.getSigners());
        else if(cmd.getValue() instanceof LicenseTermCommand.Update)
            verifyUpdate(tx, cmd.getSigners());
        else if(cmd.getValue() instanceof LicenseTermCommand.Retire)
            verifyRetire(tx, cmd.getSigners());
        else
            throw new UnsupportedOperationException();
    }

    private void verifyPublish(LedgerTransaction tx, List<PublicKey> signers) {
        requireThat(requirements -> {
            requirements.using("Zero Input State", tx.getInputs().isEmpty());
            requirements.using("Only one output state", tx.getOutputs().size() == 1);

            requirements.using("Output state is a LicenseTermState",
                    tx.getOutputs().get(0).getData() instanceof LicenseTermState);

            LicenseTermState licenseTermState = (LicenseTermState) tx.getOutputs().get(0).getData();

            requirements.using("LicenseTermState state is IN_PLACE",
                    licenseTermState.getLicenseTermState() == LTState.IN_PLACE);

            requirements.using("All required signers must sign",
                    signers.containsAll(licenseTermState.getRequiredSigners()));

            return null;
        });
    }

    private void verifyUpdate(LedgerTransaction tx, List<PublicKey> signers) {
        requireThat(requirements -> {
            requirements.using("Only one input state", tx.getInputs().size() == 1);
            requirements.using("Only one output state", tx.getOutputs().size() == 1);

            requirements.using("Input state is a LicenseTermState",
                    tx.getInputs().get(0).getState().getData() instanceof LicenseTermState);
            requirements.using("Output state is a LicenseTermState",
                    tx.getOutputs().get(0).getData() instanceof LicenseTermState);

            LicenseTermState oldLicenseTermState = (LicenseTermState) tx.getInputs().get(0).getState().getData();
            LicenseTermState newLicenseTermState = (LicenseTermState) tx.getOutputs().get(0).getData();

            requirements.using("Unique Identifier unchanged",
                    Objects.equals(oldLicenseTermState.getLinearId(),
                            newLicenseTermState.getLinearId()));

            requirements.using("Buyer Party unchanged",
                    Objects.equals(oldLicenseTermState.getBuyer().getOwningKey(),
                            newLicenseTermState.getBuyer().getOwningKey()));
            requirements.using("Seller Party unchanged",
                    Objects.equals(oldLicenseTermState.getSeller().getOwningKey(),
                            newLicenseTermState.getSeller().getOwningKey()));
            requirements.using("Governance Party Unchanged",
                    Objects.equals(oldLicenseTermState.getGovernanceParty().getOwningKey(),
                            newLicenseTermState.getGovernanceParty().getOwningKey()));

            requirements.using("All required signers must sign",
                    signers.containsAll(newLicenseTermState.getRequiredSigners()));

            return null;
        });
    }

    private void verifyRetire(LedgerTransaction tx, List<PublicKey> signers) {
        requireThat(requirements -> {
            requirements.using("Only one input state", tx.getInputs().size() == 1);
            requirements.using("Only one output state", tx.getOutputs().size() == 1);

            requirements.using("Input state is a LicenseTermState",
                    tx.getInputs().get(0).getState().getData() instanceof LicenseTermState);
            requirements.using("Output state is a LicenseTermState",
                    tx.getOutputs().get(0).getData() instanceof LicenseTermState);

            LicenseTermState oldLicenseTermState = (LicenseTermState) tx.getInputs().get(0).getState().getData();
            LicenseTermState newLicenseTermState = (LicenseTermState) tx.getOutputs().get(0).getData();

            requirements.using("Unique Identifier unchanged",
                    Objects.equals(oldLicenseTermState.getLinearId(),
                            newLicenseTermState.getLinearId()));

            requirements.using("Buyer Party unchanged",
                    Objects.equals(oldLicenseTermState.getBuyer().getOwningKey(),
                            newLicenseTermState.getBuyer().getOwningKey()));
            requirements.using("Seller Party unchanged",
                    Objects.equals(oldLicenseTermState.getSeller().getOwningKey(),
                            newLicenseTermState.getSeller().getOwningKey()));
            requirements.using("Governance Party Unchanged",
                    Objects.equals(oldLicenseTermState.getGovernanceParty().getOwningKey(),
                            newLicenseTermState.getGovernanceParty().getOwningKey()));

            requirements.using("Consumed LicenseTermState is IN_PLACE or VIOLATED",
                    oldLicenseTermState.getLicenseTermState() == LTState.IN_PLACE ||
                            oldLicenseTermState.getLicenseTermState() == LTState.VIOLATED);
            requirements.using("New LicenseTermState is RETIRED",
                    newLicenseTermState.getLicenseTermState() == LTState.RETIRED);

            requirements.using("All required signers must sign",
                    signers.containsAll(newLicenseTermState.getRequiredSigners()));

            return null;
        });
    }
}
