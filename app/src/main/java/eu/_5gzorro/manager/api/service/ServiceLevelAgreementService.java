package eu._5gzorro.manager.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import eu._5gzorro.tm_forum.models.sla.ServiceLevelAgreement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ServiceLevelAgreementService {

    Page<ServiceLevelAgreement> getSLAs(Pageable pageable);
    ServiceLevelAgreement getSLAById(UUID id) throws JsonProcessingException;
    ServiceLevelAgreement getSLAByDid(String did) throws JsonProcessingException;
    UUID createSLA(ServiceLevelAgreement dto) throws JsonProcessingException;
    void completeSLACreation(UUID id, String did) throws JsonProcessingException;
    void updateSLA(String did, ServiceLevelAgreement dto) throws JsonProcessingException;
    void deleteSLA(String did);
}