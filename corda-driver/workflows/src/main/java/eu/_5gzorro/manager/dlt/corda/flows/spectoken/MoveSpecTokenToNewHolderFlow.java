package eu._5gzorro.manager.dlt.corda.flows.spectoken;

import com.r3.corda.lib.tokens.contracts.types.TokenPointer;
import com.r3.corda.lib.tokens.workflows.flows.rpc.MoveNonFungibleTokens;
import com.r3.corda.lib.tokens.workflows.types.PartyAndToken;
import eu._5gzorro.manager.dlt.corda.models.types.SpecTokenType;
import net.corda.core.flows.FlowException;
import net.corda.core.flows.FlowLogic;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import net.corda.core.transactions.SignedTransaction;

import java.util.List;

public class MoveSpecTokenToNewHolderFlow extends FlowLogic<SignedTransaction> {

    private final TokenPointer<SpecTokenType> specTokenTypePointer;
    private final AbstractParty newHolder;
    private final List<Party> observers;

    public MoveSpecTokenToNewHolderFlow(TokenPointer<SpecTokenType> specTokenTypePointer, AbstractParty newHolder, List<Party> observers) {
        this.specTokenTypePointer = specTokenTypePointer;
        this.newHolder = newHolder;
        this.observers = observers;
    }

    @Override
    public SignedTransaction call() throws FlowException {
        final PartyAndToken newHolderAndSpecToken = new PartyAndToken(newHolder, specTokenTypePointer);
        return subFlow(new MoveNonFungibleTokens(newHolderAndSpecToken, observers));
    }

}
