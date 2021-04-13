package eu._5gzorro.manager.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import eu._5gzorro.manager.api.controller.dto.identityPermisssions.DIDStateDto;
import eu._5gzorro.manager.api.controller.dto.responses.PagedSlaResponse;
import eu._5gzorro.manager.api.service.ServiceLevelAgreementService;
import eu._5gzorro.tm_forum.models.sla.ServiceLevelAgreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ServiceLevelAgreementControllerImpl implements ServiceLevelAgreementController {

    @Autowired
    ServiceLevelAgreementService slaService;

    @Override
    public ResponseEntity<PagedSlaResponse> getServiceLevelAgreements(Pageable pageable) {

        Page<ServiceLevelAgreement> slas = slaService.getSLAs(pageable);
        PagedSlaResponse response = new PagedSlaResponse(slas);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ServiceLevelAgreement> getServiceLevelAgreement(String did) throws JsonProcessingException {
        return ResponseEntity.ok(slaService.getSLAByDid(did));
    }

    @Override
    public ResponseEntity<UUID> createServiceLevelAgreement(ServiceLevelAgreement sla) throws JsonProcessingException {

        UUID id = slaService.createSLA(sla);
        return ResponseEntity
                .accepted()
                .body(id);
    }

    @Override
    public ResponseEntity<Void> updateTemplateIdentity(UUID slaId, DIDStateDto state) throws JsonProcessingException {
        slaService.completeSLACreation(slaId, state.getDid());
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> removeServiceLevelAgreeement(String did) {
        slaService.deleteSLA(did);
        return ResponseEntity.ok().build();
    }
}