package eu._5gzorro.tm_forum.models.service;

import java.util.Objects;

/**
 * The event data structure
 */







public class ServiceCatalogBatchEvent   {
 
  private ServiceCatalog serviceCatalog = null;

  public ServiceCatalogBatchEvent serviceCatalog(ServiceCatalog serviceCatalog) {
    this.serviceCatalog = serviceCatalog;
    return this;
  }

  /**
   * The involved resource data for the event
   *
  **/
 

 

  public ServiceCatalog getServiceCatalog() {
    return serviceCatalog;
  }

  public void setServiceCatalog(ServiceCatalog serviceCatalog) {
    this.serviceCatalog = serviceCatalog;
  }


 
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceCatalogBatchEvent serviceCatalogBatchEvent = (ServiceCatalogBatchEvent) o;
    return Objects.equals(this.serviceCatalog, serviceCatalogBatchEvent.serviceCatalog);
  }

 
  public int hashCode() {
    return Objects.hash(serviceCatalog);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceCatalogBatchEvent {\n");
    
    sb.append("    serviceCatalog: ").append(toIndentedString(serviceCatalog)).append("\n");
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

