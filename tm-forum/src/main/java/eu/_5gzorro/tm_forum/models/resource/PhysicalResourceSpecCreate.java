package eu._5gzorro.tm_forum.models.resource;

import eu._5gzorro.tm_forum.models.AttachmentRef;
import eu._5gzorro.tm_forum.models.PlaceRef;
import eu._5gzorro.tm_forum.models.RelatedParty;
import eu._5gzorro.tm_forum.models.TimePeriod;
import org.threeten.bp.OffsetDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This is a concrete class that is used to define the invariant characteristics and behavior (attributes, methods, constraints, and relationships) of a PhysicalResource. Skipped properties: id,href
 */







public class PhysicalResourceSpecCreate   {
 
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

 
  private String model = null;

 
  private String name = null;

 
  private String part = null;

 
  private PlaceRef place = null;

 
 
  private List<RelatedParty> relatedParty = null;

 
 
  private List<ResourceSpecCharacteristic> resourceSpecCharacteristic = null;

 
 
  private List<ResourceSpecRelationship> resourceSpecRelationship = null;

 
  private String sku = null;

 
  private TargetResourceSchemaRef targetResourceSchema = null;

 
  private TimePeriod validFor = null;

 
  private String vendor = null;

 
  private String version = null;

  public PhysicalResourceSpecCreate baseType(String baseType) {
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

  public PhysicalResourceSpecCreate schemaLocation(String schemaLocation) {
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

  public PhysicalResourceSpecCreate type(String type) {
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

  public PhysicalResourceSpecCreate attachment(List<AttachmentRef> attachment) {
    this.attachment = attachment;
    return this;
  }

  public PhysicalResourceSpecCreate addAttachmentItem(AttachmentRef attachmentItem) {
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

  public PhysicalResourceSpecCreate category(String category) {
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

  public PhysicalResourceSpecCreate description(String description) {
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

  public PhysicalResourceSpecCreate feature(List<Feature> feature) {
    this.feature = feature;
    return this;
  }

  public PhysicalResourceSpecCreate addFeatureItem(Feature featureItem) {
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

  public PhysicalResourceSpecCreate isBundle(Boolean isBundle) {
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

  public PhysicalResourceSpecCreate lastUpdate(OffsetDateTime lastUpdate) {
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

  public PhysicalResourceSpecCreate lifecycleStatus(String lifecycleStatus) {
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

  public PhysicalResourceSpecCreate model(String model) {
    this.model = model;
    return this;
  }

  /**
   * This is a string that represents a manufacturer-allocated number used to identify the general type and/or category of the hardware item. This, in combination with the Part and the Vendor, identify different types of hardware items. The SerialNumber can then be used to differentiate between different instances of the same type of hardware item. This is an optional attribute.
   *
  **/
 


  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public PhysicalResourceSpecCreate name(String name) {
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

  public PhysicalResourceSpecCreate part(String part) {
    this.part = part;
    return this;
  }

  /**
   * This is a string that defines a manufacturer-allocated part number assigned by the organization that manufactures the hardware item. This, in combination with the Model and the Vendor, identify different types of hardware items. The SerialNumber can then be used to differentiate between different instances of the same type of hardware item. This is a REQUIRED attribute.
   *
  **/
 


  public String getPart() {
    return part;
  }

  public void setPart(String part) {
    this.part = part;
  }

  public PhysicalResourceSpecCreate place(PlaceRef place) {
    this.place = place;
    return this;
  }

  /**
   * Get place
   *
  **/
 

 

  public PlaceRef getPlace() {
    return place;
  }

  public void setPlace(PlaceRef place) {
    this.place = place;
  }

  public PhysicalResourceSpecCreate relatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public PhysicalResourceSpecCreate addRelatedPartyItem(RelatedParty relatedPartyItem) {
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

  public PhysicalResourceSpecCreate resourceSpecCharacteristic(List<ResourceSpecCharacteristic> resourceSpecCharacteristic) {
    this.resourceSpecCharacteristic = resourceSpecCharacteristic;
    return this;
  }

  public PhysicalResourceSpecCreate addResourceSpecCharacteristicItem(ResourceSpecCharacteristic resourceSpecCharacteristicItem) {
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

  public PhysicalResourceSpecCreate resourceSpecRelationship(List<ResourceSpecRelationship> resourceSpecRelationship) {
    this.resourceSpecRelationship = resourceSpecRelationship;
    return this;
  }

  public PhysicalResourceSpecCreate addResourceSpecRelationshipItem(ResourceSpecRelationship resourceSpecRelationshipItem) {
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

  public PhysicalResourceSpecCreate sku(String sku) {
    this.sku = sku;
    return this;
  }

  /**
   * This is a string that defines the manufacturer-allocated Stock Keeping Unit (SKU) number of the hardware item. This is an optional attribute.
   *
  **/
 


  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public PhysicalResourceSpecCreate targetResourceSchema(TargetResourceSchemaRef targetResourceSchema) {
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

  public PhysicalResourceSpecCreate validFor(TimePeriod validFor) {
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

  public PhysicalResourceSpecCreate vendor(String vendor) {
    this.vendor = vendor;
    return this;
  }

  /**
   * This is a string that defines the name of the manufacturer. This, in combination with the Model and the Part, identify different types of hardware items. The SerialNumber can then be used to differentiate between different instances of the same type of hardware item. This is a REQUIRED attribute for a physical resource.
   *
  **/
 


  public String getVendor() {
    return vendor;
  }

  public void setVendor(String vendor) {
    this.vendor = vendor;
  }

  public PhysicalResourceSpecCreate version(String version) {
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
    PhysicalResourceSpecCreate physicalResourceSpecCreate = (PhysicalResourceSpecCreate) o;
    return Objects.equals(this.baseType, physicalResourceSpecCreate.baseType) &&
        Objects.equals(this.schemaLocation, physicalResourceSpecCreate.schemaLocation) &&
        Objects.equals(this.type, physicalResourceSpecCreate.type) &&
        Objects.equals(this.attachment, physicalResourceSpecCreate.attachment) &&
        Objects.equals(this.category, physicalResourceSpecCreate.category) &&
        Objects.equals(this.description, physicalResourceSpecCreate.description) &&
        Objects.equals(this.feature, physicalResourceSpecCreate.feature) &&
        Objects.equals(this.isBundle, physicalResourceSpecCreate.isBundle) &&
        Objects.equals(this.lastUpdate, physicalResourceSpecCreate.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, physicalResourceSpecCreate.lifecycleStatus) &&
        Objects.equals(this.model, physicalResourceSpecCreate.model) &&
        Objects.equals(this.name, physicalResourceSpecCreate.name) &&
        Objects.equals(this.part, physicalResourceSpecCreate.part) &&
        Objects.equals(this.place, physicalResourceSpecCreate.place) &&
        Objects.equals(this.relatedParty, physicalResourceSpecCreate.relatedParty) &&
        Objects.equals(this.resourceSpecCharacteristic, physicalResourceSpecCreate.resourceSpecCharacteristic) &&
        Objects.equals(this.resourceSpecRelationship, physicalResourceSpecCreate.resourceSpecRelationship) &&
        Objects.equals(this.sku, physicalResourceSpecCreate.sku) &&
        Objects.equals(this.targetResourceSchema, physicalResourceSpecCreate.targetResourceSchema) &&
        Objects.equals(this.validFor, physicalResourceSpecCreate.validFor) &&
        Objects.equals(this.vendor, physicalResourceSpecCreate.vendor) &&
        Objects.equals(this.version, physicalResourceSpecCreate.version);
  }

 
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, attachment, category, description, feature, isBundle, lastUpdate, lifecycleStatus, model, name, part, place, relatedParty, resourceSpecCharacteristic, resourceSpecRelationship, sku, targetResourceSchema, validFor, vendor, version);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PhysicalResourceSpecCreate {\n");
    
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
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    part: ").append(toIndentedString(part)).append("\n");
    sb.append("    place: ").append(toIndentedString(place)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    resourceSpecCharacteristic: ").append(toIndentedString(resourceSpecCharacteristic)).append("\n");
    sb.append("    resourceSpecRelationship: ").append(toIndentedString(resourceSpecRelationship)).append("\n");
    sb.append("    sku: ").append(toIndentedString(sku)).append("\n");
    sb.append("    targetResourceSchema: ").append(toIndentedString(targetResourceSchema)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    vendor: ").append(toIndentedString(vendor)).append("\n");
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

