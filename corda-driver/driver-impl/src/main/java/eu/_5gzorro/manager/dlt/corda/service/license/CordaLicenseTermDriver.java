package eu._5gzorro.manager.dlt.corda.service.license;

import eu._5gzorro.manager.dlt.corda.flows.license.UpdateLicenseTermFlow;
import eu._5gzorro.manager.dlt.corda.models.types.LTState;
import eu._5gzorro.manager.dlt.corda.service.rpc.NodeRPC;
import eu._5gzorro.manager.service.LicenseTermDriver;
import net.corda.core.messaging.CordaRPCOps;

public class CordaLicenseTermDriver implements LicenseTermDriver {

    private final CordaRPCOps rpcClient;

    public CordaLicenseTermDriver(NodeRPC nodeRPC) { this.rpcClient = nodeRPC.getClient(); }

    @Override
    public void updateLicenseTermState(String productOrderDID, String productOfferingDID, Integer current, String state) {
        rpcClient.startFlowDynamic(UpdateLicenseTermFlow.UpdateLicenseTermFlowInitiator.class,
                productOrderDID, productOfferingDID, current, LTState.valueOf(state));
    }
}
