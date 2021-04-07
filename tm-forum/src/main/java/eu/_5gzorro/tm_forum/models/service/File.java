package eu._5gzorro.tm_forum.models.service;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * File
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-02-10T10:03:19.238Z")




public class File   {
  @JsonProperty("absolute")
  private Boolean absolute = null;

  @JsonProperty("absoluteFile")
  private File absoluteFile = null;

  @JsonProperty("absolutePath")
  private String absolutePath = null;

  @JsonProperty("canonicalFile")
  private File canonicalFile = null;

  @JsonProperty("canonicalPath")
  private String canonicalPath = null;

  @JsonProperty("directory")
  private Boolean directory = null;

  @JsonProperty("file")
  private Boolean file = null;

  @JsonProperty("freeSpace")
  private Long freeSpace = null;

  @JsonProperty("hidden")
  private Boolean hidden = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("parent")
  private String parent = null;

  @JsonProperty("parentFile")
  private File parentFile = null;

  @JsonProperty("path")
  private String path = null;

  @JsonProperty("totalSpace")
  private Long totalSpace = null;

  @JsonProperty("usableSpace")
  private Long usableSpace = null;

  public File absolute(Boolean absolute) {
    this.absolute = absolute;
    return this;
  }

  /**
   * Get absolute
   * @return absolute
  **/
  @ApiModelProperty(value = "")


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
   * @return absoluteFile
  **/
  @ApiModelProperty(value = "")

  @Valid

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
   * @return absolutePath
  **/
  @ApiModelProperty(value = "")


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
   * @return canonicalFile
  **/
  @ApiModelProperty(value = "")

  @Valid

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
   * @return canonicalPath
  **/
  @ApiModelProperty(value = "")


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
   * @return directory
  **/
  @ApiModelProperty(value = "")


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
   * @return file
  **/
  @ApiModelProperty(value = "")


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
   * @return freeSpace
  **/
  @ApiModelProperty(value = "")


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
   * @return hidden
  **/
  @ApiModelProperty(value = "")


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
   * @return name
  **/
  @ApiModelProperty(value = "")


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
   * @return parent
  **/
  @ApiModelProperty(value = "")


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
   * @return parentFile
  **/
  @ApiModelProperty(value = "")

  @Valid

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
   * @return path
  **/
  @ApiModelProperty(value = "")


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
   * @return totalSpace
  **/
  @ApiModelProperty(value = "")


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
   * @return usableSpace
  **/
  @ApiModelProperty(value = "")


  public Long getUsableSpace() {
    return usableSpace;
  }

  public void setUsableSpace(Long usableSpace) {
    this.usableSpace = usableSpace;
  }


  @Override
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

  @Override
  public int hashCode() {
    return Objects.hash(absolute, absoluteFile, absolutePath, canonicalFile, canonicalPath, directory, file, freeSpace, hidden, name, parent, parentFile, path, totalSpace, usableSpace);
  }

  @Override
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

