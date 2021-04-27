package eu._5gzorro.tm_forum.models.agreement;

import java.util.Objects;

public class Characteristic {

    private String baseType;
    private String schemaLocation;
    private String type;

    private String name;
    private String value;
    private String valueType;

    public Characteristic() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }


    public Characteristic baseType(String baseType) {
        this.baseType = baseType;
        return this;
    }

    public Characteristic schemaLocation(String schemaLocation) {
        this.schemaLocation = schemaLocation;
        return this;
    }

    public Characteristic type(String type) {
        this.type = type;
        return this;
    }

    public Characteristic name(String name) {
        this.name = name;
        return this;
    }

    public Characteristic value(String value) {
        this.value = value;
        return this;
    }

    public Characteristic valueType(String valueType) {
        this.valueType = valueType;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Characteristic that = (Characteristic) o;
        return baseType.equals(that.baseType) && schemaLocation.equals(that.schemaLocation) && type.equals(that.type) && name.equals(that.name) && value.equals(that.value) && valueType.equals(that.valueType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseType, schemaLocation, type, name, value, valueType);
    }

    @Override
    public String toString() {
        return "Characteristic{" +
                "baseType='" + baseType + '\'' +
                ", schemaLocation='" + schemaLocation + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", valueType='" + valueType + '\'' +
                '}';
    }
}
