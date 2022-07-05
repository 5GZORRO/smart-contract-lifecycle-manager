package eu._5gzorro.manager.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import eu._5gzorro.manager.api.dto.identityPermisssions.CredentialSubjectDto;
import eu._5gzorro.manager.api.dto.identityPermisssions.DIDStateCSDto;
import eu._5gzorro.manager.api.dto.requests.UpdateSLAStateRequest;
import eu._5gzorro.manager.api.dto.responses.PagedSlaResponse;
import eu._5gzorro.manager.api.service.ServiceLevelAgreementService;
import eu._5gzorro.manager.service.ServiceLevelAgreementDriver;
import eu._5gzorro.tm_forum.models.sla.ServiceLevelAgreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
public class ServiceLevelAgreementControllerImpl implements ServiceLevelAgreementController {

    @Autowired
    private ServiceLevelAgreementService slaService;

    @Autowired
    private ServiceLevelAgreementDriver serviceLevelAgreementDriver;

    @Override
    public ResponseEntity<PagedSlaResponse> getServiceLevelAgreements(Pageable pageable) {

        Page<ServiceLevelAgreement> slas = slaService.getSLAs(pageable);
        PagedSlaResponse response = new PagedSlaResponse(slas);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ServiceLevelAgreement> getServiceLevelAgreement(String identifier) throws JsonProcessingException {

        ServiceLevelAgreement sla;

        try {
            UUID id = UUID.fromString(identifier);
            sla = slaService.getSLAById(id);
        }
        catch(IllegalArgumentException e) {
            sla = slaService.getSLAByDid(identifier);
        }

        return ResponseEntity.ok(sla);
    }

    @Override
    public ResponseEntity<UUID> createServiceLevelAgreement(ServiceLevelAgreement sla) throws JsonProcessingException {

        UUID id = slaService.createSLA(sla);
        return ResponseEntity
                .accepted()
                .body(id);
    }

    @Override
    public ResponseEntity<Void> updateTemplateIdentity(UUID slaId, DIDStateCSDto state) throws JsonProcessingException {

        CredentialSubjectDto credentialSubjectDto = state.getCredentialSubjectDto();
        if(credentialSubjectDto == null)
            return ResponseEntity.badRequest().build();

        String did = credentialSubjectDto.getId();

        if(did == null)
            return ResponseEntity.badRequest().build();

        slaService.completeSLACreation(slaId, did);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> removeServiceLevelAgreement(String did) {
        slaService.deleteSLA(did);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> updateSLAState(@Valid UpdateSLAStateRequest request) {
        serviceLevelAgreementDriver.updateSLAState(request.getProductOrderDID(),
                request.getServiceLevelAgreementDID(), request.getState().toString());

        return ResponseEntity.noContent().build();
    }
}
