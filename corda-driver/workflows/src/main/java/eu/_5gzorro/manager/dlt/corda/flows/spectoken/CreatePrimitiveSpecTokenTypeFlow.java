package eu._5gzorro.manager.dlt.corda.flows.spectoken;

import co.paralleluniverse.fibers.Suspendable;
import com.r3.corda.lib.tokens.workflows.flows.rpc.CreateEvolvableTokens;
import eu._5gzorro.manager.dlt.corda.flows.utils.ExtendedFlowLogic;
import eu._5gzorro.manager.dlt.corda.states.PrimitiveSpecTokenType;
import net.corda.core.contracts.StateAndRef;
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
public class CreatePrimitiveSpecTokenTypeFlow extends ExtendedFlowLogic<SignedTransaction> {

    private final PrimitiveSpecTokenType primitiveSpecTokenType;

    public CreatePrimitiveSpecTokenTypeFlow(PrimitiveSpecTokenType primitiveSpecTokenType) {
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

        List<StateAndRef<PrimitiveSpecTokenType>> primitiveStateAndRefs = getServiceHub().getVaultService().queryBy(PrimitiveSpecTokenType.class).getStates();
        for (StateAndRef<PrimitiveSpecTokenType> existingPrimitiveSpecTokenTypeStateAndRef : primitiveStateAndRefs) {
            PrimitiveSpecTokenType existingPrimitiveSpectokenType = existingPrimitiveSpecTokenTypeStateAndRef.getState().getData();
            if (existingPrimitiveSpectokenType.isValid() && newPrimitiveOverlapsExisting(primitiveSpecTokenType, existingPrimitiveSpectokenType)) {
                throw new FlowException("Primitive Spectoken data overlaps existing Primitive Spectoken");
            }
        }
        TransactionState<PrimitiveSpecTokenType> transactionState = new TransactionState<>(primitiveSpecTokenType, firstNotary());
        return subFlow(new CreateEvolvableTokens(transactionState, allOtherParties));
    }

    private boolean newPrimitiveOverlapsExisting(PrimitiveSpecTokenType newPrimitiveSpecTokenType, PrimitiveSpecTokenType existingPrimitiveSpecTokenType) {
        if (isThereFrequencyOverlap(newPrimitiveSpecTokenType, existingPrimitiveSpecTokenType)) {
            return isThereTimeOverlap(newPrimitiveSpecTokenType, existingPrimitiveSpecTokenType);
        } else {
            return false;
        }
    }

    private boolean isThereFrequencyOverlap(PrimitiveSpecTokenType newPrimitiveSpecTokenType, PrimitiveSpecTokenType existingPrimitiveSpecTokenType) {
        boolean dlOverlap;
        if (newPrimitiveSpecTokenType.getEndDl() < existingPrimitiveSpecTokenType.getStartDl()) {
            dlOverlap = false;
        } else if (newPrimitiveSpecTokenType.getEndDl().equals(existingPrimitiveSpecTokenType.getStartDl())) {
            dlOverlap = true;
        } else {
            dlOverlap = newPrimitiveSpecTokenType.getStartDl() <= existingPrimitiveSpecTokenType.getEndDl();
        }

        boolean ulOverlap;
        if (newPrimitiveSpecTokenType.getEndUl() < existingPrimitiveSpecTokenType.getStartUl()) {
            ulOverlap = false;
        } else if (newPrimitiveSpecTokenType.getEndUl().equals(existingPrimitiveSpecTokenType.getStartUl())) {
            ulOverlap = true;
        } else {
            ulOverlap = newPrimitiveSpecTokenType.getStartUl() <= existingPrimitiveSpecTokenType.getEndUl();
        }

        return dlOverlap || ulOverlap;

    }

    private boolean isThereTimeOverlap(PrimitiveSpecTokenType newPrimitiveSpecTokenType, PrimitiveSpecTokenType existingPrimitiveSpecTokenType) {
        boolean timeOverlap;
        if (newPrimitiveSpecTokenType.getEndDate().before(existingPrimitiveSpecTokenType.getStartDate())) {
            timeOverlap = false;
        } else if (newPrimitiveSpecTokenType.getEndDate().equals(existingPrimitiveSpecTokenType.getStartDate())) {
            timeOverlap = true;
        } else {
            timeOverlap = newPrimitiveSpecTokenType.getStartDate().before(existingPrimitiveSpecTokenType.getEndDate()) || newPrimitiveSpecTokenType.getStartDate().equals(existingPrimitiveSpecTokenType.getEndDate());
        }
        return timeOverlap;
    }

}
