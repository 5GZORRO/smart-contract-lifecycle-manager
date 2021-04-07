package eu._5gzorro.tm_forum.models.resource;

import eu._5gzorro.tm_forum.models.AttachmentRef;
import eu._5gzorro.tm_forum.models.RelatedParty;
import eu._5gzorro.tm_forum.models.TimePeriod;
import org.threeten.bp.OffsetDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Resources are physical or non-physical components (or some combination of these) within an enterprise&#39;s infrastructure or inventory. They are typically consumed or used by services (for example a physical port assigned to a service) or contribute to the realization of a Product (for example, a SIM card). They can be drawn from the Application, Computing and Network domains, and include, for example, Network Elements, software, IT systems, content and information, and technology components. A ResourceSpecification is an abstract base class for representing a generic means for implementing a particular type of Resource. In essence, a ResourceSpecification defines the common attributes and relationships of a set of related Resources, while Resource defines a specific instance that is based on a particular ResourceSpecification. Skipped properties: id,href
 */







public class ResourceSpecificationCreate   {
 
  private String baseType = null;

 
  private String schemaLocation = null;

 
  private String type = null;

 
 
  private List<AttachmentRef> attachment = null;

 
  private String category = null;

 
  private String description = null;

 
 
  private List<Feature> feature = null;

 
  private Boolean isBundle = null;

 
  private OffsetDateTime lastUpdate = null;

 
  private String lifecycleStatus = null;

 
  private String name = null;

 
 
  private List<RelatedParty> relatedParty = null;

 
 
  private List<ResourceSpecCharacteristic> resourceSpecCharacteristic = null;

 
 
  private List<ResourceSpecRelationship> resourceSpecRelationship = null;

 
  private TargetResourceSchemaRef targetResourceSchema = null;

 
  private TimePeriod validFor = null;

 
  private String version = null;

