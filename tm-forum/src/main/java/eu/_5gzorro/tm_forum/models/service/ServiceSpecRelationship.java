package eu._5gzorro.tm_forum.models.service;

import eu._5gzorro.tm_forum.models.TimePeriod;

import java.util.Objects;

/**
 * A migration, substitution, dependency or exclusivity relationship between/among service specifications.
 */






public class ServiceSpecRelationship {

 
 
  private String baseType = null;

 
 
  private String schemaLocation = null;

 
  private String type = null;

 
  private String href = null;

 
  private String id = null;

 
  private String name = null;

 
 
  private String relationshipType = null;

 
  private String role = null;

 
 
 
 
  private String uuid = null;

 
 
 
  private TimePeriod validFor = null;

  public ServiceSpecRelationship baseType(String baseType) {
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

  public ServiceSpecRelationship schemaLocation(String schemaLocation) {
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

  public ServiceSpecRelationship type(String type) {
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

  public ServiceSpecRelationship href(String href) {
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

  public ServiceSpecRelationship id(String id) {
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

  public ServiceSpecRelationship name(String name) {
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

  public ServiceSpecRelationship relationshipType(String relationshipType) {
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

  public ServiceSpecRelationship role(String role) {
    this.role = role;
    return this;
  }

  /**
   * The association role for this service specification
   *
  **/
 


  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public ServiceSpecRelationship uuid(String uuid) {
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

  public ServiceSpecRelationship validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which the serviceSpecRelationship is valid
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
    ServiceSpecRelationship serviceSpecRelationship = (ServiceSpecRelationship) o;
    return Objects.equals(this.baseType, serviceSpecRelationship.baseType) &&
        Objects.equals(this.schemaLocation, serviceSpecRelationship.schemaLocation) &&
        Objects.equals(this.type, serviceSpecRelationship.type) &&
        Objects.equals(this.href, serviceSpecRelationship.href) &&
        Objects.equals(this.id, serviceSpecRelationship.id) &&
        Objects.equals(this.name, serviceSpecRelationship.name) &&
        Objects.equals(this.relationshipType, serviceSpecRelationship.relationshipType) &&
        Objects.equals(this.role, serviceSpecRelationship.role) &&
        Objects.equals(this.uuid, serviceSpecRelationship.uuid) &&
        Objects.equals(this.validFor, serviceSpecRelationship.validFor);
  }

 
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, href, id, name, relationshipType, role, uuid, validFor);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceSpecRelationship {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
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

