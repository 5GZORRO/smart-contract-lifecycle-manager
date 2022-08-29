package eu._5gzorro.manager.service;

import java.util.List;

public interface ServiceLevelAgreementDriver {
    void updateSLAState(String productOrderDID, String serviceLevelAgreementDID, String state);
    List<?> getServiceLevelAgreementStates();
}
