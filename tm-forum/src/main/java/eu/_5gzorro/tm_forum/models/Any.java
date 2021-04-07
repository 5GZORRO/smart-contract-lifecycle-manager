package eu._5gzorro.tm_forum.models;

import java.util.Objects;

/**
 * Any
 */




public class Any {


  private String alias = null;


  private String value = null;

  public Any alias(String alias) {
    this.alias = alias;
    return this;
  }

  /**
   * Get alias
   *
  **/



  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  public Any value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   *
  **/



  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }



  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Any any = (Any) o;
    return Objects.equals(this.alias, any.alias) &&
        Objects.equals(this.value, any.value);
  }


  public int hashCode() {
    return Objects.hash(alias, value);
  }


  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Any {\n");
    
    sb.append("    alias: ").append(toIndentedString(alias)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

