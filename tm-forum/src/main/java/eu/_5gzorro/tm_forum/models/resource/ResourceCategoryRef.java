package eu._5gzorro.tm_forum.models.resource;

import java.util.Objects;

/**
 * Category reference. The category resource is used to group product offerings, service and resource candidates in logical containers. Categories can contain other categories and/or product offerings, resource or service candidates.
 */






public class ResourceCategoryRef {

 
 
  private String baseType = null;

 
 
  private String schemaLocation = null;

 
  private String type = null;

 
  private String href = null;

 
  private String id = null;

 
  private String name = null;

 
 
 
 
  private String uuid = null;

 
  private String version = null;

  public ResourceCategoryRef baseType(String baseType) {
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

  public ResourceCategoryRef schemaLocation(String schemaLocation) {
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

  public ResourceCategoryRef type(String type) {
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

  public ResourceCategoryRef href(String href) {
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

  public ResourceCategoryRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique reference of the category
   *
  **/
 


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ResourceCategoryRef name(String name) {
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

  public ResourceCategoryRef uuid(String uuid) {
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

  public ResourceCategoryRef version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Category version
   *
  **/
 


  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

 
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceCategoryRef resourceCategoryRef = (ResourceCategoryRef) o;
    return Objects.equals(this.baseType, resourceCategoryRef.baseType) &&
        Objects.equals(this.schemaLocation, resourceCategoryRef.schemaLocation) &&
        Objects.equals(this.type, resourceCategoryRef.type) &&
        Objects.equals(this.href, resourceCategoryRef.href) &&
        Objects.equals(this.id, resourceCategoryRef.id) &&
        Objects.equals(this.name, resourceCategoryRef.name) &&
        Objects.equals(this.uuid, resourceCategoryRef.uuid) &&
        Objects.equals(this.version, resourceCategoryRef.version);
  }

 
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, href, id, name, uuid, version);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceCategoryRef {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

