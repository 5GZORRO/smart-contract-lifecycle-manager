package eu._5gzorro.tm_forum.models.service;

import java.util.Objects;

/**
 * URI
 */






public class URI   {
 
  private Boolean absolute = null;

 
  private String authority = null;

 
  private String fragment = null;

 
  private String host = null;

 
  private Boolean opaque = null;

 
  private String path = null;

 
  private Integer port = null;

 
  private String query = null;

 
  private String rawAuthority = null;

 
  private String rawFragment = null;

 
  private String rawPath = null;

 
  private String rawQuery = null;

 
  private String rawSchemeSpecificPart = null;

 
  private String rawUserInfo = null;

 
  private String scheme = null;

 
  private String schemeSpecificPart = null;

 
  private String userInfo = null;

  public URI absolute(Boolean absolute) {
    this.absolute = absolute;
    return this;
  }

  /**
   * Get absolute
   *
  **/
 


  public Boolean isAbsolute() {
    return absolute;
  }

  public void setAbsolute(Boolean absolute) {
    this.absolute = absolute;
  }

  public URI authority(String authority) {
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

  public URI fragment(String fragment) {
    this.fragment = fragment;
    return this;
  }

  /**
   * Get fragment
   *
  **/
 


  public String getFragment() {
    return fragment;
  }

  public void setFragment(String fragment) {
    this.fragment = fragment;
  }

  public URI host(String host) {
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

  public URI opaque(Boolean opaque) {
    this.opaque = opaque;
    return this;
  }

  /**
   * Get opaque
   *
  **/
 


  public Boolean isOpaque() {
    return opaque;
  }

  public void setOpaque(Boolean opaque) {
    this.opaque = opaque;
  }

  public URI path(String path) {
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

  public URI port(Integer port) {
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

  public URI query(String query) {
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

  public URI rawAuthority(String rawAuthority) {
    this.rawAuthority = rawAuthority;
    return this;
  }

  /**
   * Get rawAuthority
   *
  **/
 


  public String getRawAuthority() {
    return rawAuthority;
  }

  public void setRawAuthority(String rawAuthority) {
    this.rawAuthority = rawAuthority;
  }

  public URI rawFragment(String rawFragment) {
    this.rawFragment = rawFragment;
    return this;
  }

  /**
   * Get rawFragment
   *
  **/
 


  public String getRawFragment() {
    return rawFragment;
  }

  public void setRawFragment(String rawFragment) {
    this.rawFragment = rawFragment;
  }

  public URI rawPath(String rawPath) {
    this.rawPath = rawPath;
    return this;
  }

  /**
   * Get rawPath
   *
  **/
 


  public String getRawPath() {
    return rawPath;
  }

  public void setRawPath(String rawPath) {
    this.rawPath = rawPath;
  }

  public URI rawQuery(String rawQuery) {
    this.rawQuery = rawQuery;
    return this;
  }

  /**
   * Get rawQuery
   *
  **/
 


  public String getRawQuery() {
    return rawQuery;
  }

  public void setRawQuery(String rawQuery) {
    this.rawQuery = rawQuery;
  }

  public URI rawSchemeSpecificPart(String rawSchemeSpecificPart) {
    this.rawSchemeSpecificPart = rawSchemeSpecificPart;
    return this;
  }

  /**
   * Get rawSchemeSpecificPart
   *
  **/
 


  public String getRawSchemeSpecificPart() {
    return rawSchemeSpecificPart;
  }

  public void setRawSchemeSpecificPart(String rawSchemeSpecificPart) {
    this.rawSchemeSpecificPart = rawSchemeSpecificPart;
  }

  public URI rawUserInfo(String rawUserInfo) {
    this.rawUserInfo = rawUserInfo;
    return this;
  }

  /**
   * Get rawUserInfo
   *
  **/
 


  public String getRawUserInfo() {
    return rawUserInfo;
  }

  public void setRawUserInfo(String rawUserInfo) {
    this.rawUserInfo = rawUserInfo;
  }

  public URI scheme(String scheme) {
    this.scheme = scheme;
    return this;
  }

  /**
   * Get scheme
   *
  **/
 


  public String getScheme() {
    return scheme;
  }

  public void setScheme(String scheme) {
    this.scheme = scheme;
  }

  public URI schemeSpecificPart(String schemeSpecificPart) {
    this.schemeSpecificPart = schemeSpecificPart;
    return this;
  }

  /**
   * Get schemeSpecificPart
   *
  **/
 


  public String getSchemeSpecificPart() {
    return schemeSpecificPart;
  }

  public void setSchemeSpecificPart(String schemeSpecificPart) {
    this.schemeSpecificPart = schemeSpecificPart;
  }

  public URI userInfo(String userInfo) {
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
    URI URI = (URI) o;
    return Objects.equals(this.absolute, URI.absolute) &&
        Objects.equals(this.authority, URI.authority) &&
        Objects.equals(this.fragment, URI.fragment) &&
        Objects.equals(this.host, URI.host) &&
        Objects.equals(this.opaque, URI.opaque) &&
        Objects.equals(this.path, URI.path) &&
        Objects.equals(this.port, URI.port) &&
        Objects.equals(this.query, URI.query) &&
        Objects.equals(this.rawAuthority, URI.rawAuthority) &&
        Objects.equals(this.rawFragment, URI.rawFragment) &&
        Objects.equals(this.rawPath, URI.rawPath) &&
        Objects.equals(this.rawQuery, URI.rawQuery) &&
        Objects.equals(this.rawSchemeSpecificPart, URI.rawSchemeSpecificPart) &&
        Objects.equals(this.rawUserInfo, URI.rawUserInfo) &&
        Objects.equals(this.scheme, URI.scheme) &&
        Objects.equals(this.schemeSpecificPart, URI.schemeSpecificPart) &&
        Objects.equals(this.userInfo, URI.userInfo);
  }

 
  public int hashCode() {
    return Objects.hash(absolute, authority, fragment, host, opaque, path, port, query, rawAuthority, rawFragment, rawPath, rawQuery, rawSchemeSpecificPart, rawUserInfo, scheme, schemeSpecificPart, userInfo);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class URI {\n");
    
    sb.append("    absolute: ").append(toIndentedString(absolute)).append("\n");
    sb.append("    authority: ").append(toIndentedString(authority)).append("\n");
    sb.append("    fragment: ").append(toIndentedString(fragment)).append("\n");
    sb.append("    host: ").append(toIndentedString(host)).append("\n");
    sb.append("    opaque: ").append(toIndentedString(opaque)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    port: ").append(toIndentedString(port)).append("\n");
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
    sb.append("    rawAuthority: ").append(toIndentedString(rawAuthority)).append("\n");
    sb.append("    rawFragment: ").append(toIndentedString(rawFragment)).append("\n");
    sb.append("    rawPath: ").append(toIndentedString(rawPath)).append("\n");
    sb.append("    rawQuery: ").append(toIndentedString(rawQuery)).append("\n");
    sb.append("    rawSchemeSpecificPart: ").append(toIndentedString(rawSchemeSpecificPart)).append("\n");
    sb.append("    rawUserInfo: ").append(toIndentedString(rawUserInfo)).append("\n");
    sb.append("    scheme: ").append(toIndentedString(scheme)).append("\n");
    sb.append("    schemeSpecificPart: ").append(toIndentedString(schemeSpecificPart)).append("\n");
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

