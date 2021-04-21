package eu._5gzorro.manager.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import eu._5gzorro.tm_forum.models.agreement.Agreement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface AgreementService {

    Page<Agreement> getAgreements(Pageable pageable);
    Agreement getAgreementById(UUID id) throws JsonProcessingException;
    Agreement getAgreementByDid(String did) throws JsonProcessingException;
    UUID createAgreement(Agreement dto) throws JsonProcessingException;
    void completeAgreementCreation(UUID id, String did) throws JsonProcessingException;
    void updateAgreement(String did, Agreement dto) throws JsonProcessingException;
    void deleteAgreement(String did);
}
