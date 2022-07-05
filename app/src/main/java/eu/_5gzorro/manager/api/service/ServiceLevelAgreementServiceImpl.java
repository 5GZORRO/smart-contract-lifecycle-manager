package eu._5gzorro.manager.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu._5gzorro.manager.api.httpClient.requests.CreateDidRequest;
import eu._5gzorro.manager.api.model.AuthData;
import eu._5gzorro.manager.api.model.entity.ServiceLevelAgreementWrapper;
import eu._5gzorro.manager.api.model.enumureration.CredentialRequestType;
import eu._5gzorro.manager.api.model.enumureration.EntityStatus;
import eu._5gzorro.manager.api.model.exception.DIDCreationException;
import eu._5gzorro.manager.api.model.exception.ServiceLevelAgreementNotFoundException;
import eu._5gzorro.manager.api.model.exception.ServiceLevelAgreementStatusException;
import eu._5gzorro.manager.api.repository.ServiceLevelAgreementRepository;
import eu._5gzorro.manager.api.utils.UuidSource;
import eu._5gzorro.tm_forum.models.sla.ServiceLevelAgreement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;

@Service
public class ServiceLevelAgreementServiceImpl implements ServiceLevelAgreementService {

    private static final Logger log = LoggerFactory.getLogger(ServiceLevelAgreementServiceImpl.class);

    @Autowired
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

    @Value("${server.hostname}")
    private String hostname;

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
    public ServiceLevelAgreement getSLAById(UUID id) throws JsonProcessingException {
        ServiceLevelAgreementWrapper sla = slaRepository.findById(id)
                .orElseThrow(() -> new ServiceLevelAgreementNotFoundException(id.toString()));

        return objectMapper.readValue(sla.getProperties(), ServiceLevelAgreement.class);
    }

    @Override
    public ServiceLevelAgreement getSLAByDid(String did) throws JsonProcessingException {
        ServiceLevelAgreementWrapper sla = slaRepository.findByDid(did)
                .orElseThrow(() -> new ServiceLevelAgreementNotFoundException(did));

        return objectMapper.readValue(sla.getProperties(), ServiceLevelAgreement.class);
    }

    @Override
    public UUID createSLA(ServiceLevelAgreement dto) throws JsonProcessingException {

        UUID slaId = uuidSource.newUUID();
        dto.setId(slaId.toString());
        dto.setHref("http://" + hostname + "/api/v1/service-level-agreement/" + slaId.toString());

        ServiceLevelAgreementWrapper sla = new ServiceLevelAgreementWrapper();
        sla.setId(slaId);
        sla.setStatus(EntityStatus.CREATING);

        dto.setState(EntityStatus.CREATING.toString());

        dto.getRules().stream().forEach(rule -> rule.setId(uuidSource.newUUID().toString()));

        sla.setProperties(objectMapper.writeValueAsString(dto));
        slaRepository.save(sla);

        log.info("SLA {} stored in SCLCM.", slaId);

        try {
            String callbackUrl = String.format(updateSLAIdentityCallbackUrl, slaId);
            log.info("Requesting DID for SLA {}, the DID will be received on {}", slaId, callbackUrl);
            CreateDidRequest request = new CreateDidRequest()
                    .callbackUrl(callbackUrl)
                    .claims(Collections.emptyList())
                    .type(CredentialRequestType.SLA);

            identityClient.createDID(request);
        }
        catch (Exception ex) {
            throw new DIDCreationException(ex);
        }

        return slaId;
    }

    @Override
    @Transactional
    public void completeSLACreation(UUID slaId, String did) throws JsonProcessingException {

        log.info("Updating SLA {} with DID {}", slaId, did);

        ServiceLevelAgreementWrapper sla = slaRepository.findById(slaId)
                .orElseThrow(() -> new ServiceLevelAgreementNotFoundException(slaId.toString()));

        log.info("SLA {} retrieved", slaId);

        if(sla.getStatus() != EntityStatus.CREATING) {
            throw new ServiceLevelAgreementStatusException(EntityStatus.CREATING, sla.getStatus());
        }

        sla.setDid(did);
        sla.setStatus(EntityStatus.CREATED);

        ServiceLevelAgreement dto = objectMapper.readValue(sla.getProperties(), ServiceLevelAgreement.class);
        dto.setId(did);
        dto.setHref("http://" + hostname + "/api/v1/service-level-agreement/" + did);
        dto.setState(EntityStatus.CREATED.toString());

        sla.setProperties(objectMapper.writeValueAsString(dto));
        slaRepository.save(sla);

        log.info("SLA {} updated with DID {}", slaId, did);
    }

    @Override
    @Transactional
    public void updateSLA(String did, ServiceLevelAgreement dto) throws JsonProcessingException {

        ServiceLevelAgreementWrapper sla = slaRepository.findByDid(did)
                .orElseThrow(() -> new ServiceLevelAgreementNotFoundException(did));

        if(sla.getStatus() != EntityStatus.CREATED) {
            throw new ServiceLevelAgreementStatusException(EntityStatus.CREATED, sla.getStatus());
        }

        sla.setProperties(objectMapper.writeValueAsString(dto));
        sla.setUpdated(LocalDateTime.now());
        slaRepository.save(sla);
    }

    @Override
    @Transactional
    public void deleteSLA(String did) {
        if(!slaRepository.existsByDid(did)) {
            throw new ServiceLevelAgreementNotFoundException(did);
        }

        slaRepository.deleteByDid(did);
    }
}
