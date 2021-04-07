package eu._5gzorro.tm_forum.models.resource;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import it.nextworks.tmf_offering_catalog.information_models.Any;
import it.nextworks.tmf_offering_catalog.information_models.TimePeriod;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;

/**
 * A number or text that can be assigned to a ResourceSpecCharacteristic.
 */
@ApiModel(description = "A number or text that can be assigned to a ResourceSpecCharacteristic.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-02-10T10:00:31.056Z")

@Entity
@Table(name = "resource_spec_characteristic_values")
public class ResourceSpecCharacteristicValue {

  @JsonProperty("@baseType")
  @Column(name = "base_type")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  @Column(name = "schema_location")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("isDefault")
  @Column(name = "is_default")
  private Boolean isDefault = null;

  @JsonProperty("rangeInterval")
  @Column(name = "range_interval")
  private String rangeInterval = null;

  @JsonProperty("regex")
  private String regex = null;

  @JsonProperty("unitOfMeasure")
  @Column(name = "unit_of_measure")
  private String unitOfMeasure = null;

  @JsonIgnore
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String uuid = null;

  @JsonProperty("validFor")
  @Column(name = "valid_for")
  @Embedded
  private TimePeriod validFor = null;

  @JsonProperty("value")
  @Embedded
  private Any value = null;

  @JsonProperty("valueFrom")
  @Column(name = "value_from")
  private Integer valueFrom = null;

  @JsonProperty("valueTo")
  @Column(name = "value_to")
  private Integer valueTo = null;

  @JsonProperty("valueType")
  @Column(name = "value_type")
  private String valueType = null;

  public ResourceSpecCharacteristicValue baseType(String baseType) {
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

  public ResourceSpecCharacteristicValue schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * This (optional) field provides a link to the schema describing the value type
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "This (optional) field provides a link to the schema describing the value type")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public ResourceSpecCharacteristicValue type(String type) {
    this.type = type;
    return this;
  }

