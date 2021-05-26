package eu._5gzorro.tm_forum.models.product_order;

import java.util.Objects;

/** Characteristics of the product to instantiate or to modify. */
public class ProductCharacteristic {
  private String name;
  private String value;
  private String atType;
  private String atSchemaLocation;

  public ProductCharacteristic name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the characteristic.
   *
   * @return name
   */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductCharacteristic value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Value of the characteristic.
   *
   * @return value
   */
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public ProductCharacteristic atType(String atType) {
    this.atType = atType;
    return this;
  }

  /**
   * Indicates the (class) type of resource
   *
   * @return atType
   */
  public String getAtType() {
    return atType;
  }

  public void setAtType(String atType) {
    this.atType = atType;
  }

  public ProductCharacteristic atSchemaLocation(String atSchemaLocation) {
    this.atSchemaLocation = atSchemaLocation;
    return this;
  }

  /**
   * This field provided a link to the schema describing this REST resource.
   *
   * @return atSchemaLocation
   */
  public String getAtSchemaLocation() {
    return atSchemaLocation;
  }

  public void setAtSchemaLocation(String atSchemaLocation) {
    this.atSchemaLocation = atSchemaLocation;
  }

  /** Return true if this ProductCharacteristic object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductCharacteristic productCharacteristic = (ProductCharacteristic) o;
    return Objects.equals(this.name, productCharacteristic.name)
        && Objects.equals(this.value, productCharacteristic.value)
        && Objects.equals(this.atType, productCharacteristic.atType)
        && Objects.equals(this.atSchemaLocation, productCharacteristic.atSchemaLocation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, value, atType, atSchemaLocation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductCharacteristic {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    atType: ").append(toIndentedString(atType)).append("\n");
    sb.append("    atSchemaLocation: ").append(toIndentedString(atSchemaLocation)).append("\n");
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
