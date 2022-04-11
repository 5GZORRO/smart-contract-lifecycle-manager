package eu._5gzorro.manager.dlt.corda.contracts;

import com.r3.corda.lib.tokens.contracts.EvolvableTokenContract;
import eu._5gzorro.manager.dlt.corda.states.DerivativeSpecTokenType;
import net.corda.core.contracts.Contract;
import net.corda.core.node.services.Vault;
import net.corda.core.node.services.vault.QueryCriteria;
import net.corda.core.transactions.LedgerTransaction;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import static net.corda.core.contracts.ContractsDSL.requireThat;

public class DerivativeSpecTokenContract extends EvolvableTokenContract implements Contract {

    QueryCriteria.VaultQueryCriteria generalCriteria = new QueryCriteria.VaultQueryCriteria(Vault.StateStatus.ALL);

    @Override
    public void additionalCreateChecks(@NotNull final LedgerTransaction tx) {
        final DerivativeSpecTokenType outputSpecTokenType = tx.outputsOfType(DerivativeSpecTokenType.class).get(0);
        requireThat(require -> {
            require.using("Start DL frequency cannot be 0.", outputSpecTokenType.getStartDl() > 0L);
            require.using("End DL frequency cannot be 0.", outputSpecTokenType.getEndDl() > 0L);
            require.using("Start UL frequency cannot be 0.", outputSpecTokenType.getStartUl() > 0L);
            require.using("End DL frequency cannot be 0.", outputSpecTokenType.getEndUl() > 0L);
            require.using("Start time cannot be after end time", outputSpecTokenType.getStartDate().before(outputSpecTokenType.getEndDate()));
            require.using("End time cannot be before start time.", outputSpecTokenType.getEndDate().after(outputSpecTokenType.getStartDate()));
            require.using("Duplex mode cannot be empty.", !StringUtils.isBlank(outputSpecTokenType.getDuplexMode()));
            require.using("Band cannot be 0.", outputSpecTokenType.getBand() > 0);
            require.using("Technology cannot be empty.", !StringUtils.isBlank(outputSpecTokenType.getTechnology()));
            require.using("Country cannot be empty.", !StringUtils.isBlank(outputSpecTokenType.getCountry()));
            require.using("Primitive DID cannot be empty.", !StringUtils.isBlank(outputSpecTokenType.getPrimitiveDid()));
            return null;
        });
    }

    @Override
    public void additionalUpdateChecks(@NotNull final LedgerTransaction tx) {
        final DerivativeSpecTokenType inputSpecTokenType = tx.inputsOfType(DerivativeSpecTokenType.class).get(0);
        final DerivativeSpecTokenType outputSpecTokenType = tx.outputsOfType(DerivativeSpecTokenType.class).get(0);
        requireThat(require -> {
            require.using("Start DL frequency cannot be updated.", outputSpecTokenType.getStartDl().equals(inputSpecTokenType.getStartDl()));
            require.using("End DL frequency cannot be updated.", outputSpecTokenType.getEndDl().equals(inputSpecTokenType.getEndDl()));
            require.using("Start UL frequency cannot be updated.", outputSpecTokenType.getStartUl().equals(inputSpecTokenType.getStartUl()));
            require.using("End DL frequency cannot be updated.", outputSpecTokenType.getEndUl().equals(inputSpecTokenType.getEndUl()));
            require.using("Start time cannot be updated.", outputSpecTokenType.getStartDate().equals(inputSpecTokenType.getStartDate()));
            require.using("End time cannot be updated.", outputSpecTokenType.getEndDate().equals(inputSpecTokenType.getEndDate()));
            require.using("Duplex mode cannot be updated.", outputSpecTokenType.getDuplexMode().equals(inputSpecTokenType.getDuplexMode()));
            require.using("Band cannot be updated.", outputSpecTokenType.getBand().equals(inputSpecTokenType.getBand()));
            require.using("Technology cannot be updated.", outputSpecTokenType.getTechnology().equals(inputSpecTokenType.getTechnology()));
            require.using("Country cannot be updated.", outputSpecTokenType.getCountry().equals(inputSpecTokenType.getCountry()));
            return null;
        });
    }
}
