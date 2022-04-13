package eu._5gzorro.manager.service;

public interface ServiceLevelAgreementDriver {
    void updateSLAState(String productOrderDID, String serviceLevelAgreementDID, String state);
}
