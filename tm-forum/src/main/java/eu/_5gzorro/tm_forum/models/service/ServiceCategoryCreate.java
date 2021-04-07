package eu._5gzorro.tm_forum.models.service;

import eu._5gzorro.tm_forum.models.ServiceCandidateRef;
import eu._5gzorro.tm_forum.models.TimePeriod;
import org.threeten.bp.OffsetDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The (service) category resource is used to group service candidates in logical containers. Categories can contain other categories. Skipped properties: id,href
 */







public class ServiceCategoryCreate   {
 
  private String baseType = null;

 
  private String schemaLocation = null;

 
  private String type = null;

 
 
  private List<ServiceCategoryRef> category = null;

 
  private String description = null;

 
  private Boolean isRoot = null;

 
  private OffsetDateTime lastUpdate = null;

 
  private String lifecycleStatus = null;

 
  private String name = null;

 
  private String parentId = null;

 
 
  private List<ServiceCandidateRef> serviceCandidate = null;

 
  private TimePeriod validFor = null;

 
  private String version = null;

  public ServiceCategoryCreate baseType(String baseType) {
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

  public ServiceCategoryCreate schemaLocation(String schemaLocation) {
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

  public ServiceCategoryCreate type(String type) {
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

  public ServiceCategoryCreate category(List<ServiceCategoryRef> category) {
    this.category = category;
    return this;
  }

  public ServiceCategoryCreate addCategoryItem(ServiceCategoryRef categoryItem) {
    if (this.category == null) {
      this.category = new ArrayList<ServiceCategoryRef>();
    }
    this.category.add(categoryItem);
    return this;
  }

  /**
   * List of child categories in the tree for in this category
   *
  **/
 

 

  public List<ServiceCategoryRef> getCategory() {
    return category;
  }

  public void setCategory(List<ServiceCategoryRef> category) {
    this.category = category;
  }

  public ServiceCategoryCreate description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of the category
   *
  **/
 


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ServiceCategoryCreate isRoot(Boolean isRoot) {
    this.isRoot = isRoot;
    return this;
  }

  /**
   * If true, this Boolean indicates that the category is a root of categories
   *
  **/
 


  public Boolean isIsRoot() {
    return isRoot;
  }

  public void setIsRoot(Boolean isRoot) {
    this.isRoot = isRoot;
  }

  public ServiceCategoryCreate lastUpdate(OffsetDateTime lastUpdate) {
    this.lastUpdate = lastUpdate;
    return this;
  }

  /**
   * Date and time of the last update
   *
  **/
 

 

  public OffsetDateTime getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(OffsetDateTime lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public ServiceCategoryCreate lifecycleStatus(String lifecycleStatus) {
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

  public ServiceCategoryCreate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the category
   *
  **/
 


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ServiceCategoryCreate parentId(String parentId) {
    this.parentId = parentId;
    return this;
  }

  /**
   * Unique identifier of the parent category
   *
  **/
 


  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public ServiceCategoryCreate serviceCandidate(List<ServiceCandidateRef> serviceCandidate) {
    this.serviceCandidate = serviceCandidate;
    return this;
  }

  public ServiceCategoryCreate addServiceCandidateItem(ServiceCandidateRef serviceCandidateItem) {
    if (this.serviceCandidate == null) {
      this.serviceCandidate = new ArrayList<ServiceCandidateRef>();
    }
    this.serviceCandidate.add(serviceCandidateItem);
    return this;
  }

  /**
   * List of service candidates associated with this category
   *
  **/
 

 

  public List<ServiceCandidateRef> getServiceCandidate() {
    return serviceCandidate;
  }

  public void setServiceCandidate(List<ServiceCandidateRef> serviceCandidate) {
    this.serviceCandidate = serviceCandidate;
  }

  public ServiceCategoryCreate validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which the category is valid
   *
  **/
 

 

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public ServiceCategoryCreate version(String version) {
    this.version = version;
    return this;
  }

  /**
   * ServiceCategory version
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
    ServiceCategoryCreate serviceCategoryCreate = (ServiceCategoryCreate) o;
    return Objects.equals(this.baseType, serviceCategoryCreate.baseType) &&
        Objects.equals(this.schemaLocation, serviceCategoryCreate.schemaLocation) &&
        Objects.equals(this.type, serviceCategoryCreate.type) &&
        Objects.equals(this.category, serviceCategoryCreate.category) &&
        Objects.equals(this.description, serviceCategoryCreate.description) &&
        Objects.equals(this.isRoot, serviceCategoryCreate.isRoot) &&
        Objects.equals(this.lastUpdate, serviceCategoryCreate.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, serviceCategoryCreate.lifecycleStatus) &&
        Objects.equals(this.name, serviceCategoryCreate.name) &&
        Objects.equals(this.parentId, serviceCategoryCreate.parentId) &&
        Objects.equals(this.serviceCandidate, serviceCategoryCreate.serviceCandidate) &&
        Objects.equals(this.validFor, serviceCategoryCreate.validFor) &&
        Objects.equals(this.version, serviceCategoryCreate.version);
  }

 
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, category, description, isRoot, lastUpdate, lifecycleStatus, name, parentId, serviceCandidate, validFor, version);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceCategoryCreate {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isRoot: ").append(toIndentedString(isRoot)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
    sb.append("    serviceCandidate: ").append(toIndentedString(serviceCandidate)).append("\n");
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

