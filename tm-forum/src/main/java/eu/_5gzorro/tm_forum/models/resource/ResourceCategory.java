package eu._5gzorro.tm_forum.models.resource;

import eu._5gzorro.tm_forum.models.ResourceCandidateRef;
import eu._5gzorro.tm_forum.models.TimePeriod;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The (resource) category resource is used to group resource candidates in logical containers. Categories can contain other categories.
 */






public class ResourceCategory {



  private String baseType = null;



  private String schemaLocation = null;


  private String type = null;





  private List<ResourceCategoryRef> category = null;


  private String description = null;


  private String href = null;


  private String id = null;



  private Boolean isRoot = null;



  private String lastUpdate = null;



  private String lifecycleStatus = null;


  private String name = null;



  private String parentId = null;





  private List<ResourceCandidateRef> resourceCandidate = null;





  private String uuid = null;




  private TimePeriod validFor = null;


  private String version = null;

  public ResourceCategory baseType(String baseType) {
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

  public ResourceCategory schemaLocation(String schemaLocation) {
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

  public ResourceCategory type(String type) {
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

  public ResourceCategory category(List<ResourceCategoryRef> category) {
    this.category = category;
    return this;
  }

  public ResourceCategory addCategoryItem(ResourceCategoryRef categoryItem) {
    if (this.category == null) {
      this.category = new ArrayList<ResourceCategoryRef>();
    }
    this.category.add(categoryItem);
    return this;
  }

  /**
   * List of child categories in the tree for in this category
   *
  **/




  public List<ResourceCategoryRef> getCategory() {
    return category;
  }

  public void setCategory(List<ResourceCategoryRef> category) {
    this.category = category;
  }

  public ResourceCategory description(String description) {
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

  public ResourceCategory href(String href) {
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

  public ResourceCategory id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the category
   *
  **/



  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ResourceCategory isRoot(Boolean isRoot) {
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

  public ResourceCategory lastUpdate(String lastUpdate) {
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

  public ResourceCategory lifecycleStatus(String lifecycleStatus) {
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

  public ResourceCategory name(String name) {
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

  public ResourceCategory parentId(String parentId) {
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

  public ResourceCategory resourceCandidate(List<ResourceCandidateRef> resourceCandidate) {
    this.resourceCandidate = resourceCandidate;
    return this;
  }

  public ResourceCategory addResourceCandidateItem(ResourceCandidateRef resourceCandidateItem) {
    if (this.resourceCandidate == null) {
      this.resourceCandidate = new ArrayList<ResourceCandidateRef>();
    }
    this.resourceCandidate.add(resourceCandidateItem);
    return this;
  }

  /**
   * List of resource candidates associated with this category
   *
  **/




  public List<ResourceCandidateRef> getResourceCandidate() {
    return resourceCandidate;
  }

  public void setResourceCandidate(List<ResourceCandidateRef> resourceCandidate) {
    this.resourceCandidate = resourceCandidate;
  }

  public ResourceCategory uuid(String uuid) {
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

  public ResourceCategory validFor(TimePeriod validFor) {
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

  public ResourceCategory version(String version) {
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
    ResourceCategory resourceCategory = (ResourceCategory) o;
    return Objects.equals(this.baseType, resourceCategory.baseType) &&
        Objects.equals(this.schemaLocation, resourceCategory.schemaLocation) &&
        Objects.equals(this.type, resourceCategory.type) &&
        Objects.equals(this.category, resourceCategory.category) &&
        Objects.equals(this.description, resourceCategory.description) &&
        Objects.equals(this.href, resourceCategory.href) &&
        Objects.equals(this.id, resourceCategory.id) &&
        Objects.equals(this.isRoot, resourceCategory.isRoot) &&
        Objects.equals(this.lastUpdate, resourceCategory.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, resourceCategory.lifecycleStatus) &&
        Objects.equals(this.name, resourceCategory.name) &&
        Objects.equals(this.parentId, resourceCategory.parentId) &&
        Objects.equals(this.resourceCandidate, resourceCategory.resourceCandidate) &&
        Objects.equals(this.uuid, resourceCategory.uuid) &&
        Objects.equals(this.validFor, resourceCategory.validFor) &&
        Objects.equals(this.version, resourceCategory.version);
  }


  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, category, description, href, id, isRoot, lastUpdate, lifecycleStatus, name, parentId, resourceCandidate, uuid, validFor, version);
  }


  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceCategory {\n");
    
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
    sb.append("    resourceCandidate: ").append(toIndentedString(resourceCandidate)).append("\n");
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

