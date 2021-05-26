package eu._5gzorro.tm_forum.models.product_order;

import java.util.Objects;

/** Place defines the places where the products are sold or delivered. */
public class Place {
  private String id;
  private String href;
  private String name;
  private String role;
  private String atReferredType;
  private String atSchemaLocation;

  public Place id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the place
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Place href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Unique reference of the place
   *
   * @return href
   */
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public Place name(String name) {
    this.name = name;
    return this;
  }

  /**
   * A user-friendly name for the place, such as &#39;Paris Store&#39;, &#39;Main Home&#39;.
   *
   * @return name
   */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Place role(String role) {
    this.role = role;
    return this;
  }

  /**
   * Role of the place
   *
   * @return role
   */
  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public Place atReferredType(String atReferredType) {
    this.atReferredType = atReferredType;
    return this;
  }

  /**
   * Type of Place.
   *
   * @return atReferredType
   */
  public String getAtReferredType() {
    return atReferredType;
  }

  public void setAtReferredType(String atReferredType) {
    this.atReferredType = atReferredType;
  }

  public Place atSchemaLocation(String atSchemaLocation) {
    this.atSchemaLocation = atSchemaLocation;
    return this;
  }

  /**
   * Link to the schema describing this REST resource.
   *
   * @return atSchemaLocation
   */
  public String getAtSchemaLocation() {
    return atSchemaLocation;
  }

  public void setAtSchemaLocation(String atSchemaLocation) {
    this.atSchemaLocation = atSchemaLocation;
  }

  /** Return true if this Place object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Place place = (Place) o;
    return Objects.equals(this.id, place.id)
        && Objects.equals(this.href, place.href)
        && Objects.equals(this.name, place.name)
        && Objects.equals(this.role, place.role)
        && Objects.equals(this.atReferredType, place.atReferredType)
        && Objects.equals(this.atSchemaLocation, place.atSchemaLocation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, role, atReferredType, atSchemaLocation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Place {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    atReferredType: ").append(toIndentedString(atReferredType)).append("\n");
    sb.append("    atSchemaLocation: ").append(toIndentedString(atSchemaLocation)).append("\n");
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
