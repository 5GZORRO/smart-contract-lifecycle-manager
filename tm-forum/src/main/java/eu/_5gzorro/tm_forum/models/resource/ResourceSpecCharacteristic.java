package eu._5gzorro.tm_forum.models.resource;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.tmf_offering_catalog.information_models.TimePeriod;
import it.nextworks.tmf_offering_catalog.information_models.resource.ResourceSpecCharRelationship;
import it.nextworks.tmf_offering_catalog.information_models.resource.ResourceSpecCharacteristicValue;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;

/**
 * This class defines the characteristic features of a resource specification. Every ResourceSpecification has a variety of important attributes, methods, constraints, and relationships, which distinguish a resource specification from other resource specifications.
 */
@ApiModel(description = "This class defines the characteristic features of a resource specification. Every ResourceSpecification has a variety of important attributes, methods, constraints, and relationships, which distinguish a resource specification from other resource specifications.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-02-10T10:00:31.056Z")

@Entity
@Table(name = "resource_spec_characteristics")
public class ResourceSpecCharacteristic   {

  @JsonProperty("@baseType")
  @Column(name = "base_type")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  @Column(name = "schema_location")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("@valueSchemaLocation")
  @Column(name = "value_schema_location")
  private String valueSchemaLocation = null;

  @JsonProperty("configurable")
  private Boolean configurable = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("extensible")
  private Boolean extensible = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("isUnique")
  @Column(name = "is_unique")
  private Boolean isUnique = null;

  @JsonProperty("maxCardinality")
  @Column(name = "max_cardinality")
  private Integer maxCardinality = null;

  @JsonProperty("minCardinality")
  @Column(name = "min_cardinality")
  private Integer minCardinality = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("regex")
  private String regex = null;

