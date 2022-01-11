package eu._5gzorro.manager.api.dto.identityPermisssions;

import java.util.Objects;

public class ClaimDto {

    private String id;

    public ClaimDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClaimDto claimDto = (ClaimDto) o;
        return Objects.equals(id, claimDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ClaimDto{" +
                "id='" + id + '\'' +
                '}';
    }
}
