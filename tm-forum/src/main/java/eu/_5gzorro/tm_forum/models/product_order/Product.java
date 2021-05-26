package eu._5gzorro.tm_forum.models.product_order;

import eu._5gzorro.tm_forum.models.product.ProductSpecificationRef;
import eu._5gzorro.tm_forum.models.sla.RelatedPartyRef;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Configure the product characteristics (only configurable characteristics and necessary only if a
 * non default value is selected) and/or identify the product that needs to be modified/deleted.
 */
public class Product {
  private String id;
  private String href;
  private String name;
  private List<Place> place = null;
  private List<ProductCharacteristic> characteristic = null;
  private List<RelatedPartyRef> relatedParty = null;
  private List<ProductRelationship> productRelationship = null;
  private ProductSpecificationRef productSpecification;
  private String atType;
  private String atSchemaLocation;

  public Product id(String id) {
    this.id = id;
    return this;
  }

  /** @return id */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Product href(String href) {
    this.href = href;
    return this;
  }

  /** @return href */
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public Product name(String name) {
    this.name = name;
    return this;
  }

  /** @return name */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Product place(List<Place> place) {
    this.place = place;
    return this;
  }

  public Product addPlaceItem(Place placeItem) {
    if (this.place == null) {
      this.place = new ArrayList<>();
    }
    this.place.add(placeItem);
    return this;
  }

  /**
   * Get place
   *
   * @return place
   */
  public List<Place> getPlace() {
    return place;
  }

  public void setPlace(List<Place> place) {
    this.place = place;
  }

  public Product characteristic(List<ProductCharacteristic> characteristic) {
    this.characteristic = characteristic;
    return this;
  }

  public Product addCharacteristicItem(ProductCharacteristic characteristicItem) {
    if (this.characteristic == null) {
      this.characteristic = new ArrayList<>();
    }
    this.characteristic.add(characteristicItem);
    return this;
  }

  /**
   * Get characteristic
   *
   * @return characteristic
   */
  public List<ProductCharacteristic> getCharacteristic() {
    return characteristic;
  }

  public void setCharacteristic(List<ProductCharacteristic> characteristic) {
    this.characteristic = characteristic;
  }

  public Product relatedParty(List<RelatedPartyRef> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public Product addRelatedPartyItem(RelatedPartyRef relatedPartyItem) {
    if (this.relatedParty == null) {
      this.relatedParty = new ArrayList<>();
    }
    this.relatedParty.add(relatedPartyItem);
    return this;
  }

  /**
   * Get relatedParty
   *
   * @return relatedParty
   */
  public List<RelatedPartyRef> getRelatedParty() {
    return relatedParty;
  }

  public void setRelatedParty(List<RelatedPartyRef> relatedParty) {
    this.relatedParty = relatedParty;
  }

  public Product productRelationship(List<ProductRelationship> productRelationship) {
    this.productRelationship = productRelationship;
    return this;
  }

  public Product addProductRelationshipItem(ProductRelationship productRelationshipItem) {
    if (this.productRelationship == null) {
      this.productRelationship = new ArrayList<>();
    }
    this.productRelationship.add(productRelationshipItem);
    return this;
  }

  /**
   * Get productRelationship
   *
   * @return productRelationship
   */
  public List<ProductRelationship> getProductRelationship() {
    return productRelationship;
  }

  public void setProductRelationship(List<ProductRelationship> productRelationship) {
    this.productRelationship = productRelationship;
  }

  public Product productSpecification(ProductSpecificationRef productSpecification) {
    this.productSpecification = productSpecification;
    return this;
  }

  /**
   * Get productSpecification
   *
   * @return productSpecification
   */
  public ProductSpecificationRef getProductSpecification() {
    return productSpecification;
  }

  public void setProductSpecification(ProductSpecificationRef productSpecification) {
    this.productSpecification = productSpecification;
  }

  public Product atType(String atType) {
    this.atType = atType;
    return this;
  }

  /** @return atType */
  public String getAtType() {
    return atType;
  }

  public void setAtType(String atType) {
    this.atType = atType;
  }

  public Product atSchemaLocation(String atSchemaLocation) {
    this.atSchemaLocation = atSchemaLocation;
    return this;
  }

  /** @return atSchemaLocation */
  public String getAtSchemaLocation() {
    return atSchemaLocation;
  }

  public void setAtSchemaLocation(String atSchemaLocation) {
    this.atSchemaLocation = atSchemaLocation;
  }

  /** Return true if this Product object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return Objects.equals(this.id, product.id)
        && Objects.equals(this.href, product.href)
        && Objects.equals(this.name, product.name)
        && Objects.equals(this.place, product.place)
        && Objects.equals(this.characteristic, product.characteristic)
        && Objects.equals(this.relatedParty, product.relatedParty)
        && Objects.equals(this.productRelationship, product.productRelationship)
        && Objects.equals(this.productSpecification, product.productSpecification)
        && Objects.equals(this.atType, product.atType)
        && Objects.equals(this.atSchemaLocation, product.atSchemaLocation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id,
        href,
        name,
        place,
        characteristic,
        relatedParty,
        productRelationship,
        productSpecification,
        atType,
        atSchemaLocation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Product {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    place: ").append(toIndentedString(place)).append("\n");
    sb.append("    characteristic: ").append(toIndentedString(characteristic)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    productRelationship: ")
        .append(toIndentedString(productRelationship))
        .append("\n");
    sb.append("    productSpecification: ")
        .append(toIndentedString(productSpecification))
        .append("\n");
    sb.append("    atType: ").append(toIndentedString(atType)).append("\n");
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
