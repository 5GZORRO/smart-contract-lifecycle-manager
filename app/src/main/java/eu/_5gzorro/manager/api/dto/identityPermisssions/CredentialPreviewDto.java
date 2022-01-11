package eu._5gzorro.manager.api.dto.identityPermisssions;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class CredentialPreviewDto {
    private List<CredentialAttributeDto> attributes;

    public CredentialPreviewDto() {
    }

    public List<CredentialAttributeDto>  getAttributes() {
        return attributes;
    }

    public void setAttributes(List<CredentialAttributeDto>  attributes) {
        this.attributes = attributes;
    }

    public String getDid()  {
        try {
            Optional<CredentialAttributeDto> attr = attributes.stream().filter(a -> a.getName().equals("credentialSubject")).findFirst();

            if(!attr.isPresent())
                return null;

            String valToDeserialise = attr.get().getValue().replace("'", "\"");
            ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            CredentialSubjectDto subject = mapper.readValue(valToDeserialise, CredentialSubjectDto.class);
            return subject.getId();
        }
        catch(Exception e)
        {
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CredentialPreviewDto that = (CredentialPreviewDto) o;
        return Objects.equals(attributes, that.attributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attributes);
    }

    @Override
    public String toString() {
        return "CredentialPreviewDto{" +
                "attributes=" + attributes +
                '}';
    }
}
