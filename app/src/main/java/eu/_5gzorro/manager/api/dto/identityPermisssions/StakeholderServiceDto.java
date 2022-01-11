package eu._5gzorro.manager.api.dto.identityPermisssions;

import java.util.Objects;

public class StakeholderServiceDto {
    private String type;  //TODO: ENUM when available
    private String endpoint;

    public StakeholderServiceDto() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StakeholderServiceDto that = (StakeholderServiceDto) o;
        return type.equals(that.type) && endpoint.equals(that.endpoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, endpoint);
    }

    @Override
    public String toString() {
        return "StakeholderServiceDto{" +
                "type='" + type + '\'' +
                ", endpoint='" + endpoint + '\'' +
                '}';
    }
}
