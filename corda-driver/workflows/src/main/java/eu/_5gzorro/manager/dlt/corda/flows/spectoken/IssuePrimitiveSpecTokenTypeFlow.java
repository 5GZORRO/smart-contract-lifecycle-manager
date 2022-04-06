package eu._5gzorro.manager.dlt.corda.flows.spectoken;

import co.paralleluniverse.fibers.Suspendable;
import com.r3.corda.lib.tokens.workflows.flows.rpc.CreateEvolvableTokens;
import eu._5gzorro.manager.dlt.corda.flows.utils.ExtendedFlowLogic;
import eu._5gzorro.manager.dlt.corda.states.PrimitiveSpecTokenType;
import net.corda.core.contracts.TransactionState;
import net.corda.core.flows.FlowException;
import net.corda.core.flows.InitiatingFlow;
import net.corda.core.flows.StartableByRPC;
import net.corda.core.identity.Party;
import net.corda.core.transactions.SignedTransaction;

import java.security.PublicKey;
import java.util.List;
import java.util.stream.Collectors;

@InitiatingFlow
public class IssuePrimitiveSpecTokenTypeFlow extends ExtendedFlowLogic<SignedTransaction> {

    private final PrimitiveSpecTokenType primitiveSpecTokenType;
    private final List<Party> otherParties;

    public IssuePrimitiveSpecTokenTypeFlow(PrimitiveSpecTokenType primitiveSpecTokenType, List<Party> otherParties) {
        this.primitiveSpecTokenType = primitiveSpecTokenType;
        this.otherParties = otherParties;
    }

    @Suspendable
    @Override
    public SignedTransaction call() throws FlowException {
        List<PublicKey> requiredSigners = primitiveSpecTokenType.getRequiredSigners();
        TransactionState<PrimitiveSpecTokenType> transactionState = new TransactionState<>(primitiveSpecTokenType, firstNotary());
        return subFlow(new CreateEvolvableTokens(transactionState, otherParties));
    }

    @InitiatingFlow
    @StartableByRPC
    public static class IssuePrimitiveSpecTokenTypeFlowInitiator extends ExtendedFlowLogic<SignedTransaction> {
        private final PrimitiveSpecTokenType primitiveSpecTokenType;

        public IssuePrimitiveSpecTokenTypeFlowInitiator(PrimitiveSpecTokenType primitiveSpecTokenType) {
            this.primitiveSpecTokenType = primitiveSpecTokenType;
        }

        @Suspendable
        @Override
        public SignedTransaction call() throws FlowException {
            List<Party> allOtherParties = getServiceHub()
                    .getNetworkMapCache()
                    .getAllNodes()
                    .stream()
                    .flatMap(c -> c.getLegalIdentities().stream())
                    .filter(p -> !p.equals(getOurIdentity())) // Filter out own identity
                    .collect(Collectors.toList());

            return subFlow(new IssuePrimitiveSpecTokenTypeFlow(primitiveSpecTokenType, allOtherParties));
        }
    }
}