  /**
   * The class type of a complex value type
   * @return type
  **/
  @ApiModelProperty(value = "The class type of a complex value type")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ResourceSpecCharacteristicValue href(String href) {
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

  public ResourceSpecCharacteristicValue isDefault(Boolean isDefault) {
    this.isDefault = isDefault;
    return this;
  }

  /**
   * If true, the Boolean Indicates if the value is the default value for a characteristic
   * @return isDefault
  **/
  @ApiModelProperty(value = "If true, the Boolean Indicates if the value is the default value for a characteristic")


  public Boolean isIsDefault() {
    return isDefault;
  }

  public void setIsDefault(Boolean isDefault) {
    this.isDefault = isDefault;
  }

  public ResourceSpecCharacteristicValue rangeInterval(String rangeInterval) {
    this.rangeInterval = rangeInterval;
    return this;
  }

  /**
   * An indicator that specifies the inclusion or exclusion of the valueFrom and valueTo attributes. If applicable, possible values are \"open\", \"closed\", \"closedBottom\" and \"closedTop\".
   * @return rangeInterval
  **/
  @ApiModelProperty(value = "An indicator that specifies the inclusion or exclusion of the valueFrom and valueTo attributes. If applicable, possible values are \"open\", \"closed\", \"closedBottom\" and \"closedTop\".")


  public String getRangeInterval() {
    return rangeInterval;
  }

  public void setRangeInterval(String rangeInterval) {
    this.rangeInterval = rangeInterval;
  }

  public ResourceSpecCharacteristicValue regex(String regex) {
    this.regex = regex;
    return this;
  }

  /**
   * A regular expression constraint for given value
   * @return regex
  **/
  @ApiModelProperty(value = "A regular expression constraint for given value")


  public String getRegex() {
    return regex;
  }

  public void setRegex(String regex) {
    this.regex = regex;
  }

  public ResourceSpecCharacteristicValue unitOfMeasure(String unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
    return this;
  }

  /**
   * A length, surface, volume, dry measure, liquid measure, money, weight, time, and the like. In general, a determinate quantity or magnitude of the kind designated, taken as a standard of comparison for others of the same kind, in assigning to them numerical values, as 1 foot, 1 yard, 1 mile, 1 square foot.
   * @return unitOfMeasure
  **/
  @ApiModelProperty(value = "A length, surface, volume, dry measure, liquid measure, money, weight, time, and the like. In general, a determinate quantity or magnitude of the kind designated, taken as a standard of comparison for others of the same kind, in assigning to them numerical values, as 1 foot, 1 yard, 1 mile, 1 square foot.")


  public String getUnitOfMeasure() {
    return unitOfMeasure;
  }

  public void setUnitOfMeasure(String unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
  }

  public ResourceSpecCharacteristicValue uuid(String uuid) {
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

  public ResourceSpecCharacteristicValue validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period of time for which a value is applicable.
   * @return validFor
  **/
  @ApiModelProperty(value = "The period of time for which a value is applicable.")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public ResourceSpecCharacteristicValue value(Any value) {
    this.value = value;
    return this;
  }

  /**
   * The value that the characteristic can take on. If the value is a complex type, the definition of the type should be found by the link as defined in @schemaLocation
   * @return value
  **/
  @ApiModelProperty(value = "The value that the characteristic can take on. If the value is a complex type, the definition of the type should be found by the link as defined in @schemaLocation")

  @Valid

  public Any getValue() {
    return value;
  }

  public void setValue(Any value) {
    this.value = value;
  }

  public ResourceSpecCharacteristicValue valueFrom(Integer valueFrom) {
    this.valueFrom = valueFrom;
    return this;
  }

  /**
   * The low range value that a characteristic can take on
   * @return valueFrom
  **/
  @ApiModelProperty(value = "The low range value that a characteristic can take on")


  public Integer getValueFrom() {
    return valueFrom;
  }

  public void setValueFrom(Integer valueFrom) {
    this.valueFrom = valueFrom;
  }

  public ResourceSpecCharacteristicValue valueTo(Integer valueTo) {
    this.valueTo = valueTo;
    return this;
  }

  /**
   * The upper range value that a characteristic can take on
   * @return valueTo
  **/
  @ApiModelProperty(value = "The upper range value that a characteristic can take on")


  public Integer getValueTo() {
    return valueTo;
  }

  public void setValueTo(Integer valueTo) {
    this.valueTo = valueTo;
  }

  public ResourceSpecCharacteristicValue valueType(String valueType) {
    this.valueType = valueType;
    return this;
  }

  /**
   * A kind of value that the characteristic value can take on, such as numeric, text and so forth
   * @return valueType
  **/
  @ApiModelProperty(value = "A kind of value that the characteristic value can take on, such as numeric, text and so forth")


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
    ResourceSpecCharacteristicValue resourceSpecCharacteristicValue = (ResourceSpecCharacteristicValue) o;
    return Objects.equals(this.baseType, resourceSpecCharacteristicValue.baseType) &&
        Objects.equals(this.schemaLocation, resourceSpecCharacteristicValue.schemaLocation) &&
        Objects.equals(this.type, resourceSpecCharacteristicValue.type) &&
        Objects.equals(this.href, resourceSpecCharacteristicValue.href) &&
        Objects.equals(this.isDefault, resourceSpecCharacteristicValue.isDefault) &&
        Objects.equals(this.rangeInterval, resourceSpecCharacteristicValue.rangeInterval) &&
        Objects.equals(this.regex, resourceSpecCharacteristicValue.regex) &&
        Objects.equals(this.unitOfMeasure, resourceSpecCharacteristicValue.unitOfMeasure) &&
        Objects.equals(this.uuid, resourceSpecCharacteristicValue.uuid) &&
        Objects.equals(this.validFor, resourceSpecCharacteristicValue.validFor) &&
        Objects.equals(this.value, resourceSpecCharacteristicValue.value) &&
        Objects.equals(this.valueFrom, resourceSpecCharacteristicValue.valueFrom) &&
        Objects.equals(this.valueTo, resourceSpecCharacteristicValue.valueTo) &&
        Objects.equals(this.valueType, resourceSpecCharacteristicValue.valueType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, href, isDefault, rangeInterval, regex, unitOfMeasure, uuid, validFor, value, valueFrom, valueTo, valueType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceSpecCharacteristicValue {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    isDefault: ").append(toIndentedString(isDefault)).append("\n");
    sb.append("    rangeInterval: ").append(toIndentedString(rangeInterval)).append("\n");
    sb.append("    regex: ").append(toIndentedString(regex)).append("\n");
    sb.append("    unitOfMeasure: ").append(toIndentedString(unitOfMeasure)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    valueFrom: ").append(toIndentedString(valueFrom)).append("\n");
    sb.append("    valueTo: ").append(toIndentedString(valueTo)).append("\n");
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

