package eu._5gzorro.tm_forum.models.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This model will hold information that will help later on service orchestration.
 */







public class ServiceDescriptor   {
 
 
  private List<ServiceDescriptorAttr> metadata = null;

 
  private String rootEntityID = null;

 
  private String rootEntityType = null;

 
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
   *
  **/
 

 

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
   *
  **/
 


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
   *
  **/
 


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
   *
  **/
 


  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }


 
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

 
  public int hashCode() {
    return Objects.hash(metadata, rootEntityID, rootEntityType, uuid);
  }

 
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

