package eu._5gzorro.tm_forum.models.product_order;

import java.util.Objects;

/**
 * A product offering represents entities that are order-able from the provider of the catalog, this
 * resource includes pricing information.
 */
public class ProductOfferingRef {
  private String id;
  private String href;
  private String name;
  private String atReferredType;

  public ProductOfferingRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the product offering.
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ProductOfferingRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the product offering.
   *
   * @return href
   */
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ProductOfferingRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the product offering.
   *
   * @return name
   */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductOfferingRef atReferredType(String atReferredType) {
    this.atReferredType = atReferredType;
    return this;
  }

  /**
   * Indicate the class (type) of product offering.
   *
   * @return atReferredType
   */
  public String getAtReferredType() {
    return atReferredType;
  }

  public void setAtReferredType(String atReferredType) {
    this.atReferredType = atReferredType;
  }

  /** Return true if this ProductOfferingRef object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductOfferingRef productOfferingRef = (ProductOfferingRef) o;
    return Objects.equals(this.id, productOfferingRef.id)
        && Objects.equals(this.href, productOfferingRef.href)
        && Objects.equals(this.name, productOfferingRef.name)
        && Objects.equals(this.atReferredType, productOfferingRef.atReferredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, atReferredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductOfferingRef {\n");
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
