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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@InitiatingFlow
@StartableByRPC
public class InvalidateDerivativeSpectokensFlow extends ExtendedFlowLogic<List<String>> {

    private final String primitiveId;

    public InvalidateDerivativeSpectokensFlow(String primitiveId) {
        this.primitiveId = primitiveId;
    }

    @Suspendable
    @Override
    public List<String> call() throws FlowException {
        List<StateAndRef<DerivativeSpecTokenType>> states = getServiceHub().getVaultService().queryBy(DerivativeSpecTokenType.class).getStates();
        DerivativeSpecTokenType derivativeSpecTokenType;
        List<Party> allOtherParties = getServiceHub()
            .getNetworkMapCache()
            .getAllNodes()
            .stream()
            .flatMap(c -> c.getLegalIdentities().stream())
            .filter(p -> !p.equals(getOurIdentity())) // Filter out own identity
            .collect(Collectors.toList());

        List<String> offerDids = new ArrayList<>();

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
                    derivativeSpecTokenType.getOfferDid(),
                    false);
                subFlow(new UpdateEvolvableToken(derivativeSpecTokenStateAndRef, newDerivativeSpecTokenType, allOtherParties));
                offerDids.add(derivativeSpecTokenType.getOfferDid());
            }
        }
        return offerDids;
    }
}
