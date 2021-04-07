package eu._5gzorro.tm_forum.models.product;

import java.util.Objects;

/**
 * provides references to the corresponding market segment as target of product offerings. A market segment is grouping of Parties, GeographicAreas, SalesChannels, and so forth.
 */






public class MarketSegmentRef {

 
 
  private String baseType = null;

 
 
  private String referredType = null;

 
 
  private String schemaLocation = null;

 
  private String type = null;

 
  private String href = null;

 
  private String id = null;

 
  private String name = null;

 
 
 
 
  private String uuid = null;

  public MarketSegmentRef baseType(String baseType) {
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

  public MarketSegmentRef referredType(String referredType) {
    this.referredType = referredType;
    return this;
  }

  /**
   * (Class) type of the referred market segment
   *
  **/
 


  public String getReferredType() {
    return referredType;
  }

  public void setReferredType(String referredType) {
    this.referredType = referredType;
  }

  public MarketSegmentRef schemaLocation(String schemaLocation) {
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

  public MarketSegmentRef type(String type) {
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

  public MarketSegmentRef href(String href) {
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

  public MarketSegmentRef id(String id) {
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

  public MarketSegmentRef name(String name) {
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

  public MarketSegmentRef uuid(String uuid) {
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
    MarketSegmentRef marketSegmentRef = (MarketSegmentRef) o;
    return Objects.equals(this.baseType, marketSegmentRef.baseType) &&
        Objects.equals(this.referredType, marketSegmentRef.referredType) &&
        Objects.equals(this.schemaLocation, marketSegmentRef.schemaLocation) &&
        Objects.equals(this.type, marketSegmentRef.type) &&
        Objects.equals(this.href, marketSegmentRef.href) &&
        Objects.equals(this.id, marketSegmentRef.id) &&
        Objects.equals(this.name, marketSegmentRef.name) &&
        Objects.equals(this.uuid, marketSegmentRef.uuid);
  }

 
  public int hashCode() {
    return Objects.hash(baseType, referredType, schemaLocation, type, href, id, name, uuid);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MarketSegmentRef {\n");
    
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

