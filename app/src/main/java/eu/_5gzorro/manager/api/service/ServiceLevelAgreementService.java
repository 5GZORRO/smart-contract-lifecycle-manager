package eu._5gzorro.manager.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import eu._5gzorro.manager.api.controller.dto.ServiceLevelAgreementDto;
import eu._5gzorro.manager.api.model.entity.ServiceLevelAgreement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ServiceLevelAgreementService {

    Page<ServiceLevelAgreementDto> getSLAs(Pageable pageable);
    ServiceLevelAgreementDto getSLA(String slaId) throws JsonProcessingException;
    UUID createSLA(ServiceLevelAgreementDto dto) throws JsonProcessingException;
    void completeSLACreation(UUID slaHandle, String did) throws JsonProcessingException;
    void updateSLA(String slaId, ServiceLevelAgreementDto dto) throws JsonProcessingException;
    void deleteSLA(String slaId);
}
