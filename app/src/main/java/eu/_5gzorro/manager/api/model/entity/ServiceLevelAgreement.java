package eu._5gzorro.manager.api.model.entity;

//import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="service_level_agreement")
@TypeDef(
        name = "jsonb",
        typeClass = JsonBinaryType.class
)
public class ServiceLevelAgreement {
    @Id
    private String id;

    @NaturalId
    @Column(name="handle", nullable = false, unique = true)
    private UUID handle;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String properties;
}
