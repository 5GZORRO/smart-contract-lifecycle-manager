package eu._5gzorro.manager.dlt.corda.flows.spectoken;

import co.paralleluniverse.fibers.Suspendable;
import com.r3.corda.lib.tokens.contracts.types.TokenPointer;
import com.r3.corda.lib.tokens.workflows.flows.rpc.RedeemNonFungibleTokens;
import eu._5gzorro.manager.dlt.corda.flows.utils.ExtendedFlowLogic;
import eu._5gzorro.manager.dlt.corda.states.DerivativeSpecTokenType;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.flows.FlowException;
import net.corda.core.flows.InitiatingFlow;
import net.corda.core.flows.StartableByRPC;
import net.corda.core.identity.Party;
import net.corda.core.transactions.SignedTransaction;

import java.util.List;

@InitiatingFlow
@StartableByRPC
public class RedeemDerivativeSpecTokenFlow extends ExtendedFlowLogic<SignedTransaction> {

    private final String offerDid;
    private final Party issuer;

    public RedeemDerivativeSpecTokenFlow(String offerDid, Party issuer) {
        this.offerDid = offerDid;
        this.issuer = issuer;
    }

    @Suspendable
    @Override
    public SignedTransaction call() throws FlowException {
        List<StateAndRef<DerivativeSpecTokenType>> states = getServiceHub().getVaultService().queryBy(DerivativeSpecTokenType.class).getStates();
        if (states.isEmpty()) {
            throw new FlowException("Derivative Spectoken not found.");
        }
        DerivativeSpecTokenType derivativeSpecTokenType = null;
        for (StateAndRef<DerivativeSpecTokenType> derivativeSpecTokenTypeStateAndRef : states) {
            if (offerDid.equals(derivativeSpecTokenTypeStateAndRef.getState().getData().getOfferDid())) {
                derivativeSpecTokenType = derivativeSpecTokenTypeStateAndRef.getState().getData();
                break;
            }
        }
        if (derivativeSpecTokenType == null) {
            throw new FlowException("Incorrect license DID.");
        }
        TokenPointer<DerivativeSpecTokenType> derivativeSpecTokenTypeTokenPointer = derivativeSpecTokenType.toPointer(DerivativeSpecTokenType.class);
        return subFlow(new RedeemNonFungibleTokens(derivativeSpecTokenTypeTokenPointer, issuer));
    }
}
