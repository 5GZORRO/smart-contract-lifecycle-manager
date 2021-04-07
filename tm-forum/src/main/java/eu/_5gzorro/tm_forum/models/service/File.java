package eu._5gzorro.tm_forum.models.service;

import java.util.Objects;

/**
 * File
 */






public class File   {

  private Boolean absolute = null;


  private File absoluteFile = null;


  private String absolutePath = null;


  private File canonicalFile = null;


  private String canonicalPath = null;


  private Boolean directory = null;


  private Boolean file = null;


  private Long freeSpace = null;


  private Boolean hidden = null;


  private String name = null;


  private String parent = null;


  private File parentFile = null;


  private String path = null;


  private Long totalSpace = null;


  private Long usableSpace = null;

  public File absolute(Boolean absolute) {
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

  public File absoluteFile(File absoluteFile) {
    this.absoluteFile = absoluteFile;
    return this;
  }

  /**
   * Get absoluteFile
   *
  **/




  public File getAbsoluteFile() {
    return absoluteFile;
  }

  public void setAbsoluteFile(File absoluteFile) {
    this.absoluteFile = absoluteFile;
  }

  public File absolutePath(String absolutePath) {
    this.absolutePath = absolutePath;
    return this;
  }

  /**
   * Get absolutePath
   *
  **/



  public String getAbsolutePath() {
    return absolutePath;
  }

  public void setAbsolutePath(String absolutePath) {
    this.absolutePath = absolutePath;
  }

  public File canonicalFile(File canonicalFile) {
    this.canonicalFile = canonicalFile;
    return this;
  }

  /**
   * Get canonicalFile
   *
  **/




  public File getCanonicalFile() {
    return canonicalFile;
  }

  public void setCanonicalFile(File canonicalFile) {
    this.canonicalFile = canonicalFile;
  }

  public File canonicalPath(String canonicalPath) {
    this.canonicalPath = canonicalPath;
    return this;
  }

  /**
   * Get canonicalPath
   *
  **/



  public String getCanonicalPath() {
    return canonicalPath;
  }

  public void setCanonicalPath(String canonicalPath) {
    this.canonicalPath = canonicalPath;
  }

  public File directory(Boolean directory) {
    this.directory = directory;
    return this;
  }

  /**
   * Get directory
   *
  **/



  public Boolean isDirectory() {
    return directory;
  }

  public void setDirectory(Boolean directory) {
    this.directory = directory;
  }

  public File file(Boolean file) {
    this.file = file;
    return this;
  }

  /**
   * Get file
   *
  **/



  public Boolean isFile() {
    return file;
  }

  public void setFile(Boolean file) {
    this.file = file;
  }

  public File freeSpace(Long freeSpace) {
    this.freeSpace = freeSpace;
    return this;
  }

  /**
   * Get freeSpace
   *
  **/



  public Long getFreeSpace() {
    return freeSpace;
  }

  public void setFreeSpace(Long freeSpace) {
    this.freeSpace = freeSpace;
  }

  public File hidden(Boolean hidden) {
    this.hidden = hidden;
    return this;
  }

  /**
   * Get hidden
   *
  **/



  public Boolean isHidden() {
    return hidden;
  }

  public void setHidden(Boolean hidden) {
    this.hidden = hidden;
  }

  public File name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   *
  **/



  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public File parent(String parent) {
    this.parent = parent;
    return this;
  }

  /**
   * Get parent
   *
  **/



  public String getParent() {
    return parent;
  }

  public void setParent(String parent) {
    this.parent = parent;
  }

  public File parentFile(File parentFile) {
    this.parentFile = parentFile;
    return this;
  }

  /**
   * Get parentFile
   *
  **/




  public File getParentFile() {
    return parentFile;
  }

  public void setParentFile(File parentFile) {
    this.parentFile = parentFile;
  }

  public File path(String path) {
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

  public File totalSpace(Long totalSpace) {
    this.totalSpace = totalSpace;
    return this;
  }

  /**
   * Get totalSpace
   *
  **/



  public Long getTotalSpace() {
    return totalSpace;
  }

  public void setTotalSpace(Long totalSpace) {
    this.totalSpace = totalSpace;
  }

  public File usableSpace(Long usableSpace) {
    this.usableSpace = usableSpace;
    return this;
  }

  /**
   * Get usableSpace
   *
  **/



  public Long getUsableSpace() {
    return usableSpace;
  }

  public void setUsableSpace(Long usableSpace) {
    this.usableSpace = usableSpace;
  }



  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    File file = (File) o;
    return Objects.equals(this.absolute, file.absolute) &&
        Objects.equals(this.absoluteFile, file.absoluteFile) &&
        Objects.equals(this.absolutePath, file.absolutePath) &&
        Objects.equals(this.canonicalFile, file.canonicalFile) &&
        Objects.equals(this.canonicalPath, file.canonicalPath) &&
        Objects.equals(this.directory, file.directory) &&
        Objects.equals(this.file, file.file) &&
        Objects.equals(this.freeSpace, file.freeSpace) &&
        Objects.equals(this.hidden, file.hidden) &&
        Objects.equals(this.name, file.name) &&
        Objects.equals(this.parent, file.parent) &&
        Objects.equals(this.parentFile, file.parentFile) &&
        Objects.equals(this.path, file.path) &&
        Objects.equals(this.totalSpace, file.totalSpace) &&
        Objects.equals(this.usableSpace, file.usableSpace);
  }


  public int hashCode() {
    return Objects.hash(absolute, absoluteFile, absolutePath, canonicalFile, canonicalPath, directory, file, freeSpace, hidden, name, parent, parentFile, path, totalSpace, usableSpace);
  }


  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class File {\n");
    
    sb.append("    absolute: ").append(toIndentedString(absolute)).append("\n");
    sb.append("    absoluteFile: ").append(toIndentedString(absoluteFile)).append("\n");
    sb.append("    absolutePath: ").append(toIndentedString(absolutePath)).append("\n");
    sb.append("    canonicalFile: ").append(toIndentedString(canonicalFile)).append("\n");
    sb.append("    canonicalPath: ").append(toIndentedString(canonicalPath)).append("\n");
    sb.append("    directory: ").append(toIndentedString(directory)).append("\n");
    sb.append("    file: ").append(toIndentedString(file)).append("\n");
    sb.append("    freeSpace: ").append(toIndentedString(freeSpace)).append("\n");
    sb.append("    hidden: ").append(toIndentedString(hidden)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    parent: ").append(toIndentedString(parent)).append("\n");
    sb.append("    parentFile: ").append(toIndentedString(parentFile)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    totalSpace: ").append(toIndentedString(totalSpace)).append("\n");
    sb.append("    usableSpace: ").append(toIndentedString(usableSpace)).append("\n");
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

