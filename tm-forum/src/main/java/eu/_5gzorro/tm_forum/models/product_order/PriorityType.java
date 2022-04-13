package eu._5gzorro.tm_forum.models.product_order;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** */
public enum PriorityType {
  _0("0"),

  _1("1"),

  _2("2"),

  _3("3"),

  _4("4");

  private String value;

  PriorityType(String value) {
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
  public static PriorityType fromValue(String value) {
    for (PriorityType b : PriorityType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
