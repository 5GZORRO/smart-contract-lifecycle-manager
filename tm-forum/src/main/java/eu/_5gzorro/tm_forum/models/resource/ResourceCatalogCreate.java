package eu._5gzorro.tm_forum.models.resource;

import eu._5gzorro.tm_forum.models.RelatedParty;
import eu._5gzorro.tm_forum.models.TimePeriod;
import org.threeten.bp.OffsetDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The root entity for resource catalog management. A resource catalog is a group of resource specifications made available through resource candidates that an organization provides to the consumers (internal consumers like its employees or B2B customers or B2C customers). Skipped properties: id,href
 */







public class ResourceCatalogCreate   {

  private String baseType = null;


  private String schemaLocation = null;


  private String type = null;



  private List<ResourceCategoryRef> category = null;


  private String description = null;


  private OffsetDateTime lastUpdate = null;


  private String lifecycleStatus = null;


  private String name = null;



  private List<RelatedParty> relatedParty = null;


  private TimePeriod validFor = null;


  private String version = null;

  public ResourceCatalogCreate baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * Indicates<b> </b>the base (class) type of this REST resource
   *
  **/



  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public ResourceCatalogCreate schemaLocation(String schemaLocation) {
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

  public ResourceCatalogCreate type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Indicates the (class) type of catalog. For resource catalogs, this will be 'ResourceCatalog'.
   *
  **/



  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ResourceCatalogCreate category(List<ResourceCategoryRef> category) {
    this.category = category;
    return this;
  }

  public ResourceCatalogCreate addCategoryItem(ResourceCategoryRef categoryItem) {
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

  public ResourceCatalogCreate description(String description) {
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

  public ResourceCatalogCreate lastUpdate(OffsetDateTime lastUpdate) {
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

  public ResourceCatalogCreate lifecycleStatus(String lifecycleStatus) {
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

  public ResourceCatalogCreate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the catalog
   *
  **/



  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ResourceCatalogCreate relatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public ResourceCatalogCreate addRelatedPartyItem(RelatedParty relatedPartyItem) {
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

  public ResourceCatalogCreate validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which the catalog is valid
   *
  **/




  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public ResourceCatalogCreate version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Catalog version
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
    ResourceCatalogCreate resourceCatalogCreate = (ResourceCatalogCreate) o;
    return Objects.equals(this.baseType, resourceCatalogCreate.baseType) &&
        Objects.equals(this.schemaLocation, resourceCatalogCreate.schemaLocation) &&
        Objects.equals(this.type, resourceCatalogCreate.type) &&
        Objects.equals(this.category, resourceCatalogCreate.category) &&
        Objects.equals(this.description, resourceCatalogCreate.description) &&
        Objects.equals(this.lastUpdate, resourceCatalogCreate.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, resourceCatalogCreate.lifecycleStatus) &&
        Objects.equals(this.name, resourceCatalogCreate.name) &&
        Objects.equals(this.relatedParty, resourceCatalogCreate.relatedParty) &&
        Objects.equals(this.validFor, resourceCatalogCreate.validFor) &&
        Objects.equals(this.version, resourceCatalogCreate.version);
  }


  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, category, description, lastUpdate, lifecycleStatus, name, relatedParty, validFor, version);
  }


  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceCatalogCreate {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
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

