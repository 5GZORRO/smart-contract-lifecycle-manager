package eu._5gzorro.tm_forum.models.resource;

import eu._5gzorro.tm_forum.models.TimePeriod;

import java.util.Objects;

/**
 * A migration, substitution, dependency or exclusivity relationship between/among resource specifications.
 */






public class ResourceSpecRelationship {

 
 
  private String baseType = null;

 
  private String type = null;

 
  private String href = null;

 
  private String id = null;

 
  private String name = null;

 
 
  private String relationshipType = null;

 
  private String role = null;

 
 
 
 
  private String uuid = null;

 
 
 
  private TimePeriod validFor = null;

  public ResourceSpecRelationship baseType(String baseType) {
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

  public ResourceSpecRelationship type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Type of relationship such as migration, substitution, dependency, exclusivity
   *
  **/
 


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ResourceSpecRelationship href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the target ResourceSpecification
   *
  **/
 


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ResourceSpecRelationship id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of target ResourceSpecification
   *
  **/
 


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ResourceSpecRelationship name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name given to the target resource specification instance
   *
  **/
 


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ResourceSpecRelationship relationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
    return this;
  }

  /**
   * Get relationshipType
   *
  **/
 


  public String getRelationshipType() {
    return relationshipType;
  }

  public void setRelationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
  }

  public ResourceSpecRelationship role(String role) {
    this.role = role;
    return this;
  }

  /**
   * The association role for this resource specification
   *
  **/
 


  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public ResourceSpecRelationship uuid(String uuid) {
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

  public ResourceSpecRelationship validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which the ResourceSpecRelationship is valid
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
    ResourceSpecRelationship resourceSpecRelationship = (ResourceSpecRelationship) o;
    return Objects.equals(this.baseType, resourceSpecRelationship.baseType) &&
        Objects.equals(this.type, resourceSpecRelationship.type) &&
        Objects.equals(this.href, resourceSpecRelationship.href) &&
        Objects.equals(this.id, resourceSpecRelationship.id) &&
        Objects.equals(this.name, resourceSpecRelationship.name) &&
        Objects.equals(this.relationshipType, resourceSpecRelationship.relationshipType) &&
        Objects.equals(this.role, resourceSpecRelationship.role) &&
        Objects.equals(this.uuid, resourceSpecRelationship.uuid) &&
        Objects.equals(this.validFor, resourceSpecRelationship.validFor);
  }

 
  public int hashCode() {
    return Objects.hash(baseType, type, href, id, name, relationshipType, role, uuid, validFor);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceSpecRelationship {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
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

