package eu._5gzorro.manager.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import eu._5gzorro.elicense.models.LicenseTerm;
import eu._5gzorro.manager.api.dto.identityPermisssions.CredentialSubjectDto;
import eu._5gzorro.manager.api.dto.identityPermisssions.DIDStateCSDto;
import eu._5gzorro.manager.api.dto.requests.UpdateLicenseTermStateRequest;
import eu._5gzorro.manager.api.service.LicenseTermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
public class LicenseTermControllerImpl implements LicenseTermController {

    @Autowired
    LicenseTermService licenseTermService;

    @Override
    public ResponseEntity<?> getLicenseTerms() {
        return ResponseEntity.ok(licenseTermService.getLicenseTerms());
    }

    @Override
    public ResponseEntity<?> getLicenseTerm(String identifier) throws JsonProcessingException {
        LicenseTerm licenseTerm;

        try {
            UUID id = UUID.fromString(identifier);
            licenseTerm = licenseTermService.getLicenseTermById(id);
        } catch(IllegalArgumentException e) {
            licenseTerm = licenseTermService.getLicenseTermByDID(identifier);
        }

        return ResponseEntity.ok(licenseTerm);
    }

    @Override
    public ResponseEntity<UUID> createLicenseTerm(@Valid LicenseTerm licenseTerm) throws JsonProcessingException {
        UUID id = licenseTermService.createLicenseTerm(licenseTerm);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @Override
    public ResponseEntity<Void> updateTemplateIdentity(UUID licenseTermId, @Valid DIDStateCSDto state) throws JsonProcessingException {

        CredentialSubjectDto credentialSubjectDto = state.getCredentialSubjectDto();
        if(credentialSubjectDto == null)
            return ResponseEntity.badRequest().build();

        String did = credentialSubjectDto.getId();
        if(did == null)
            return ResponseEntity.badRequest().build();

        licenseTermService.completeLicenseTermCreation(licenseTermId, did);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteLicenseTerm(String did) {
        licenseTermService.deleteLicenseTerm(did);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> updateLicenseTermState(@Valid UpdateLicenseTermStateRequest request) {
        return null;
    }
}
