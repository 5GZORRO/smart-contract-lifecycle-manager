package eu._5gzorro.manager.api.dto.identityPermisssions;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class DIDStateDto {
    @JsonProperty("credential_exchange_id")
    private String credentialExchangeId;

    @JsonProperty("credential_offer_dict")
    private CredentialOfferDto credentialOffer;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("schema_id")
    private String schemaId;

    private String state;

    public DIDStateDto() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCredentialExchangeId() {
        return credentialExchangeId;
    }

    public void setCredentialExchangeId(String credentialExchangeId) {
        this.credentialExchangeId = credentialExchangeId;
    }

    public CredentialOfferDto getCredentialOffer() {
        return credentialOffer;
    }

    public void setCredentialOffer(CredentialOfferDto credentialOffer) {
        this.credentialOffer = credentialOffer;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getSchemaId() {
        return schemaId;
    }

    public void setSchemaId(String schemaId) {
        this.schemaId = schemaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DIDStateDto that = (DIDStateDto) o;
        return credentialExchangeId.equals(that.credentialExchangeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(credentialExchangeId);
    }

    @Override
    public String toString() {
        return "DIDStateDto{" +
                "credentialExchangeId='" + credentialExchangeId + '\'' +
                ", credentialOffer=" + credentialOffer +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", schemaId='" + schemaId + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
