package eu._5gzorro.tm_forum.models.product_order;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** */
public enum StateType {
  ACKNOWLEDGED("acknowledged"),

  INPROGRESS("inProgress"),

  CANCELLED("cancelled"),

  COMPLETED("completed"),

  REJECTED("rejected"),

  PENDING("pending"),

  HELD("held"),

  FAILED("failed"),

  PARTIAL("partial");

  private String value;

  StateType(String value) {
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
  public static StateType fromValue(String value) {
    for (StateType b : StateType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
