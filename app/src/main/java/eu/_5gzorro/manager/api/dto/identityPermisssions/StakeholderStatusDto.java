package eu._5gzorro.manager.api.dto.identityPermisssions;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class StakeholderStatusDto {

    @JsonProperty("id_token")
    private String authToken;
    private String timestamp;
    private String state;
    @JsonProperty("credential_definition_id")
    private String credentialDefinitionId;
    private StakeholderClaimDto stakeholderClaim;

    public StakeholderStatusDto() {
    }

    public StakeholderClaimDto getStakeholderClaim() {
        return stakeholderClaim;
    }

    public void setStakeholderClaim(StakeholderClaimDto stakeholderClaim) {
        this.stakeholderClaim = stakeholderClaim;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCredentialDefinitionId() {
        return credentialDefinitionId;
    }

    public void setCredentialDefinitionId(String credentialDefinitionId) {
        this.credentialDefinitionId = credentialDefinitionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StakeholderStatusDto that = (StakeholderStatusDto) o;
        return credentialDefinitionId.equals(that.credentialDefinitionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(credentialDefinitionId);
    }

    @Override
    public String toString() {
        return "StakeholderStatusDto{" +
                "authToken='" + authToken + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", state='" + state + '\'' +
                ", credentialDefinitionId='" + credentialDefinitionId + '\'' +
                ", stakeholderClaim=" + stakeholderClaim +
                '}';
    }
}
