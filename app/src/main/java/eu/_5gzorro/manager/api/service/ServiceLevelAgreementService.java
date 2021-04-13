package eu._5gzorro.manager.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import eu._5gzorro.tm_forum.models.sla.ServiceLevelAgreement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ServiceLevelAgreementService {

    Page<ServiceLevelAgreement> getSLAs(Pageable pageable);
    ServiceLevelAgreement getSLA(String slaId) throws JsonProcessingException;
    UUID createSLA(ServiceLevelAgreement dto) throws JsonProcessingException;
    void completeSLACreation(UUID slaHandle, String did) throws JsonProcessingException;
    void updateSLA(String slaId, ServiceLevelAgreement dto) throws JsonProcessingException;
    void deleteSLA(String slaId);
}
