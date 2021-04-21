package eu._5gzorro.tm_forum.models.product;

import java.util.Objects;

public class ProductRef {

    private String baseType;
    private String schemaLocation;
    private String referredType;
    private String type;

    private String id;
    private String name;
    private String href;

    public ProductRef() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }


    public ProductRef baseType(String baseType) {
        this.baseType = baseType;
        return this;
    }

    public ProductRef schemaLocation(String schemaLocation) {
        this.schemaLocation = schemaLocation;
        return this;
    }

    public ProductRef referredType(String referredType) {
        this.referredType = referredType;
        return this;
    }

    public ProductRef type(String type) {
        this.type = type;
        return this;
    }

    public ProductRef id(String id) {
        this.id = id;
        return this;
    }

    public ProductRef name(String name) {
        this.name = name;
        return this;
    }

    public ProductRef href(String href) {
        this.href = href;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRef that = (ProductRef) o;
        return baseType.equals(that.baseType) && schemaLocation.equals(that.schemaLocation) && referredType.equals(that.referredType) && type.equals(that.type) && id.equals(that.id) && name.equals(that.name) && href.equals(that.href);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseType, schemaLocation, referredType, type, id, name, href);
    }

    @Override
    public String toString() {
        return "ProductRef{" +
                "baseType='" + baseType + '\'' +
                ", schemaLocation='" + schemaLocation + '\'' +
                ", referredType='" + referredType + '\'' +
                ", type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}
