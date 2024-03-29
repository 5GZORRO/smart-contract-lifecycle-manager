package eu._5gzorro.tm_forum.models.service;

import eu._5gzorro.tm_forum.models.RelatedParty;
import eu._5gzorro.tm_forum.models.TimePeriod;
import org.threeten.bp.OffsetDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The root entity for service catalog management. A service catalog is a group of service specifications made available through service candidates that an organization provides to the consumers (internal consumers like its employees or B2B customers or B2C customers).  A service catalog typically includes name, description and time period that is valid for. It will have a list of ServiceCandidate catalog items. A ServiceCandidate is an entity that makes a ServiceSpecification available to a catalog. A ServiceCandidate and its associated ServiceSpecification may be \&quot;published\&quot; - made visible -in any number of ServiceCatalogs, or in none. Skipped properties: id,href
 */







public class ServiceCatalogCreate   {
 
  private String baseType = null;

 
  private String schemaLocation = null;

 
  private String type = null;

 
 
  private List<ServiceCategoryRef> category = null;

 
  private String description = null;

 
  private OffsetDateTime lastUpdate = null;

 
  private String lifecycleStatus = null;

 
  private String name = null;

 
 
  private List<RelatedParty> relatedParty = null;

 
  private TimePeriod validFor = null;

 
  private String version = null;

  public ServiceCatalogCreate baseType(String baseType) {
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

  public ServiceCatalogCreate schemaLocation(String schemaLocation) {
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

  public ServiceCatalogCreate type(String type) {
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

  public ServiceCatalogCreate category(List<ServiceCategoryRef> category) {
    this.category = category;
    return this;
  }

  public ServiceCatalogCreate addCategoryItem(ServiceCategoryRef categoryItem) {
    if (this.category == null) {
      this.category = new ArrayList<ServiceCategoryRef>();
    }
    this.category.add(categoryItem);
    return this;
  }

  /**
   * List of service categories associated with this catalog
   *
  **/
 

 

  public List<ServiceCategoryRef> getCategory() {
    return category;
  }

  public void setCategory(List<ServiceCategoryRef> category) {
    this.category = category;
  }

  public ServiceCatalogCreate description(String description) {
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

  public ServiceCatalogCreate lastUpdate(OffsetDateTime lastUpdate) {
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

  public ServiceCatalogCreate lifecycleStatus(String lifecycleStatus) {
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

  public ServiceCatalogCreate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the service catalog
   *
  **/
 


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ServiceCatalogCreate relatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public ServiceCatalogCreate addRelatedPartyItem(RelatedParty relatedPartyItem) {
    if (this.relatedParty == null) {
      this.relatedParty = new ArrayList<RelatedParty>();
    }
    this.relatedParty.add(relatedPartyItem);
    return this;
  }

  /**
   * List of parties or party roles related to this category
   *
  **/
 

 

  public List<RelatedParty> getRelatedParty() {
    return relatedParty;
  }

  public void setRelatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
  }

  public ServiceCatalogCreate validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which the service catalog is valid
   *
  **/
 

 

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public ServiceCatalogCreate version(String version) {
    this.version = version;
    return this;
  }

  /**
   * ServiceCatalog version
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
    ServiceCatalogCreate serviceCatalogCreate = (ServiceCatalogCreate) o;
    return Objects.equals(this.baseType, serviceCatalogCreate.baseType) &&
        Objects.equals(this.schemaLocation, serviceCatalogCreate.schemaLocation) &&
        Objects.equals(this.type, serviceCatalogCreate.type) &&
        Objects.equals(this.category, serviceCatalogCreate.category) &&
        Objects.equals(this.description, serviceCatalogCreate.description) &&
        Objects.equals(this.lastUpdate, serviceCatalogCreate.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, serviceCatalogCreate.lifecycleStatus) &&
        Objects.equals(this.name, serviceCatalogCreate.name) &&
        Objects.equals(this.relatedParty, serviceCatalogCreate.relatedParty) &&
        Objects.equals(this.validFor, serviceCatalogCreate.validFor) &&
        Objects.equals(this.version, serviceCatalogCreate.version);
  }

 
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, category, description, lastUpdate, lifecycleStatus, name, relatedParty, validFor, version);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceCatalogCreate {\n");
    
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

