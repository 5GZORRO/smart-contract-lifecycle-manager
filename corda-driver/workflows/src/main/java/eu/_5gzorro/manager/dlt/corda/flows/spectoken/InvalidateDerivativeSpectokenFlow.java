package eu._5gzorro.manager.dlt.corda.flows.spectoken;

import co.paralleluniverse.fibers.Suspendable;
import com.r3.corda.lib.tokens.workflows.flows.rpc.UpdateEvolvableToken;
import eu._5gzorro.manager.dlt.corda.flows.utils.ExtendedFlowLogic;
import eu._5gzorro.manager.dlt.corda.states.DerivativeSpecTokenType;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.flows.FlowException;
import net.corda.core.flows.InitiatingFlow;
import net.corda.core.flows.StartableByRPC;
import net.corda.core.identity.Party;

import java.util.List;
import java.util.stream.Collectors;

@InitiatingFlow
@StartableByRPC
public class InvalidateDerivativeSpectokenFlow extends ExtendedFlowLogic<String> {

    private final String linearId;

    public InvalidateDerivativeSpectokenFlow(String linearId) {
        this.linearId = linearId;
    }

    @Suspendable
    @Override
    public String call() throws FlowException {
        List<StateAndRef<DerivativeSpecTokenType>> states = getServiceHub().getVaultService().queryBy(DerivativeSpecTokenType.class).getStates();
        if (states.isEmpty()) {
            throw new FlowException("Any Derivative Spectoken found.");
        }
        DerivativeSpecTokenType derivativeSpecTokenType;
        List<Party> allOtherParties = getServiceHub()
            .getNetworkMapCache()
            .getAllNodes()
            .stream()
            .flatMap(c -> c.getLegalIdentities().stream())
            .filter(p -> !p.equals(getOurIdentity())) // Filter out own identity
            .collect(Collectors.toList());

        String id = null;

        for (StateAndRef<DerivativeSpecTokenType> derivativeSpecTokenStateAndRef : states) {
            derivativeSpecTokenType = derivativeSpecTokenStateAndRef.getState().getData();
            if (linearId.equals(derivativeSpecTokenType.getLinearId().toString()) && derivativeSpecTokenType.isValid()) {
                DerivativeSpecTokenType newDerivativeSpecTokenType = new DerivativeSpecTokenType(
                    derivativeSpecTokenType.getMaintainers(),
                    derivativeSpecTokenType.getLinearId(),
                    derivativeSpecTokenType.getStartDl(),
                    derivativeSpecTokenType.getEndDl(),
                    derivativeSpecTokenType.getStartUl(),
                    derivativeSpecTokenType.getEndUl(),
                    derivativeSpecTokenType.getStartDate(),
                    derivativeSpecTokenType.getEndDate(),
                    derivativeSpecTokenType.getDuplexMode(),
                    derivativeSpecTokenType.getBand(),
                    derivativeSpecTokenType.getTechnology(),
                    derivativeSpecTokenType.getCountry(),
                    false,
                    derivativeSpecTokenType.getPrimitiveId(),
                    derivativeSpecTokenType.getPrice(),
                    derivativeSpecTokenType.getOfferDid(),
                    false);
                subFlow(new UpdateEvolvableToken(derivativeSpecTokenStateAndRef, newDerivativeSpecTokenType, allOtherParties));
                id = newDerivativeSpecTokenType.getLinearId().toString();
            }
        }
        return id;
    }
}
