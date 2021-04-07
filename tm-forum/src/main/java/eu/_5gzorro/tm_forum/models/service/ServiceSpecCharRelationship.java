package eu._5gzorro.tm_forum.models.service;

import eu._5gzorro.tm_forum.models.TimePeriod;

import java.util.Objects;

/**
 * An aggregation, migration, substitution, dependency or exclusivity relationship between/among serviceSpecCharacteristics.
 */






public class ServiceSpecCharRelationship {



  private String baseType = null;



  private String schemaLocation = null;


  private String type = null;


  private String id = null;


  private String name = null;



  private String relationshipType = null;


  private String role = null;





  private String uuid = null;




  private TimePeriod validFor = null;

  public ServiceSpecCharRelationship baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * Get baseType
   *
  **/



  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public ServiceSpecCharRelationship schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * Get schemaLocation
   *
  **/



  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public ServiceSpecCharRelationship type(String type) {
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

  public ServiceSpecCharRelationship id(String id) {
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

  public ServiceSpecCharRelationship name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   *
  **/



  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ServiceSpecCharRelationship relationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
    return this;
  }

  /**
   * Type of relationship such as aggregation, migration, substitution, dependency, exclusivity
   *
  **/



  public String getRelationshipType() {
    return relationshipType;
  }

  public void setRelationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
  }

  public ServiceSpecCharRelationship role(String role) {
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

  public ServiceSpecCharRelationship uuid(String uuid) {
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

  public ServiceSpecCharRelationship validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which the serviceSpecCharRelationship is valid
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
    ServiceSpecCharRelationship serviceSpecCharRelationship = (ServiceSpecCharRelationship) o;
    return Objects.equals(this.baseType, serviceSpecCharRelationship.baseType) &&
        Objects.equals(this.schemaLocation, serviceSpecCharRelationship.schemaLocation) &&
        Objects.equals(this.type, serviceSpecCharRelationship.type) &&
        Objects.equals(this.id, serviceSpecCharRelationship.id) &&
        Objects.equals(this.name, serviceSpecCharRelationship.name) &&
        Objects.equals(this.relationshipType, serviceSpecCharRelationship.relationshipType) &&
        Objects.equals(this.role, serviceSpecCharRelationship.role) &&
        Objects.equals(this.uuid, serviceSpecCharRelationship.uuid) &&
        Objects.equals(this.validFor, serviceSpecCharRelationship.validFor);
  }


  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, id, name, relationshipType, role, uuid, validFor);
  }


  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceSpecCharRelationship {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

