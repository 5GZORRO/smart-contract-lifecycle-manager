package eu._5gzorro.tm_forum.models.service;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.tmf_offering_catalog.information_models.service.ServiceDescriptorAttr;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * This model will hold information that will help later on service orchestration.
 */
@ApiModel(description = "This model will hold information that will help later on service orchestration.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-02-10T10:03:19.238Z")




public class ServiceDescriptor   {
  @JsonProperty("metadata")
  @Valid
  private List<ServiceDescriptorAttr> metadata = null;

  @JsonProperty("rootEntityID")
  private String rootEntityID = null;

  @JsonProperty("rootEntityType")
  private String rootEntityType = null;

  @JsonIgnore
  private String uuid = null;

  public ServiceDescriptor metadata(List<ServiceDescriptorAttr> metadata) {
    this.metadata = metadata;
    return this;
  }

  public ServiceDescriptor addMetadataItem(ServiceDescriptorAttr metadataItem) {
    if (this.metadata == null) {
      this.metadata = new ArrayList<ServiceDescriptorAttr>();
    }
    this.metadata.add(metadataItem);
    return this;
  }

  /**
   * Get metadata
   * @return metadata
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ServiceDescriptorAttr> getMetadata() {
    return metadata;
  }

  public void setMetadata(List<ServiceDescriptorAttr> metadata) {
    this.metadata = metadata;
  }

  public ServiceDescriptor rootEntityID(String rootEntityID) {
    this.rootEntityID = rootEntityID;
    return this;
  }

  /**
   * Get rootEntityID
   * @return rootEntityID
  **/
  @ApiModelProperty(value = "")


  public String getRootEntityID() {
    return rootEntityID;
  }

  public void setRootEntityID(String rootEntityID) {
    this.rootEntityID = rootEntityID;
  }

  public ServiceDescriptor rootEntityType(String rootEntityType) {
    this.rootEntityType = rootEntityType;
    return this;
  }

  /**
   * Get rootEntityType
   * @return rootEntityType
  **/
  @ApiModelProperty(value = "")


  public String getRootEntityType() {
    return rootEntityType;
  }

  public void setRootEntityType(String rootEntityType) {
    this.rootEntityType = rootEntityType;
  }

  public ServiceDescriptor uuid(String uuid) {
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
    ServiceDescriptor serviceDescriptor = (ServiceDescriptor) o;
    return Objects.equals(this.metadata, serviceDescriptor.metadata) &&
        Objects.equals(this.rootEntityID, serviceDescriptor.rootEntityID) &&
        Objects.equals(this.rootEntityType, serviceDescriptor.rootEntityType) &&
        Objects.equals(this.uuid, serviceDescriptor.uuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metadata, rootEntityID, rootEntityType, uuid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceDescriptor {\n");
    
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    rootEntityID: ").append(toIndentedString(rootEntityID)).append("\n");
    sb.append("    rootEntityType: ").append(toIndentedString(rootEntityType)).append("\n");
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

