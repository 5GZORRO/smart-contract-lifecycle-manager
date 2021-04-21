package eu._5gzorro.tm_forum.models.agreement;

import eu._5gzorro.tm_forum.models.product.ProductOfferingRef;
import eu._5gzorro.tm_forum.models.product.ProductRef;

import java.util.List;
import java.util.Objects;

public class AgreementItem {

    private String baseType;
    private String schemaLocation;
    private String type;

    private List<ProductRef> product;
    private List<AgreementTermOrCondition> termOrCondition;
    private List<ProductOfferingRef> productOffering;

    public AgreementItem() {
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

    public List<ProductRef> getProduct() {
        return product;
    }

    public void setProduct(List<ProductRef> product) {
        this.product = product;
    }

    public List<AgreementTermOrCondition> getTermOrCondition() {
        return termOrCondition;
    }

    public void setTermOrCondition(List<AgreementTermOrCondition> termOrCondition) {
        this.termOrCondition = termOrCondition;
    }

    public List<ProductOfferingRef> getProductOffering() {
        return productOffering;
    }

    public void setProductOffering(List<ProductOfferingRef> productOffering) {
        this.productOffering = productOffering;
    }


    public AgreementItem baseType(String baseType) {
        this.baseType = baseType;
        return this;
    }

    public AgreementItem schemaLocation(String schemaLocation) {
        this.schemaLocation = schemaLocation;
        return this;
    }

    public AgreementItem type(String type) {
        this.type = type;
        return this;
    }

    public AgreementItem product(List<ProductRef> product) {
        this.product = product;
        return this;
    }

    public AgreementItem termOrCondition(List<AgreementTermOrCondition> termOrCondition) {
        this.termOrCondition = termOrCondition;
        return this;
    }

    public AgreementItem productOffering(List<ProductOfferingRef> productOffering) {
        this.productOffering = productOffering;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgreementItem that = (AgreementItem) o;
        return baseType.equals(that.baseType) && schemaLocation.equals(that.schemaLocation) && type.equals(that.type) && Objects.equals(product, that.product) && Objects.equals(termOrCondition, that.termOrCondition) && Objects.equals(productOffering, that.productOffering);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseType, schemaLocation, type);
    }

    @Override
    public String toString() {
        return "AgreementItem{" +
                "baseType='" + baseType + '\'' +
                ", schemaLocation='" + schemaLocation + '\'' +
                ", type='" + type + '\'' +
                ", product=" + product +
                ", termOrCondition=" + termOrCondition +
                ", productOffering=" + productOffering +
                '}';
    }
}
