package eu._5gzorro.tm_forum.models.service;

import java.util.Objects;

/**
 * Used when an API throws an Error, typically with a HTTP error response-code (3xx, 4xx, 5xx)
 */







public class Error   {

  private String baseType = null;


  private String schemaLocation = null;


  private String type = null;


  private Integer code = null;


  private String message = null;


  private String reason = null;


  private String referenceError = null;


  private Integer status = null;

  public Error baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class.
   *
  **/



  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public Error schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   *
  **/



  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public Error type(String type) {
    this.type = type;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name.
   *
  **/



  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Error code(Integer code) {
    this.code = code;
    return this;
  }

  /**
   * Application relevant detail, defined in the API or a common list.
   *
  **/




  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public Error message(String message) {
    this.message = message;
    return this;
  }

  /**
   * More details and corrective actions related to the error which can be shown to a client user.
   *
  **/



  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Error reason(String reason) {
    this.reason = reason;
    return this;
  }

  /**
   * Explanation of the reason for the error which can be shown to a client user.
   *
  **/




  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public Error referenceError(String referenceError) {
    this.referenceError = referenceError;
    return this;
  }

  /**
   * URI of documentation describing the error.
   *
  **/



  public String getReferenceError() {
    return referenceError;
  }

  public void setReferenceError(String referenceError) {
    this.referenceError = referenceError;
  }

  public Error status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * HTTP Error code extension
   *
  **/



  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }



  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.baseType, error.baseType) &&
        Objects.equals(this.schemaLocation, error.schemaLocation) &&
        Objects.equals(this.type, error.type) &&
        Objects.equals(this.code, error.code) &&
        Objects.equals(this.message, error.message) &&
        Objects.equals(this.reason, error.reason) &&
        Objects.equals(this.referenceError, error.referenceError) &&
        Objects.equals(this.status, error.status);
  }


  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, code, message, reason, referenceError, status);
  }


  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    referenceError: ").append(toIndentedString(referenceError)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

