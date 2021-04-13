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
@Table(name="service_level_agreement")
@TypeDef(
        name = "jsonb",
        typeClass = JsonBinaryType.class
)
public class ServiceLevelAgreementWrapper {
    @Id
    private String id;

    @NaturalId
    @Column(name="handle", nullable = false, unique = true)
    private UUID handle;

    private EntityStatus status = EntityStatus.CREATING;
    private LocalDateTime created = LocalDateTime.now();
    private LocalDateTime updated;


    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String properties;

    public ServiceLevelAgreementWrapper() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UUID getHandle() {
        return handle;
    }

    public void setHandle(UUID handle) {
        this.handle = handle;
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
        return id.equals(that.id) && handle.equals(that.handle) && properties.equals(that.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, handle, properties);
    }

    @Override
    public String toString() {
        return "ServiceLevelAgreement{" +
                "id='" + id + '\'' +
                ", handle=" + handle +
                ", status=" + status +
                ", created=" + created +
                ", updated=" + updated +
                ", properties='" + properties + '\'' +
                '}';
    }
}
