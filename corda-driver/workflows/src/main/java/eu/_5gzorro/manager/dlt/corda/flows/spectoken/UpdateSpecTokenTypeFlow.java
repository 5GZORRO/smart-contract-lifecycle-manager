package eu._5gzorro.manager.dlt.corda.flows.spectoken;

import co.paralleluniverse.fibers.Suspendable;
import com.r3.corda.lib.tokens.workflows.flows.rpc.UpdateEvolvableToken;
import eu._5gzorro.manager.dlt.corda.states.SpecTokenType;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.flows.FlowException;
import net.corda.core.flows.FlowLogic;
import net.corda.core.identity.Party;
import net.corda.core.transactions.SignedTransaction;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class UpdateSpecTokenTypeFlow extends FlowLogic<SignedTransaction> {

    @NotNull
    private final StateAndRef<SpecTokenType> spectokenRef;
    @NotNull
    private final List<Party> observers;

    public UpdateSpecTokenTypeFlow(@NotNull final StateAndRef<SpecTokenType> spectokenRef, @NotNull final List<Party> observers) {
        this.spectokenRef = spectokenRef;
        this.observers = observers;
    }

    @Suspendable
    @Override
    public SignedTransaction call() throws FlowException {
        final SpecTokenType spectoken = spectokenRef.getState().getData();
        final SpecTokenType updatedSpectoken = new SpecTokenType(
                spectoken.getMaintainers(),
                spectoken.getLinearId(),
                spectoken.getDid(),
                spectoken.getStartDl(),
                spectoken.getEndDl(),
                spectoken.getStartUl(),
                spectoken.getEndUl(),
                spectoken.getStartDate(),
                spectoken.getEndDate(),
                spectoken.getDuplexMode(),
                spectoken.getBand(),
                spectoken.getTechnology(),
                spectoken.getCountry(),
                spectoken.getOwnerDid()
        );
        return subFlow(new UpdateEvolvableToken(spectokenRef, updatedSpectoken, observers));
    }
}
