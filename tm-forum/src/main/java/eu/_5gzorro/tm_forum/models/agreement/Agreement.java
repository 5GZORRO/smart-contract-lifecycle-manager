package eu._5gzorro.tm_forum.models.agreement;

import eu._5gzorro.tm_forum.models.RelatedParty;
import eu._5gzorro.tm_forum.models.TimePeriod;
import eu._5gzorro.tm_forum.models.product.AgreementRef;
import org.threeten.bp.OffsetDateTime;

import java.util.List;
import java.util.Objects;

public class Agreement {

    private String baseType;
    private String schemaLocation;
    private String type;

    private String id;
    private String href;
    private String name;
    private TimePeriod agreementPeriod;
    private String agreementType;
    private TimePeriod completionDate;
    private String description;
    private Integer documentNumber;
    private OffsetDateTime initialDate;
    private String statementOfIntent;
    private String status;
    private String version;
    private List<Characteristic> characteristic;
    private List<AgreementRef> associatedAgreement;
    private List<RelatedParty> engagedParty;
    private List<AgreementSpecificationRef> agreementSpecification;
    private List<AgreementAuthorization> agreementAuthorization;
    private List<AgreementItem> agreementItem;

    public Agreement() {
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

    public TimePeriod getAgreementPeriod() {
        return agreementPeriod;
    }

    public void setAgreementPeriod(TimePeriod agreementPeriod) {
        this.agreementPeriod = agreementPeriod;
    }

    public String getAgreementType() {
        return agreementType;
    }

    public void setAgreementType(String agreementType) {
        this.agreementType = agreementType;
    }

    public TimePeriod getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(TimePeriod completionDate) {
        this.completionDate = completionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(Integer documentNumber) {
        this.documentNumber = documentNumber;
    }

    public OffsetDateTime getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(OffsetDateTime initialDate) {
        this.initialDate = initialDate;
    }

    public String getStatementOfIntent() {
        return statementOfIntent;
    }

    public void setStatementOfIntent(String statementOfIntent) {
        this.statementOfIntent = statementOfIntent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<Characteristic> getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(List<Characteristic> characteristic) {
        this.characteristic = characteristic;
    }

    public List<AgreementRef> getAssociatedAgreement() {
        return associatedAgreement;
    }

    public void setAssociatedAgreement(List<AgreementRef> associatedAgreement) {
        this.associatedAgreement = associatedAgreement;
    }

    public List<RelatedParty> getEngagedParty() {
        return engagedParty;
    }

    public void setEngagedParty(List<RelatedParty> engagedParty) {
        this.engagedParty = engagedParty;
    }

    public List<AgreementSpecificationRef> getAgreementSpecification() {
        return agreementSpecification;
    }

    public void setAgreementSpecification(List<AgreementSpecificationRef> agreementSpecification) {
        this.agreementSpecification = agreementSpecification;
    }

    public List<AgreementAuthorization> getAgreementAuthorization() {
        return agreementAuthorization;
    }

    public void setAgreementAuthorization(List<AgreementAuthorization> agreementAuthorization) {
        this.agreementAuthorization = agreementAuthorization;
    }

    public List<AgreementItem> getAgreementItem() {
        return agreementItem;
    }

    public void setAgreementItem(List<AgreementItem> agreementItem) {
        this.agreementItem = agreementItem;
    }


    public Agreement baseType(String baseType) {
        this.baseType = baseType;
        return this;
    }

    public Agreement schemaLocation(String schemaLocation) {
        this.schemaLocation = schemaLocation;
        return this;
    }

    public Agreement type(String type) {
        this.type = type;
        return this;
    }

    public Agreement id(String id) {
        this.id = id;
        return this;
    }

    public Agreement href(String href) {
        this.href = href;
        return this;
    }

    public Agreement name(String name) {
        this.name = name;
        return this;
    }

    public Agreement agreementPeriod(TimePeriod agreementPeriod) {
        this.agreementPeriod = agreementPeriod;
        return this;
    }

    public Agreement agreementType(String agreementType) {
        this.agreementType = agreementType;
        return this;
    }

    public Agreement completionDate(TimePeriod completionDate) {
        this.completionDate = completionDate;
        return this;
    }

    public Agreement description(String description) {
        this.description = description;
        return this;
    }

    public Agreement documentNumber(Integer documentNumber) {
        this.documentNumber = documentNumber;
        return this;
    }

    public Agreement initialDate(OffsetDateTime initialDate) {
        this.initialDate = initialDate;
        return this;
    }

    public Agreement statementOfIntent(String statementOfIntent) {
        this.statementOfIntent = statementOfIntent;
        return this;
    }

    public Agreement status(String status) {
        this.status = status;
        return this;
    }

    public Agreement version(String version) {
        this.version = version;
        return this;
    }

    public Agreement characteristic(List<Characteristic> characteristic) {
        this.characteristic = characteristic;
        return this;
    }

    public Agreement associatedAgreement(List<AgreementRef> associatedAgreement) {
        this.associatedAgreement = associatedAgreement;
        return this;
    }

    public Agreement engagedParty(List<RelatedParty> engagedParty) {
        this.engagedParty = engagedParty;
        return this;
    }

    public Agreement agreementSpecification(List<AgreementSpecificationRef> agreementSpecification) {
        this.agreementSpecification = agreementSpecification;
        return this;
    }

    public Agreement agreementAuthorization(List<AgreementAuthorization> agreementAuthorization) {
        this.agreementAuthorization = agreementAuthorization;
        return this;
    }

    public Agreement agreementItem(List<AgreementItem> agreementItem) {
        this.agreementItem = agreementItem;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agreement agreement = (Agreement) o;
        return baseType.equals(agreement.baseType) && schemaLocation.equals(agreement.schemaLocation) && type.equals(agreement.type) && id.equals(agreement.id) && href.equals(agreement.href) && name.equals(agreement.name) && agreementPeriod.equals(agreement.agreementPeriod) && agreementType.equals(agreement.agreementType) && Objects.equals(completionDate, agreement.completionDate) && Objects.equals(description, agreement.description) && Objects.equals(documentNumber, agreement.documentNumber) && Objects.equals(initialDate, agreement.initialDate) && Objects.equals(statementOfIntent, agreement.statementOfIntent) && Objects.equals(status, agreement.status) && Objects.equals(version, agreement.version) && Objects.equals(characteristic, agreement.characteristic) && Objects.equals(associatedAgreement, agreement.associatedAgreement) && Objects.equals(engagedParty, agreement.engagedParty) && Objects.equals(agreementSpecification, agreement.agreementSpecification) && Objects.equals(agreementAuthorization, agreement.agreementAuthorization) && Objects.equals(agreementItem, agreement.agreementItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseType, schemaLocation, type, id, href, name);
    }

    @Override
    public String toString() {
        return "Agreement{" +
                "baseType='" + baseType + '\'' +
                ", schemaLocation='" + schemaLocation + '\'' +
                ", type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", href='" + href + '\'' +
                ", name='" + name + '\'' +
                ", agreementPeriod=" + agreementPeriod +
                ", agreementType='" + agreementType + '\'' +
                ", completionDate=" + completionDate +
                ", description='" + description + '\'' +
                ", documentNumber=" + documentNumber +
                ", initialDate=" + initialDate +
                ", statementOfIntent='" + statementOfIntent + '\'' +
                ", status='" + status + '\'' +
                ", version='" + version + '\'' +
                ", characteristic=" + characteristic +
                ", associatedAgreement=" + associatedAgreement +
                ", engagedParty=" + engagedParty +
                ", agreementSpecification=" + agreementSpecification +
                ", agreementAuthorization=" + agreementAuthorization +
                ", agreementItem=" + agreementItem +
                '}';
    }
}
