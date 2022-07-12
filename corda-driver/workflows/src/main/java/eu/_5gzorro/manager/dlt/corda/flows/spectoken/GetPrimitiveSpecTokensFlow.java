package eu._5gzorro.manager.dlt.corda.flows.spectoken;

import co.paralleluniverse.fibers.Suspendable;
import eu._5gzorro.manager.dlt.corda.flows.utils.ExtendedFlowLogic;
import eu._5gzorro.manager.dlt.corda.states.PrimitiveSpecTokenType;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.flows.FlowException;
import net.corda.core.flows.InitiatingFlow;
import net.corda.core.flows.StartableByRPC;

import java.util.List;

@InitiatingFlow
@StartableByRPC
public class GetPrimitiveSpecTokensFlow extends ExtendedFlowLogic<List<StateAndRef<PrimitiveSpecTokenType>>> {

    public GetPrimitiveSpecTokensFlow() {

    }

    @Suspendable
    @Override
    public List<StateAndRef<PrimitiveSpecTokenType>> call() throws FlowException {
        return getServiceHub().getVaultService().queryBy(PrimitiveSpecTokenType.class).getStates();
    }
}
