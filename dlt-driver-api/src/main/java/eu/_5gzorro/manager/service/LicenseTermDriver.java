package eu._5gzorro.manager.service;

public interface LicenseTermDriver {
    void updateLicenseTermState(String productOrderDID, String productOfferingDID, Integer current, String state);
}
