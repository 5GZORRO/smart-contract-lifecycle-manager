package eu._5gzorro.tm_forum.models.product;

import java.util.Objects;

/**
 * A tax item is created for each tax rate and tax type used in the bill.
 */






public class TaxItem {

 
 
  private String baseType = null;

 
 
  private String schemaLocation = null;

 
  private String type = null;

 
  private String href = null;

 
 
 
  private Money taxAmount = null;

 
 
  private String taxCategory = null;

 
 
  private Float taxRate = null;

 
 
 
 
  private String uuid = null;

  public TaxItem baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   *
  **/
 


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public TaxItem schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   *
  **/
 


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public TaxItem type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   *
  **/
 


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public TaxItem href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Unique reference of the entity
   *
  **/
 


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public TaxItem taxAmount(Money taxAmount) {
    this.taxAmount = taxAmount;
    return this;
  }

  /**
   * Amount of tax expressed in the given currency
   *
  **/
 

 

  public Money getTaxAmount() {
    return taxAmount;
  }

  public void setTaxAmount(Money taxAmount) {
    this.taxAmount = taxAmount;
  }

  public TaxItem taxCategory(String taxCategory) {
    this.taxCategory = taxCategory;
    return this;
  }

  /**
   * Tax category
   *
  **/
 


  public String getTaxCategory() {
    return taxCategory;
  }

  public void setTaxCategory(String taxCategory) {
    this.taxCategory = taxCategory;
  }

  public TaxItem taxRate(Float taxRate) {
    this.taxRate = taxRate;
    return this;
  }

  /**
   * Applied rate of the tax
   *
  **/
 


  public Float getTaxRate() {
    return taxRate;
  }

  public void setTaxRate(Float taxRate) {
    this.taxRate = taxRate;
  }

  public TaxItem uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

  /**
   * Get uuid
   *
  **/
 


  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }


 
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaxItem taxItem = (TaxItem) o;
    return Objects.equals(this.baseType, taxItem.baseType) &&
        Objects.equals(this.schemaLocation, taxItem.schemaLocation) &&
        Objects.equals(this.type, taxItem.type) &&
        Objects.equals(this.href, taxItem.href) &&
        Objects.equals(this.taxAmount, taxItem.taxAmount) &&
        Objects.equals(this.taxCategory, taxItem.taxCategory) &&
        Objects.equals(this.taxRate, taxItem.taxRate) &&
        Objects.equals(this.uuid, taxItem.uuid);
  }

 
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, href, taxAmount, taxCategory, taxRate, uuid);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaxItem {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    taxAmount: ").append(toIndentedString(taxAmount)).append("\n");
    sb.append("    taxCategory: ").append(toIndentedString(taxCategory)).append("\n");
    sb.append("    taxRate: ").append(toIndentedString(taxRate)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

