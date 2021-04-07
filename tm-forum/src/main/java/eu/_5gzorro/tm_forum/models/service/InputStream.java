package eu._5gzorro.tm_forum.models.service;

import java.util.Objects;

/**
 * InputStream
 */






public class InputStream   {

 
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    return o != null && getClass() == o.getClass();
  }

 
  public int hashCode() {
    return Objects.hash();
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InputStream {\n");
    
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

