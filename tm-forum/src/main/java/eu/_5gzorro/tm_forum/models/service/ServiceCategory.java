package eu._5gzorro.tm_forum.models.service;

import eu._5gzorro.tm_forum.models.ServiceCandidateRef;
import eu._5gzorro.tm_forum.models.TimePeriod;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The (service) category resource is used to group service candidates in logical containers. Categories can contain other categories.
 */






public class ServiceCategory {



  private String baseType = null;



  private String schemaLocation = null;


  private String type = null;





  private List<ServiceCategoryRef> category = null;


  private String description = null;


  private String href = null;


  private String id = null;


  private Boolean isRoot = null;



  private String lastUpdate = null;



  private String lifecycleStatus = null;


  private String name = null;



  private String parentId = null;





  private List<ServiceCandidateRef> serviceCandidate = null;





  private String uuid = null;




  private TimePeriod validFor = null;


  private String version = null;

  public ServiceCategory baseType(String baseType) {
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

  public ServiceCategory schemaLocation(String schemaLocation) {
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

  public ServiceCategory type(String type) {
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

  public ServiceCategory category(List<ServiceCategoryRef> category) {
    this.category = category;
    return this;
  }

  public ServiceCategory addCategoryItem(ServiceCategoryRef categoryItem) {
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

  public ServiceCategory description(String description) {
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

  public ServiceCategory href(String href) {
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

  public ServiceCategory id(String id) {
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

  public ServiceCategory isRoot(Boolean isRoot) {
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

  public ServiceCategory lastUpdate(String lastUpdate) {
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

  public ServiceCategory lifecycleStatus(String lifecycleStatus) {
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

  public ServiceCategory name(String name) {
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

  public ServiceCategory parentId(String parentId) {
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

  public ServiceCategory serviceCandidate(List<ServiceCandidateRef> serviceCandidate) {
    this.serviceCandidate = serviceCandidate;
    return this;
  }

  public ServiceCategory addServiceCandidateItem(ServiceCandidateRef serviceCandidateItem) {
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

  public ServiceCategory uuid(String uuid) {
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

  public ServiceCategory validFor(TimePeriod validFor) {
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

  public ServiceCategory version(String version) {
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
    ServiceCategory serviceCategory = (ServiceCategory) o;
    return Objects.equals(this.baseType, serviceCategory.baseType) &&
        Objects.equals(this.schemaLocation, serviceCategory.schemaLocation) &&
        Objects.equals(this.type, serviceCategory.type) &&
        Objects.equals(this.category, serviceCategory.category) &&
        Objects.equals(this.description, serviceCategory.description) &&
        Objects.equals(this.href, serviceCategory.href) &&
        Objects.equals(this.id, serviceCategory.id) &&
        Objects.equals(this.isRoot, serviceCategory.isRoot) &&
        Objects.equals(this.lastUpdate, serviceCategory.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, serviceCategory.lifecycleStatus) &&
        Objects.equals(this.name, serviceCategory.name) &&
        Objects.equals(this.parentId, serviceCategory.parentId) &&
        Objects.equals(this.serviceCandidate, serviceCategory.serviceCandidate) &&
        Objects.equals(this.uuid, serviceCategory.uuid) &&
        Objects.equals(this.validFor, serviceCategory.validFor) &&
        Objects.equals(this.version, serviceCategory.version);
  }


  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, category, description, href, id, isRoot, lastUpdate, lifecycleStatus, name, parentId, serviceCandidate, uuid, validFor, version);
  }


  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceCategory {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    isRoot: ").append(toIndentedString(isRoot)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
    sb.append("    serviceCandidate: ").append(toIndentedString(serviceCandidate)).append("\n");
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

