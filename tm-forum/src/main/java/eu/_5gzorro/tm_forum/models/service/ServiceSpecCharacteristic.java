package eu._5gzorro.tm_forum.models.service;

import eu._5gzorro.tm_forum.models.TimePeriod;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class represents the key features of this service specification. For example, bandwidth is a characteristic of many different types of services; if bandwidth is a relevant characteristic (e.g., from the point-of-view of a Customer obtaining this Service via a Product) then bandwidth would be a ServiceSpecCharacteristic for that particular Service.
 */






public class ServiceSpecCharacteristic {

 
 
  private String baseType = null;

 
 
  private String schemaLocation = null;

 
  private String type = null;

 
 
  private String valueSchemaLocation = null;

 
  private Boolean configurable = null;

 
  private String description = null;

 
  private Boolean extensible = null;

 
  private String href = null;

 
  private String id = null;

 
 
  private Boolean isUnique = null;

 
 
  private Integer maxCardinality = null;

 
 
  private Integer minCardinality = null;

 
  private String name = null;

 
  private String regex = null;

 
 
 
 
  private List<ServiceSpecCharRelationship> serviceSpecCharRelationship = null;

 
 
 
 
  private List<ServiceSpecCharacteristicValue> serviceSpecCharacteristicValue = null;

 
 
 
 
  private String uuid = null;

 
 
 
  private TimePeriod validFor = null;

 
 
  private String valueType = null;

