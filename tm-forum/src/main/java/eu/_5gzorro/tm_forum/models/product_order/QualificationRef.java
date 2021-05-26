package eu._5gzorro.tm_forum.models.product_order;

import java.util.Objects;

/**
 * It could be a serviceQualification or a productOfferingQualification that has been executed
 * previously and captured in the productOrder to provide &#39;eligibility&#39; information.
 */
public class QualificationRef {
  private String id;
  private String href;
  private String qualificationItemId;
  private String atReferredType;

  public QualificationRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Identifier of a pre-existing qualification.
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public QualificationRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * href of the qualification.
   *
   * @return href
   */
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public QualificationRef qualificationItemId(String qualificationItemId) {
    this.qualificationItemId = qualificationItemId;
    return this;
  }

  /**
   * Id of an item of a qualification.
   *
   * @return qualificationItemId
   */
  public String getQualificationItemId() {
    return qualificationItemId;
  }

  public void setQualificationItemId(String qualificationItemId) {
    this.qualificationItemId = qualificationItemId;
  }

  public QualificationRef atReferredType(String atReferredType) {
    this.atReferredType = atReferredType;
    return this;
  }

  /**
   * Indicates the type of resource. Here it can be a type of qualification. (could a service
   * qualification or a product offering qualification).
   *
   * @return atReferredType
   */
  public String getAtReferredType() {
    return atReferredType;
  }

  public void setAtReferredType(String atReferredType) {
    this.atReferredType = atReferredType;
  }

  /** Return true if this QualificationRef object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QualificationRef qualificationRef = (QualificationRef) o;
    return Objects.equals(this.id, qualificationRef.id)
        && Objects.equals(this.href, qualificationRef.href)
        && Objects.equals(this.qualificationItemId, qualificationRef.qualificationItemId)
        && Objects.equals(this.atReferredType, qualificationRef.atReferredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, qualificationItemId, atReferredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QualificationRef {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    qualificationItemId: ")
        .append(toIndentedString(qualificationItemId))
        .append("\n");
    sb.append("    atReferredType: ").append(toIndentedString(atReferredType)).append("\n");
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
