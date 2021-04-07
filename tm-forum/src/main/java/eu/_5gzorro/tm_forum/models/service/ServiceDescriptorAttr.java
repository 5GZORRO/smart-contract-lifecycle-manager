package eu._5gzorro.tm_forum.models.service;

import java.util.Objects;

/**
 * ServiceDescriptorAttr
 */






public class ServiceDescriptorAttr   {

  private String name = null;


  private String uuid = null;


  private String value = null;

  public ServiceDescriptorAttr name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   *
  **/



  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ServiceDescriptorAttr uuid(String uuid) {
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

  public ServiceDescriptorAttr value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   *
  **/



  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }



  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceDescriptorAttr serviceDescriptorAttr = (ServiceDescriptorAttr) o;
    return Objects.equals(this.name, serviceDescriptorAttr.name) &&
        Objects.equals(this.uuid, serviceDescriptorAttr.uuid) &&
        Objects.equals(this.value, serviceDescriptorAttr.value);
  }


  public int hashCode() {
    return Objects.hash(name, uuid, value);
  }


  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceDescriptorAttr {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

