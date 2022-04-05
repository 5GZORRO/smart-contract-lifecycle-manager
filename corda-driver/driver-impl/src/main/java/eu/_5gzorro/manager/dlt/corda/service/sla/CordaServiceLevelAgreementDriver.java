package eu._5gzorro.manager.dlt.corda.service.sla;

import eu._5gzorro.manager.dlt.corda.flows.sla.UpdateServiceLevelAgreementFlow;
import eu._5gzorro.manager.dlt.corda.models.types.SLAState;
import eu._5gzorro.manager.dlt.corda.service.rpc.NodeRPC;
import eu._5gzorro.manager.service.ServiceLevelAgreementDriver;
import net.corda.core.messaging.CordaRPCOps;

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
}
