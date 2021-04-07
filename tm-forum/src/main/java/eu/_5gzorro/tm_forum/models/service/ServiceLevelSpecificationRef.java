package eu._5gzorro.tm_forum.models.service;

import java.util.Objects;

/**
 * A Service Level Specification represents a pre-defined or negotiated set of Service Level  Objectives. In addition, certain consequences are associated with not meeting the Service Level  Objectives. Service Level Agreements are expressed in terms of Service Level Specifications.
 */






public class ServiceLevelSpecificationRef {



  private String baseType = null;



  private String referredType = null;



  private String schemaLocation = null;


  private String type = null;


  private String href = null;


  private String id = null;


  private String name = null;





  private String uuid = null;

  public ServiceLevelSpecificationRef baseType(String baseType) {
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

  public ServiceLevelSpecificationRef referredType(String referredType) {
    this.referredType = referredType;
    return this;
  }

  /**
   * The actual type of the target instance when needed for disambiguation.
   *
  **/



  public String getReferredType() {
    return referredType;
  }

  public void setReferredType(String referredType) {
    this.referredType = referredType;
  }

  public ServiceLevelSpecificationRef schemaLocation(String schemaLocation) {
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

  public ServiceLevelSpecificationRef type(String type) {
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

  public ServiceLevelSpecificationRef href(String href) {
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

  public ServiceLevelSpecificationRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   *
  **/



  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ServiceLevelSpecificationRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the entity
   *
  **/



  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ServiceLevelSpecificationRef uuid(String uuid) {
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
    ServiceLevelSpecificationRef serviceLevelSpecificationRef = (ServiceLevelSpecificationRef) o;
    return Objects.equals(this.baseType, serviceLevelSpecificationRef.baseType) &&
        Objects.equals(this.referredType, serviceLevelSpecificationRef.referredType) &&
        Objects.equals(this.schemaLocation, serviceLevelSpecificationRef.schemaLocation) &&
        Objects.equals(this.type, serviceLevelSpecificationRef.type) &&
        Objects.equals(this.href, serviceLevelSpecificationRef.href) &&
        Objects.equals(this.id, serviceLevelSpecificationRef.id) &&
        Objects.equals(this.name, serviceLevelSpecificationRef.name) &&
        Objects.equals(this.uuid, serviceLevelSpecificationRef.uuid);
  }


  public int hashCode() {
    return Objects.hash(baseType, referredType, schemaLocation, type, href, id, name, uuid);
  }


  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceLevelSpecificationRef {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    referredType: ").append(toIndentedString(referredType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

