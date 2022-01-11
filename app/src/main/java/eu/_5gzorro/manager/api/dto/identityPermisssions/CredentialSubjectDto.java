package eu._5gzorro.manager.api.dto.identityPermisssions;

import java.util.Objects;


public class CredentialSubjectDto {
    private String id;

    public CredentialSubjectDto() {
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
        CredentialSubjectDto that = (CredentialSubjectDto) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "CredentialSubjectDto{" +
                "id='" + id + '\'' +
                '}';
    }
}
