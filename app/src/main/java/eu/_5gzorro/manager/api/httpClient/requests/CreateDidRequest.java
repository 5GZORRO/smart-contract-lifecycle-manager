package eu._5gzorro.manager.api.httpClient.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import eu._5gzorro.manager.api.dto.identityPermisssions.ClaimDto;
import eu._5gzorro.manager.api.model.enumureration.CredentialRequestType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CreateDidRequest {
    @JsonProperty("token")
    private String authToken;
    private CredentialRequestType type;
    private List<ClaimDto> claims;

    @JsonProperty("handler_url")
    private String callbackUrl;

    public CreateDidRequest() {
        claims = new ArrayList<>();
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public CredentialRequestType getType() {
        return type;
    }

    public void setType(CredentialRequestType type) {
        this.type = type;
    }

    public List<ClaimDto> getClaims() {
        return claims;
    }

    public void setClaims(List<ClaimDto> claims) {
        this.claims = claims;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public CreateDidRequest authToken(String authToken) {
        this.authToken = authToken;
        return this;
    }

    public CreateDidRequest type(CredentialRequestType type) {
        this.type = type;
        return this;
    }

    public CreateDidRequest claims(List<ClaimDto> claims) {
        this.claims = claims;
        return this;
    }

    public CreateDidRequest callbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateDidRequest that = (CreateDidRequest) o;
        return authToken.equals(that.authToken) && type == that.type && claims.equals(that.claims) && callbackUrl.equals(that.callbackUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authToken, type, claims, callbackUrl);
    }

    @Override
    public String toString() {
        return "CreateDidRequest{" +
                "authToken='" + authToken + '\'' +
                ", type=" + type +
                ", claims=" + claims +
                ", callbackUrl='" + callbackUrl + '\'' +
                '}';
    }
}
