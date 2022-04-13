package eu._5gzorro.tm_forum.models.product_order;

import java.util.Objects;

/**
 * If an immediate payment has been done at the product order submission, the payment information
 * are captured and stored (as a reference) in the order.
 */
public class PaymentRef {
  private String id;
  private String href;
  private String name;
  private String atReferredType;

  public PaymentRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Identifier of a payment.
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PaymentRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Hyperlink to access to a payment.
   *
   * @return href
   */
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public PaymentRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of a payment.
   *
   * @return name
   */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PaymentRef atReferredType(String atReferredType) {
    this.atReferredType = atReferredType;
    return this;
  }

  /**
   * Indicates the type of resource. Here can be &#39;cash&#39;, &#39;BankCard&#39;, ‘Check’, etc...
   *
   * @return atReferredType
   */
  public String getAtReferredType() {
    return atReferredType;
  }

  public void setAtReferredType(String atReferredType) {
    this.atReferredType = atReferredType;
  }

  /** Return true if this PaymentRef object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentRef paymentRef = (PaymentRef) o;
    return Objects.equals(this.id, paymentRef.id)
        && Objects.equals(this.href, paymentRef.href)
        && Objects.equals(this.name, paymentRef.name)
        && Objects.equals(this.atReferredType, paymentRef.atReferredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, atReferredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentRef {\n");
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
