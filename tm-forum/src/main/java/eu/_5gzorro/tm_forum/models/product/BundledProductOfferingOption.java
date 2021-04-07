package eu._5gzorro.tm_forum.models.product;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

/**
 * A set of numbers that specifies the lower and upper limits for a ProductOffering that can be procured as part of the related BundledProductOffering. Values can range from 0 to unbounded
 */
@ApiModel(description = "A set of numbers that specifies the lower and upper limits for a ProductOffering that can be procured as part of the related BundledProductOffering. Values can range from 0 to unbounded")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-02-09T15:56:41.618Z")

@Entity
@Table(name = "bundled_product_offering_options")
public class BundledProductOfferingOption {

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

  @JsonProperty("numberRelOfferDefault")
  @Column(name = "number_rel_offer_default")
  private Integer numberRelOfferDefault = null;

  @JsonProperty("numberRelOfferLowerLimit")
  @Column(name = "number_rel_offer_lower_limit")
  private Integer numberRelOfferLowerLimit = null;

  @JsonProperty("numberRelOfferUpperLimit")
  @Column(name = "number_rel_offer_upper_limit")
  private Integer numberRelOfferUpperLimit = null;

  @JsonIgnore
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String uuid = null;

  public BundledProductOfferingOption baseType(String baseType) {
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

  public BundledProductOfferingOption schemaLocation(String schemaLocation) {
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

  public BundledProductOfferingOption type(String type) {
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

  public BundledProductOfferingOption href(String href) {
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

  public BundledProductOfferingOption numberRelOfferDefault(Integer numberRelOfferDefault) {
    this.numberRelOfferDefault = numberRelOfferDefault;
    return this;
  }

  /**
   * Default number of produc offereings that should be procured as part of the related BundledProductOffering
   * @return numberRelOfferDefault
  **/
  @ApiModelProperty(value = "Default number of produc offereings that should be procured as part of the related BundledProductOffering")


  public Integer getNumberRelOfferDefault() {
    return numberRelOfferDefault;
  }

  public void setNumberRelOfferDefault(Integer numberRelOfferDefault) {
    this.numberRelOfferDefault = numberRelOfferDefault;
  }

  public BundledProductOfferingOption numberRelOfferLowerLimit(Integer numberRelOfferLowerLimit) {
    this.numberRelOfferLowerLimit = numberRelOfferLowerLimit;
    return this;
  }

  /**
   * lower limit for a product offering that can be procured as part of the related BundledProductOffering
   * @return numberRelOfferLowerLimit
  **/
  @ApiModelProperty(value = "lower limit for a product offering that can be procured as part of the related BundledProductOffering")


  public Integer getNumberRelOfferLowerLimit() {
    return numberRelOfferLowerLimit;
  }

  public void setNumberRelOfferLowerLimit(Integer numberRelOfferLowerLimit) {
    this.numberRelOfferLowerLimit = numberRelOfferLowerLimit;
  }

  public BundledProductOfferingOption numberRelOfferUpperLimit(Integer numberRelOfferUpperLimit) {
    this.numberRelOfferUpperLimit = numberRelOfferUpperLimit;
    return this;
  }

  /**
   * upper limit for a product offering that can be procured as part of the related BundledProductOffering
   * @return numberRelOfferUpperLimit
  **/
  @ApiModelProperty(value = "upper limit for a product offering that can be procured as part of the related BundledProductOffering")


  public Integer getNumberRelOfferUpperLimit() {
    return numberRelOfferUpperLimit;
  }

  public void setNumberRelOfferUpperLimit(Integer numberRelOfferUpperLimit) {
    this.numberRelOfferUpperLimit = numberRelOfferUpperLimit;
  }

  public BundledProductOfferingOption uuid(String uuid) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BundledProductOfferingOption bundledProductOfferingOption = (BundledProductOfferingOption) o;
    return Objects.equals(this.baseType, bundledProductOfferingOption.baseType) &&
        Objects.equals(this.schemaLocation, bundledProductOfferingOption.schemaLocation) &&
        Objects.equals(this.type, bundledProductOfferingOption.type) &&
        Objects.equals(this.href, bundledProductOfferingOption.href) &&
        Objects.equals(this.numberRelOfferDefault, bundledProductOfferingOption.numberRelOfferDefault) &&
        Objects.equals(this.numberRelOfferLowerLimit, bundledProductOfferingOption.numberRelOfferLowerLimit) &&
        Objects.equals(this.numberRelOfferUpperLimit, bundledProductOfferingOption.numberRelOfferUpperLimit) &&
        Objects.equals(this.uuid, bundledProductOfferingOption.uuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, href, numberRelOfferDefault, numberRelOfferLowerLimit, numberRelOfferUpperLimit, uuid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BundledProductOfferingOption {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    numberRelOfferDefault: ").append(toIndentedString(numberRelOfferDefault)).append("\n");
    sb.append("    numberRelOfferLowerLimit: ").append(toIndentedString(numberRelOfferLowerLimit)).append("\n");
    sb.append("    numberRelOfferUpperLimit: ").append(toIndentedString(numberRelOfferUpperLimit)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
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