  public ServiceSpecCharacteristic baseType(String baseType) {
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

  public ServiceSpecCharacteristic schemaLocation(String schemaLocation) {
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

  public ServiceSpecCharacteristic type(String type) {
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

  public ServiceSpecCharacteristic valueSchemaLocation(String valueSchemaLocation) {
    this.valueSchemaLocation = valueSchemaLocation;
    return this;
  }

  /**
   * This (optional) field provides a link to the schema describing the value type.
   *
  **/
 


  public String getValueSchemaLocation() {
    return valueSchemaLocation;
  }

  public void setValueSchemaLocation(String valueSchemaLocation) {
    this.valueSchemaLocation = valueSchemaLocation;
  }

  public ServiceSpecCharacteristic configurable(Boolean configurable) {
    this.configurable = configurable;
    return this;
  }

  /**
   * If true, the Boolean indicates that the serviceSpecCharacteristic is configurable
   *
  **/
 


  public Boolean isConfigurable() {
    return configurable;
  }

  public void setConfigurable(Boolean configurable) {
    this.configurable = configurable;
  }

  public ServiceSpecCharacteristic description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A narrative that explains in detail what the serviceSpecCharacteristic is
   *
  **/
 


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ServiceSpecCharacteristic extensible(Boolean extensible) {
    this.extensible = extensible;
    return this;
  }

  /**
   * An indicator that specifies that the values for the characteristic can be extended by adding new values when instantiating a characteristic for an Entity.
   *
  **/
 


  public Boolean isExtensible() {
    return extensible;
  }

  public void setExtensible(Boolean extensible) {
    this.extensible = extensible;
  }

  public ServiceSpecCharacteristic href(String href) {
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

  public ServiceSpecCharacteristic id(String id) {
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

  public ServiceSpecCharacteristic isUnique(Boolean isUnique) {
    this.isUnique = isUnique;
    return this;
  }

  /**
   * An indicator that specifies if a value is unique for the specification. Possible values are; \"unique while value is in effect\" and \"unique whether value is in effect or not\"
   *
  **/
 


  public Boolean isIsUnique() {
    return isUnique;
  }

  public void setIsUnique(Boolean isUnique) {
    this.isUnique = isUnique;
  }

  public ServiceSpecCharacteristic maxCardinality(Integer maxCardinality) {
    this.maxCardinality = maxCardinality;
    return this;
  }

  /**
   * The maximum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where five is the value for the maxCardinality.
   *
  **/
 


  public Integer getMaxCardinality() {
    return maxCardinality;
  }

  public void setMaxCardinality(Integer maxCardinality) {
    this.maxCardinality = maxCardinality;
  }

  public ServiceSpecCharacteristic minCardinality(Integer minCardinality) {
    this.minCardinality = minCardinality;
    return this;
  }

  /**
   * The minimum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where zero is the value for the minCardinality.
   *
  **/
 


  public Integer getMinCardinality() {
    return minCardinality;
  }

  public void setMinCardinality(Integer minCardinality) {
    this.minCardinality = minCardinality;
  }

  public ServiceSpecCharacteristic name(String name) {
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

  public ServiceSpecCharacteristic regex(String regex) {
    this.regex = regex;
    return this;
  }

  /**
   * A rule or principle represented in regular expression used to derive the value of a characteristic value.
   *
  **/
 


  public String getRegex() {
    return regex;
  }

  public void setRegex(String regex) {
    this.regex = regex;
  }

  public ServiceSpecCharacteristic serviceSpecCharRelationship(List<ServiceSpecCharRelationship> serviceSpecCharRelationship) {
    this.serviceSpecCharRelationship = serviceSpecCharRelationship;
    return this;
  }

  public ServiceSpecCharacteristic addServiceSpecCharRelationshipItem(ServiceSpecCharRelationship serviceSpecCharRelationshipItem) {
    if (this.serviceSpecCharRelationship == null) {
      this.serviceSpecCharRelationship = new ArrayList<ServiceSpecCharRelationship>();
    }
    this.serviceSpecCharRelationship.add(serviceSpecCharRelationshipItem);
    return this;
  }

  /**
   * A list of service spec char relationships (ServiceSpecCharRelationship [*]). An aggregation, migration, substitution, dependency or exclusivity relationship between/among Specification Characteristics.
   *
  **/
 

 

  public List<ServiceSpecCharRelationship> getServiceSpecCharRelationship() {
    return serviceSpecCharRelationship;
  }

  public void setServiceSpecCharRelationship(List<ServiceSpecCharRelationship> serviceSpecCharRelationship) {
    this.serviceSpecCharRelationship = serviceSpecCharRelationship;
  }

  public ServiceSpecCharacteristic serviceSpecCharacteristicValue(List<ServiceSpecCharacteristicValue> serviceSpecCharacteristicValue) {
    this.serviceSpecCharacteristicValue = serviceSpecCharacteristicValue;
    return this;
  }

  public ServiceSpecCharacteristic addServiceSpecCharacteristicValueItem(ServiceSpecCharacteristicValue serviceSpecCharacteristicValueItem) {
    if (this.serviceSpecCharacteristicValue == null) {
      this.serviceSpecCharacteristicValue = new ArrayList<ServiceSpecCharacteristicValue>();
    }
    this.serviceSpecCharacteristicValue.add(serviceSpecCharacteristicValueItem);
    return this;
  }

  /**
   * A list of service spec characteristic values (ServiceSpecCharacteristicValue [*]). A ServiceSpecCharacteristicValue object is used to define a set of attributes, each of which can be assigned to a corresponding set of attributes in a ServiceSpecCharacteristic object. The values of the attributes in the ServiceSpecCharacteristicValue object describe the values of the attributes that a corresponding ServiceSpecCharacteristic object can take on.
   *
  **/
 

 

  public List<ServiceSpecCharacteristicValue> getServiceSpecCharacteristicValue() {
    return serviceSpecCharacteristicValue;
  }

  public void setServiceSpecCharacteristicValue(List<ServiceSpecCharacteristicValue> serviceSpecCharacteristicValue) {
    this.serviceSpecCharacteristicValue = serviceSpecCharacteristicValue;
  }

  public ServiceSpecCharacteristic uuid(String uuid) {
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

  public ServiceSpecCharacteristic validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which the serviceSpecCharacteristic is valid
   *
  **/
 

 

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public ServiceSpecCharacteristic valueType(String valueType) {
    this.valueType = valueType;
    return this;
  }

  /**
   * A kind of value that the characteristic can take on, such as numeric, text and so forth
   *
  **/
 


  public String getValueType() {
    return valueType;
  }

  public void setValueType(String valueType) {
    this.valueType = valueType;
  }


 
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceSpecCharacteristic serviceSpecCharacteristic = (ServiceSpecCharacteristic) o;
    return Objects.equals(this.baseType, serviceSpecCharacteristic.baseType) &&
        Objects.equals(this.schemaLocation, serviceSpecCharacteristic.schemaLocation) &&
        Objects.equals(this.type, serviceSpecCharacteristic.type) &&
        Objects.equals(this.valueSchemaLocation, serviceSpecCharacteristic.valueSchemaLocation) &&
        Objects.equals(this.configurable, serviceSpecCharacteristic.configurable) &&
        Objects.equals(this.description, serviceSpecCharacteristic.description) &&
        Objects.equals(this.extensible, serviceSpecCharacteristic.extensible) &&
        Objects.equals(this.href, serviceSpecCharacteristic.href) &&
        Objects.equals(this.id, serviceSpecCharacteristic.id) &&
        Objects.equals(this.isUnique, serviceSpecCharacteristic.isUnique) &&
        Objects.equals(this.maxCardinality, serviceSpecCharacteristic.maxCardinality) &&
        Objects.equals(this.minCardinality, serviceSpecCharacteristic.minCardinality) &&
        Objects.equals(this.name, serviceSpecCharacteristic.name) &&
        Objects.equals(this.regex, serviceSpecCharacteristic.regex) &&
        Objects.equals(this.serviceSpecCharRelationship, serviceSpecCharacteristic.serviceSpecCharRelationship) &&
        Objects.equals(this.serviceSpecCharacteristicValue, serviceSpecCharacteristic.serviceSpecCharacteristicValue) &&
        Objects.equals(this.uuid, serviceSpecCharacteristic.uuid) &&
        Objects.equals(this.validFor, serviceSpecCharacteristic.validFor) &&
        Objects.equals(this.valueType, serviceSpecCharacteristic.valueType);
  }

 
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, valueSchemaLocation, configurable, description, extensible, href, id, isUnique, maxCardinality, minCardinality, name, regex, serviceSpecCharRelationship, serviceSpecCharacteristicValue, uuid, validFor, valueType);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceSpecCharacteristic {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    valueSchemaLocation: ").append(toIndentedString(valueSchemaLocation)).append("\n");
    sb.append("    configurable: ").append(toIndentedString(configurable)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    extensible: ").append(toIndentedString(extensible)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    isUnique: ").append(toIndentedString(isUnique)).append("\n");
    sb.append("    maxCardinality: ").append(toIndentedString(maxCardinality)).append("\n");
    sb.append("    minCardinality: ").append(toIndentedString(minCardinality)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    regex: ").append(toIndentedString(regex)).append("\n");
    sb.append("    serviceSpecCharRelationship: ").append(toIndentedString(serviceSpecCharRelationship)).append("\n");
    sb.append("    serviceSpecCharacteristicValue: ").append(toIndentedString(serviceSpecCharacteristicValue)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    valueType: ").append(toIndentedString(valueType)).append("\n");
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

