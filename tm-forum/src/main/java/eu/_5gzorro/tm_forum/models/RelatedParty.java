package eu._5gzorro.tm_forum.models;

import java.util.Objects;

/**
 * RelatedParty reference. A related party defines party or party role linked to a specific entity.
 */






public class RelatedParty {

 
 
  private String baseType = null;

 
 
  private String referredType = null;

 
 
  private String schemaLocation = null;

 
  private String type = null;

 
 
  private String extendedInfo = null;

 
  private String href = null;

 
  private String id = null;

 
  private String name = null;

 
  private String role = null;

 
 
 
 
  private String uuid = null;

  public RelatedParty baseType(String baseType) {
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

  public RelatedParty referredType(String referredType) {
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

  public RelatedParty schemaLocation(String schemaLocation) {
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

  public RelatedParty type(String type) {
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

  public RelatedParty extendedInfo(String extendedInfo) {
    this.extendedInfo = extendedInfo;
    return this;
  }

  /**
   * Get extendedInfo
   *
  **/
 


  public String getExtendedInfo() {
    return extendedInfo;
  }

  public void setExtendedInfo(String extendedInfo) {
    this.extendedInfo = extendedInfo;
  }

  public RelatedParty href(String href) {
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

  public RelatedParty id(String id) {
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

  public RelatedParty name(String name) {
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

  public RelatedParty role(String role) {
    this.role = role;
    return this;
  }

  /**
   * Role of the related party.
   *
  **/
 


  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public RelatedParty uuid(String uuid) {
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
    RelatedParty relatedParty = (RelatedParty) o;
    return Objects.equals(this.baseType, relatedParty.baseType) &&
        Objects.equals(this.referredType, relatedParty.referredType) &&
        Objects.equals(this.schemaLocation, relatedParty.schemaLocation) &&
        Objects.equals(this.type, relatedParty.type) &&
        Objects.equals(this.extendedInfo, relatedParty.extendedInfo) &&
        Objects.equals(this.href, relatedParty.href) &&
        Objects.equals(this.id, relatedParty.id) &&
        Objects.equals(this.name, relatedParty.name) &&
        Objects.equals(this.role, relatedParty.role) &&
        Objects.equals(this.uuid, relatedParty.uuid);
  }

 
  public int hashCode() {
    return Objects.hash(baseType, referredType, schemaLocation, type, extendedInfo, href, id, name, role, uuid);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RelatedParty {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    referredType: ").append(toIndentedString(referredType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    extendedInfo: ").append(toIndentedString(extendedInfo)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
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

