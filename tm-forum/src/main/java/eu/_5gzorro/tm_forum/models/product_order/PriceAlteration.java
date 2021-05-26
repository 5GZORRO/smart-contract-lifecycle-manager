package eu._5gzorro.tm_forum.models.product_order;

import java.util.Objects;

/** Is an amount, usually of money, that modifies the price charged for an order item. */
public class PriceAlteration {
  private String name;
  private String description;
  private PriceType priceType;
  private String unitOfMeasure;
  private String recurringChargePeriod;
  private String applicationDuration;
  private Integer priority;
  private Price price;
  private String atType;
  private String atSchemaLocation;

  public PriceAlteration name(String name) {
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

  public PriceAlteration description(String description) {
    this.description = description;
    return this;
  }

  /** @return description */
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public PriceAlteration priceType(PriceType priceType) {
    this.priceType = priceType;
    return this;
  }

  /**
   * Get priceType
   *
   * @return priceType
   */
  public PriceType getPriceType() {
    return priceType;
  }

  public void setPriceType(PriceType priceType) {
    this.priceType = priceType;
  }

  public PriceAlteration unitOfMeasure(String unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
    return this;
  }

  /** @return unitOfMeasure */
  public String getUnitOfMeasure() {
    return unitOfMeasure;
  }

  public void setUnitOfMeasure(String unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
  }

  public PriceAlteration recurringChargePeriod(String recurringChargePeriod) {
    this.recurringChargePeriod = recurringChargePeriod;
    return this;
  }

  /** @return recurringChargePeriod */
  public String getRecurringChargePeriod() {
    return recurringChargePeriod;
  }

  public void setRecurringChargePeriod(String recurringChargePeriod) {
    this.recurringChargePeriod = recurringChargePeriod;
  }

  public PriceAlteration applicationDuration(String applicationDuration) {
    this.applicationDuration = applicationDuration;
    return this;
  }

  /** @return applicationDuration */
  public String getApplicationDuration() {
    return applicationDuration;
  }

  public void setApplicationDuration(String applicationDuration) {
    this.applicationDuration = applicationDuration;
  }

  public PriceAlteration priority(Integer priority) {
    this.priority = priority;
    return this;
  }

  /** @return priority */
  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  public PriceAlteration price(Price price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   *
   * @return price
   */
  public Price getPrice() {
    return price;
  }

  public void setPrice(Price price) {
    this.price = price;
  }

  public PriceAlteration atType(String atType) {
    this.atType = atType;
    return this;
  }

  public String getAtType() {
    return atType;
  }

  public void setAtType(String atType) {
    this.atType = atType;
  }

  public PriceAlteration atSchemaLocation(String atSchemaLocation) {
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

  /** Return true if this PriceAlteration object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PriceAlteration priceAlteration = (PriceAlteration) o;
    return Objects.equals(this.name, priceAlteration.name)
        && Objects.equals(this.description, priceAlteration.description)
        && Objects.equals(this.priceType, priceAlteration.priceType)
        && Objects.equals(this.unitOfMeasure, priceAlteration.unitOfMeasure)
        && Objects.equals(this.recurringChargePeriod, priceAlteration.recurringChargePeriod)
        && Objects.equals(this.applicationDuration, priceAlteration.applicationDuration)
        && Objects.equals(this.priority, priceAlteration.priority)
        && Objects.equals(this.price, priceAlteration.price)
        && Objects.equals(this.atType, priceAlteration.atType)
        && Objects.equals(this.atSchemaLocation, priceAlteration.atSchemaLocation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        name,
        description,
        priceType,
        unitOfMeasure,
        recurringChargePeriod,
        applicationDuration,
        priority,
        price,
        atType,
        atSchemaLocation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PriceAlteration {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    priceType: ").append(toIndentedString(priceType)).append("\n");
    sb.append("    unitOfMeasure: ").append(toIndentedString(unitOfMeasure)).append("\n");
    sb.append("    recurringChargePeriod: ")
        .append(toIndentedString(recurringChargePeriod))
        .append("\n");
    sb.append("    applicationDuration: ")
        .append(toIndentedString(applicationDuration))
        .append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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
