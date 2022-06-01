package eu._5gzorro.manager.dlt.corda.flows.spectoken;

import co.paralleluniverse.fibers.Suspendable;
import com.r3.corda.lib.tokens.workflows.flows.rpc.CreateEvolvableTokens;
import eu._5gzorro.manager.dlt.corda.flows.utils.ExtendedFlowLogic;
import eu._5gzorro.manager.dlt.corda.states.DerivativeSpecTokenType;
import eu._5gzorro.manager.dlt.corda.states.PrimitiveSpecTokenType;
import eu._5gzorro.manager.dlt.corda.states.ProductOffering;
import eu._5gzorro.manager.domain.ProductOfferDetails;
import eu._5gzorro.tm_forum.models.resource.ResourceSpecCharacteristic;
import eu._5gzorro.tm_forum.models.resource.ResourceSpecification;
import net.corda.core.contracts.TransactionState;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.flows.FlowException;
import net.corda.core.flows.InitiatingFlow;
import net.corda.core.flows.StartableByRPC;
import net.corda.core.identity.Party;
import net.corda.core.node.services.Vault;
import net.corda.core.node.services.vault.QueryCriteria;
import net.corda.core.transactions.SignedTransaction;
import org.threeten.bp.OffsetDateTime;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;

@InitiatingFlow
@StartableByRPC
public class CreateDerivativeSpecTokenTypeFromOfferFlow extends ExtendedFlowLogic<SignedTransaction> {

    private final String offerId;
    private final OffsetDateTime requestedStartDate;
    private final OffsetDateTime requestedCompletionDate;
    private final Party buyer;

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

    public CreateDerivativeSpecTokenTypeFromOfferFlow(String offerId, OffsetDateTime requestedStartDate, OffsetDateTime requestedCompletionDate, Party buyer) {
        this.offerId = offerId;
        this.requestedStartDate = requestedStartDate;
        this.requestedCompletionDate = requestedCompletionDate;
        this.buyer = buyer;
    }

    @Suspendable
    @Override
    public SignedTransaction call() throws FlowException {
        Set<Class<ProductOffering>> contractStateTypes = new HashSet(singletonList(ProductOffering.class));
        List<UniqueIdentifier> linearIds = singletonList(new UniqueIdentifier(offerId));
        QueryCriteria linearCriteriaAll = new QueryCriteria.LinearStateQueryCriteria(null, linearIds, Vault.StateStatus.UNCONSUMED, null);
        ProductOffering productOffering = getServiceHub().getVaultService().queryBy(ProductOffering.class, linearCriteriaAll).getStates().get(0).getState().getData();
        DerivativeSpecTokenType derivativeSpecTokenType = derivativeSpectokenBuild(productOffering);
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

    private DerivativeSpecTokenType derivativeSpectokenBuild(ProductOffering productOffering) {
        ProductOfferDetails offerDetails = productOffering.getOfferDetails();
        ResourceSpecification resourceSpecification = offerDetails.getResourceSpecifications().get(0);
        Map<String, ResourceSpecCharacteristic> resourceSpecCharacteristicMap = new HashMap<>();

        QueryCriteria.VaultQueryCriteria criteria = new QueryCriteria.VaultQueryCriteria(Vault.StateStatus.UNCONSUMED);
        PrimitiveSpecTokenType primitiveSpecTokenType = getServiceHub().getVaultService().queryBy(PrimitiveSpecTokenType.class, criteria).getStates().get(0).getState().getData();

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
                new Date(requestedStartDate.toInstant().toEpochMilli()),
                new Date(requestedCompletionDate.toInstant().toEpochMilli()),
                resourceSpecCharacteristicMap.get(DUPLEX_MODE).getResourceSpecCharacteristicValue().get(0).getValue().getValue(),
                Integer.valueOf(resourceSpecCharacteristicMap.get(BAND).getResourceSpecCharacteristicValue().get(0).getValue().getValue()),
                resourceSpecCharacteristicMap.get(TECHNOLOGY).getResourceSpecCharacteristicValue().get(0).getValue().getValue(),
                offerDetails.getGeographicAddresses().get(0).getCountry(),
                buyer.getName().toString(),
                primitiveSpecTokenType.getLinearId().toString(),
                offerDetails.getProductOfferingPrices().get(0).getPrice().getValue()
        );
    }

}
