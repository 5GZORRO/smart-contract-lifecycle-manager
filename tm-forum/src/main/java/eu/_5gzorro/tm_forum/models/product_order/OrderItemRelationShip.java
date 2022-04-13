package eu._5gzorro.tm_forum.models.product_order;

import java.util.Objects;

/** Linked order items to the one instantiate. */
public class OrderItemRelationShip {
  private RelationShipType type;
  private String id;

  public OrderItemRelationShip type(RelationShipType type) {
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

  public OrderItemRelationShip id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The identifier of the related ordered item.
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  /** Return true if this OrderItemRelationShip object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderItemRelationShip orderItemRelationShip = (OrderItemRelationShip) o;
    return Objects.equals(this.type, orderItemRelationShip.type)
        && Objects.equals(this.id, orderItemRelationShip.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderItemRelationShip {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
