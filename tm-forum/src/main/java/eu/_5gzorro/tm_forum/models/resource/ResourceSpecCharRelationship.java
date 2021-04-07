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
 * An aggregation, migration, substitution, dependency or exclusivity relationship between/among Specification Characteristics.
 */
@ApiModel(description = "An aggregation, migration, substitution, dependency or exclusivity relationship between/among Specification Characteristics.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-02-10T10:00:31.056Z")

@Entity
@Table(name = "resource_spec_char_relationships")
public class ResourceSpecCharRelationship {

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("relationshipType")
  @Column(name = "relationship_type")
  private String relationshipType = null;

  @JsonIgnore
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String uuid = null;

  @JsonProperty("validFor")
  @Column(name = "valid_for")
  @Embedded
  private TimePeriod validFor = null;

  public ResourceSpecCharRelationship type(String type) {
    this.type = type;
    return this;
  }

  /**
   * class type of target specification
   * @return type
  **/
  @ApiModelProperty(value = "class type of target specification")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ResourceSpecCharRelationship href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Hyperlink reference to the target specification
   * @return href
  **/
  @ApiModelProperty(value = "Hyperlink reference to the target specification")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ResourceSpecCharRelationship id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the target specification
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the target specification")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ResourceSpecCharRelationship name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the target characteristic
   * @return name
  **/
  @ApiModelProperty(value = "Name of the target characteristic")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ResourceSpecCharRelationship relationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
    return this;
  }

  /**
   * Get relationshipType
   * @return relationshipType
  **/
  @ApiModelProperty(value = "")


  public String getRelationshipType() {
    return relationshipType;
  }

  public void setRelationshipType(String relationshipType) {
    this.relationshipType = relationshipType;
  }

  public ResourceSpecCharRelationship uuid(String uuid) {
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

  public ResourceSpecCharRelationship validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which the object is valid
   * @return validFor
  **/
  @ApiModelProperty(value = "The period for which the object is valid")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceSpecCharRelationship resourceSpecCharRelationship = (ResourceSpecCharRelationship) o;
    return Objects.equals(this.type, resourceSpecCharRelationship.type) &&
        Objects.equals(this.href, resourceSpecCharRelationship.href) &&
        Objects.equals(this.id, resourceSpecCharRelationship.id) &&
        Objects.equals(this.name, resourceSpecCharRelationship.name) &&
        Objects.equals(this.relationshipType, resourceSpecCharRelationship.relationshipType) &&
        Objects.equals(this.uuid, resourceSpecCharRelationship.uuid) &&
        Objects.equals(this.validFor, resourceSpecCharRelationship.validFor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, href, id, name, relationshipType, uuid, validFor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceSpecCharRelationship {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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

