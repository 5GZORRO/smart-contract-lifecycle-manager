package eu._5gzorro.tm_forum.models;

import java.util.Objects;

/**
 * Place reference. PlaceRef defines the placeRefs where the products are sold or delivered.
 */






public class PlaceRef {

 
 
  private String baseType = null;

 
 
  private String referredType = null;

 
 
  private String schemaLocation = null;

 
  private String type = null;

 
  private String href = null;

 
  private String id = null;

 
  private String name = null;

 
  private String role = null;

 
 
 
 
  private String uuid = null;

  public PlaceRef baseType(String baseType) {
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

  public PlaceRef referredType(String referredType) {
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

  public PlaceRef schemaLocation(String schemaLocation) {
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

  public PlaceRef type(String type) {
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

  public PlaceRef href(String href) {
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

  public PlaceRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of a related entity.
   *
  **/
 
 


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PlaceRef name(String name) {
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

  public PlaceRef role(String role) {
    this.role = role;
    return this;
  }

  /**
   * Role of the place (for instance: 'home delivery', 'shop retrieval')
   *
   **/
 


  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public PlaceRef uuid(String uuid) {
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
    PlaceRef placeRef = (PlaceRef) o;
    return Objects.equals(this.baseType, placeRef.baseType) &&
        Objects.equals(this.referredType, placeRef.referredType) &&
        Objects.equals(this.schemaLocation, placeRef.schemaLocation) &&
        Objects.equals(this.type, placeRef.type) &&
        Objects.equals(this.href, placeRef.href) &&
        Objects.equals(this.id, placeRef.id) &&
        Objects.equals(this.name, placeRef.name) &&
        Objects.equals(this.role, placeRef.role) &&
        Objects.equals(this.uuid, placeRef.uuid);
  }

 
  public int hashCode() {
    return Objects.hash(baseType, referredType, schemaLocation, type, href, id, name, role, uuid);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlaceRef {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    referredType: ").append(toIndentedString(referredType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

