package eu._5gzorro.manager.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu._5gzorro.manager.api.model.AuthData;
import eu._5gzorro.manager.api.model.entity.ServiceLevelAgreementWrapper;
import eu._5gzorro.manager.api.model.enumureration.EntityStatus;
import eu._5gzorro.manager.api.model.exception.ServiceLevelAgreementNotFoundException;
import eu._5gzorro.manager.api.model.exception.ServiceLevelAgreementStatusException;
import eu._5gzorro.manager.api.repository.ServiceLevelAgreementRepository;
import eu._5gzorro.manager.api.utils.UuidSource;
import eu._5gzorro.tm_forum.models.sla.ServiceLevelAgreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ServiceLevelAgreementServiceImpl implements ServiceLevelAgreementService {

    private static final Logger log = LoggerFactory.getLogger(ServiceLevelAgreementServiceImpl.class);

    private ObjectMapper objectMapper;

    @Autowired
    UuidSource uuidSource;

    @Autowired
    ServiceLevelAgreementRepository slaRepository;

    @Autowired
    IdentityAndPermissionsApiClient identityClient;

    @Autowired
    AuthData authData;

    @Value("${callbacks.updateSLAIdentity}")
    private String updateSLAIdentityCallbackUrl;

    public ServiceLevelAgreementServiceImpl() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public Page<ServiceLevelAgreement> getSLAs(Pageable pageable) {

        return slaRepository.findAll(pageable)
                .map(sla -> {
                    try {
                        return objectMapper.readValue(sla.getProperties(), ServiceLevelAgreement.class);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    return null;
                });
    }

    @Override
    public ServiceLevelAgreement getSLA(String slaId) throws JsonProcessingException {
        ServiceLevelAgreementWrapper sla = slaRepository.findById(slaId)
                .orElseThrow(() -> new ServiceLevelAgreementNotFoundException(slaId));

        return objectMapper.readValue(sla.getProperties(), ServiceLevelAgreement.class);
    }

    @Override
    @Transactional
    public UUID createSLA(ServiceLevelAgreement dto) throws JsonProcessingException {

        UUID slaHandle = uuidSource.newUUID();

//        try {
//            String callbackUrl = String.format(updateSLAIdentityCallbackUrl, slaHandle);
//            identityClient.createDID(callbackUrl, authData.getAuthToken());
//        }
//        catch (Exception ex) {
//            throw new DIDCreationException(ex);
//        }

        ServiceLevelAgreementWrapper sla = new ServiceLevelAgreementWrapper();

        //set temporary ID
        sla.setId(slaHandle.toString());
        sla.setHandle(slaHandle);

        dto.setId(slaHandle.toString());
        dto.setState(EntityStatus.CREATING.toString());

        sla.setProperties(objectMapper.writeValueAsString(dto));
        slaRepository.save(sla);

        return slaHandle;
    }

    @Override
    @Transactional
    public void completeSLACreation(UUID slaHandle, String did) throws JsonProcessingException {

        ServiceLevelAgreementWrapper sla = slaRepository.findById(slaHandle.toString())
                .orElseThrow(() -> new ServiceLevelAgreementNotFoundException(slaHandle.toString()));

        if(sla.getStatus() != EntityStatus.CREATING) {
            throw new ServiceLevelAgreementStatusException(EntityStatus.CREATING, sla.getStatus());
        }

        sla.setId(did);
        sla.setStatus(EntityStatus.CREATED);

        ServiceLevelAgreement dto = objectMapper.readValue(sla.getProperties(), ServiceLevelAgreement.class);
        dto.setId(did);
        dto.setState(EntityStatus.CREATED.toString());

        sla.setProperties(objectMapper.writeValueAsString(dto));
        slaRepository.save(sla);
    }

    @Override
    @Transactional
    public void updateSLA(String slaId, ServiceLevelAgreement dto) throws JsonProcessingException {

        ServiceLevelAgreementWrapper sla = slaRepository.findById(slaId)
                .orElseThrow(() -> new ServiceLevelAgreementNotFoundException(slaId));

        if(sla.getStatus() != EntityStatus.CREATED) {
            throw new ServiceLevelAgreementStatusException(EntityStatus.CREATED, sla.getStatus());
        }

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
