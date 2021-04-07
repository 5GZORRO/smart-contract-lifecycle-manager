package eu._5gzorro.tm_forum.models.resource;

import java.util.Objects;

/**
 * Error
 */






public class Error   {
 
  private Integer code = null;

 
  private String description = null;

 
  private String infoURL = null;

 
  private String message = null;

  public Error code(Integer code) {
    this.code = code;
    return this;
  }

  /**
   * An integer coding the error type. This is given to caller so he can translate them if required.
   *
  **/
 
 


  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public Error description(String description) {
    this.description = description;
    return this;
  }

  /**
   * (optional) A long localized error description if needed. It can contain precise information about which parameter is missing, or what are the identifier acceptable values.
   *
  **/
 


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Error infoURL(String infoURL) {
    this.infoURL = infoURL;
    return this;
  }

  /**
   * (optional) A URL to online documentation that provides more information about the error.
   *
  **/
 


  public String getInfoURL() {
    return infoURL;
  }

  public void setInfoURL(String infoURL) {
    this.infoURL = infoURL;
  }

  public Error message(String message) {
    this.message = message;
    return this;
  }

  /**
   * A short localized string that describes the error.
   *
  **/
 
 


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


 
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.code, error.code) &&
        Objects.equals(this.description, error.description) &&
        Objects.equals(this.infoURL, error.infoURL) &&
        Objects.equals(this.message, error.message);
  }

 
  public int hashCode() {
    return Objects.hash(code, description, infoURL, message);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    infoURL: ").append(toIndentedString(infoURL)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

