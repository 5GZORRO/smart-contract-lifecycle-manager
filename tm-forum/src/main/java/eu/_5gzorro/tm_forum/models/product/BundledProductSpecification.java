package eu._5gzorro.tm_forum.models.product;

import eu._5gzorro.tm_forum.models.LifecycleStatusEnumEnum;
import eu._5gzorro.tm_forum.models.TimePeriod;

import java.util.Objects;

/**
 * A type of ProductSpecification that belongs to a grouping of ProductSpecifications made available to the market. It inherits of all attributes of ProductSpecification.
 */






public class BundledProductSpecification {

 
 
  private String baseType = null;

 
 
  private String schemaLocation = null;

 
  private String type = null;

 
  private String description = null;

 
  private String href = null;

 
  private String id = null;

 
 
  private String lastUpdate = null;

 
 
  private String lifecycleStatus = null;

 
 
  private LifecycleStatusEnumEnum lifecycleStatusEnum = null;

 
  private String name = null;

 
 
 
 
  private String uuid = null;

 
 
 
  private TimePeriod validFor = null;

 
  private String version = null;

  public BundledProductSpecification baseType(String baseType) {
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

  public BundledProductSpecification schemaLocation(String schemaLocation) {
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

  public BundledProductSpecification type(String type) {
    this.type = type;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
   *
  **/
 


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public BundledProductSpecification description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of this catalog
   *
  **/
 


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BundledProductSpecification href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the product specification
   *
  **/
 


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public BundledProductSpecification id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the product specification
   *
  **/
 


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public BundledProductSpecification lastUpdate(String lastUpdate) {
    this.lastUpdate = lastUpdate;
    return this;
  }

  /**
   * Date and time of the last update
   *
  **/
 


  public String getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(String lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public BundledProductSpecification lifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
    return this;
  }

  /**
   * Used to indicate the current lifecycle status
   *
  **/
 


  public String getLifecycleStatus() {
    return lifecycleStatus;
  }

  public void setLifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
  }

  public BundledProductSpecification lifecycleStatusEnum(LifecycleStatusEnumEnum lifecycleStatusEnum) {
    this.lifecycleStatusEnum = lifecycleStatusEnum;
    return this;
  }

  /**
   * Get lifecycleStatusEnum
   *
  **/
 


  public LifecycleStatusEnumEnum getLifecycleStatusEnum() {
    return lifecycleStatusEnum;
  }

  public void setLifecycleStatusEnum(LifecycleStatusEnumEnum lifecycleStatusEnum) {
    this.lifecycleStatusEnum = lifecycleStatusEnum;
  }

  public BundledProductSpecification name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the product specification
   *
  **/
 


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BundledProductSpecification uuid(String uuid) {
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

  public BundledProductSpecification validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which the entity is valid
   *
  **/
 

 

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public BundledProductSpecification version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Entity version
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
    BundledProductSpecification bundledProductSpecification = (BundledProductSpecification) o;
    return Objects.equals(this.baseType, bundledProductSpecification.baseType) &&
        Objects.equals(this.schemaLocation, bundledProductSpecification.schemaLocation) &&
        Objects.equals(this.type, bundledProductSpecification.type) &&
        Objects.equals(this.description, bundledProductSpecification.description) &&
        Objects.equals(this.href, bundledProductSpecification.href) &&
        Objects.equals(this.id, bundledProductSpecification.id) &&
        Objects.equals(this.lastUpdate, bundledProductSpecification.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, bundledProductSpecification.lifecycleStatus) &&
        Objects.equals(this.lifecycleStatusEnum, bundledProductSpecification.lifecycleStatusEnum) &&
        Objects.equals(this.name, bundledProductSpecification.name) &&
        Objects.equals(this.uuid, bundledProductSpecification.uuid) &&
        Objects.equals(this.validFor, bundledProductSpecification.validFor) &&
        Objects.equals(this.version, bundledProductSpecification.version);
  }

 
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, description, href, id, lastUpdate, lifecycleStatus, lifecycleStatusEnum, name, uuid, validFor, version);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BundledProductSpecification {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    lifecycleStatusEnum: ").append(toIndentedString(lifecycleStatusEnum)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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

