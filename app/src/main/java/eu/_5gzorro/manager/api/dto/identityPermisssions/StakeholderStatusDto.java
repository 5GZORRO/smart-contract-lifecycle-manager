package eu._5gzorro.manager.api.dto.identityPermisssions;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class StakeholderStatusDto {

    @JsonProperty("id_token")
    private String authToken;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StakeholderStatusDto that = (StakeholderStatusDto) o;
        return stakeholderClaim.equals(that.stakeholderClaim) && authToken.equals(that.authToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stakeholderClaim, authToken);
    }

    @Override
    public String toString() {
        return "StakeholderStatusDto{" +
                "stakeholderClaim='" + stakeholderClaim + '\'' +
                ", authToken='" + authToken + '\'' +
                '}';
    }
}
