package eu._5gzorro.tm_forum.models.product_order;

import java.util.Objects;

/** */
public class ProductRelationship {
  private RelationShipType type;
  private Product product;

  public ProductRelationship type(RelationShipType type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   *
   * @return type
   */
  public RelationShipType getType() {
    return type;
  }

  public void setType(RelationShipType type) {
    this.type = type;
  }

  public ProductRelationship product(Product product) {
    this.product = product;
    return this;
  }

  /**
   * Get product
   *
   * @return product
   */
  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  /** Return true if this ProductRelationship object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductRelationship productRelationship = (ProductRelationship) o;
    return Objects.equals(this.type, productRelationship.type)
        && Objects.equals(this.product, productRelationship.product);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, product);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductRelationship {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
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
