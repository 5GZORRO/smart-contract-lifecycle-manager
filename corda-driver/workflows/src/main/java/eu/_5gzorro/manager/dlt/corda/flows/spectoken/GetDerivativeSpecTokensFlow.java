package eu._5gzorro.manager.dlt.corda.flows.spectoken;

import co.paralleluniverse.fibers.Suspendable;
import eu._5gzorro.manager.dlt.corda.flows.utils.ExtendedFlowLogic;
import eu._5gzorro.manager.dlt.corda.states.DerivativeSpecTokenType;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.flows.FlowException;
import net.corda.core.flows.InitiatingFlow;
import net.corda.core.flows.StartableByRPC;

import java.util.List;

@InitiatingFlow
@StartableByRPC
public class GetDerivativeSpecTokensFlow extends ExtendedFlowLogic<List<StateAndRef<DerivativeSpecTokenType>>> {

    public GetDerivativeSpecTokensFlow() {

    }

    @Suspendable
    @Override
    public List<StateAndRef<DerivativeSpecTokenType>> call() throws FlowException {
        return getServiceHub().getVaultService().queryBy(DerivativeSpecTokenType.class).getStates();
    }
}
