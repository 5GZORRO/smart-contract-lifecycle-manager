package eu._5gzorro.tm_forum.models.product;

import eu._5gzorro.tm_forum.models.LifecycleStatusEnumEnum;
import eu._5gzorro.tm_forum.models.TimePeriod;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The category resource is used to group product offerings, service and resource candidates in logical containers. Categories can contain other categories and/or product offerings, resource or service candidates.
 */






public class Category {

 
 
  private String baseType = null;

 
 
  private String schemaLocation = null;

 
  private String type = null;

 
  private String description = null;

 
  private String href = null;

 
  private String id = null;

 
 
  private Boolean isRoot = null;

 
 
  private String lastUpdate = null;

 
 
  private String lifecycleStatus = null;

 
 
  private LifecycleStatusEnumEnum lifecycleStatusEnum = null;

 
  private String name = null;

 
 
  private String parentId = null;

 
 
 
 
  private List<ProductOfferingRef> productOffering = null;

 
 
 
 
  private List<CategoryRef> subCategory = null;

 
 
 
 
  private String uuid = null;

 
 
 
  private TimePeriod validFor = null;

 
  private String version = null;

  public Category baseType(String baseType) {
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

  public Category schemaLocation(String schemaLocation) {
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

  public Category type(String type) {
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

  public Category description(String description) {
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

  public Category href(String href) {
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

  public Category id(String id) {
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

  public Category isRoot(Boolean isRoot) {
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

  public Category lastUpdate(String lastUpdate) {
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

  public Category lifecycleStatus(String lifecycleStatus) {
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

  public Category lifecycleStatusEnum(LifecycleStatusEnumEnum lifecycleStatusEnum) {
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

  public Category name(String name) {
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

  public Category parentId(String parentId) {
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

  public Category productOffering(List<ProductOfferingRef> productOffering) {
    this.productOffering = productOffering;
    return this;
  }

  public Category addProductOfferingItem(ProductOfferingRef productOfferingItem) {
    if (this.productOffering == null) {
      this.productOffering = new ArrayList<ProductOfferingRef>();
    }
    this.productOffering.add(productOfferingItem);
    return this;
  }

  /**
   * A product offering represents entities that are orderable from the provider of the catalog, this resource includes pricing information.
   *
  **/
 

 

  public List<ProductOfferingRef> getProductOffering() {
    return productOffering;
  }

  public void setProductOffering(List<ProductOfferingRef> productOffering) {
    this.productOffering = productOffering;
  }

  public Category subCategory(List<CategoryRef> subCategory) {
    this.subCategory = subCategory;
    return this;
  }

  public Category addSubCategoryItem(CategoryRef subCategoryItem) {
    if (this.subCategory == null) {
      this.subCategory = new ArrayList<CategoryRef>();
    }
    this.subCategory.add(subCategoryItem);
    return this;
  }

  /**
   * List of child categories in the tree for in this category
   *
  **/
 

 

  public List<CategoryRef> getSubCategory() {
    return subCategory;
  }

  public void setSubCategory(List<CategoryRef> subCategory) {
    this.subCategory = subCategory;
  }

  public Category uuid(String uuid) {
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

  public Category validFor(TimePeriod validFor) {
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

  public Category version(String version) {
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
    Category category = (Category) o;
    return Objects.equals(this.baseType, category.baseType) &&
        Objects.equals(this.schemaLocation, category.schemaLocation) &&
        Objects.equals(this.type, category.type) &&
        Objects.equals(this.description, category.description) &&
        Objects.equals(this.href, category.href) &&
        Objects.equals(this.id, category.id) &&
        Objects.equals(this.isRoot, category.isRoot) &&
        Objects.equals(this.lastUpdate, category.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, category.lifecycleStatus) &&
        Objects.equals(this.lifecycleStatusEnum, category.lifecycleStatusEnum) &&
        Objects.equals(this.name, category.name) &&
        Objects.equals(this.parentId, category.parentId) &&
        Objects.equals(this.productOffering, category.productOffering) &&
        Objects.equals(this.subCategory, category.subCategory) &&
        Objects.equals(this.uuid, category.uuid) &&
        Objects.equals(this.validFor, category.validFor) &&
        Objects.equals(this.version, category.version);
  }

 
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, description, href, id, isRoot, lastUpdate, lifecycleStatus, lifecycleStatusEnum, name, parentId, productOffering, subCategory, uuid, validFor, version);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Category {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    isRoot: ").append(toIndentedString(isRoot)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    lifecycleStatusEnum: ").append(toIndentedString(lifecycleStatusEnum)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
    sb.append("    productOffering: ").append(toIndentedString(productOffering)).append("\n");
    sb.append("    subCategory: ").append(toIndentedString(subCategory)).append("\n");
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

