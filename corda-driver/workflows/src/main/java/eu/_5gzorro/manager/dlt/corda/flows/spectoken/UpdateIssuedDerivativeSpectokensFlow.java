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
public class UpdateIssuedDerivativeSpectokensFlow extends ExtendedFlowLogic<SignedTransaction> {

    private final StateAndRef<DerivativeSpecTokenType> derivativeSpecTokenTypeStateAndRef;
    private final boolean issued;

    public UpdateIssuedDerivativeSpectokensFlow(StateAndRef<DerivativeSpecTokenType> derivativeSpecTokenTypeStateAndRef, boolean issued) {
        this.derivativeSpecTokenTypeStateAndRef = derivativeSpecTokenTypeStateAndRef;
        this.issued = issued;
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

        DerivativeSpecTokenType derivativeSpecTokenType = derivativeSpecTokenTypeStateAndRef.getState().getData();

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
            derivativeSpecTokenType.isValid(),
            derivativeSpecTokenType.getPrimitiveId(),
            derivativeSpecTokenType.getPrice(),
            derivativeSpecTokenType.getOfferDid(),
            issued);

        return subFlow(new UpdateEvolvableToken(derivativeSpecTokenTypeStateAndRef, newDerivativeSpecTokenType, allOtherParties));
    }
}
