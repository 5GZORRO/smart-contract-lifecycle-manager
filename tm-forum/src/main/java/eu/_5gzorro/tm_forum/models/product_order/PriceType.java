package eu._5gzorro.tm_forum.models.product_order;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** */
public enum PriceType {
  RECURING("recuring"),

  ONETIME("oneTime"),

  USAGE("usage");

  private String value;

  PriceType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static PriceType fromValue(String value) {
    for (PriceType b : PriceType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
