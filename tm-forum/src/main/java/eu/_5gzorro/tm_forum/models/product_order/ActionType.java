package eu._5gzorro.tm_forum.models.product_order;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 
 */
public enum ActionType {
  
  ADD("add"),
  
  MODIFY("modify"),
  
  NOCHANGE("noChange"),
  
  DELETE("delete");

  private String value;

  ActionType(String value) {
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
  public static ActionType fromValue(String value) {
    for (ActionType b : ActionType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
