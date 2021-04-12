package eu._5gzorro.manager.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu._5gzorro.manager.api.controller.dto.ServiceLevelAgreementDto;
import eu._5gzorro.manager.api.model.entity.ServiceLevelAgreement;
import eu._5gzorro.manager.api.model.enumureration.EntityStatus;
import eu._5gzorro.manager.api.model.exception.ServiceLevelAgreementNotFoundException;
import eu._5gzorro.manager.api.repository.ServiceLevelAgreementRepository;
import eu._5gzorro.manager.api.utils.UuidSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.UUID;

public class ServiceLevelAgreementServiceImpl implements ServiceLevelAgreementService {

    private ObjectMapper objectMapper;

    @Autowired
    UuidSource uuidSource;

    @Autowired
    ServiceLevelAgreementRepository slaRepository;

    public ServiceLevelAgreementServiceImpl() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public Page<ServiceLevelAgreementDto> getSLAs(Pageable pageable) {
        return null;
    }

    @Override
    public ServiceLevelAgreementDto getSLA(String slaId) {
        return null;
    }

    @Override
    @Transactional
    public UUID createSLA(ServiceLevelAgreementDto dto) throws JsonProcessingException {

        UUID slaHandle = uuidSource.newUUID();
        ServiceLevelAgreement sla = new ServiceLevelAgreement();
        sla.setId(slaHandle.toString());
        sla.setHandle(slaHandle);
        sla.setProperties(objectMapper.writeValueAsString(dto));

        slaRepository.save(sla);

        //TODO: Request DID

        return slaHandle;
    }

    @Override
    @Transactional
    public void completeSLACreation(String slaId, String did) {

        ServiceLevelAgreement sla = slaRepository.findById(slaId)
                .orElseThrow(() -> new ServiceLevelAgreementNotFoundException(slaId));

        sla.setId(did);
        sla.setStatus(EntityStatus.CREATED);
        slaRepository.save(sla);
    }

    @Override
    @Transactional
    public void updateSLA(String slaId, ServiceLevelAgreementDto dto) throws JsonProcessingException {

        ServiceLevelAgreement sla = slaRepository.findById(slaId)
                .orElseThrow(() -> new ServiceLevelAgreementNotFoundException(slaId));

        sla.setProperties(objectMapper.writeValueAsString(dto));
        sla.setUpdated(LocalDateTime.now());
        slaRepository.save(sla);
    }

    @Override
    @Transactional
    public void deleteSLA(String slaId) {
        if(!slaRepository.existsById(slaId)) {
            throw new ServiceLevelAgreementNotFoundException(slaId);
        }

        slaRepository.deleteById(slaId);
    }
}
