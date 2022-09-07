package eu._5gzorro.manager.dlt.corda.flows.spectoken;

import co.paralleluniverse.fibers.Suspendable;
import com.r3.corda.lib.tokens.contracts.states.NonFungibleToken;
import com.r3.corda.lib.tokens.contracts.types.IssuedTokenType;
import com.r3.corda.lib.tokens.contracts.types.TokenPointer;
import com.r3.corda.lib.tokens.contracts.utilities.TransactionUtilitiesKt;
import com.r3.corda.lib.tokens.workflows.flows.rpc.IssueTokens;
import eu._5gzorro.manager.dlt.corda.flows.utils.ExtendedFlowLogic;
import eu._5gzorro.manager.dlt.corda.states.DerivativeSpecTokenType;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.flows.FlowException;
import net.corda.core.flows.InitiatingFlow;
import net.corda.core.flows.StartableByRPC;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import net.corda.core.transactions.SignedTransaction;

import java.util.Collections;
import java.util.List;

@InitiatingFlow
@StartableByRPC
public class IssueDerivativeSpecTokenToHolderFlow extends ExtendedFlowLogic<SignedTransaction> {

    private final String offerDid;
    private final Party issuer;
    private final AbstractParty holder;

    public IssueDerivativeSpecTokenToHolderFlow(String offerDid, Party issuer, AbstractParty holder) {
        this.offerDid = offerDid;
        this.issuer = issuer;
        this.holder = holder;
    }

    @Suspendable
    @Override
    public SignedTransaction call() throws FlowException {
        List<StateAndRef<DerivativeSpecTokenType>> states = getServiceHub().getVaultService().queryBy(DerivativeSpecTokenType.class).getStates();
        DerivativeSpecTokenType derivativeSpecTokenType = null;
        for (StateAndRef<DerivativeSpecTokenType> stateAndRef : states) {
            derivativeSpecTokenType = stateAndRef.getState().getData();
            if (derivativeSpecTokenType.getOfferDid().equals(offerDid) && derivativeSpecTokenType.isValid()) {
                break;
            } else {
                derivativeSpecTokenType = null;
            }
        }
        if (derivativeSpecTokenType == null) {
            throw new FlowException("Valid DerivativeSpectokenType not found for offerDid " + offerDid);
        }
        final TokenPointer<DerivativeSpecTokenType> derivativeSpecTokenTypeTokenPointer = derivativeSpecTokenType.toPointer(DerivativeSpecTokenType.class);
        final IssuedTokenType issuedDerivativeSpectoken = new IssuedTokenType(issuer, derivativeSpecTokenTypeTokenPointer);
        final NonFungibleToken derivativeSpectokenNft = new NonFungibleToken(issuedDerivativeSpectoken, holder, new UniqueIdentifier(), TransactionUtilitiesKt.getAttachmentIdForGenericParam(derivativeSpecTokenTypeTokenPointer));
        return subFlow(new IssueTokens(Collections.singletonList(derivativeSpectokenNft)));
    }
}
