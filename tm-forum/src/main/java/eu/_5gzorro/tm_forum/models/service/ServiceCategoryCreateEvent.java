package eu._5gzorro.tm_forum.models.service;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * The event data structure
 */
@ApiModel(description = "The event data structure")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-02-10T10:03:19.238Z")




public class ServiceCategoryCreateEvent   {
  @JsonProperty("serviceCategory")
  private ServiceCategory serviceCategory = null;

  public ServiceCategoryCreateEvent serviceCategory(ServiceCategory serviceCategory) {
    this.serviceCategory = serviceCategory;
    return this;
  }

  /**
   * The involved resource data for the event
   * @return serviceCategory
  **/
  @ApiModelProperty(value = "The involved resource data for the event")

  @Valid

  public ServiceCategory getServiceCategory() {
    return serviceCategory;
  }

  public void setServiceCategory(ServiceCategory serviceCategory) {
    this.serviceCategory = serviceCategory;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceCategoryCreateEvent serviceCategoryCreateEvent = (ServiceCategoryCreateEvent) o;
    return Objects.equals(this.serviceCategory, serviceCategoryCreateEvent.serviceCategory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceCategory);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceCategoryCreateEvent {\n");
    
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

