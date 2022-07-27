package eu._5gzorro.manager.api.dto.requests;

public class UpdateLicenseTermStateRequest {

    public enum LicenseTermState {
        VIOLATED,
        RETIRED
    }

    private final String productOrderDID;
    private final String productOfferingDID;
    private final Integer current;
    private final LicenseTermState state;

    public UpdateLicenseTermStateRequest(String productOrderDID,
                                         String productOfferingDID,
                                         Integer current,
                                         LicenseTermState state) {
        this.productOrderDID = productOrderDID;
        this.productOfferingDID = productOfferingDID;
        this.current = current;
        this.state = state;
    }

    public String getProductOrderDID() { return productOrderDID; }

    public String getProductOfferingDID() { return productOfferingDID; }

    public Integer getCurrent() { return current; }

    public LicenseTermState getState() { return state; }
}
