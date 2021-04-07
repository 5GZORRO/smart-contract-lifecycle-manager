package eu._5gzorro.tm_forum.models.service;

import java.util.Objects;

/**
 * The event data structure
 */







public class ServiceCategoryDeleteEvent   {
 
  private ServiceCategory serviceCategory = null;

  public ServiceCategoryDeleteEvent serviceCategory(ServiceCategory serviceCategory) {
    this.serviceCategory = serviceCategory;
    return this;
  }

  /**
   * The involved resource data for the event
   *
  **/
 

 

  public ServiceCategory getServiceCategory() {
    return serviceCategory;
  }

  public void setServiceCategory(ServiceCategory serviceCategory) {
    this.serviceCategory = serviceCategory;
  }


 
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceCategoryDeleteEvent serviceCategoryDeleteEvent = (ServiceCategoryDeleteEvent) o;
    return Objects.equals(this.serviceCategory, serviceCategoryDeleteEvent.serviceCategory);
  }

 
  public int hashCode() {
    return Objects.hash(serviceCategory);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceCategoryDeleteEvent {\n");
    
    sb.append("    serviceCategory: ").append(toIndentedString(serviceCategory)).append("\n");
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

