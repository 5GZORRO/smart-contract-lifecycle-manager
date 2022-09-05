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
import net.corda.core.transactions.SignedTransaction;

import java.util.List;
import java.util.stream.Collectors;

@InitiatingFlow
@StartableByRPC
public class InvalidateDerivativeSpectokensFlow extends ExtendedFlowLogic<SignedTransaction> {

    private final String primitiveId;

    public InvalidateDerivativeSpectokensFlow(String primitiveId) {
        this.primitiveId = primitiveId;
    }

    @Suspendable
    @Override
    public SignedTransaction call() throws FlowException {
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

        for (StateAndRef<DerivativeSpecTokenType> derivativeSpecTokenStateAndRef : states) {
            derivativeSpecTokenType = derivativeSpecTokenStateAndRef.getState().getData();
            if (primitiveId.equals(derivativeSpecTokenType.getPrimitiveId()) && derivativeSpecTokenType.isValid()) {
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
                    derivativeSpecTokenType.getOfferDid()
                );
                subFlow(new UpdateEvolvableToken(derivativeSpecTokenStateAndRef, newDerivativeSpecTokenType, allOtherParties));
            }
        }
        return null;
    }
}
