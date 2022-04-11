package eu._5gzorro.manager.dlt.corda.flows.spectoken;

import co.paralleluniverse.fibers.Suspendable;
import com.r3.corda.lib.tokens.workflows.flows.rpc.CreateEvolvableTokens;
import eu._5gzorro.manager.dlt.corda.flows.utils.ExtendedFlowLogic;
import eu._5gzorro.manager.dlt.corda.states.DerivativeSpecTokenType;
import net.corda.core.contracts.TransactionState;
import net.corda.core.flows.FlowException;
import net.corda.core.flows.InitiatingFlow;
import net.corda.core.flows.StartableByRPC;
import net.corda.core.identity.Party;
import net.corda.core.transactions.SignedTransaction;

import java.util.List;
import java.util.stream.Collectors;

@InitiatingFlow
@StartableByRPC
public class IssueDerivativeSpecTokenTypeFlow extends ExtendedFlowLogic<SignedTransaction> {

    private final DerivativeSpecTokenType derivativeSpecTokenType;

    public IssueDerivativeSpecTokenTypeFlow(DerivativeSpecTokenType derivativeSpecTokenType) {
        this.derivativeSpecTokenType = derivativeSpecTokenType;
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
        TransactionState<DerivativeSpecTokenType> transactionState = new TransactionState<>(derivativeSpecTokenType, firstNotary());
        return subFlow(new CreateEvolvableTokens(transactionState, allOtherParties));
    }

}
