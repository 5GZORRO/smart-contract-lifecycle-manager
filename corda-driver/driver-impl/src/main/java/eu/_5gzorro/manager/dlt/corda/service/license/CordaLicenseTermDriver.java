package eu._5gzorro.manager.dlt.corda.service.license;

import eu._5gzorro.manager.dlt.corda.flows.license.UpdateLicenseTermFlow;
import eu._5gzorro.manager.dlt.corda.models.types.LTState;
import eu._5gzorro.manager.dlt.corda.service.rpc.NodeRPC;
import eu._5gzorro.manager.dlt.corda.states.LicenseTermState;
import eu._5gzorro.manager.service.LicenseTermDriver;
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

public class CordaLicenseTermDriver implements LicenseTermDriver {

    private final CordaRPCOps rpcClient;

    public CordaLicenseTermDriver(NodeRPC nodeRPC) { this.rpcClient = nodeRPC.getClient(); }

    @Override
    public void updateLicenseTermState(String productOrderDID, String productOfferingDID, Integer current, String state) {
        rpcClient.startFlowDynamic(UpdateLicenseTermFlow.UpdateLicenseTermFlowInitiator.class,
                productOrderDID, productOfferingDID, current, LTState.valueOf(state));
    }

    @Override
    public List<?> getLicenseTermStates() {
        QueryCriteria criteria = new QueryCriteria.VaultQueryCriteria(Vault.StateStatus.UNCONSUMED);

        int pageNumber = DEFAULT_PAGE_NUM;
        List<StateAndRef<LicenseTermState>> states = new ArrayList<>();
        long totalResults;
        do {
            PageSpecification pageSpecification = new PageSpecification(pageNumber, DEFAULT_PAGE_SIZE);
            Vault.Page<LicenseTermState> results =
                    rpcClient.vaultQueryByWithPagingSpec(LicenseTermState.class, criteria, pageSpecification);
            totalResults = results.getTotalStatesAvailable();
            states.addAll(results.getStates());
            pageNumber++;
        } while(((long) DEFAULT_PAGE_SIZE * (pageNumber - 1) <= totalResults));

        return states.stream().map(s -> s.getState().getData()).collect(Collectors.toList());
    }
}
