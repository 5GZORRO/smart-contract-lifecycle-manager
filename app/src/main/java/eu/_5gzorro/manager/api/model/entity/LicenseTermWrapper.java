package eu._5gzorro.manager.api.model.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import eu._5gzorro.manager.api.model.enumureration.EntityStatus;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "license_terms")
@TypeDef(
        name = "jsonb",
        typeClass = JsonBinaryType.class
)
public class LicenseTermWrapper {

    @Id
    private UUID id;

    @NaturalId(mutable = true)
    @Column(name = "did", unique = true)
    private String did;

    private EntityStatus status = EntityStatus.CREATING;
    private LocalDateTime created = LocalDateTime.now();
    private LocalDateTime updated;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String properties;

    public UUID getId() { return id; }

    public void setId(UUID id) { this.id = id; }

    public String getDid() { return did; }

    public void setDid(String did) { this.did = did; }

    public EntityStatus getStatus() { return status; }

    public void setStatus(EntityStatus status) { this.status = status; }

    public LocalDateTime getCreated() { return created; }

    public void setCreated(LocalDateTime created) { this.created = created; }

    public LocalDateTime getUpdated() { return updated; }

    public void setUpdated(LocalDateTime updated) { this.updated = updated; }

    public String getProperties() { return properties; }

    public void setProperties(String properties) { this.properties = properties; }

    @Override
    public boolean equals(java.lang.Object o) {
        if(this == o)
            return true;

        if(o == null || getClass() != o.getClass())
            return false;

        LicenseTermWrapper licenseTermWrapper = (LicenseTermWrapper) o;
        return Objects.equals(id, licenseTermWrapper.id) &&
                Objects.equals(did, licenseTermWrapper.did) &&
                Objects.equals(status, licenseTermWrapper.status) &&
                Objects.equals(created, licenseTermWrapper.created) &&
                Objects.equals(updated, licenseTermWrapper.updated) &&
                Objects.equals(properties, licenseTermWrapper.properties);
    }

    @Override
    public int hashCode() { return Objects.hash(id, did, status, created, updated, properties); }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("class LicenseTermWrapper {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    did: ").append(toIndentedString(did)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    created").append(toIndentedString(created)).append("\n");
        sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
        sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
        sb.append("}");

        return sb.toString();
    }

    private String toIndentedString(java.lang.Object o) {
        if(o == null)
            return "null";

        return o.toString().replace("\n", "\n    ");
    }
}
