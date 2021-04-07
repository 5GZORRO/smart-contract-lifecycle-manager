package eu._5gzorro.tm_forum.models.resource;

import eu._5gzorro.tm_forum.models.AttachmentRef;
import eu._5gzorro.tm_forum.models.RelatedParty;
import eu._5gzorro.tm_forum.models.TimePeriod;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This is a base class that is used to define the invariant characteristics and behavior (attributes, methods, constraints, and relationships) of a LogicalResource. Skipped properties: id,href,id,href,lastUpdate,@type
 */







public class LogicalResourceSpecUpdate   {

  private String baseType = null;


  private String schemaLocation = null;



  private List<AttachmentRef> attachment = null;


  private String category = null;


  private String description = null;



  private List<Feature> feature = null;


  private Boolean isBundle = null;


  private String lifecycleStatus = null;


  private String name = null;



  private List<RelatedParty> relatedParty = null;



  private List<ResourceSpecCharacteristic> resourceSpecCharacteristic = null;



  private List<ResourceSpecRelationship> resourceSpecRelationship = null;


  private TargetResourceSchemaRef targetResourceSchema = null;


  private TimePeriod validFor = null;


  private String version = null;

  public LogicalResourceSpecUpdate baseType(String baseType) {
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

  public LogicalResourceSpecUpdate schemaLocation(String schemaLocation) {
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

  public LogicalResourceSpecUpdate attachment(List<AttachmentRef> attachment) {
    this.attachment = attachment;
    return this;
  }

  public LogicalResourceSpecUpdate addAttachmentItem(AttachmentRef attachmentItem) {
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

  public LogicalResourceSpecUpdate category(String category) {
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

  public LogicalResourceSpecUpdate description(String description) {
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

  public LogicalResourceSpecUpdate feature(List<Feature> feature) {
    this.feature = feature;
    return this;
  }

  public LogicalResourceSpecUpdate addFeatureItem(Feature featureItem) {
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

  public LogicalResourceSpecUpdate isBundle(Boolean isBundle) {
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

  public LogicalResourceSpecUpdate lifecycleStatus(String lifecycleStatus) {
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

  public LogicalResourceSpecUpdate name(String name) {
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

  public LogicalResourceSpecUpdate relatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public LogicalResourceSpecUpdate addRelatedPartyItem(RelatedParty relatedPartyItem) {
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

  public LogicalResourceSpecUpdate resourceSpecCharacteristic(List<ResourceSpecCharacteristic> resourceSpecCharacteristic) {
    this.resourceSpecCharacteristic = resourceSpecCharacteristic;
    return this;
  }

  public LogicalResourceSpecUpdate addResourceSpecCharacteristicItem(ResourceSpecCharacteristic resourceSpecCharacteristicItem) {
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

  public LogicalResourceSpecUpdate resourceSpecRelationship(List<ResourceSpecRelationship> resourceSpecRelationship) {
    this.resourceSpecRelationship = resourceSpecRelationship;
    return this;
  }

  public LogicalResourceSpecUpdate addResourceSpecRelationshipItem(ResourceSpecRelationship resourceSpecRelationshipItem) {
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

  public LogicalResourceSpecUpdate targetResourceSchema(TargetResourceSchemaRef targetResourceSchema) {
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

  public LogicalResourceSpecUpdate validFor(TimePeriod validFor) {
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

  public LogicalResourceSpecUpdate version(String version) {
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
    LogicalResourceSpecUpdate logicalResourceSpecUpdate = (LogicalResourceSpecUpdate) o;
    return Objects.equals(this.baseType, logicalResourceSpecUpdate.baseType) &&
        Objects.equals(this.schemaLocation, logicalResourceSpecUpdate.schemaLocation) &&
        Objects.equals(this.attachment, logicalResourceSpecUpdate.attachment) &&
        Objects.equals(this.category, logicalResourceSpecUpdate.category) &&
        Objects.equals(this.description, logicalResourceSpecUpdate.description) &&
        Objects.equals(this.feature, logicalResourceSpecUpdate.feature) &&
        Objects.equals(this.isBundle, logicalResourceSpecUpdate.isBundle) &&
        Objects.equals(this.lifecycleStatus, logicalResourceSpecUpdate.lifecycleStatus) &&
        Objects.equals(this.name, logicalResourceSpecUpdate.name) &&
        Objects.equals(this.relatedParty, logicalResourceSpecUpdate.relatedParty) &&
        Objects.equals(this.resourceSpecCharacteristic, logicalResourceSpecUpdate.resourceSpecCharacteristic) &&
        Objects.equals(this.resourceSpecRelationship, logicalResourceSpecUpdate.resourceSpecRelationship) &&
        Objects.equals(this.targetResourceSchema, logicalResourceSpecUpdate.targetResourceSchema) &&
        Objects.equals(this.validFor, logicalResourceSpecUpdate.validFor) &&
        Objects.equals(this.version, logicalResourceSpecUpdate.version);
  }


  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, attachment, category, description, feature, isBundle, lifecycleStatus, name, relatedParty, resourceSpecCharacteristic, resourceSpecRelationship, targetResourceSchema, validFor, version);
  }


  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LogicalResourceSpecUpdate {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    feature: ").append(toIndentedString(feature)).append("\n");
    sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
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

