package eu._5gzorro.manager.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import eu._5gzorro.manager.api.dto.identityPermisssions.DIDStateDto;
import eu._5gzorro.manager.api.dto.responses.PagedAgreementResponse;
import eu._5gzorro.manager.api.service.AgreementService;
import eu._5gzorro.tm_forum.models.agreement.Agreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class AgreementControllerImpl implements AgreementController {

    @Autowired
    AgreementService agreementService;

    @Override
    public ResponseEntity<PagedAgreementResponse> getAgreements(Pageable pageable) {

        Page<Agreement> agreements = agreementService.getAgreements(pageable);
        PagedAgreementResponse response = new PagedAgreementResponse(agreements);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Agreement> getAgreement(String identifier) throws JsonProcessingException {

        Agreement agreement;

        try {
            UUID id = UUID.fromString(identifier);
            agreement = agreementService.getAgreementById(id);
        }
        catch(IllegalArgumentException e) {
            agreement = agreementService.getAgreementByDid(identifier);
        }

        return ResponseEntity.ok(agreement);
    }

    @Override
    public ResponseEntity<UUID> createAgreement(Agreement agreement) throws JsonProcessingException {

        UUID id = agreementService.createAgreement(agreement);
        return ResponseEntity
                .accepted()
                .body(id);
    }

    @Override
    public ResponseEntity<Void> updateTemplateIdentity(UUID id, DIDStateDto state) throws JsonProcessingException {
        agreementService.completeAgreementCreation(id, state.getDid());
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> removeAgreement(String did) {
        agreementService.deleteAgreement(did);
        return ResponseEntity.ok().build();
    }
}
