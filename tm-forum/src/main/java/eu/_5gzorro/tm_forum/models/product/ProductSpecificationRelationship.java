package eu._5gzorro.tm_forum.models.product;

import eu._5gzorro.tm_forum.models.TimePeriod;

import java.util.Objects;

/**
 * A migration, substitution, dependency or exclusivity relationship between/among product specifications.
 */






public class ProductSpecificationRelationship {

 
 
  private String baseType = null;

 
 
  private String schemaLocation = null;

 
  private String type = null;

 
  private String href = null;

 
  private String id = null;

 
 
  private String relationshipType = null;

 
 
 
 
  private String uuid = null;

 
 
 
  private TimePeriod validFor = null;

  public ProductSpecificationRelationship baseType(String baseType) {
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

  public ProductSpecificationRelationship schemaLocation(String schemaLocation) {
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

  public ProductSpecificationRelationship type(String type) {
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

  public ProductSpecificationRelationship href(String href) {
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

  public ProductSpecificationRelationship id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the productSpecification
   *
  **/
 


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ProductSpecificationRelationship relationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
    return this;
  }

  /**
   * Type of relationship such as migration, substitution, dependency, exclusivity
   *
  **/
 


  public String getRelationshipType() {
    return relationshipType;
  }

  public void setRelationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
  }

  public ProductSpecificationRelationship uuid(String uuid) {
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

  public ProductSpecificationRelationship validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which the productSpecificationRelationship is valid
   *
  **/
 

 

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }


 
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductSpecificationRelationship productSpecificationRelationship = (ProductSpecificationRelationship) o;
    return Objects.equals(this.baseType, productSpecificationRelationship.baseType) &&
        Objects.equals(this.schemaLocation, productSpecificationRelationship.schemaLocation) &&
        Objects.equals(this.type, productSpecificationRelationship.type) &&
        Objects.equals(this.href, productSpecificationRelationship.href) &&
        Objects.equals(this.id, productSpecificationRelationship.id) &&
        Objects.equals(this.relationshipType, productSpecificationRelationship.relationshipType) &&
        Objects.equals(this.uuid, productSpecificationRelationship.uuid) &&
        Objects.equals(this.validFor, productSpecificationRelationship.validFor);
  }

 
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, href, id, relationshipType, uuid, validFor);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductSpecificationRelationship {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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

