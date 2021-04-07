package eu._5gzorro.tm_forum.models.service;

import java.util.Objects;

/**
 * The event data structure
 */







public class ServiceCandidateChangeEvent   {

  private ServiceCandidate serviceCandidate = null;

  public ServiceCandidateChangeEvent serviceCandidate(ServiceCandidate serviceCandidate) {
    this.serviceCandidate = serviceCandidate;
    return this;
  }

  /**
   * The involved resource data for the event
   *
  **/




  public ServiceCandidate getServiceCandidate() {
    return serviceCandidate;
  }

  public void setServiceCandidate(ServiceCandidate serviceCandidate) {
    this.serviceCandidate = serviceCandidate;
  }



  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceCandidateChangeEvent serviceCandidateChangeEvent = (ServiceCandidateChangeEvent) o;
    return Objects.equals(this.serviceCandidate, serviceCandidateChangeEvent.serviceCandidate);
  }


  public int hashCode() {
    return Objects.hash(serviceCandidate);
  }


  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceCandidateChangeEvent {\n");
    
    sb.append("    serviceCandidate: ").append(toIndentedString(serviceCandidate)).append("\n");
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

