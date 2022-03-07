package eu._5gzorro.tm_forum.models.agreement;

import org.threeten.bp.OffsetDateTime;

import java.util.Objects;

public class AgreementAuthorization {

    private String baseType;
    private String schemaLocation;
    private String type;

    private OffsetDateTime date;
    private String signaturePresentation;
    private String state;

    public AgreementAuthorization() {
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

    public OffsetDateTime getDate() {
        return date;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    public String getSignaturePresentation() {
        return signaturePresentation;
    }

    public void setSignaturePresentation(String signaturePresentation) {
        this.signaturePresentation = signaturePresentation;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public AgreementAuthorization baseType(String baseType) {
        this.baseType = baseType;
        return this;
    }

    public AgreementAuthorization schemaLocation(String schemaLocation) {
        this.schemaLocation = schemaLocation;
        return this;
    }

    public AgreementAuthorization type(String type) {
        this.type = type;
        return this;
    }

    public AgreementAuthorization date(OffsetDateTime date) {
        this.date = date;
        return this;
    }

    public AgreementAuthorization signaturePresentation(String signaturePresentation) {
        this.signaturePresentation = signaturePresentation;
        return this;
    }

    public AgreementAuthorization state(String state) {
        this.state = state;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgreementAuthorization that = (AgreementAuthorization) o;
        return baseType.equals(that.baseType) && schemaLocation.equals(that.schemaLocation) && type.equals(that.type) && date.equals(that.date) && signaturePresentation.equals(that.signaturePresentation) && state.equals(that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseType, schemaLocation, type, date, signaturePresentation, state);
    }

    @Override
    public String toString() {
        return "AgreementAuthorization{" +
                "baseType='" + baseType + '\'' +
                ", schemaLocation='" + schemaLocation + '\'' +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", signaturePresentation='" + signaturePresentation + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
