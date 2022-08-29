package eu._5gzorro.manager.dlt.corda.service.sla;

import eu._5gzorro.manager.dlt.corda.flows.sla.UpdateServiceLevelAgreementFlow;
import eu._5gzorro.manager.dlt.corda.models.types.SLAState;
import eu._5gzorro.manager.dlt.corda.service.rpc.NodeRPC;
import eu._5gzorro.manager.dlt.corda.states.ServiceLevelAgreementState;
import eu._5gzorro.manager.service.ServiceLevelAgreementDriver;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.messaging.CordaRPCOps;
import net.corda.core.node.services.Vault;
import net.corda.core.node.services.vault.PageSpecification;
import net.corda.core.node.services.vault.QueryCriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static net.corda.core.node.services.vault.QueryCriteriaUtils.DEFAULT_PAGE_NUM;
import static net.corda.core.node.services.vault.QueryCriteriaUtils.DEFAULT_PAGE_SIZE;

public class CordaServiceLevelAgreementDriver implements ServiceLevelAgreementDriver {

    private final CordaRPCOps rpcClient;

    public CordaServiceLevelAgreementDriver(NodeRPC nodeRPC) {
        this.rpcClient = nodeRPC.getClient();
    }

    @Override
    public void updateSLAState(String productOrderDID, String serviceLevelAgreementDID, String state) {
        rpcClient.startFlowDynamic(UpdateServiceLevelAgreementFlow.UpdateServiceLevelAgreementFlowInitiator.class,
                productOrderDID, serviceLevelAgreementDID, SLAState.valueOf(state));
    }

    @Override
    public List<?> getServiceLevelAgreementStates() {

        QueryCriteria criteria = new QueryCriteria.VaultQueryCriteria(Vault.StateStatus.UNCONSUMED);

        int pageNumber = DEFAULT_PAGE_NUM;
        List<StateAndRef<ServiceLevelAgreementState>> states = new ArrayList<>();
        long totalResults;
        do {
            PageSpecification pageSpecification = new PageSpecification(pageNumber, DEFAULT_PAGE_SIZE);
            Vault.Page<ServiceLevelAgreementState> results =
                    rpcClient.vaultQueryByWithPagingSpec(ServiceLevelAgreementState.class, criteria, pageSpecification);
            totalResults = results.getTotalStatesAvailable();
            states.addAll(results.getStates());
            pageNumber++;
        } while(((long) DEFAULT_PAGE_SIZE * (pageNumber - 1) <= totalResults));

        return states.stream().map(s -> s.getState().getData()).collect(Collectors.toList());
    }
}
