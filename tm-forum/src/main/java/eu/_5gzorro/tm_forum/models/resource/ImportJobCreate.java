package eu._5gzorro.tm_forum.models.resource;

import org.threeten.bp.OffsetDateTime;

import java.util.Objects;

/**
 * Represents a task used to import resources from a file Skipped properties: id,href
 */







public class ImportJobCreate   {

  private OffsetDateTime completionDate = null;


  private String contentType = null;


  private OffsetDateTime creationDate = null;


  private String errorLog = null;


  private String path = null;


  private String status = null;


  private String url = null;

  public ImportJobCreate completionDate(OffsetDateTime completionDate) {
    this.completionDate = completionDate;
    return this;
  }

  /**
   * Date at which the job was completed
   *
  **/




  public OffsetDateTime getCompletionDate() {
    return completionDate;
  }

  public void setCompletionDate(OffsetDateTime completionDate) {
    this.completionDate = completionDate;
  }

  public ImportJobCreate contentType(String contentType) {
    this.contentType = contentType;
    return this;
  }

  /**
   * Indicates the format of the imported data
   *
  **/



  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public ImportJobCreate creationDate(OffsetDateTime creationDate) {
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

  public ImportJobCreate errorLog(String errorLog) {
    this.errorLog = errorLog;
    return this;
  }

  /**
   * Reason for failure if status is failed
   *
  **/



  public String getErrorLog() {
    return errorLog;
  }

  public void setErrorLog(String errorLog) {
    this.errorLog = errorLog;
  }

  public ImportJobCreate path(String path) {
    this.path = path;
    return this;
  }

  /**
   * URL of the root resource where the content of the file specified by the import job must be applied
   *
  **/



  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public ImportJobCreate status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Status of the import job (not started, running, succeeded, failed)
   *
  **/



  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public ImportJobCreate url(String url) {
    this.url = url;
    return this;
  }

  /**
   * URL of the file containing the data to be imported
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
    ImportJobCreate importJobCreate = (ImportJobCreate) o;
    return Objects.equals(this.completionDate, importJobCreate.completionDate) &&
        Objects.equals(this.contentType, importJobCreate.contentType) &&
        Objects.equals(this.creationDate, importJobCreate.creationDate) &&
        Objects.equals(this.errorLog, importJobCreate.errorLog) &&
        Objects.equals(this.path, importJobCreate.path) &&
        Objects.equals(this.status, importJobCreate.status) &&
        Objects.equals(this.url, importJobCreate.url);
  }


  public int hashCode() {
    return Objects.hash(completionDate, contentType, creationDate, errorLog, path, status, url);
  }


  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImportJobCreate {\n");
    
    sb.append("    completionDate: ").append(toIndentedString(completionDate)).append("\n");
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    errorLog: ").append(toIndentedString(errorLog)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
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

