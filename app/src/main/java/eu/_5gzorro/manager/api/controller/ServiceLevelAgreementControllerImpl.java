package eu._5gzorro.manager.api.controller;

import eu._5gzorro.manager.api.controller.dto.ServiceLevelAgreementDto;
import eu._5gzorro.manager.api.controller.dto.responses.PagedSlaResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public class ServiceLevelAgreementControllerImpl implements ServiceLevelAgreementController {
    @Override
    public ResponseEntity<PagedSlaResponse> getServiceLevelAgreements(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<ServiceLevelAgreementDto> getServiceLevelAgreement(String id) {
        return null;
    }

    @Override
    public ResponseEntity<ServiceLevelAgreementDto> createServiceLevelAgreement(ServiceLevelAgreementDto sla) {
        return null;
    }

    @Override
    public ResponseEntity<String> removeServiceLevelAgreeement(String id) {
        return null;
    }
}
