package eu._5gzorro.manager.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu._5gzorro.elicense.models.LicenseTerm;
import eu._5gzorro.manager.api.httpClient.requests.CreateDidRequest;
import eu._5gzorro.manager.api.model.entity.LicenseTermWrapper;
import eu._5gzorro.manager.api.model.enumureration.CredentialRequestType;
import eu._5gzorro.manager.api.model.enumureration.EntityStatus;
import eu._5gzorro.manager.api.model.exception.DIDCreationException;
import eu._5gzorro.manager.api.model.exception.LicenseTermNotFoundException;
import eu._5gzorro.manager.api.model.exception.LicenseTermStatusException;
import eu._5gzorro.manager.api.repository.LicenseTermRepository;
import eu._5gzorro.manager.api.utils.UuidSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LicenseTermServiceImpl implements LicenseTermService {

    private static final Logger log = LoggerFactory.getLogger(LicenseTermServiceImpl.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    UuidSource uuidSource;

    @Autowired
    LicenseTermRepository licenseTermRepository;

    @Autowired
    IdentityAndPermissionsApiClient identityClient;

    @Value("${callbacks.updateLicenseTerm}")
    private String updateLicenseTermCallbackUrl;

    @Value("${server.hostname}")
    private String hostname;


    @Override
    public List<LicenseTerm> getLicenseTerms() {
        return licenseTermRepository.findAll().stream().map(licenseTermWrapper -> {
            try {
                return objectMapper.readValue(licenseTermWrapper.getProperties(), LicenseTerm.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());
    }

    @Override
    public LicenseTerm getLicenseTermById(UUID id) throws JsonProcessingException {
        LicenseTermWrapper licenseTermWrapper = licenseTermRepository
                .findById(id).orElseThrow(() -> new LicenseTermNotFoundException(id.toString()));

        return objectMapper.readValue(licenseTermWrapper.getProperties(), LicenseTerm.class);
    }

    @Override
    public LicenseTerm getLicenseTermByDID(String did) throws JsonProcessingException {
        LicenseTermWrapper licenseTermWrapper = licenseTermRepository
                .findByDid(did).orElseThrow(() -> new LicenseTermNotFoundException(did));

        return objectMapper.readValue(licenseTermWrapper.getProperties(), LicenseTerm.class);
    }

    @Override
    public UUID createLicenseTerm(LicenseTerm dto) throws JsonProcessingException {

        UUID licenseTermId = uuidSource.newUUID();
        dto.setId(licenseTermId.toString());
        dto.setHref("http://" + hostname + "/api/v1/license-term/" + licenseTermId.toString());
        dto.setState(EntityStatus.CREATING.toString());

        LicenseTermWrapper licenseTermWrapper = new LicenseTermWrapper();
        licenseTermWrapper.setId(licenseTermId);
        licenseTermWrapper.setStatus(EntityStatus.CREATING);
        licenseTermWrapper.setProperties(objectMapper.writeValueAsString(dto));

        licenseTermRepository.save(licenseTermWrapper);

        log.info("License Term {} stored in SCLCM.", licenseTermId);

        try {
            String callbackUrl = String.format(updateLicenseTermCallbackUrl, licenseTermId);
            log.info("Requesting DID for License Term {}, the DID will be received on {}", licenseTermId, callbackUrl);
            CreateDidRequest request = new CreateDidRequest()
                    .callbackUrl(callbackUrl)
                    .claims(Collections.emptyList())
                    .type(CredentialRequestType.Agreement);
            identityClient.createDID(request);
        } catch(Exception e) {
            throw new DIDCreationException(e);
        }

        return licenseTermId;
    }

    @Override
    @Transactional
    public void completeLicenseTermCreation(UUID id, String did) throws JsonProcessingException {
        log.info("Updating License Term {} with DID {}", id, did);

        LicenseTermWrapper licenseTermWrapper = licenseTermRepository
                .findById(id).orElseThrow(() -> new LicenseTermNotFoundException(id.toString()));

        log.info("License Term {} retrieved", id);

        if(licenseTermWrapper.getStatus() != EntityStatus.CREATING)
            throw new LicenseTermStatusException(EntityStatus.CREATING, licenseTermWrapper.getStatus());

        licenseTermWrapper.setDid(did);
        licenseTermWrapper.setStatus(EntityStatus.CREATED);

        LicenseTerm licenseTerm = objectMapper.readValue(licenseTermWrapper.getProperties(), LicenseTerm.class);
        licenseTerm.setId(did);
        licenseTerm.setHref("http://" + hostname + "/api/v1/license-term/" + did);
        licenseTerm.setState(EntityStatus.CREATED.toString());

        licenseTermWrapper.setProperties(objectMapper.writeValueAsString(licenseTerm));
        licenseTermRepository.save(licenseTermWrapper);

        log.info("License Term {} updated with DID {}", id, did);
    }

    @Override
    @Transactional
    public void updateLicenseTerm(String did, LicenseTerm dto) throws JsonProcessingException {
        LicenseTermWrapper licenseTermWrapper = licenseTermRepository
                .findByDid(did).orElseThrow(() -> new LicenseTermNotFoundException(did));

        if(licenseTermWrapper.getStatus() != EntityStatus.CREATED)
            throw new LicenseTermStatusException(EntityStatus.CREATED, licenseTermWrapper.getStatus());

        licenseTermWrapper.setProperties(objectMapper.writeValueAsString(dto));
        licenseTermWrapper.setUpdated(LocalDateTime.now());
        licenseTermRepository.save(licenseTermWrapper);
    }

    @Override
    @Transactional
    public void deleteLicenseTerm(String did) {
        if(!licenseTermRepository.existsByDid(did))
            throw new LicenseTermNotFoundException(did);

        licenseTermRepository.deleteByDid(did);
    }
}
