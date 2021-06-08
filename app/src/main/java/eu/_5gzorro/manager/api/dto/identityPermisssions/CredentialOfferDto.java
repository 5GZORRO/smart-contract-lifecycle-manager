package eu._5gzorro.manager.api.dto.identityPermisssions;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class CredentialOfferDto {
    @JsonProperty("credential_preview")
    private CredentialPreviewDto credentialPreview;

    public CredentialOfferDto() {
    }

    public CredentialPreviewDto getCredentialPreview() {
        return credentialPreview;
    }

    public void setCredentialPreview(CredentialPreviewDto credentialPreview) {
        this.credentialPreview = credentialPreview;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CredentialOfferDto that = (CredentialOfferDto) o;
        return Objects.equals(credentialPreview, that.credentialPreview);
    }

    @Override
    public int hashCode() {
        return Objects.hash(credentialPreview);
    }

    @Override
    public String toString() {
        return "CredentialOfferDto{" +
                "credentialPreview=" + credentialPreview +
                '}';
    }
}
