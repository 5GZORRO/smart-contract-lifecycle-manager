package eu._5gzorro.tm_forum.models.service;

import java.util.Objects;

/**
 * URL
 */






public class URL   {
 
  private String authority = null;

 
  private Object content = null;

 
  private Integer defaultPort = null;

 
  private String file = null;

 
  private String host = null;

 
  private String path = null;

 
  private Integer port = null;

 
  private String protocol = null;

 
  private String query = null;

 
  private String ref = null;

 
  private String userInfo = null;

  public URL authority(String authority) {
    this.authority = authority;
    return this;
  }

  /**
   * Get authority
   *
  **/
 


  public String getAuthority() {
    return authority;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
  }

  public URL content(Object content) {
    this.content = content;
    return this;
  }

  /**
   * Get content
   *
  **/
 


  public Object getContent() {
    return content;
  }

  public void setContent(Object content) {
    this.content = content;
  }

  public URL defaultPort(Integer defaultPort) {
    this.defaultPort = defaultPort;
    return this;
  }

  /**
   * Get defaultPort
   *
  **/
 


  public Integer getDefaultPort() {
    return defaultPort;
  }

  public void setDefaultPort(Integer defaultPort) {
    this.defaultPort = defaultPort;
  }

  public URL file(String file) {
    this.file = file;
    return this;
  }

  /**
   * Get file
   *
  **/
 


  public String getFile() {
    return file;
  }

  public void setFile(String file) {
    this.file = file;
  }

  public URL host(String host) {
    this.host = host;
    return this;
  }

  /**
   * Get host
   *
  **/
 


  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public URL path(String path) {
    this.path = path;
    return this;
  }

  /**
   * Get path
   *
  **/
 


  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public URL port(Integer port) {
    this.port = port;
    return this;
  }

  /**
   * Get port
   *
  **/
 


  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }

  public URL protocol(String protocol) {
    this.protocol = protocol;
    return this;
  }

  /**
   * Get protocol
   *
  **/
 


  public String getProtocol() {
    return protocol;
  }

  public void setProtocol(String protocol) {
    this.protocol = protocol;
  }

  public URL query(String query) {
    this.query = query;
    return this;
  }

  /**
   * Get query
   *
  **/
 


  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public URL ref(String ref) {
    this.ref = ref;
    return this;
  }

  /**
   * Get ref
   *
  **/
 


  public String getRef() {
    return ref;
  }

  public void setRef(String ref) {
    this.ref = ref;
  }

  public URL userInfo(String userInfo) {
    this.userInfo = userInfo;
    return this;
  }

  /**
   * Get userInfo
   *
  **/
 


  public String getUserInfo() {
    return userInfo;
  }

  public void setUserInfo(String userInfo) {
    this.userInfo = userInfo;
  }


 
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    URL URL = (URL) o;
    return Objects.equals(this.authority, URL.authority) &&
        Objects.equals(this.content, URL.content) &&
        Objects.equals(this.defaultPort, URL.defaultPort) &&
        Objects.equals(this.file, URL.file) &&
        Objects.equals(this.host, URL.host) &&
        Objects.equals(this.path, URL.path) &&
        Objects.equals(this.port, URL.port) &&
        Objects.equals(this.protocol, URL.protocol) &&
        Objects.equals(this.query, URL.query) &&
        Objects.equals(this.ref, URL.ref) &&
        Objects.equals(this.userInfo, URL.userInfo);
  }

 
  public int hashCode() {
    return Objects.hash(authority, content, defaultPort, file, host, path, port, protocol, query, ref, userInfo);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class URL {\n");
    
    sb.append("    authority: ").append(toIndentedString(authority)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    defaultPort: ").append(toIndentedString(defaultPort)).append("\n");
    sb.append("    file: ").append(toIndentedString(file)).append("\n");
    sb.append("    host: ").append(toIndentedString(host)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    port: ").append(toIndentedString(port)).append("\n");
    sb.append("    protocol: ").append(toIndentedString(protocol)).append("\n");
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
    sb.append("    ref: ").append(toIndentedString(ref)).append("\n");
    sb.append("    userInfo: ").append(toIndentedString(userInfo)).append("\n");
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
