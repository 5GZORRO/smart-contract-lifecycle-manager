package eu._5gzorro.tm_forum.models.product_order;

import java.util.Objects;

/** A BillingAccount is a detailed description of a bill structure. */
public class BillingAccountRef {
  private String id;
  private String href;
  private String name;
  private String atReferredType;

  public BillingAccountRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the billing account
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public BillingAccountRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Unique reference of the billing account
   *
   * @return href
   */
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public BillingAccountRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the billing account
   *
   * @return name
   */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BillingAccountRef atReferredType(String atReferredType) {
    this.atReferredType = atReferredType;
    return this;
  }

  /**
   * Indicates the (class) type of resource.
   *
   * @return atReferredType
   */
  public String getAtReferredType() {
    return atReferredType;
  }

  public void setAtReferredType(String atReferredType) {
    this.atReferredType = atReferredType;
  }

  /** Return true if this BillingAccountRef object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BillingAccountRef billingAccountRef = (BillingAccountRef) o;
    return Objects.equals(this.id, billingAccountRef.id)
        && Objects.equals(this.href, billingAccountRef.href)
        && Objects.equals(this.name, billingAccountRef.name)
        && Objects.equals(this.atReferredType, billingAccountRef.atReferredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, atReferredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BillingAccountRef {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    atReferredType: ").append(toIndentedString(atReferredType)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
