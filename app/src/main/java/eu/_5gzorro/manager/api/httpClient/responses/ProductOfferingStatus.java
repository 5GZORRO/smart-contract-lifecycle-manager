package eu._5gzorro.manager.api.httpClient.responses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

public class ProductOfferingStatus {

    public enum ProductOfferingStatesEnum {

        DID_REQUESTED("Product Offering DID requested"),

        STORED_WITH_DID("Product Offering stored with DID"),

        CLASSIFIED("Product Offering classified"),

        CLASSIFICATION_FAILED("Product Offering classification failed"),

        PUBLISHED("Product Offering published"),

        PUBLISHING_FAILED("Product Offering publishing failed"),

        EXTERNAL("External Product Offering");

        private String value;

        ProductOfferingStatesEnum(String value) { this.value = value; }

        @Override
        @JsonValue
        public String toString() { return String.valueOf(value); }

        @JsonCreator
        public static ProductOfferingStatesEnum fromValue(String text) {
            for(ProductOfferingStatesEnum b : ProductOfferingStatesEnum.values()) {
                if(String.valueOf(b.value).equals(text))
                    return b;
            }

            return null;
        }

    }

    @JsonProperty("catalogId")
    private String catalogId;

    @JsonProperty("did")
    private String did;

    @JsonProperty("status")
    private ProductOfferingStatesEnum status;

    public ProductOfferingStatus catalogId(String catalogId) {
        this.catalogId = catalogId;
        return this;
    }

    public void setCatalogId(String catalogId) { this.catalogId = catalogId; }

    public String getCatalogId() { return catalogId; }

    public ProductOfferingStatus did(String did) {
        this.did = did;
        return this;
    }

    public void setDid(String did) { this.did = did; }

    public String getDid() { return did; }

    public ProductOfferingStatus status(ProductOfferingStatesEnum status) {
        this.status = status;
        return this;
    }

    public void setStatus(ProductOfferingStatesEnum status) { this.status = status; }

    public ProductOfferingStatesEnum getStatus() { return status; }

    @Override
    public boolean equals(java.lang.Object o) {

        if(this == o)
            return true;

        if(o == null || getClass() != o.getClass())
            return false;

        ProductOfferingStatus productOfferingStatus = (ProductOfferingStatus) o;
        return Objects.equals(this.catalogId, productOfferingStatus.catalogId) &&
                Objects.equals(this.did, productOfferingStatus.did) &&
                Objects.equals(this.status, productOfferingStatus.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catalogId, did, status);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProductOfferingStatus {\n");

        sb.append("    catalogId: ").append(toIndentedString(catalogId)).append("\n");
        sb.append("    did: ").append(toIndentedString(did)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("}");

        return sb.toString();
    }

    private String toIndentedString(java.lang.Object o) {

        if(o == null)
            return "null";

        return o.toString().replace("\n", "\n    ");
    }
}