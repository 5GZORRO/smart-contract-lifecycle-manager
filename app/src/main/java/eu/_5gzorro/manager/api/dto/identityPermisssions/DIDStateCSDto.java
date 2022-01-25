package eu._5gzorro.manager.api.dto.identityPermisssions;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class DIDStateCSDto {

    @JsonProperty("credentialSubject")
    private CredentialSubjectDto credentialSubjectDto;

    public DIDStateCSDto() {}

    public CredentialSubjectDto getCredentialSubjectDto() { return credentialSubjectDto; }

    public void setCredentialSubjectDto(CredentialSubjectDto credentialSubjectDto) { this.credentialSubjectDto = credentialSubjectDto; }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;

        if(o == null || getClass() != o.getClass())
            return false;

        DIDStateCSDto didStateCSDto = (DIDStateCSDto) o;

        return Objects.equals(this.credentialSubjectDto, didStateCSDto.credentialSubjectDto);
    }

    @Override
    public int hashCode() { return Objects.hash(credentialSubjectDto); }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DIDStateCSDto {\n");
        sb.append("    credentialSubjectDto: ").append(toIndentedString(credentialSubjectDto)).append("\n");
        sb.append("}");

        return sb.toString();
    }

    private String toIndentedString(java.lang.Object o) {
        if(o == null)
            return "null";

        return o.toString().replace("\n", "\n    ");
    }
}
