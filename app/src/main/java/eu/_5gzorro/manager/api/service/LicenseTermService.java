package eu._5gzorro.manager.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import eu._5gzorro.elicense.models.LicenseTerm;

import java.util.List;
import java.util.UUID;

public interface LicenseTermService {
    List<LicenseTerm> getLicenseTerms();
    LicenseTerm getLicenseTermById(UUID id) throws JsonProcessingException;
    LicenseTerm getLicenseTermByDID(String did) throws JsonProcessingException;
    UUID createLicenseTerm(LicenseTerm dto) throws JsonProcessingException;
    void completeLicenseTermCreation(UUID id, String did) throws JsonProcessingException;
    void updateLicenseTerm(String did, LicenseTerm dto) throws JsonProcessingException;
    void deleteLicenseTerm(String did);
}
