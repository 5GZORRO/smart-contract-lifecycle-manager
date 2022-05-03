package eu._5gzorro.manager.dlt.corda.flows.spectoken;

import co.paralleluniverse.fibers.Suspendable;
import com.r3.corda.lib.tokens.contracts.states.NonFungibleToken;
import com.r3.corda.lib.tokens.contracts.types.IssuedTokenType;
import com.r3.corda.lib.tokens.contracts.types.TokenPointer;
import com.r3.corda.lib.tokens.contracts.utilities.TransactionUtilitiesKt;
import com.r3.corda.lib.tokens.workflows.flows.rpc.IssueTokens;
import eu._5gzorro.manager.dlt.corda.flows.utils.ExtendedFlowLogic;
import eu._5gzorro.manager.dlt.corda.states.DerivativeSpecTokenType;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.flows.FlowException;
import net.corda.core.flows.InitiatingFlow;
import net.corda.core.flows.StartableByRPC;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import net.corda.core.transactions.SignedTransaction;

import java.util.Collections;

@InitiatingFlow
@StartableByRPC
public class IssueDerivativeSpecTokenToHolderFlow extends ExtendedFlowLogic<SignedTransaction> {

    private final DerivativeSpecTokenType derivativeSpecTokenType;
    private final Party issuer;
    private final AbstractParty holder;

    public IssueDerivativeSpecTokenToHolderFlow(DerivativeSpecTokenType derivativeSpecTokenType, Party issuer, AbstractParty holder) {
        this.derivativeSpecTokenType = derivativeSpecTokenType;
        this.issuer = issuer;
        this.holder = holder;
    }

    @Suspendable
    @Override
    public SignedTransaction call() throws FlowException {
        final TokenPointer<DerivativeSpecTokenType> derivativeSpecTokenTypeTokenPointer = derivativeSpecTokenType.toPointer(DerivativeSpecTokenType.class);
        final IssuedTokenType issuedDerivativeSpectoken = new IssuedTokenType(issuer, derivativeSpecTokenTypeTokenPointer);
        final NonFungibleToken derivativeSpectokenNft = new NonFungibleToken(issuedDerivativeSpectoken, holder, new UniqueIdentifier(), TransactionUtilitiesKt.getAttachmentIdForGenericParam(derivativeSpecTokenTypeTokenPointer));
        return subFlow(new IssueTokens(Collections.singletonList(derivativeSpectokenNft)));
    }
}
