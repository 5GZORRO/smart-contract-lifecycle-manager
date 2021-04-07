package eu._5gzorro.tm_forum.models.resource;

import eu._5gzorro.tm_forum.models.ResourceSpecificationRef;
import eu._5gzorro.tm_forum.models.TimePeriod;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ResourceCandidate is an entity that makes a resource specification available to a catalog. A ResourceCandidate and its associated resource specification may be published - made visible - in any number of resource catalogs, or in none.
 */






public class ResourceCandidate {



  private String baseType = null;



  private String schemaLocation = null;


  private String type = null;





  private List<ResourceCategoryRef> category = null;


  private String description = null;


  private String href = null;


  private String id = null;



  private String lastUpdate = null;



  private String lifecycleStatus = null;


  private String name = null;




  private ResourceSpecificationRef resourceSpecification = null;





  private String uuid = null;




  private TimePeriod validFor = null;


  private String version = null;

  public ResourceCandidate baseType(String baseType) {
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

  public ResourceCandidate schemaLocation(String schemaLocation) {
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

  public ResourceCandidate type(String type) {
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

  public ResourceCandidate category(List<ResourceCategoryRef> category) {
    this.category = category;
    return this;
  }

  public ResourceCandidate addCategoryItem(ResourceCategoryRef categoryItem) {
    if (this.category == null) {
      this.category = new ArrayList<ResourceCategoryRef>();
    }
    this.category.add(categoryItem);
    return this;
  }

  /**
   * The category specification implied by this candidate
   *
  **/




  public List<ResourceCategoryRef> getCategory() {
    return category;
  }

  public void setCategory(List<ResourceCategoryRef> category) {
    this.category = category;
  }

  public ResourceCandidate description(String description) {
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

  public ResourceCandidate href(String href) {
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

  public ResourceCandidate id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of this REST resource
   *
  **/



  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ResourceCandidate lastUpdate(String lastUpdate) {
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

  public ResourceCandidate lifecycleStatus(String lifecycleStatus) {
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

  public ResourceCandidate name(String name) {
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

  public ResourceCandidate resourceSpecification(ResourceSpecificationRef resourceSpecification) {
    this.resourceSpecification = resourceSpecification;
    return this;
  }

  /**
   * The resource specification implied by this candidate
   *
  **/




  public ResourceSpecificationRef getResourceSpecification() {
    return resourceSpecification;
  }

  public void setResourceSpecification(ResourceSpecificationRef resourceSpecification) {
    this.resourceSpecification = resourceSpecification;
  }

  public ResourceCandidate uuid(String uuid) {
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

  public ResourceCandidate validFor(TimePeriod validFor) {
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

  public ResourceCandidate version(String version) {
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
    ResourceCandidate resourceCandidate = (ResourceCandidate) o;
    return Objects.equals(this.baseType, resourceCandidate.baseType) &&
        Objects.equals(this.schemaLocation, resourceCandidate.schemaLocation) &&
        Objects.equals(this.type, resourceCandidate.type) &&
        Objects.equals(this.category, resourceCandidate.category) &&
        Objects.equals(this.description, resourceCandidate.description) &&
        Objects.equals(this.href, resourceCandidate.href) &&
        Objects.equals(this.id, resourceCandidate.id) &&
        Objects.equals(this.lastUpdate, resourceCandidate.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, resourceCandidate.lifecycleStatus) &&
        Objects.equals(this.name, resourceCandidate.name) &&
        Objects.equals(this.resourceSpecification, resourceCandidate.resourceSpecification) &&
        Objects.equals(this.uuid, resourceCandidate.uuid) &&
        Objects.equals(this.validFor, resourceCandidate.validFor) &&
        Objects.equals(this.version, resourceCandidate.version);
  }


  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, category, description, href, id, lastUpdate, lifecycleStatus, name, resourceSpecification, uuid, validFor, version);
  }


  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceCandidate {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    resourceSpecification: ").append(toIndentedString(resourceSpecification)).append("\n");
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

