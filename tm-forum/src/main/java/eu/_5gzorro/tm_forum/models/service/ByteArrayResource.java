package eu._5gzorro.tm_forum.models.service;

import java.io.File;
import java.util.Objects;

/**
 * ByteArrayResource
 */






public class ByteArrayResource   {
 
  private byte[] byteArray = null;

 
  private String description = null;

 
  private File file = null;

 
  private String filename = null;

 
  private InputStream inputStream = null;

 
  private Boolean open = null;

 
  private Boolean readable = null;

 
  private URI uri = null;

 
  private URL url = null;

  public ByteArrayResource byteArray(byte[] byteArray) {
    this.byteArray = byteArray;
    return this;
  }

  /**
   * Get byteArray
   *
  **/
 


  public byte[] getByteArray() {
    return byteArray;
  }

  public void setByteArray(byte[] byteArray) {
    this.byteArray = byteArray;
  }

  public ByteArrayResource description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   *
  **/
 


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ByteArrayResource file(File file) {
    this.file = file;
    return this;
  }

  /**
   * Get file
   *
  **/
 

 

  public File getFile() {
    return file;
  }

  public void setFile(File file) {
    this.file = file;
  }

  public ByteArrayResource filename(String filename) {
    this.filename = filename;
    return this;
  }

  /**
   * Get filename
   *
  **/
 


  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public ByteArrayResource inputStream(InputStream inputStream) {
    this.inputStream = inputStream;
    return this;
  }

  /**
   * Get inputStream
   *
  **/
 

 

  public InputStream getInputStream() {
    return inputStream;
  }

  public void setInputStream(InputStream inputStream) {
    this.inputStream = inputStream;
  }

  public ByteArrayResource open(Boolean open) {
    this.open = open;
    return this;
  }

  /**
   * Get open
   *
  **/
 


  public Boolean isOpen() {
    return open;
  }

  public void setOpen(Boolean open) {
    this.open = open;
  }

  public ByteArrayResource readable(Boolean readable) {
    this.readable = readable;
    return this;
  }

  /**
   * Get readable
   *
  **/
 


  public Boolean isReadable() {
    return readable;
  }

  public void setReadable(Boolean readable) {
    this.readable = readable;
  }

  public ByteArrayResource uri(URI uri) {
    this.uri = uri;
    return this;
  }

  /**
   * Get uri
   *
  **/
 

 

  public URI getUri() {
    return uri;
  }

  public void setUri(URI uri) {
    this.uri = uri;
  }

  public ByteArrayResource url(URL url) {
    this.url = url;
    return this;
  }

  /**
   * Get url
   *
  **/
 

 

  public URL getUrl() {
    return url;
  }

  public void setUrl(URL url) {
    this.url = url;
  }


 
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ByteArrayResource byteArrayResource = (ByteArrayResource) o;
    return Objects.equals(this.byteArray, byteArrayResource.byteArray) &&
        Objects.equals(this.description, byteArrayResource.description) &&
        Objects.equals(this.file, byteArrayResource.file) &&
        Objects.equals(this.filename, byteArrayResource.filename) &&
        Objects.equals(this.inputStream, byteArrayResource.inputStream) &&
        Objects.equals(this.open, byteArrayResource.open) &&
        Objects.equals(this.readable, byteArrayResource.readable) &&
        Objects.equals(this.uri, byteArrayResource.uri) &&
        Objects.equals(this.url, byteArrayResource.url);
  }

 
  public int hashCode() {
    return Objects.hash(byteArray, description, file, filename, inputStream, open, readable, uri, url);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ByteArrayResource {\n");
    
    sb.append("    byteArray: ").append(toIndentedString(byteArray)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    file: ").append(toIndentedString(file)).append("\n");
    sb.append("    filename: ").append(toIndentedString(filename)).append("\n");
    sb.append("    inputStream: ").append(toIndentedString(inputStream)).append("\n");
    sb.append("    open: ").append(toIndentedString(open)).append("\n");
    sb.append("    readable: ").append(toIndentedString(readable)).append("\n");
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
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

