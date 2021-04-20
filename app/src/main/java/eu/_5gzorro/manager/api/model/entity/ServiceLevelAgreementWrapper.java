package eu._5gzorro.manager.api.model.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import eu._5gzorro.manager.api.model.enumureration.EntityStatus;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="service_level_agreement", indexes = {
        @Index(name = "ix_did", unique = true, columnList = "did")
})
@TypeDef(
        name = "jsonb",
        typeClass = JsonBinaryType.class
)
public class ServiceLevelAgreementWrapper {
    @Id
    private UUID id;

    @NaturalId(mutable=true) //mutable to allow null -> did
    @Column(name="did", unique = true)
    private String did;

    private EntityStatus status = EntityStatus.CREATING;
    private LocalDateTime created = LocalDateTime.now();
    private LocalDateTime updated;


    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String properties;

    public ServiceLevelAgreementWrapper() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public EntityStatus getStatus() {
        return status;
    }

    public void setStatus(EntityStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceLevelAgreementWrapper that = (ServiceLevelAgreementWrapper) o;
        return id.equals(that.id) && did.equals(that.did) && properties.equals(that.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, did, properties);
    }

    @Override
    public String toString() {
        return "ServiceLevelAgreement{" +
                "id='" + id + '\'' +
                ", did=" + did +
                ", status=" + status +
                ", created=" + created +
                ", updated=" + updated +
                ", properties='" + properties + '\'' +
                '}';
    }
}
