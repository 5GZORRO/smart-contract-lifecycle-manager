package eu._5gzorro.tm_forum.models;

import java.util.Objects;

/**
 * Attachment reference. An attachment complements the description of an element (for instance a product) through video, pictures
 */






public class AttachmentRef {



  private String baseType = null;



  private String referredType = null;



  private String schemaLocation = null;


  private String type = null;


  private String description = null;


  private String href = null;


  private String id = null;


  private String name = null;


  private String url = null;





  private String uuid = null;

  public AttachmentRef baseType(String baseType) {
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

  public AttachmentRef referredType(String referredType) {
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

  public AttachmentRef schemaLocation(String schemaLocation) {
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

  public AttachmentRef type(String type) {
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

  public AttachmentRef description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A narrative text describing the content of the attachment
   *
  **/



  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public AttachmentRef href(String href) {
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

  public AttachmentRef id(String id) {
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

  public AttachmentRef name(String name) {
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

  public AttachmentRef url(String url) {
    this.url = url;
    return this;
  }

  /**
   * Link to the attachment media/content
   *
  **/



  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public AttachmentRef uuid(String uuid) {
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
    AttachmentRef attachmentRef = (AttachmentRef) o;
    return Objects.equals(this.baseType, attachmentRef.baseType) &&
        Objects.equals(this.referredType, attachmentRef.referredType) &&
        Objects.equals(this.schemaLocation, attachmentRef.schemaLocation) &&
        Objects.equals(this.type, attachmentRef.type) &&
        Objects.equals(this.description, attachmentRef.description) &&
        Objects.equals(this.href, attachmentRef.href) &&
        Objects.equals(this.id, attachmentRef.id) &&
        Objects.equals(this.name, attachmentRef.name) &&
        Objects.equals(this.url, attachmentRef.url) &&
        Objects.equals(this.uuid, attachmentRef.uuid);
  }


  public int hashCode() {
    return Objects.hash(baseType, referredType, schemaLocation, type, description, href, id, name, url, uuid);
  }


  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttachmentRef {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    referredType: ").append(toIndentedString(referredType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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

