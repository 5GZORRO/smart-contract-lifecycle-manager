package eu._5gzorro.manager.dlt.corda.flows.spectoken;

import co.paralleluniverse.fibers.Suspendable;
import com.r3.corda.lib.tokens.workflows.flows.rpc.UpdateEvolvableToken;
import eu._5gzorro.manager.dlt.corda.flows.utils.ExtendedFlowLogic;
import eu._5gzorro.manager.dlt.corda.states.PrimitiveSpecTokenType;
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
public class InvalidatePrimitiveSpectokenFlow extends ExtendedFlowLogic<SignedTransaction> {

    private final String licenseId;

    public InvalidatePrimitiveSpectokenFlow(String licenseId) {
        this.licenseId = licenseId;
    }

    @Suspendable
    @Override
    public SignedTransaction call() throws FlowException {
        List<StateAndRef<PrimitiveSpecTokenType>> states = getServiceHub().getVaultService().queryBy(PrimitiveSpecTokenType.class).getStates();
        if (states.isEmpty()) {
            throw new FlowException("Primitive Spectoken not found.");
        }
        PrimitiveSpecTokenType primitiveSpecTokenType = null;
        StateAndRef<PrimitiveSpecTokenType> primitiveSpecTokenStateAndRef = null;
        for (StateAndRef<PrimitiveSpecTokenType> primitiveSpecTokenTypeStateAndRef : states) {
            if (licenseId.equals(primitiveSpecTokenTypeStateAndRef.getState().getData().getLicense())) {
                primitiveSpecTokenType = primitiveSpecTokenTypeStateAndRef.getState().getData();
                primitiveSpecTokenStateAndRef = primitiveSpecTokenTypeStateAndRef;
                break;
            }
        }
        if (primitiveSpecTokenType == null) {
            throw new FlowException("Incorrect license DID.");
        }
        PrimitiveSpecTokenType newPrimitiveSpectoken = new PrimitiveSpecTokenType(
            primitiveSpecTokenType.getMaintainers(),
            primitiveSpecTokenType.getLinearId(),
            primitiveSpecTokenType.getStartDl(),
            primitiveSpecTokenType.getEndDl(),
            primitiveSpecTokenType.getStartUl(),
            primitiveSpecTokenType.getEndUl(),
            primitiveSpecTokenType.getStartDate(),
            primitiveSpecTokenType.getEndDate(),
            primitiveSpecTokenType.getDuplexMode(),
            primitiveSpecTokenType.getBand(),
            primitiveSpecTokenType.getTechnology(),
            primitiveSpecTokenType.getCountry(),
            false,
            primitiveSpecTokenType.getLicense(),
            primitiveSpecTokenType.getOwnerDid()
        );

        List<Party> allOtherParties = getServiceHub()
            .getNetworkMapCache()
            .getAllNodes()
            .stream()
            .flatMap(c -> c.getLegalIdentities().stream())
            .filter(p -> !p.equals(getOurIdentity())) // Filter out own identity
            .collect(Collectors.toList());

        return subFlow(new UpdateEvolvableToken(primitiveSpecTokenStateAndRef, newPrimitiveSpectoken, allOtherParties));
    }
}
