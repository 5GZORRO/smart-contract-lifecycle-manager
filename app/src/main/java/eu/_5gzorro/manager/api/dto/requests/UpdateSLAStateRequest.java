package eu._5gzorro.manager.api.dto.requests;

public class UpdateSLAStateRequest {

    public enum SLAUpdateState {
        VIOLATED,
        RETIRED
    }

    private final String productOrderDID;
    private final String serviceLevelAgreementDID;
    private final SLAUpdateState state;

    public UpdateSLAStateRequest(String productOrderDID,
                                 String serviceLevelAgreementDID,
                                 SLAUpdateState state) {
        this.productOrderDID = productOrderDID;
        this.serviceLevelAgreementDID = serviceLevelAgreementDID;
        this.state = state;
    }

    public String getProductOrderDID() { return productOrderDID; }

    public String getServiceLevelAgreementDID() { return serviceLevelAgreementDID; }

    public SLAUpdateState getState() { return state; }
}
