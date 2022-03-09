package eu._5gzorro.manager.dlt.corda.flows.spectoken;

import co.paralleluniverse.fibers.Suspendable;
import com.r3.corda.lib.tokens.contracts.states.NonFungibleToken;
import com.r3.corda.lib.tokens.contracts.types.IssuedTokenType;
import com.r3.corda.lib.tokens.contracts.types.TokenPointer;
import com.r3.corda.lib.tokens.workflows.flows.rpc.IssueTokens;
import eu._5gzorro.manager.dlt.corda.models.types.SpecTokenType;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.flows.FlowException;
import net.corda.core.flows.FlowLogic;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import net.corda.core.transactions.SignedTransaction;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;

public class IssueSpecTokenToHolderFlow extends FlowLogic<SignedTransaction> {

    @NotNull
    private final SpecTokenType spectoken;
    @NotNull
    private final Party spectrumProvider;
    @NotNull
    private final AbstractParty holder;

    public IssueSpecTokenToHolderFlow(@NotNull final SpecTokenType spectoken, @NotNull final Party spectrumProvider, @NotNull final AbstractParty holder) {
        this.spectoken = spectoken;
        this.spectrumProvider = spectrumProvider;
        this.holder = holder;
    }

    @Suspendable
    @Override
    public SignedTransaction call() throws FlowException {
        final TokenPointer<SpecTokenType> spectokenPointer = spectoken.toPointer(SpecTokenType.class);
        final IssuedTokenType spectokenWithProvider = new IssuedTokenType(spectrumProvider, spectokenPointer);
        final NonFungibleToken spectokenNft = new NonFungibleToken(spectokenWithProvider, holder, new UniqueIdentifier(), null);
        return subFlow(new IssueTokens(Collections.singletonList(spectokenNft)));
    }
}
