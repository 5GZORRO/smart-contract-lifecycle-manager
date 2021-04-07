package eu._5gzorro.tm_forum.models.service;

import java.util.Objects;

/**
 * The event data structure
 */







public class ServiceSpecificationDeleteEvent   {
 
  private ServiceSpecification serviceSpecification = null;

  public ServiceSpecificationDeleteEvent serviceSpecification(ServiceSpecification serviceSpecification) {
    this.serviceSpecification = serviceSpecification;
    return this;
  }

  /**
   * The involved resource data for the event
   *
  **/
 

 

  public ServiceSpecification getServiceSpecification() {
    return serviceSpecification;
  }

  public void setServiceSpecification(ServiceSpecification serviceSpecification) {
    this.serviceSpecification = serviceSpecification;
  }


 
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceSpecificationDeleteEvent serviceSpecificationDeleteEvent = (ServiceSpecificationDeleteEvent) o;
    return Objects.equals(this.serviceSpecification, serviceSpecificationDeleteEvent.serviceSpecification);
  }

 
  public int hashCode() {
    return Objects.hash(serviceSpecification);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceSpecificationDeleteEvent {\n");
    
    sb.append("    serviceSpecification: ").append(toIndentedString(serviceSpecification)).append("\n");
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

