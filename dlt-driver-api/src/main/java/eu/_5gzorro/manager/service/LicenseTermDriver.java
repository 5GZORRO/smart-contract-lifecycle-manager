package eu._5gzorro.manager.service;

import java.util.List;

public interface LicenseTermDriver {
    void updateLicenseTermState(String productOrderDID, String productOfferingDID, Integer current, String state);
    List<?> getLicenseTermStates();
}
