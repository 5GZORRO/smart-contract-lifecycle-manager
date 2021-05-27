package eu._5gzorro.manager.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu._5gzorro.manager.api.httpClient.requests.CreateDidRequest;
import eu._5gzorro.manager.api.model.AuthData;
import eu._5gzorro.manager.api.model.entity.AgreementWrapper;
import eu._5gzorro.manager.api.model.enumureration.CredentialRequestType;
import eu._5gzorro.manager.api.model.enumureration.EntityStatus;
import eu._5gzorro.manager.api.model.exception.AgreementNotFoundException;
import eu._5gzorro.manager.api.model.exception.AgreementStatusException;
import eu._5gzorro.manager.api.model.exception.DIDCreationException;
import eu._5gzorro.manager.api.repository.AgreementRepository;
import eu._5gzorro.manager.api.utils.UuidSource;
import eu._5gzorro.tm_forum.models.agreement.Agreement;
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
public class AgreementServiceImpl implements AgreementService {

    private static final Logger log = LoggerFactory.getLogger(AgreementServiceImpl.class);

    private ObjectMapper objectMapper;

    @Autowired
    UuidSource uuidSource;

    @Autowired
    AgreementRepository agreementRepository;

    @Autowired
    IdentityAndPermissionsApiClient identityClient;

    @Autowired
    AuthData authData;

    @Value("${callbacks.updateAgreementIdentity}")
    private String updateAgreementIdentityCallbackUrl;

    public AgreementServiceImpl() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public Page<Agreement> getAgreements(Pageable pageable) {

        return agreementRepository.findAll(pageable)
                .map(agreement -> {
                    try {
                        return objectMapper.readValue(agreement.getProperties(), Agreement.class);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    return null;
                });
    }

    @Override
    public Agreement getAgreementById(UUID id) throws JsonProcessingException {
        AgreementWrapper agreement = agreementRepository.findById(id)
                .orElseThrow(() -> new AgreementNotFoundException(id.toString()));

        return objectMapper.readValue(agreement.getProperties(), Agreement.class);
    }

    @Override
    public Agreement getAgreementByDid(String did) throws JsonProcessingException {
        AgreementWrapper agreement = agreementRepository.findByDid(did)
                .orElseThrow(() -> new AgreementNotFoundException(did));

        return objectMapper.readValue(agreement.getProperties(), Agreement.class);
    }

    @Override
    @Transactional
    public UUID createAgreement(Agreement dto) throws JsonProcessingException {

        UUID id = uuidSource.newUUID();

        try {
            String callbackUrl = String.format(updateAgreementIdentityCallbackUrl, id);
            CreateDidRequest request = new CreateDidRequest()
                    .callbackUrl(callbackUrl)
                    .claims(Collections.emptyList())
                    .type(CredentialRequestType.Agreement);

            identityClient.createDID(request);
        }
        catch (Exception ex) {
            throw new DIDCreationException(ex);
        }

        AgreementWrapper agreement = new AgreementWrapper();
        agreement.setId(id);
        agreement.setStatus(EntityStatus.CREATING);

        dto.setStatus(EntityStatus.CREATING.toString());

        agreement.setProperties(objectMapper.writeValueAsString(dto));
        agreementRepository.save(agreement);

        return id;
    }

    @Override
    @Transactional
    public void completeAgreementCreation(UUID id, String did) throws JsonProcessingException {

        AgreementWrapper agreement = agreementRepository.findById(id)
                .orElseThrow(() -> new AgreementNotFoundException(id.toString()));

        if(agreement.getStatus() != EntityStatus.CREATING) {
            throw new AgreementStatusException(EntityStatus.CREATING, agreement.getStatus());
        }

        agreement.setDid(did);
        agreement.setStatus(EntityStatus.CREATED);

        Agreement dto = objectMapper.readValue(agreement.getProperties(), Agreement.class);
        dto.setId(did);
        dto.setStatus(EntityStatus.CREATED.toString());

        agreement.setProperties(objectMapper.writeValueAsString(dto));
        agreementRepository.save(agreement);
    }

    @Override
    @Transactional
    public void updateAgreement(String did, Agreement dto) throws JsonProcessingException {

        AgreementWrapper agreement = agreementRepository.findByDid(did)
                .orElseThrow(() -> new AgreementNotFoundException(did));

        if(agreement.getStatus() != EntityStatus.CREATED) {
            throw new AgreementStatusException(EntityStatus.CREATED, agreement.getStatus());
        }

        agreement.setProperties(objectMapper.writeValueAsString(dto));
        agreement.setUpdated(LocalDateTime.now());
        agreementRepository.save(agreement);
    }

    @Override
    @Transactional
    public void deleteAgreement(String did) {
        if(!agreementRepository.existsByDid(did)) {
            throw new AgreementNotFoundException(did);
        }

        agreementRepository.deleteByDid(did);
    }
}
