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
 * A migration, substitution, dependency or exclusivity relationship between/among resource specifications.
 */
@ApiModel(description = "A migration, substitution, dependency or exclusivity relationship between/among resource specifications.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-02-10T10:00:31.056Z")

@Entity
@Table(name = "resource_spec_relationships")
public class ResourceSpecRelationship {

  @JsonProperty("@baseType")
  @Column(name = "base_type")
  private String baseType = null;

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

  @JsonProperty("role")
  private String role = null;

  @JsonIgnore
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String uuid = null;

  @JsonProperty("validFor")
  @Column(name = "valid_for")
  @Embedded
  private TimePeriod validFor = null;

  public ResourceSpecRelationship baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * Get baseType
   * @return baseType
  **/
  @ApiModelProperty(value = "")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public ResourceSpecRelationship type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Type of relationship such as migration, substitution, dependency, exclusivity
   * @return type
  **/
  @ApiModelProperty(value = "Type of relationship such as migration, substitution, dependency, exclusivity")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ResourceSpecRelationship href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the target ResourceSpecification
   * @return href
  **/
  @ApiModelProperty(value = "Reference of the target ResourceSpecification")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ResourceSpecRelationship id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of target ResourceSpecification
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of target ResourceSpecification")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ResourceSpecRelationship name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name given to the target resource specification instance
   * @return name
  **/
  @ApiModelProperty(value = "The name given to the target resource specification instance")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ResourceSpecRelationship relationshipType(String relationshipType) {
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

  public ResourceSpecRelationship role(String role) {
    this.role = role;
    return this;
  }

  /**
   * The association role for this resource specification
   * @return role
  **/
  @ApiModelProperty(value = "The association role for this resource specification")


  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public ResourceSpecRelationship uuid(String uuid) {
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

  public ResourceSpecRelationship validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period for which the ResourceSpecRelationship is valid
   * @return validFor
  **/
  @ApiModelProperty(value = "The period for which the ResourceSpecRelationship is valid")

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
    ResourceSpecRelationship resourceSpecRelationship = (ResourceSpecRelationship) o;
    return Objects.equals(this.baseType, resourceSpecRelationship.baseType) &&
        Objects.equals(this.type, resourceSpecRelationship.type) &&
        Objects.equals(this.href, resourceSpecRelationship.href) &&
        Objects.equals(this.id, resourceSpecRelationship.id) &&
        Objects.equals(this.name, resourceSpecRelationship.name) &&
        Objects.equals(this.relationshipType, resourceSpecRelationship.relationshipType) &&
        Objects.equals(this.role, resourceSpecRelationship.role) &&
        Objects.equals(this.uuid, resourceSpecRelationship.uuid) &&
        Objects.equals(this.validFor, resourceSpecRelationship.validFor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseType, type, href, id, name, relationshipType, role, uuid, validFor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceSpecRelationship {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
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

