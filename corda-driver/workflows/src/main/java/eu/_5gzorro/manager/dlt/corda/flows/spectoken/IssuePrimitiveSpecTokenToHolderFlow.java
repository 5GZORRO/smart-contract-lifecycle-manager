package eu._5gzorro.manager.dlt.corda.flows.spectoken;

import co.paralleluniverse.fibers.Suspendable;
import com.r3.corda.lib.tokens.contracts.states.NonFungibleToken;
import com.r3.corda.lib.tokens.contracts.types.IssuedTokenType;
import com.r3.corda.lib.tokens.contracts.types.TokenPointer;
import com.r3.corda.lib.tokens.contracts.utilities.TransactionUtilitiesKt;
import com.r3.corda.lib.tokens.workflows.flows.rpc.IssueTokens;
import eu._5gzorro.manager.dlt.corda.flows.utils.ExtendedFlowLogic;
import eu._5gzorro.manager.dlt.corda.states.PrimitiveSpecTokenType;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.flows.FlowException;
import net.corda.core.flows.InitiatingFlow;
import net.corda.core.flows.StartableByRPC;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import net.corda.core.transactions.SignedTransaction;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;

@InitiatingFlow
@StartableByRPC
public class IssuePrimitiveSpecTokenToHolderFlow extends ExtendedFlowLogic<SignedTransaction> {

    private final PrimitiveSpecTokenType primitiveSpecTokenType;
    private final Party issuer;
    private final AbstractParty holder;

    public IssuePrimitiveSpecTokenToHolderFlow(PrimitiveSpecTokenType primitiveSpecTokenType, Party issuer, AbstractParty holder) {
        this.primitiveSpecTokenType = primitiveSpecTokenType;
        this.issuer = issuer;
        this.holder = holder;
    }

    @Suspendable
    @Override
    public SignedTransaction call() throws FlowException {
        final TokenPointer<PrimitiveSpecTokenType> primitiveSpecTokenTypeTokenPointer = primitiveSpecTokenType.toPointer(PrimitiveSpecTokenType.class);
        final IssuedTokenType issuedPrimitiveSpectoken = new IssuedTokenType(issuer, primitiveSpecTokenTypeTokenPointer);
        final NonFungibleToken primitiveSpectokenNft = new NonFungibleToken(issuedPrimitiveSpectoken, holder, new UniqueIdentifier(), TransactionUtilitiesKt.getAttachmentIdForGenericParam(primitiveSpecTokenTypeTokenPointer));
        return subFlow(new IssueTokens(Collections.singletonList(primitiveSpectokenNft)));
    }
}
