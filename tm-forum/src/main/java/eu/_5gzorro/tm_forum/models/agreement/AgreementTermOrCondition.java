package eu._5gzorro.tm_forum.models.agreement;

import eu._5gzorro.tm_forum.models.TimePeriod;

import java.util.Objects;

public class AgreementTermOrCondition {

    private String baseType;
    private String schemaLocation;
    private String type;

    private String id;
    private String description;
    private TimePeriod validFor;

    public AgreementTermOrCondition() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TimePeriod getValidFor() {
        return validFor;
    }

    public void setValidFor(TimePeriod validFor) {
        this.validFor = validFor;
    }


    public AgreementTermOrCondition baseType(String baseType) {
        this.baseType = baseType;
        return this;
    }

    public AgreementTermOrCondition schemaLocation(String schemaLocation) {
        this.schemaLocation = schemaLocation;
        return this;
    }

    public AgreementTermOrCondition type(String type) {
        this.type = type;
        return this;
    }

    public AgreementTermOrCondition id(String id) {
        this.id = id;
        return this;
    }

    public AgreementTermOrCondition description(String description) {
        this.description = description;
        return this;
    }

    public AgreementTermOrCondition validFor(TimePeriod validFor) {
        this.validFor = validFor;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgreementTermOrCondition that = (AgreementTermOrCondition) o;
        return baseType.equals(that.baseType) && schemaLocation.equals(that.schemaLocation) && type.equals(that.type) && id.equals(that.id) && Objects.equals(description, that.description) && Objects.equals(validFor, that.validFor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseType, schemaLocation, type, id, description, validFor);
    }

    @Override
    public String toString() {
        return "AgreementTermOrCondition{" +
                "baseType='" + baseType + '\'' +
                ", schemaLocation='" + schemaLocation + '\'' +
                ", type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", validFor=" + validFor +
                '}';
    }
}
