package eu._5gzorro.tm_forum.models.product_order;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import eu._5gzorro.tm_forum.models.Quantity;

import java.util.Objects;


/**
 * Description of a productTerm linked to this orderItem. This represent a commitment with a duration. Duration or name must be provided.
 */
public class OrderTerm {
  private String name;
  private String description;
  private Quantity duration;

  public static final String JSON_PROPERTY_AT_TYPE = "@type";
  private String atType;


  public OrderTerm name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the productOrderTerm.
   * @return name
  **/
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public OrderTerm description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Description of the productOrderTerm.
   * @return description
  **/
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public OrderTerm duration(Quantity duration) {
    this.duration = duration;
    return this;
  }

   /**
   * Get duration
   * @return duration
  **/
  public Quantity getDuration() {
    return duration;
  }

  public void setDuration(Quantity duration) {
    this.duration = duration;
  }


  public OrderTerm atType(String atType) {
    this.atType = atType;
    return this;
  }

   /**
   * Indicated the type of Term.
   * @return atType
  **/
  @JsonProperty(JSON_PROPERTY_AT_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getAtType() {
    return atType;
  }

  @JsonProperty(JSON_PROPERTY_AT_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAtType(String atType) {
    this.atType = atType;
  }

  /**
   * Return true if this OrderTerm object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderTerm orderTerm = (OrderTerm) o;
    return Objects.equals(this.name, orderTerm.name) &&
        Objects.equals(this.description, orderTerm.description) &&
        Objects.equals(this.duration, orderTerm.duration) &&
        Objects.equals(this.atType, orderTerm.atType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, duration, atType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderTerm {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    atType: ").append(toIndentedString(atType)).append("\n");
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

