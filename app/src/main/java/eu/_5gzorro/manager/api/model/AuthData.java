package eu._5gzorro.manager.api.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Objects;

@Component
@RequestScope
public class AuthData {
    private String userId = "AuthenticatedUserId"; // TODO: Extract from auth header/token in auth filter and set
    private String authToken = "Token";

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
        AuthData authData = (AuthData) o;
        return userId.equals(authData.userId) && Objects.equals(authToken, authData.authToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, authToken);
    }

    @Override
    public String toString() {
        return "AuthData{" +
                "userId='" + userId + '\'' +
                ", authToken='" + authToken + '\'' +
                '}';
    }
}
