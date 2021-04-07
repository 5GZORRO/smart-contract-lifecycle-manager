package eu._5gzorro.tm_forum.models.service;

import eu._5gzorro.tm_forum.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ServiceSpecification is a class that offers characteristics to describe a type of service. Functionally, it acts as a template by which Services may be instantiated. By sharing the same  specification, these services would therefore share the same set of characteristics. Skipped properties: id,href,lastUpdate
 */







public class ServiceSpecificationUpdate   {

  private String baseType = null;


  private String schemaLocation = null;


  private String type = null;



  private List<AttachmentRef> attachment = null;


  private String description = null;


  private Boolean isBundle = null;


  private String lifecycleStatus = null;


  private String name = null;



  private List<RelatedParty> relatedParty = null;



  private List<ResourceSpecificationRef> resourceSpecification = null;



  private List<ServiceLevelSpecificationRef> serviceLevelSpecification = null;



  private List<ServiceSpecCharacteristic> serviceSpecCharacteristic = null;



  private List<ServiceSpecRelationship> serviceSpecRelationship = null;


  private TargetServiceSchema targetServiceSchema = null;


  private TimePeriod validFor = null;


  private String version = null;

  public ServiceSpecificationUpdate baseType(String baseType) {
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

  public ServiceSpecificationUpdate schemaLocation(String schemaLocation) {
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

  public ServiceSpecificationUpdate type(String type) {
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

  public ServiceSpecificationUpdate attachment(List<AttachmentRef> attachment) {
    this.attachment = attachment;
    return this;
  }

  public ServiceSpecificationUpdate addAttachmentItem(AttachmentRef attachmentItem) {
    if (this.attachment == null) {
      this.attachment = new ArrayList<AttachmentRef>();
    }
    this.attachment.add(attachmentItem);
    return this;
  }

  /**
   * A list of attachments (Attachment [*]). Complements the description of the specification through video, pictures...
   *
  **/




  public List<AttachmentRef> getAttachment() {
    return attachment;
  }

  public void setAttachment(List<AttachmentRef> attachment) {
    this.attachment = attachment;
  }

  public ServiceSpecificationUpdate description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A narrative that explains in detail what the service specification is
   *
  **/



  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ServiceSpecificationUpdate isBundle(Boolean isBundle) {
    this.isBundle = isBundle;
    return this;
  }

  /**
   * isBundle determines whether a ServiceSpecification represents a single ServiceSpecification (false), or a bundle of ServiceSpecification (true).
   *
  **/



  public Boolean isIsBundle() {
    return isBundle;
  }

  public void setIsBundle(Boolean isBundle) {
    this.isBundle = isBundle;
  }

  public ServiceSpecificationUpdate lifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
    return this;
  }

  /**
   * Used to indicate the current lifecycle status of the service specification
   *
  **/



  public String getLifecycleStatus() {
    return lifecycleStatus;
  }

  public void setLifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
  }

  public ServiceSpecificationUpdate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the service specification
   *
  **/



  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ServiceSpecificationUpdate relatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public ServiceSpecificationUpdate addRelatedPartyItem(RelatedParty relatedPartyItem) {
    if (this.relatedParty == null) {
      this.relatedParty = new ArrayList<RelatedParty>();
    }
    this.relatedParty.add(relatedPartyItem);
    return this;
  }

  /**
   * A list of related party references (RelatedParty [*]). A related party defines party or party role linked to a specific entity.
   *
  **/




  public List<RelatedParty> getRelatedParty() {
    return relatedParty;
  }

  public void setRelatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
  }

  public ServiceSpecificationUpdate resourceSpecification(List<ResourceSpecificationRef> resourceSpecification) {
    this.resourceSpecification = resourceSpecification;
    return this;
  }

  public ServiceSpecificationUpdate addResourceSpecificationItem(ResourceSpecificationRef resourceSpecificationItem) {
    if (this.resourceSpecification == null) {
      this.resourceSpecification = new ArrayList<ResourceSpecificationRef>();
    }
    this.resourceSpecification.add(resourceSpecificationItem);
    return this;
  }

  /**
   * A list of resource specification references (ResourceSpecificationRef [*]). The ResourceSpecification is required for a service specification with type ResourceFacingServiceSpecification (RFSS).
   *
  **/




  public List<ResourceSpecificationRef> getResourceSpecification() {
    return resourceSpecification;
  }

  public void setResourceSpecification(List<ResourceSpecificationRef> resourceSpecification) {
    this.resourceSpecification = resourceSpecification;
  }

  public ServiceSpecificationUpdate serviceLevelSpecification(List<ServiceLevelSpecificationRef> serviceLevelSpecification) {
    this.serviceLevelSpecification = serviceLevelSpecification;
    return this;
  }

  public ServiceSpecificationUpdate addServiceLevelSpecificationItem(ServiceLevelSpecificationRef serviceLevelSpecificationItem) {
    if (this.serviceLevelSpecification == null) {
      this.serviceLevelSpecification = new ArrayList<ServiceLevelSpecificationRef>();
    }
    this.serviceLevelSpecification.add(serviceLevelSpecificationItem);
    return this;
  }

  /**
   * A list of service level specifications related to this service specification, and which will need to be satisifiable for corresponding service instances; e.g. Gold, Platinum
   *
  **/




  public List<ServiceLevelSpecificationRef> getServiceLevelSpecification() {
    return serviceLevelSpecification;
  }

