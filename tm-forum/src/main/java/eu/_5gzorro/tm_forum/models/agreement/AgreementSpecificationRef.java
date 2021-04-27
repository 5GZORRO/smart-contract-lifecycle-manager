package eu._5gzorro.tm_forum.models.agreement;

import java.util.Objects;

public class AgreementSpecificationRef {

    private String baseType;
    private String schemaLocation;
    private String referredType;
    private String type;

    private String id;
    private String href;
    private String name;
    private String description;

    public AgreementSpecificationRef() {
    }

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }

    public String getSchemaLocation() {
        return schemaLocation;
    }

    public void setSchemaLocation(String schemaLocation) {
        this.schemaLocation = schemaLocation;
    }

    public String getReferredType() {
        return referredType;
    }

    public void setReferredType(String referredType) {
        this.referredType = referredType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public AgreementSpecificationRef baseType(String baseType) {
        this.baseType = baseType;
        return this;
    }

    public AgreementSpecificationRef schemaLocation(String schemaLocation) {
        this.schemaLocation = schemaLocation;
        return this;
    }

    public AgreementSpecificationRef referredType(String referredType) {
        this.referredType = referredType;
        return this;
    }

    public AgreementSpecificationRef type(String type) {
        this.type = type;
        return this;
    }

    public AgreementSpecificationRef id(String id) {
        this.id = id;
        return this;
    }

    public AgreementSpecificationRef href(String href) {
        this.href = href;
        return this;
    }

    public AgreementSpecificationRef name(String name) {
        this.name = name;
        return this;
    }

    public AgreementSpecificationRef description(String description) {
        this.description = description;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgreementSpecificationRef that = (AgreementSpecificationRef) o;
        return baseType.equals(that.baseType) && schemaLocation.equals(that.schemaLocation) && referredType.equals(that.referredType) && type.equals(that.type) && id.equals(that.id) && Objects.equals(href, that.href) && name.equals(that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseType, schemaLocation, referredType, type, id, href, name);
    }

    @Override
    public String toString() {
        return "AgreementSpecificationRef{" +
                "baseType='" + baseType + '\'' +
                ", schemaLocation='" + schemaLocation + '\'' +
                ", referredType='" + referredType + '\'' +
                ", type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", href='" + href + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