  @JsonProperty("resourceSpecCharRelationship")
  @Valid
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "resource_spec_characteristic_fk", referencedColumnName = "uuid")
  private List<ResourceSpecCharRelationship> resourceSpecCharRelationship = null;

  @JsonProperty("resourceSpecCharacteristicValue")
  @Valid
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "resource_spec_characteristic_fk", referencedColumnName = "uuid")
  private List<ResourceSpecCharacteristicValue> resourceSpecCharacteristicValue = null;

  @JsonIgnore
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String uuid = null;

  @JsonProperty("validFor")
  @Column(name = "valid_for")
  @Embedded
  private TimePeriod validFor = null;

  @JsonProperty("valueType")
  @Column(name = "value_type")
  private String valueType = null;

  public ResourceSpecCharacteristic baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return baseType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the super-class")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public ResourceSpecCharacteristic schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A link to the schema describing this characteristic specification
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "A link to the schema describing this characteristic specification")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public ResourceSpecCharacteristic type(String type) {
    this.type = type;
    return this;
  }

  /**
   * (Class) type of the ResourceSpecCharacteristic
   * @return type
  **/
  @ApiModelProperty(value = "(Class) type of the ResourceSpecCharacteristic")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ResourceSpecCharacteristic valueSchemaLocation(String valueSchemaLocation) {
    this.valueSchemaLocation = valueSchemaLocation;
    return this;
  }

  /**
   * This (optional) field provides a link to the schema describing the value type
   * @return valueSchemaLocation
  **/
  @ApiModelProperty(value = "This (optional) field provides a link to the schema describing the value type")


  public String getValueSchemaLocation() {
    return valueSchemaLocation;
  }

  public void setValueSchemaLocation(String valueSchemaLocation) {
    this.valueSchemaLocation = valueSchemaLocation;
  }

  public ResourceSpecCharacteristic configurable(Boolean configurable) {
    this.configurable = configurable;
    return this;
  }

  /**
   * If true, the Boolean indicates that the ResourceSpecCharacteristic is configurable
   * @return configurable
  **/
  @ApiModelProperty(value = "If true, the Boolean indicates that the ResourceSpecCharacteristic is configurable")


  public Boolean isConfigurable() {
    return configurable;
  }

  public void setConfigurable(Boolean configurable) {
    this.configurable = configurable;
  }

  public ResourceSpecCharacteristic description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A narrative that explains the CharacteristicSpecification.
   * @return description
  **/
  @ApiModelProperty(value = "A narrative that explains the CharacteristicSpecification.")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ResourceSpecCharacteristic extensible(Boolean extensible) {
    this.extensible = extensible;
    return this;
  }

  /**
   * An indicator that specifies that the values for the characteristic can be extended by adding new values when instantiating a characteristic for a resource.
   * @return extensible
  **/
  @ApiModelProperty(value = "An indicator that specifies that the values for the characteristic can be extended by adding new values when instantiating a characteristic for a resource.")


  public Boolean isExtensible() {
    return extensible;
  }

  public void setExtensible(Boolean extensible) {
    this.extensible = extensible;
  }

  public ResourceSpecCharacteristic href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Unique reference of the entity
   * @return href
  **/
  @ApiModelProperty(value = "Unique reference of the entity")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ResourceSpecCharacteristic isUnique(Boolean isUnique) {
    this.isUnique = isUnique;
    return this;
  }

  /**
   * An indicator that specifies if a value is unique for the specification. Possible values are; \"unique while value is in effect\" and \"unique whether value is in effect or not\"
   * @return isUnique
  **/
  @ApiModelProperty(value = "An indicator that specifies if a value is unique for the specification. Possible values are; \"unique while value is in effect\" and \"unique whether value is in effect or not\"")


  public Boolean isIsUnique() {
    return isUnique;
  }

  public void setIsUnique(Boolean isUnique) {
    this.isUnique = isUnique;
  }

  public ResourceSpecCharacteristic maxCardinality(Integer maxCardinality) {
    this.maxCardinality = maxCardinality;
    return this;
  }

  /**
   * The maximum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where five is the value for the maxCardinality.
   * @return maxCardinality
  **/
  @ApiModelProperty(value = "The maximum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where five is the value for the maxCardinality.")


  public Integer getMaxCardinality() {
    return maxCardinality;
  }

  public void setMaxCardinality(Integer maxCardinality) {
    this.maxCardinality = maxCardinality;
  }

  public ResourceSpecCharacteristic minCardinality(Integer minCardinality) {
    this.minCardinality = minCardinality;
    return this;
  }

  /**
   * The minimum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where zero is the value for the minCardinality.
   * @return minCardinality
  **/
  @ApiModelProperty(value = "The minimum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where zero is the value for the minCardinality.")


  public Integer getMinCardinality() {
    return minCardinality;
  }

  public void setMinCardinality(Integer minCardinality) {
    this.minCardinality = minCardinality;
  }

  public ResourceSpecCharacteristic name(String name) {
    this.name = name;
    return this;
  }

  /**
   * A word, term, or phrase by which this characteristic specification is known and distinguished from other characteristic specifications.
   * @return name
  **/
  @ApiModelProperty(value = "A word, term, or phrase by which this characteristic specification is known and distinguished from other characteristic specifications.")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ResourceSpecCharacteristic regex(String regex) {
    this.regex = regex;
    return this;
  }

  /**
   * A rule or principle represented in regular expression used to derive the value of a characteristic value.
   * @return regex
  **/
  @ApiModelProperty(value = "A rule or principle represented in regular expression used to derive the value of a characteristic value.")


  public String getRegex() {
    return regex;
  }

  public void setRegex(String regex) {
    this.regex = regex;
  }

  public ResourceSpecCharacteristic resourceSpecCharRelationship(List<ResourceSpecCharRelationship> resourceSpecCharRelationship) {
    this.resourceSpecCharRelationship = resourceSpecCharRelationship;
    return this;
  }

  public ResourceSpecCharacteristic addResourceSpecCharRelationshipItem(ResourceSpecCharRelationship resourceSpecCharRelationshipItem) {
    if (this.resourceSpecCharRelationship == null) {
      this.resourceSpecCharRelationship = new ArrayList<ResourceSpecCharRelationship>();
    }
    this.resourceSpecCharRelationship.add(resourceSpecCharRelationshipItem);
    return this;
  }

  /**
   * Get resourceSpecCharRelationship
   * @return resourceSpecCharRelationship
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ResourceSpecCharRelationship> getResourceSpecCharRelationship() {
    return resourceSpecCharRelationship;
  }

  public void setResourceSpecCharRelationship(List<ResourceSpecCharRelationship> resourceSpecCharRelationship) {
    this.resourceSpecCharRelationship = resourceSpecCharRelationship;
  }

  public ResourceSpecCharacteristic resourceSpecCharacteristicValue(List<ResourceSpecCharacteristicValue> resourceSpecCharacteristicValue) {
    this.resourceSpecCharacteristicValue = resourceSpecCharacteristicValue;
    return this;
  }

  public ResourceSpecCharacteristic addResourceSpecCharacteristicValueItem(ResourceSpecCharacteristicValue resourceSpecCharacteristicValueItem) {
    if (this.resourceSpecCharacteristicValue == null) {
      this.resourceSpecCharacteristicValue = new ArrayList<ResourceSpecCharacteristicValue>();
    }
    this.resourceSpecCharacteristicValue.add(resourceSpecCharacteristicValueItem);
    return this;
  }

  /**
   * Get resourceSpecCharacteristicValue
   * @return resourceSpecCharacteristicValue
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ResourceSpecCharacteristicValue> getResourceSpecCharacteristicValue() {
    return resourceSpecCharacteristicValue;
  }

  public void setResourceSpecCharacteristicValue(List<ResourceSpecCharacteristicValue> resourceSpecCharacteristicValue) {
    this.resourceSpecCharacteristicValue = resourceSpecCharacteristicValue;
  }

  public ResourceSpecCharacteristic uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

  /**
   * Get uuid
   * @return uuid
  **/
  @ApiModelProperty(value = "")


  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public ResourceSpecCharacteristic validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period of time for which a characteristic is applicable.
   * @return validFor
  **/
  @ApiModelProperty(value = "The period of time for which a characteristic is applicable.")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public ResourceSpecCharacteristic valueType(String valueType) {
    this.valueType = valueType;
    return this;
  }

  /**
   * A kind of value that the characteristic can take on, such as numeric, text and so forth
   * @return valueType
  **/
  @ApiModelProperty(value = "A kind of value that the characteristic can take on, such as numeric, text and so forth")


  public String getValueType() {
    return valueType;
  }

  public void setValueType(String valueType) {
    this.valueType = valueType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceSpecCharacteristic resourceSpecCharacteristic = (ResourceSpecCharacteristic) o;
    return Objects.equals(this.baseType, resourceSpecCharacteristic.baseType) &&
        Objects.equals(this.schemaLocation, resourceSpecCharacteristic.schemaLocation) &&
        Objects.equals(this.type, resourceSpecCharacteristic.type) &&
        Objects.equals(this.valueSchemaLocation, resourceSpecCharacteristic.valueSchemaLocation) &&
        Objects.equals(this.configurable, resourceSpecCharacteristic.configurable) &&
        Objects.equals(this.description, resourceSpecCharacteristic.description) &&
        Objects.equals(this.extensible, resourceSpecCharacteristic.extensible) &&
        Objects.equals(this.href, resourceSpecCharacteristic.href) &&
        Objects.equals(this.isUnique, resourceSpecCharacteristic.isUnique) &&
        Objects.equals(this.maxCardinality, resourceSpecCharacteristic.maxCardinality) &&
        Objects.equals(this.minCardinality, resourceSpecCharacteristic.minCardinality) &&
        Objects.equals(this.name, resourceSpecCharacteristic.name) &&
        Objects.equals(this.regex, resourceSpecCharacteristic.regex) &&
        Objects.equals(this.resourceSpecCharRelationship, resourceSpecCharacteristic.resourceSpecCharRelationship) &&
        Objects.equals(this.resourceSpecCharacteristicValue, resourceSpecCharacteristic.resourceSpecCharacteristicValue) &&
        Objects.equals(this.uuid, resourceSpecCharacteristic.uuid) &&
        Objects.equals(this.validFor, resourceSpecCharacteristic.validFor) &&
        Objects.equals(this.valueType, resourceSpecCharacteristic.valueType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, valueSchemaLocation, configurable, description, extensible, href, isUnique, maxCardinality, minCardinality, name, regex, resourceSpecCharRelationship, resourceSpecCharacteristicValue, uuid, validFor, valueType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceSpecCharacteristic {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    valueSchemaLocation: ").append(toIndentedString(valueSchemaLocation)).append("\n");
    sb.append("    configurable: ").append(toIndentedString(configurable)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    extensible: ").append(toIndentedString(extensible)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    isUnique: ").append(toIndentedString(isUnique)).append("\n");
    sb.append("    maxCardinality: ").append(toIndentedString(maxCardinality)).append("\n");
    sb.append("    minCardinality: ").append(toIndentedString(minCardinality)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    regex: ").append(toIndentedString(regex)).append("\n");
    sb.append("    resourceSpecCharRelationship: ").append(toIndentedString(resourceSpecCharRelationship)).append("\n");
    sb.append("    resourceSpecCharacteristicValue: ").append(toIndentedString(resourceSpecCharacteristicValue)).append("\n");
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

