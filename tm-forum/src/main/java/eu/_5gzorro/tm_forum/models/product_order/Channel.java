package eu._5gzorro.tm_forum.models.product_order;

import java.util.Objects;

/** The channel defines the channel for selling product offerings where order has been submitted. */
public class Channel {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_HREF = "href";
  private String href;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_ROLE = "role";
  private String role;

  public static final String JSON_PROPERTY_AT_TYPE = "@type";
  private String atType;

  public Channel id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the channel
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Channel href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Unique reference of the channel
   *
   * @return href
   */
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public Channel name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the channel
   *
   * @return name
   */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Channel role(String role) {
    this.role = role;
    return this;
  }

  /**
   * Role of the channel - could be &#39;initChannel&#39;, &#39;submitChannel&#39; for example.
   *
   * @return role
   */
  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public Channel atType(String atType) {
    this.atType = atType;
    return this;
  }

  /**
   * Indicates the (class) type of resource.
   *
   * @return atType
   */
  public String getAtType() {
    return atType;
  }

  public void setAtType(String atType) {
    this.atType = atType;
  }

  /** Return true if this Channel object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Channel channel = (Channel) o;
    return Objects.equals(this.id, channel.id)
        && Objects.equals(this.href, channel.href)
        && Objects.equals(this.name, channel.name)
        && Objects.equals(this.role, channel.role)
        && Objects.equals(this.atType, channel.atType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, role, atType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Channel {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    atType: ").append(toIndentedString(atType)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