  public void setServiceLevelSpecification(List<ServiceLevelSpecificationRef> serviceLevelSpecification) {
    this.serviceLevelSpecification = serviceLevelSpecification;
  }

  public ServiceSpecificationUpdate serviceSpecCharacteristic(List<ServiceSpecCharacteristic> serviceSpecCharacteristic) {
    this.serviceSpecCharacteristic = serviceSpecCharacteristic;
    return this;
  }

  public ServiceSpecificationUpdate addServiceSpecCharacteristicItem(ServiceSpecCharacteristic serviceSpecCharacteristicItem) {
    if (this.serviceSpecCharacteristic == null) {
      this.serviceSpecCharacteristic = new ArrayList<ServiceSpecCharacteristic>();
    }
    this.serviceSpecCharacteristic.add(serviceSpecCharacteristicItem);
    return this;
  }

  /**
   * A list of service spec characteristics (ServiceSpecCharacteristic [*]). This class represents the key features of this service specification.
   *
  **/




  public List<ServiceSpecCharacteristic> getServiceSpecCharacteristic() {
    return serviceSpecCharacteristic;
  }

  public void setServiceSpecCharacteristic(List<ServiceSpecCharacteristic> serviceSpecCharacteristic) {
    this.serviceSpecCharacteristic = serviceSpecCharacteristic;
  }

  public ServiceSpecificationUpdate serviceSpecRelationship(List<ServiceSpecRelationship> serviceSpecRelationship) {
    this.serviceSpecRelationship = serviceSpecRelationship;
    return this;
  }

  public ServiceSpecificationUpdate addServiceSpecRelationshipItem(ServiceSpecRelationship serviceSpecRelationshipItem) {
    if (this.serviceSpecRelationship == null) {
      this.serviceSpecRelationship = new ArrayList<ServiceSpecRelationship>();
    }
    this.serviceSpecRelationship.add(serviceSpecRelationshipItem);
    return this;
  }

  /**
   * A list of service specifications related to this specification, e.g. migration, substitution, dependency or exclusivity relationship
   *
  **/




  public List<ServiceSpecRelationship> getServiceSpecRelationship() {
    return serviceSpecRelationship;
  }

  public void setServiceSpecRelationship(List<ServiceSpecRelationship> serviceSpecRelationship) {
    this.serviceSpecRelationship = serviceSpecRelationship;
  }

  public ServiceSpecificationUpdate targetServiceSchema(TargetServiceSchema targetServiceSchema) {
    this.targetServiceSchema = targetServiceSchema;
    return this;
  }

  /**
   * A target service schema reference (TargetServiceSchemaRef). The reference object to the schema and type of target service which is described by service specification.
   *
  **/




  public TargetServiceSchema getTargetServiceSchema() {
    return targetServiceSchema;
  }

  public void setTargetServiceSchema(TargetServiceSchema targetServiceSchema) {
    this.targetServiceSchema = targetServiceSchema;
  }

  public ServiceSpecificationUpdate validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which the service specification is valid
   *
  **/




  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public ServiceSpecificationUpdate version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Service specification version
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
    ServiceSpecificationUpdate serviceSpecificationUpdate = (ServiceSpecificationUpdate) o;
    return Objects.equals(this.baseType, serviceSpecificationUpdate.baseType) &&
        Objects.equals(this.schemaLocation, serviceSpecificationUpdate.schemaLocation) &&
        Objects.equals(this.type, serviceSpecificationUpdate.type) &&
        Objects.equals(this.attachment, serviceSpecificationUpdate.attachment) &&
        Objects.equals(this.description, serviceSpecificationUpdate.description) &&
        Objects.equals(this.isBundle, serviceSpecificationUpdate.isBundle) &&
        Objects.equals(this.lifecycleStatus, serviceSpecificationUpdate.lifecycleStatus) &&
        Objects.equals(this.name, serviceSpecificationUpdate.name) &&
        Objects.equals(this.relatedParty, serviceSpecificationUpdate.relatedParty) &&
        Objects.equals(this.resourceSpecification, serviceSpecificationUpdate.resourceSpecification) &&
        Objects.equals(this.serviceLevelSpecification, serviceSpecificationUpdate.serviceLevelSpecification) &&
        Objects.equals(this.serviceSpecCharacteristic, serviceSpecificationUpdate.serviceSpecCharacteristic) &&
        Objects.equals(this.serviceSpecRelationship, serviceSpecificationUpdate.serviceSpecRelationship) &&
        Objects.equals(this.targetServiceSchema, serviceSpecificationUpdate.targetServiceSchema) &&
        Objects.equals(this.validFor, serviceSpecificationUpdate.validFor) &&
        Objects.equals(this.version, serviceSpecificationUpdate.version);
  }


  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, attachment, description, isBundle, lifecycleStatus, name, relatedParty, resourceSpecification, serviceLevelSpecification, serviceSpecCharacteristic, serviceSpecRelationship, targetServiceSchema, validFor, version);
  }


  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceSpecificationUpdate {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    resourceSpecification: ").append(toIndentedString(resourceSpecification)).append("\n");
    sb.append("    serviceLevelSpecification: ").append(toIndentedString(serviceLevelSpecification)).append("\n");
    sb.append("    serviceSpecCharacteristic: ").append(toIndentedString(serviceSpecCharacteristic)).append("\n");
    sb.append("    serviceSpecRelationship: ").append(toIndentedString(serviceSpecRelationship)).append("\n");
    sb.append("    targetServiceSchema: ").append(toIndentedString(targetServiceSchema)).append("\n");
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

