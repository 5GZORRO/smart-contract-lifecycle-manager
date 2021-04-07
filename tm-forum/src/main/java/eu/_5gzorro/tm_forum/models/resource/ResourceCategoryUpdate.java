package eu._5gzorro.tm_forum.models.resource;

import eu._5gzorro.tm_forum.models.RelatedParty;
import eu._5gzorro.tm_forum.models.ResourceCandidateRef;
import eu._5gzorro.tm_forum.models.TimePeriod;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The (resource) category resource is used to group resource candidates in logical containers. Categories can contain other categories. Skipped properties: id,href,id,href
 */







public class ResourceCategoryUpdate   {
 
  private String baseType = null;

 
  private String schemalLocation = null;

 
  private String type = null;

 
 
  private List<ResourceCategoryRef> category = null;

 
  private String description = null;

 
  private Boolean isRoot = null;

 
  private String lifecycleStatus = null;

 
  private String name = null;

 
  private String parentId = null;

 
 
  private List<RelatedParty> relatedParty = null;

 
 
  private List<ResourceCandidateRef> resourceCandidate = null;

 
  private TimePeriod validFor = null;

 
  private String version = null;

  public ResourceCategoryUpdate baseType(String baseType) {
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

  public ResourceCategoryUpdate schemalLocation(String schemalLocation) {
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

  public ResourceCategoryUpdate type(String type) {
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

  public ResourceCategoryUpdate category(List<ResourceCategoryRef> category) {
    this.category = category;
    return this;
  }

  public ResourceCategoryUpdate addCategoryItem(ResourceCategoryRef categoryItem) {
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

  public ResourceCategoryUpdate description(String description) {
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

  public ResourceCategoryUpdate isRoot(Boolean isRoot) {
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

  public ResourceCategoryUpdate lifecycleStatus(String lifecycleStatus) {
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

  public ResourceCategoryUpdate name(String name) {
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

  public ResourceCategoryUpdate parentId(String parentId) {
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

  public ResourceCategoryUpdate relatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public ResourceCategoryUpdate addRelatedPartyItem(RelatedParty relatedPartyItem) {
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

  public ResourceCategoryUpdate resourceCandidate(List<ResourceCandidateRef> resourceCandidate) {
    this.resourceCandidate = resourceCandidate;
    return this;
  }

  public ResourceCategoryUpdate addResourceCandidateItem(ResourceCandidateRef resourceCandidateItem) {
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

  public ResourceCategoryUpdate validFor(TimePeriod validFor) {
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

  public ResourceCategoryUpdate version(String version) {
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
    ResourceCategoryUpdate resourceCategoryUpdate = (ResourceCategoryUpdate) o;
    return Objects.equals(this.baseType, resourceCategoryUpdate.baseType) &&
        Objects.equals(this.schemalLocation, resourceCategoryUpdate.schemalLocation) &&
        Objects.equals(this.type, resourceCategoryUpdate.type) &&
        Objects.equals(this.category, resourceCategoryUpdate.category) &&
        Objects.equals(this.description, resourceCategoryUpdate.description) &&
        Objects.equals(this.isRoot, resourceCategoryUpdate.isRoot) &&
        Objects.equals(this.lifecycleStatus, resourceCategoryUpdate.lifecycleStatus) &&
        Objects.equals(this.name, resourceCategoryUpdate.name) &&
        Objects.equals(this.parentId, resourceCategoryUpdate.parentId) &&
        Objects.equals(this.relatedParty, resourceCategoryUpdate.relatedParty) &&
        Objects.equals(this.resourceCandidate, resourceCategoryUpdate.resourceCandidate) &&
        Objects.equals(this.validFor, resourceCategoryUpdate.validFor) &&
        Objects.equals(this.version, resourceCategoryUpdate.version);
  }

 
  public int hashCode() {
    return Objects.hash(baseType, schemalLocation, type, category, description, isRoot, lifecycleStatus, name, parentId, relatedParty, resourceCandidate, validFor, version);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceCategoryUpdate {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemalLocation: ").append(toIndentedString(schemalLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isRoot: ").append(toIndentedString(isRoot)).append("\n");
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

