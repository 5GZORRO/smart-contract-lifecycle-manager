package eu._5gzorro.tm_forum.models.product;

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
 * A ProductSpecificationCharacteristicValue object is used to define a set of attributes, each of which can be assigned to a corresponding set of attributes in a ProductSpecificationCharacteristic object. The values of the attributes in the ProductSpecificationCharacteristicValue object describe the values of the attributes that a corresponding ProductSpecificationCharacteristic object can take on.
 */
@ApiModel(description = "A ProductSpecificationCharacteristicValue object is used to define a set of attributes, each of which can be assigned to a corresponding set of attributes in a ProductSpecificationCharacteristic object. The values of the attributes in the ProductSpecificationCharacteristicValue object describe the values of the attributes that a corresponding ProductSpecificationCharacteristic object can take on.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-02-09T15:56:41.618Z")

@Entity
@Table(name = "product_specification_characteristic_values")
public class ProductSpecificationCharacteristicValue {

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
  private String valueFrom = null;

  @JsonProperty("valueTo")
  @Column(name = "value_to")
  private String valueTo = null;

  @JsonProperty("valueType")
  @Column(name = "value_type")
  private String valueType = null;

  public ProductSpecificationCharacteristicValue baseType(String baseType) {
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

  public ProductSpecificationCharacteristicValue schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public ProductSpecificationCharacteristicValue type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(value = "")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ProductSpecificationCharacteristicValue href(String href) {
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

  public ProductSpecificationCharacteristicValue isDefault(Boolean isDefault) {
    this.isDefault = isDefault;
    return this;
  }

  /**
   * Indicates if the value is the default value for a characteristic
   * @return isDefault
  **/
  @ApiModelProperty(value = "Indicates if the value is the default value for a characteristic")


  public Boolean isIsDefault() {
    return isDefault;
  }

  public void setIsDefault(Boolean isDefault) {
    this.isDefault = isDefault;
  }

  public ProductSpecificationCharacteristicValue rangeInterval(String rangeInterval) {
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

  public ProductSpecificationCharacteristicValue regex(String regex) {
    this.regex = regex;
    return this;
  }

  /**
   * Regular expression to define constraint on the allowed value
   * @return regex
  **/
  @ApiModelProperty(value = "Regular expression to define constraint on the allowed value")


  public String getRegex() {
    return regex;
  }

  public void setRegex(String regex) {
    this.regex = regex;
  }

  public ProductSpecificationCharacteristicValue unitOfMeasure(String unitOfMeasure) {
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

  public ProductSpecificationCharacteristicValue uuid(String uuid) {
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

  public ProductSpecificationCharacteristicValue validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which the entity is valid
   * @return validFor
  **/
  @ApiModelProperty(value = "The period for which the entity is valid")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public ProductSpecificationCharacteristicValue value(Any value) {
    this.value = value;
    return this;
  }

  /**
   * A discrete value that the characteristic can take on, or the actual value of the characteristic
   * @return value
  **/
  @ApiModelProperty(value = "A discrete value that the characteristic can take on, or the actual value of the characteristic")

  @Valid

  public Any getValue() {
    return value;
  }

  public void setValue(Any value) {
    this.value = value;
  }

  public ProductSpecificationCharacteristicValue valueFrom(String valueFrom) {
    this.valueFrom = valueFrom;
    return this;
  }

  /**
   * The low range value that a characteristic can take on
   * @return valueFrom
  **/
  @ApiModelProperty(value = "The low range value that a characteristic can take on")


  public String getValueFrom() {
    return valueFrom;
  }

  public void setValueFrom(String valueFrom) {
    this.valueFrom = valueFrom;
  }

  public ProductSpecificationCharacteristicValue valueTo(String valueTo) {
    this.valueTo = valueTo;
    return this;
  }

  /**
   * The upper range value that a characteristic can take on
   * @return valueTo
  **/
  @ApiModelProperty(value = "The upper range value that a characteristic can take on")


  public String getValueTo() {
    return valueTo;
  }

  public void setValueTo(String valueTo) {
    this.valueTo = valueTo;
  }

  public ProductSpecificationCharacteristicValue valueType(String valueType) {
    this.valueType = valueType;
    return this;
  }

  /**
   * A kind of value that the characteristic can take on, such as numeric, text, and so forth
   * @return valueType
  **/
  @ApiModelProperty(value = "A kind of value that the characteristic can take on, such as numeric, text, and so forth")


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
    ProductSpecificationCharacteristicValue productSpecificationCharacteristicValue = (ProductSpecificationCharacteristicValue) o;
    return Objects.equals(this.baseType, productSpecificationCharacteristicValue.baseType) &&
        Objects.equals(this.schemaLocation, productSpecificationCharacteristicValue.schemaLocation) &&
        Objects.equals(this.type, productSpecificationCharacteristicValue.type) &&
        Objects.equals(this.href, productSpecificationCharacteristicValue.href) &&
        Objects.equals(this.isDefault, productSpecificationCharacteristicValue.isDefault) &&
        Objects.equals(this.rangeInterval, productSpecificationCharacteristicValue.rangeInterval) &&
        Objects.equals(this.regex, productSpecificationCharacteristicValue.regex) &&
        Objects.equals(this.unitOfMeasure, productSpecificationCharacteristicValue.unitOfMeasure) &&
        Objects.equals(this.uuid, productSpecificationCharacteristicValue.uuid) &&
        Objects.equals(this.validFor, productSpecificationCharacteristicValue.validFor) &&
        Objects.equals(this.value, productSpecificationCharacteristicValue.value) &&
        Objects.equals(this.valueFrom, productSpecificationCharacteristicValue.valueFrom) &&
        Objects.equals(this.valueTo, productSpecificationCharacteristicValue.valueTo) &&
        Objects.equals(this.valueType, productSpecificationCharacteristicValue.valueType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, href, isDefault, rangeInterval, regex, unitOfMeasure, uuid, validFor, value, valueFrom, valueTo, valueType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductSpecificationCharacteristicValue {\n");
    
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

