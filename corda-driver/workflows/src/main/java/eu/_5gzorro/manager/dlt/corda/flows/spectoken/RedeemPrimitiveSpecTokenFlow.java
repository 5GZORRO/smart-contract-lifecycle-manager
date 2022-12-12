package eu._5gzorro.manager.dlt.corda.flows.spectoken;

import co.paralleluniverse.fibers.Suspendable;
import com.r3.corda.lib.tokens.contracts.types.TokenPointer;
import com.r3.corda.lib.tokens.workflows.flows.rpc.RedeemNonFungibleTokens;
import eu._5gzorro.manager.dlt.corda.flows.utils.ExtendedFlowLogic;
import eu._5gzorro.manager.dlt.corda.states.PrimitiveSpecTokenType;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.flows.FlowException;
import net.corda.core.flows.InitiatingFlow;
import net.corda.core.flows.StartableByRPC;
import net.corda.core.identity.Party;
import net.corda.core.transactions.SignedTransaction;

import java.util.List;

@InitiatingFlow
@StartableByRPC
public class RedeemPrimitiveSpecTokenFlow extends ExtendedFlowLogic<SignedTransaction> {

    private final String id;
    private final Party issuer;

    public RedeemPrimitiveSpecTokenFlow(String id, Party issuer) {
        this.id = id;
        this.issuer = issuer;
    }

    @Suspendable
    @Override
    public SignedTransaction call() throws FlowException {
        List<StateAndRef<PrimitiveSpecTokenType>> states = getServiceHub().getVaultService().queryBy(PrimitiveSpecTokenType.class).getStates();
        if (states.isEmpty()) {
            throw new FlowException("Primitive Spectoken not found.");
        }
        PrimitiveSpecTokenType primitiveSpecTokenType = null;
        for (StateAndRef<PrimitiveSpecTokenType> primitiveSpecTokenTypeStateAndRef : states) {
            if (id.equals(primitiveSpecTokenTypeStateAndRef.getState().getData().getLinearId().toString())) {
                primitiveSpecTokenType = primitiveSpecTokenTypeStateAndRef.getState().getData();
                break;
            }
        }
        if (primitiveSpecTokenType == null) {
            throw new FlowException("Incorrect id.");
        }
        TokenPointer<PrimitiveSpecTokenType> primitiveSpecTokenTypeTokenPointer = primitiveSpecTokenType.toPointer(PrimitiveSpecTokenType.class);
        return subFlow(new RedeemNonFungibleTokens(primitiveSpecTokenTypeTokenPointer, issuer));
    }
}
