package eu._5gzorro.tm_forum.models.product_order;

import java.util.Objects;


/**
 * If the product order item requires an appointment between the service provider and the customer.
 */
public class AppointmentRef {
  private String href;
  private String id;
  private String atReferredType;

  public AppointmentRef href(String href) {
    this.href = href;
    return this;
  }

   /**
   * Hyperlink to access the appointment
   * @return href
  **/
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public AppointmentRef id(String id) {
    this.id = id;
    return this;
  }

   /**
   * id of the appointment
   * @return id
  **/
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public AppointmentRef atReferredType(String atReferredType) {
    this.atReferredType = atReferredType;
    return this;
  }

   /**
   * Indicates the (class) type of resource.
   * @return atReferredType
  **/
  public String getAtReferredType() {
    return atReferredType;
  }

  public void setAtReferredType(String atReferredType) {
    this.atReferredType = atReferredType;
  }

  /**
   * Return true if this AppointmentRef object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppointmentRef appointmentRef = (AppointmentRef) o;
    return Objects.equals(this.href, appointmentRef.href) &&
        Objects.equals(this.id, appointmentRef.id) &&
        Objects.equals(this.atReferredType, appointmentRef.atReferredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(href, id, atReferredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppointmentRef {\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    atReferredType: ").append(toIndentedString(atReferredType)).append("\n");
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

