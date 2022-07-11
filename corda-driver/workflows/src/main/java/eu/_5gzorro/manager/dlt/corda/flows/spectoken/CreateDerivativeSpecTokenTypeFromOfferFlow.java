package eu._5gzorro.manager.dlt.corda.flows.spectoken;

import co.paralleluniverse.fibers.Suspendable;
import com.r3.corda.lib.tokens.workflows.flows.rpc.CreateEvolvableTokens;
import eu._5gzorro.manager.dlt.corda.flows.utils.ExtendedFlowLogic;
import eu._5gzorro.manager.dlt.corda.states.DerivativeSpecTokenType;
import eu._5gzorro.manager.dlt.corda.states.PrimitiveSpecTokenType;
import eu._5gzorro.manager.domain.ProductOfferDetails;
import eu._5gzorro.tm_forum.models.resource.ResourceSpecCharacteristic;
import eu._5gzorro.tm_forum.models.resource.ResourceSpecification;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.contracts.TransactionState;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.flows.FlowException;
import net.corda.core.flows.InitiatingFlow;
import net.corda.core.flows.StartableByRPC;
import net.corda.core.identity.Party;
import net.corda.core.transactions.SignedTransaction;

import java.util.*;
import java.util.stream.Collectors;

@InitiatingFlow
@StartableByRPC
public class CreateDerivativeSpecTokenTypeFromOfferFlow extends ExtendedFlowLogic<SignedTransaction> {

    private final ProductOfferDetails productOfferDetails;
    private final String offerDid;

    private static final String START_DL = "startFreqDl";
    private static final String END_DL = "endFreqDl";
    private static final String START_UL = "startFreqUl";
    private static final String END_UL = "endFreqUl";
    private static final String TECHNOLOGY = "technology";
    private static final String DUPLEX_MODE = "duplexMode";
    private static final String BAND = "operationBand";

    private static final List<String> CHARACTERISTIC_NAMES = Collections.unmodifiableList(new ArrayList<String>() {
        {
            add(START_DL);
            add(END_DL);
            add(START_UL);
            add(END_UL);
            add(TECHNOLOGY);
            add(DUPLEX_MODE);
            add(BAND);
        }
    });

    public CreateDerivativeSpecTokenTypeFromOfferFlow(ProductOfferDetails productOfferDetails, String offerDid) {
        this.productOfferDetails = productOfferDetails;
        this.offerDid = offerDid;
    }

    @Suspendable
    @Override
    public SignedTransaction call() throws FlowException {
        List<StateAndRef<PrimitiveSpecTokenType>> states = getServiceHub().getVaultService().queryBy(PrimitiveSpecTokenType.class).getStates();
        PrimitiveSpecTokenType primitiveSpecTokenType = states.get(states.size() - 1).getState().getData();
        DerivativeSpecTokenType derivativeSpecTokenType = derivativeSpectokenBuild(primitiveSpecTokenType.getLinearId().toString());

        if (!doesDerivativeMatchPrimitive(primitiveSpecTokenType, derivativeSpecTokenType)) {
            throw new FlowException("Derivative's data does not match with Primitive's");
        }

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

    private DerivativeSpecTokenType derivativeSpectokenBuild(String primitiveLinearId) {
        ResourceSpecification resourceSpecification = productOfferDetails.getResourceSpecifications().get(0);
        Map<String, ResourceSpecCharacteristic> resourceSpecCharacteristicMap = new HashMap<>();

        for (ResourceSpecCharacteristic resourceSpecCharacteristic : resourceSpecification.getResourceSpecCharacteristic()) {
            if (CHARACTERISTIC_NAMES.contains(resourceSpecCharacteristic.getName())) {
                resourceSpecCharacteristicMap.put(resourceSpecCharacteristic.getName(), resourceSpecCharacteristic);
            }
        }
        return new DerivativeSpecTokenType(
                Collections.singletonList(getOurIdentity()),
                new UniqueIdentifier(),
                Double.valueOf(resourceSpecCharacteristicMap.get(START_DL).getResourceSpecCharacteristicValue().get(0).getValue().getValue()),
                Double.valueOf(resourceSpecCharacteristicMap.get(END_DL).getResourceSpecCharacteristicValue().get(0).getValue().getValue()),
                Double.valueOf(resourceSpecCharacteristicMap.get(START_UL).getResourceSpecCharacteristicValue().get(0).getValue().getValue()),
                Double.valueOf(resourceSpecCharacteristicMap.get(END_UL).getResourceSpecCharacteristicValue().get(0).getValue().getValue()),
                null,
                null,
                resourceSpecCharacteristicMap.get(DUPLEX_MODE).getResourceSpecCharacteristicValue().get(0).getValue().getValue(),
                Integer.valueOf(resourceSpecCharacteristicMap.get(BAND).getResourceSpecCharacteristicValue().get(0).getValue().getValue()),
                resourceSpecCharacteristicMap.get(TECHNOLOGY).getResourceSpecCharacteristicValue().get(0).getValue().getValue(),
                productOfferDetails.getGeographicAddresses().get(0).getCountry(),
                null,
                primitiveLinearId,
                productOfferDetails.getProductOfferingPrices().get(0).getPrice().getValue(),
                offerDid
        );
    }

    private boolean doesDerivativeMatchPrimitive(PrimitiveSpecTokenType primitiveSpecTokenType, DerivativeSpecTokenType derivativeSpecTokenType) {
        return derivativeSpecTokenType.getStartDl() >= primitiveSpecTokenType.getStartDl()
                && derivativeSpecTokenType.getEndDl() <= primitiveSpecTokenType.getEndDl()
                && derivativeSpecTokenType.getStartUl() >= primitiveSpecTokenType.getStartUl()
                && derivativeSpecTokenType.getEndUl() <= primitiveSpecTokenType.getEndUl()
                && derivativeSpecTokenType.getCountry().equals(primitiveSpecTokenType.getCountry());
    }

}
