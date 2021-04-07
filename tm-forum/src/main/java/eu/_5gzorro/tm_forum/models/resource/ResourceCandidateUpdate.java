package eu._5gzorro.tm_forum.models.resource;

import eu._5gzorro.tm_forum.models.ResourceSpecificationRef;
import eu._5gzorro.tm_forum.models.TimePeriod;
import org.threeten.bp.OffsetDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ResourceCandidate is an entity that makes a resource specification available to a catalog. A ResourceCandidate and its associated resource specification may be published - made visible - in any number of resource catalogs, or in none. Skipped properties: id,href,id,href
 */







public class ResourceCandidateUpdate   {
 
  private String baseType = null;

 
  private String schemaLocation = null;

 
  private String type = null;

 
 
  private List<ResourceCategoryRef> category = null;

 
  private String description = null;

 
  private OffsetDateTime lastUpdate = null;

 
  private String lifecycleStatus = null;

 
  private String name = null;

 
  private ResourceSpecificationRef resourceSpecification = null;

 
  private TimePeriod validFor = null;

 
  private String version = null;

  public ResourceCandidateUpdate baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * The (immediate) base class type of this REST resource
   *
  **/
 


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public ResourceCandidateUpdate schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * This field provides a link to the schema describing this REST resource
   *
  **/
 


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public ResourceCandidateUpdate type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Class type of this REST resource
   *
  **/
 


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ResourceCandidateUpdate category(List<ResourceCategoryRef> category) {
    this.category = category;
    return this;
  }

  public ResourceCandidateUpdate addCategoryItem(ResourceCategoryRef categoryItem) {
    if (this.category == null) {
      this.category = new ArrayList<ResourceCategoryRef>();
    }
    this.category.add(categoryItem);
    return this;
  }

  /**
   * Get category
   *
  **/
 

 

  public List<ResourceCategoryRef> getCategory() {
    return category;
  }

  public void setCategory(List<ResourceCategoryRef> category) {
    this.category = category;
  }

  public ResourceCandidateUpdate description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of this REST resource
   *
  **/
 


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ResourceCandidateUpdate lastUpdate(OffsetDateTime lastUpdate) {
    this.lastUpdate = lastUpdate;
    return this;
  }

  /**
   * Date and time of the last update of this REST resource
   *
  **/
 

 

  public OffsetDateTime getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(OffsetDateTime lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public ResourceCandidateUpdate lifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
    return this;
  }

  /**
   * Used to indicate the current lifecycle status of the resource candidate.
   *
  **/
 


  public String getLifecycleStatus() {
    return lifecycleStatus;
  }

  public void setLifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
  }

  public ResourceCandidateUpdate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name given to this REST resource
   *
  **/
 


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ResourceCandidateUpdate resourceSpecification(ResourceSpecificationRef resourceSpecification) {
    this.resourceSpecification = resourceSpecification;
    return this;
  }

  /**
   * Get resourceSpecification
   *
  **/
 

 

  public ResourceSpecificationRef getResourceSpecification() {
    return resourceSpecification;
  }

  public void setResourceSpecification(ResourceSpecificationRef resourceSpecification) {
    this.resourceSpecification = resourceSpecification;
  }

  public ResourceCandidateUpdate validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which this REST resource is valid
   *
  **/
 

 

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public ResourceCandidateUpdate version(String version) {
    this.version = version;
    return this;
  }

  /**
   * the version of resource candidate
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
    ResourceCandidateUpdate resourceCandidateUpdate = (ResourceCandidateUpdate) o;
    return Objects.equals(this.baseType, resourceCandidateUpdate.baseType) &&
        Objects.equals(this.schemaLocation, resourceCandidateUpdate.schemaLocation) &&
        Objects.equals(this.type, resourceCandidateUpdate.type) &&
        Objects.equals(this.category, resourceCandidateUpdate.category) &&
        Objects.equals(this.description, resourceCandidateUpdate.description) &&
        Objects.equals(this.lastUpdate, resourceCandidateUpdate.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, resourceCandidateUpdate.lifecycleStatus) &&
        Objects.equals(this.name, resourceCandidateUpdate.name) &&
        Objects.equals(this.resourceSpecification, resourceCandidateUpdate.resourceSpecification) &&
        Objects.equals(this.validFor, resourceCandidateUpdate.validFor) &&
        Objects.equals(this.version, resourceCandidateUpdate.version);
  }

 
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, category, description, lastUpdate, lifecycleStatus, name, resourceSpecification, validFor, version);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceCandidateUpdate {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    resourceSpecification: ").append(toIndentedString(resourceSpecification)).append("\n");
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

