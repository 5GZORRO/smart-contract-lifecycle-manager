package eu._5gzorro.tm_forum.models.resource;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import it.nextworks.tmf_offering_catalog.information_models.TimePeriod;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;

/**
 * applicable feature(s) for this resource specification.
 */
@ApiModel(description = "applicable feature(s) for this resource specification.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-02-10T10:00:31.056Z")

@Entity
@Table(name = "features")
public class Feature {

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

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("isBundle")
  @Column(name = "is_bundle")
  private Boolean isBundle = null;

  @JsonProperty("isEnabled")
  @Column(name = "is_enabled")
  private Boolean isEnabled = null;

  @JsonProperty("name")
  private String name = null;

  @JsonIgnore
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String uuid = null;

  @JsonProperty("validFor")
  @Column(name = "valid_for")
  @Embedded
  private TimePeriod validFor = null;

  @JsonProperty("version")
  private String version = null;

  public Feature baseType(String baseType) {
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

  public Feature schemaLocation(String schemaLocation) {
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

  public Feature type(String type) {
    this.type = type;
    return this;
  }

  /**
   * The optional (class) type of the feature
   * @return type
  **/
  @ApiModelProperty(value = "The optional (class) type of the feature")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Feature href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Hyperlink reference to the target feature. It is optional if the feature is not defined as a separate REST resource.
   * @return href
  **/
  @ApiModelProperty(value = "Hyperlink reference to the target feature. It is optional if the feature is not defined as a separate REST resource.")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public Feature id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Feature isBundle(Boolean isBundle) {
    this.isBundle = isBundle;
    return this;
  }

  /**
   * A flag indicating if the feature is bundle (true) or not (false).
   * @return isBundle
  **/
  @ApiModelProperty(value = "A flag indicating if the feature is bundle (true) or not (false).")


  public Boolean isIsBundle() {
    return isBundle;
  }

  public void setIsBundle(Boolean isBundle) {
    this.isBundle = isBundle;
  }

  public Feature isEnabled(Boolean isEnabled) {
    this.isEnabled = isEnabled;
    return this;
  }

  /**
   * A flag indicating if the feature is enabled (true) or not (false).
   * @return isEnabled
  **/
  @ApiModelProperty(value = "A flag indicating if the feature is enabled (true) or not (false).")


  public Boolean isIsEnabled() {
    return isEnabled;
  }

  public void setIsEnabled(Boolean isEnabled) {
    this.isEnabled = isEnabled;
  }

  public Feature name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Unique name given to the feature. it is Required if the feature is not introduced as a separate REST resource
   * @return name
  **/
  @ApiModelProperty(value = "Unique name given to the feature. it is Required if the feature is not introduced as a separate REST resource")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Feature uuid(String uuid) {
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

  public Feature validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which this relationship is valid
   * @return validFor
  **/
  @ApiModelProperty(value = "The period for which this relationship is valid")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public Feature version(String version) {
    this.version = version;
    return this;
  }

  /**
   * feature version
   * @return version
  **/
  @ApiModelProperty(value = "feature version")


  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Feature feature = (Feature) o;
    return Objects.equals(this.baseType, feature.baseType) &&
        Objects.equals(this.schemaLocation, feature.schemaLocation) &&
        Objects.equals(this.type, feature.type) &&
        Objects.equals(this.href, feature.href) &&
        Objects.equals(this.id, feature.id) &&
        Objects.equals(this.isBundle, feature.isBundle) &&
        Objects.equals(this.isEnabled, feature.isEnabled) &&
        Objects.equals(this.name, feature.name) &&
        Objects.equals(this.uuid, feature.uuid) &&
        Objects.equals(this.validFor, feature.validFor) &&
        Objects.equals(this.version, feature.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, href, id, isBundle, isEnabled, name, uuid, validFor, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Feature {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
    sb.append("    isEnabled: ").append(toIndentedString(isEnabled)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
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

