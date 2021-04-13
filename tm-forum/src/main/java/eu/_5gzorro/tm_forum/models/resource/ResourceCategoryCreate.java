package eu._5gzorro.tm_forum.models.resource;

import eu._5gzorro.tm_forum.models.RelatedParty;
import eu._5gzorro.tm_forum.models.ResourceCandidateRef;
import eu._5gzorro.tm_forum.models.TimePeriod;
import org.threeten.bp.OffsetDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The (resource) category resource is used to group resource candidates in logical containers. Categories can contain other categories. Skipped properties: id,href
 */







public class ResourceCategoryCreate   {

  private String baseType = null;


  private String schemalLocation = null;


  private String type = null;



  private List<ResourceCategoryRef> category = null;


  private String description = null;


  private Boolean isRoot = null;


  private OffsetDateTime lastUpdate = null;


  private String lifecycleStatus = null;


  private String name = null;


  private String parentId = null;



  private List<RelatedParty> relatedParty = null;



  private List<ResourceCandidateRef> resourceCandidate = null;


  private TimePeriod validFor = null;


  private String version = null;

  public ResourceCategoryCreate baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * Immediate base class type of this category
   *
  **/



  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public ResourceCategoryCreate schemalLocation(String schemalLocation) {
    this.schemalLocation = schemalLocation;
    return this;
  }

  /**
   * This field provides a link to the schema describing this REST resource
   *
  **/



  public String getSchemalLocation() {
    return schemalLocation;
  }

  public void setSchemalLocation(String schemalLocation) {
    this.schemalLocation = schemalLocation;
  }

  public ResourceCategoryCreate type(String type) {
    this.type = type;
    return this;
  }

  /**
   * The (class) type of this category
   *
  **/



  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ResourceCategoryCreate category(List<ResourceCategoryRef> category) {
    this.category = category;
    return this;
  }

  public ResourceCategoryCreate addCategoryItem(ResourceCategoryRef categoryItem) {
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

  public ResourceCategoryCreate description(String description) {
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

  public ResourceCategoryCreate isRoot(Boolean isRoot) {
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

  public ResourceCategoryCreate lastUpdate(OffsetDateTime lastUpdate) {
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

  public ResourceCategoryCreate lifecycleStatus(String lifecycleStatus) {
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

  public ResourceCategoryCreate name(String name) {
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

  public ResourceCategoryCreate parentId(String parentId) {
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

  public ResourceCategoryCreate relatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public ResourceCategoryCreate addRelatedPartyItem(RelatedParty relatedPartyItem) {
    if (this.relatedParty == null) {
      this.relatedParty = new ArrayList<RelatedParty>();
    }
    this.relatedParty.add(relatedPartyItem);
    return this;
  }

  /**
   * Get relatedParty
   *
  **/




  public List<RelatedParty> getRelatedParty() {
    return relatedParty;
  }

  public void setRelatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
  }

  public ResourceCategoryCreate resourceCandidate(List<ResourceCandidateRef> resourceCandidate) {
    this.resourceCandidate = resourceCandidate;
    return this;
  }

  public ResourceCategoryCreate addResourceCandidateItem(ResourceCandidateRef resourceCandidateItem) {
    if (this.resourceCandidate == null) {
      this.resourceCandidate = new ArrayList<ResourceCandidateRef>();
    }
    this.resourceCandidate.add(resourceCandidateItem);
    return this;
  }

  /**
   * Get resourceCandidate
   *
  **/




  public List<ResourceCandidateRef> getResourceCandidate() {
    return resourceCandidate;
  }

  public void setResourceCandidate(List<ResourceCandidateRef> resourceCandidate) {
    this.resourceCandidate = resourceCandidate;
  }

  public ResourceCategoryCreate validFor(TimePeriod validFor) {
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

  public ResourceCategoryCreate version(String version) {
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
    ResourceCategoryCreate resourceCategoryCreate = (ResourceCategoryCreate) o;
    return Objects.equals(this.baseType, resourceCategoryCreate.baseType) &&
        Objects.equals(this.schemalLocation, resourceCategoryCreate.schemalLocation) &&
        Objects.equals(this.type, resourceCategoryCreate.type) &&
        Objects.equals(this.category, resourceCategoryCreate.category) &&
        Objects.equals(this.description, resourceCategoryCreate.description) &&
        Objects.equals(this.isRoot, resourceCategoryCreate.isRoot) &&
        Objects.equals(this.lastUpdate, resourceCategoryCreate.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, resourceCategoryCreate.lifecycleStatus) &&
        Objects.equals(this.name, resourceCategoryCreate.name) &&
        Objects.equals(this.parentId, resourceCategoryCreate.parentId) &&
        Objects.equals(this.relatedParty, resourceCategoryCreate.relatedParty) &&
        Objects.equals(this.resourceCandidate, resourceCategoryCreate.resourceCandidate) &&
        Objects.equals(this.validFor, resourceCategoryCreate.validFor) &&
        Objects.equals(this.version, resourceCategoryCreate.version);
  }


  public int hashCode() {
    return Objects.hash(baseType, schemalLocation, type, category, description, isRoot, lastUpdate, lifecycleStatus, name, parentId, relatedParty, resourceCandidate, validFor, version);
  }


  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceCategoryCreate {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemalLocation: ").append(toIndentedString(schemalLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isRoot: ").append(toIndentedString(isRoot)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    resourceCandidate: ").append(toIndentedString(resourceCandidate)).append("\n");
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
