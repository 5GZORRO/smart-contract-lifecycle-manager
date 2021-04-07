package eu._5gzorro.tm_forum.models.product;

import eu._5gzorro.tm_forum.models.StatusEnum;
import org.threeten.bp.OffsetDateTime;

import java.util.Objects;

/**
 * Represents a task used to export resources to a file Skipped properties: id,href
 */







public class ExportJobCreate   {
 
  private String baseType = null;

 
  private String schemaLocation = null;

 
  private String type = null;

 
  private OffsetDateTime completionDate = null;

 
  private String contentType = null;

 
  private OffsetDateTime creationDate = null;

 
  private String errorLog = null;

 
  private String path = null;

 
  private String query = null;

 
  private StatusEnum status = null;

 
  private String url = null;

  public ExportJobCreate baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   *
  **/
 


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public ExportJobCreate schemaLocation(String schemaLocation) {
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

  public ExportJobCreate type(String type) {
    this.type = type;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
   *
  **/
 


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ExportJobCreate completionDate(OffsetDateTime completionDate) {
    this.completionDate = completionDate;
    return this;
  }

  /**
   * Data at which the job was completed
   *
  **/
 

 

  public OffsetDateTime getCompletionDate() {
    return completionDate;
  }

  public void setCompletionDate(OffsetDateTime completionDate) {
    this.completionDate = completionDate;
  }

  public ExportJobCreate contentType(String contentType) {
    this.contentType = contentType;
    return this;
  }

  /**
   * The format of the exported data
   *
  **/
 


  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public ExportJobCreate creationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  /**
   * Date at which the job was created
   *
  **/
 

 

  public OffsetDateTime getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
  }

  public ExportJobCreate errorLog(String errorLog) {
    this.errorLog = errorLog;
    return this;
  }

  /**
   * Reason for failure
   *
  **/
 


  public String getErrorLog() {
    return errorLog;
  }

  public void setErrorLog(String errorLog) {
    this.errorLog = errorLog;
  }

  public ExportJobCreate path(String path) {
    this.path = path;
    return this;
  }

  /**
   * URL of the root resource acting as the source for streaming content to the file specified by the export job
   *
  **/
 


  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public ExportJobCreate query(String query) {
    this.query = query;
    return this;
  }

  /**
   * Used to scope the exported data
   *
  **/
 


  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public ExportJobCreate status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Status of the export job (not started, running, succeeded, failed)
   *
  **/
 


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public ExportJobCreate url(String url) {
    this.url = url;
    return this;
  }

  /**
   * URL of the file containing the data to be exported
   *
  **/
 
 


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


 
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExportJobCreate exportJobCreate = (ExportJobCreate) o;
    return Objects.equals(this.baseType, exportJobCreate.baseType) &&
        Objects.equals(this.schemaLocation, exportJobCreate.schemaLocation) &&
        Objects.equals(this.type, exportJobCreate.type) &&
        Objects.equals(this.completionDate, exportJobCreate.completionDate) &&
        Objects.equals(this.contentType, exportJobCreate.contentType) &&
        Objects.equals(this.creationDate, exportJobCreate.creationDate) &&
        Objects.equals(this.errorLog, exportJobCreate.errorLog) &&
        Objects.equals(this.path, exportJobCreate.path) &&
        Objects.equals(this.query, exportJobCreate.query) &&
        Objects.equals(this.status, exportJobCreate.status) &&
        Objects.equals(this.url, exportJobCreate.url);
  }

 
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, completionDate, contentType, creationDate, errorLog, path, query, status, url);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExportJobCreate {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    completionDate: ").append(toIndentedString(completionDate)).append("\n");
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    errorLog: ").append(toIndentedString(errorLog)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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