  public ResourceSpecificationCreate baseType(String baseType) {
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

  public ResourceSpecificationCreate schemaLocation(String schemaLocation) {
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

  public ResourceSpecificationCreate type(String type) {
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

  public ResourceSpecificationCreate attachment(List<AttachmentRef> attachment) {
    this.attachment = attachment;
    return this;
  }

  public ResourceSpecificationCreate addAttachmentItem(AttachmentRef attachmentItem) {
    if (this.attachment == null) {
      this.attachment = new ArrayList<AttachmentRef>();
    }
    this.attachment.add(attachmentItem);
    return this;
  }

  /**
   * Get attachment
   *
  **/
 

 

  public List<AttachmentRef> getAttachment() {
    return attachment;
  }

  public void setAttachment(List<AttachmentRef> attachment) {
    this.attachment = attachment;
  }

  public ResourceSpecificationCreate category(String category) {
    this.category = category;
    return this;
  }

  /**
   * Category of the target resource like NetworkConnectivity, PhysicalLinks, Generic, L2Network and so on.
   *
  **/
 


  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public ResourceSpecificationCreate description(String description) {
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

  public ResourceSpecificationCreate feature(List<Feature> feature) {
    this.feature = feature;
    return this;
  }

  public ResourceSpecificationCreate addFeatureItem(Feature featureItem) {
    if (this.feature == null) {
      this.feature = new ArrayList<Feature>();
    }
    this.feature.add(featureItem);
    return this;
  }

  /**
   * Get feature
   *
  **/
 

 

  public List<Feature> getFeature() {
    return feature;
  }

  public void setFeature(List<Feature> feature) {
    this.feature = feature;
  }

  public ResourceSpecificationCreate isBundle(Boolean isBundle) {
    this.isBundle = isBundle;
    return this;
  }

  /**
   * A flag indicates that if this resource specification is a bundled specification (true) or single (false).
   *
  **/
 


  public Boolean isIsBundle() {
    return isBundle;
  }

  public void setIsBundle(Boolean isBundle) {
    this.isBundle = isBundle;
  }

  public ResourceSpecificationCreate lastUpdate(OffsetDateTime lastUpdate) {
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

  public ResourceSpecificationCreate lifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
    return this;
  }

  /**
   * Used to indicate the current lifecycle status of the resource specification
   *
  **/
 


  public String getLifecycleStatus() {
    return lifecycleStatus;
  }

  public void setLifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
  }

  public ResourceSpecificationCreate name(String name) {
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

  public ResourceSpecificationCreate relatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public ResourceSpecificationCreate addRelatedPartyItem(RelatedParty relatedPartyItem) {
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

  public ResourceSpecificationCreate resourceSpecCharacteristic(List<ResourceSpecCharacteristic> resourceSpecCharacteristic) {
    this.resourceSpecCharacteristic = resourceSpecCharacteristic;
    return this;
  }

  public ResourceSpecificationCreate addResourceSpecCharacteristicItem(ResourceSpecCharacteristic resourceSpecCharacteristicItem) {
    if (this.resourceSpecCharacteristic == null) {
      this.resourceSpecCharacteristic = new ArrayList<ResourceSpecCharacteristic>();
    }
    this.resourceSpecCharacteristic.add(resourceSpecCharacteristicItem);
    return this;
  }

  /**
   * Get resourceSpecCharacteristic
   *
  **/
 

 

  public List<ResourceSpecCharacteristic> getResourceSpecCharacteristic() {
    return resourceSpecCharacteristic;
  }

  public void setResourceSpecCharacteristic(List<ResourceSpecCharacteristic> resourceSpecCharacteristic) {
    this.resourceSpecCharacteristic = resourceSpecCharacteristic;
  }

  public ResourceSpecificationCreate resourceSpecRelationship(List<ResourceSpecRelationship> resourceSpecRelationship) {
    this.resourceSpecRelationship = resourceSpecRelationship;
    return this;
  }

  public ResourceSpecificationCreate addResourceSpecRelationshipItem(ResourceSpecRelationship resourceSpecRelationshipItem) {
    if (this.resourceSpecRelationship == null) {
      this.resourceSpecRelationship = new ArrayList<ResourceSpecRelationship>();
    }
    this.resourceSpecRelationship.add(resourceSpecRelationshipItem);
    return this;
  }

  /**
   * Get resourceSpecRelationship
   *
  **/
 

 

  public List<ResourceSpecRelationship> getResourceSpecRelationship() {
    return resourceSpecRelationship;
  }

  public void setResourceSpecRelationship(List<ResourceSpecRelationship> resourceSpecRelationship) {
    this.resourceSpecRelationship = resourceSpecRelationship;
  }

  public ResourceSpecificationCreate targetResourceSchema(TargetResourceSchemaRef targetResourceSchema) {
    this.targetResourceSchema = targetResourceSchema;
    return this;
  }

  /**
   * Get targetResourceSchema
   *
  **/
 

 

  public TargetResourceSchemaRef getTargetResourceSchema() {
    return targetResourceSchema;
  }

  public void setTargetResourceSchema(TargetResourceSchemaRef targetResourceSchema) {
    this.targetResourceSchema = targetResourceSchema;
  }

  public ResourceSpecificationCreate validFor(TimePeriod validFor) {
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

  public ResourceSpecificationCreate version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Resource Specification version
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
    ResourceSpecificationCreate resourceSpecificationCreate = (ResourceSpecificationCreate) o;
    return Objects.equals(this.baseType, resourceSpecificationCreate.baseType) &&
        Objects.equals(this.schemaLocation, resourceSpecificationCreate.schemaLocation) &&
        Objects.equals(this.type, resourceSpecificationCreate.type) &&
        Objects.equals(this.attachment, resourceSpecificationCreate.attachment) &&
        Objects.equals(this.category, resourceSpecificationCreate.category) &&
        Objects.equals(this.description, resourceSpecificationCreate.description) &&
        Objects.equals(this.feature, resourceSpecificationCreate.feature) &&
        Objects.equals(this.isBundle, resourceSpecificationCreate.isBundle) &&
        Objects.equals(this.lastUpdate, resourceSpecificationCreate.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, resourceSpecificationCreate.lifecycleStatus) &&
        Objects.equals(this.name, resourceSpecificationCreate.name) &&
        Objects.equals(this.relatedParty, resourceSpecificationCreate.relatedParty) &&
        Objects.equals(this.resourceSpecCharacteristic, resourceSpecificationCreate.resourceSpecCharacteristic) &&
        Objects.equals(this.resourceSpecRelationship, resourceSpecificationCreate.resourceSpecRelationship) &&
        Objects.equals(this.targetResourceSchema, resourceSpecificationCreate.targetResourceSchema) &&
        Objects.equals(this.validFor, resourceSpecificationCreate.validFor) &&
        Objects.equals(this.version, resourceSpecificationCreate.version);
  }

 
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, attachment, category, description, feature, isBundle, lastUpdate, lifecycleStatus, name, relatedParty, resourceSpecCharacteristic, resourceSpecRelationship, targetResourceSchema, validFor, version);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceSpecificationCreate {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    feature: ").append(toIndentedString(feature)).append("\n");
    sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    resourceSpecCharacteristic: ").append(toIndentedString(resourceSpecCharacteristic)).append("\n");
    sb.append("    resourceSpecRelationship: ").append(toIndentedString(resourceSpecRelationship)).append("\n");
    sb.append("    targetResourceSchema: ").append(toIndentedString(targetResourceSchema)).append("\n");
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

