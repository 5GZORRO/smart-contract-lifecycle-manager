package eu._5gzorro.tm_forum.models.product_order;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

/**
 * An amount, usually of money, that represents the actual price paid by the Customer for this item
 * or this order.
 */
public class OrderPrice {
  private String name;
  private String description;
  private PriceType priceType;
  private String unitOfMeasure;
  private String recurringChargePeriod;
  private String atType;
  private String atSchemaLocation;
  private Price price;
  private List<PriceAlteration> priceAlteration = null;
  private BillingAccountRef billingAccount;

  public OrderPrice name(String name) {
    this.name = name;
    return this;
  }

  /**
   * A short descriptive name such as \&quot;Subscription price\&quot;.
   *
   * @return name
   */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public OrderPrice description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A narrative that explains in detail the semantics of this order item price
   *
   * @return description
   */
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public OrderPrice priceType(PriceType priceType) {
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

  public OrderPrice unitOfMeasure(String unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
    return this;
  }

  /**
   * Could be minutes, gigaBytes,...
   *
   * @return unitOfMeasure
   */
  public String getUnitOfMeasure() {
    return unitOfMeasure;
  }

  public void setUnitOfMeasure(String unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
  }

  public OrderPrice recurringChargePeriod(String recurringChargePeriod) {
    this.recurringChargePeriod = recurringChargePeriod;
    return this;
  }

  /**
   * Could be month, week,...
   *
   * @return recurringChargePeriod
   */
  public String getRecurringChargePeriod() {
    return recurringChargePeriod;
  }

  public void setRecurringChargePeriod(String recurringChargePeriod) {
    this.recurringChargePeriod = recurringChargePeriod;
  }

  public OrderPrice atType(String atType) {
    this.atType = atType;
    return this;
  }

  /**
   * Indicate the type of orderPrice.
   *
   * @return atType
   */
  public String getAtType() {
    return atType;
  }

  public void setAtType(String atType) {
    this.atType = atType;
  }

  public OrderPrice atSchemaLocation(String atSchemaLocation) {
    this.atSchemaLocation = atSchemaLocation;
    return this;
  }

  /**
   * A link to the schema describing this orderPrice extension.
   *
   * @return atSchemaLocation
   */
  public String getAtSchemaLocation() {
    return atSchemaLocation;
  }

  public void setAtSchemaLocation(String atSchemaLocation) {
    this.atSchemaLocation = atSchemaLocation;
  }

  public OrderPrice price(Price price) {
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

  public OrderPrice priceAlteration(List<PriceAlteration> priceAlteration) {
    this.priceAlteration = priceAlteration;
    return this;
  }

  public OrderPrice addPriceAlterationItem(PriceAlteration priceAlterationItem) {
    if (this.priceAlteration == null) {
      this.priceAlteration = new ArrayList<>();
    }
    this.priceAlteration.add(priceAlterationItem);
    return this;
  }

  /**
   * Get priceAlteration
   *
   * @return priceAlteration
   */
  public List<PriceAlteration> getPriceAlteration() {
    return priceAlteration;
  }

  public void setPriceAlteration(List<PriceAlteration> priceAlteration) {
    this.priceAlteration = priceAlteration;
  }

  public OrderPrice billingAccount(BillingAccountRef billingAccount) {
    this.billingAccount = billingAccount;
    return this;
  }

  /**
   * Get billingAccount
   *
   * @return billingAccount
   */
  public BillingAccountRef getBillingAccount() {
    return billingAccount;
  }

  public void setBillingAccount(BillingAccountRef billingAccount) {
    this.billingAccount = billingAccount;
  }

  /** Return true if this OrderPrice object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderPrice orderPrice = (OrderPrice) o;
    return Objects.equals(this.name, orderPrice.name)
        && Objects.equals(this.description, orderPrice.description)
        && Objects.equals(this.priceType, orderPrice.priceType)
        && Objects.equals(this.unitOfMeasure, orderPrice.unitOfMeasure)
        && Objects.equals(this.recurringChargePeriod, orderPrice.recurringChargePeriod)
        && Objects.equals(this.atType, orderPrice.atType)
        && Objects.equals(this.atSchemaLocation, orderPrice.atSchemaLocation)
        && Objects.equals(this.price, orderPrice.price)
        && Objects.equals(this.priceAlteration, orderPrice.priceAlteration)
        && Objects.equals(this.billingAccount, orderPrice.billingAccount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        name,
        description,
        priceType,
        unitOfMeasure,
        recurringChargePeriod,
        atType,
        atSchemaLocation,
        price,
        priceAlteration,
        billingAccount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderPrice {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    priceType: ").append(toIndentedString(priceType)).append("\n");
    sb.append("    unitOfMeasure: ").append(toIndentedString(unitOfMeasure)).append("\n");
    sb.append("    recurringChargePeriod: ")
        .append(toIndentedString(recurringChargePeriod))
        .append("\n");
    sb.append("    atType: ").append(toIndentedString(atType)).append("\n");
    sb.append("    atSchemaLocation: ").append(toIndentedString(atSchemaLocation)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    priceAlteration: ").append(toIndentedString(priceAlteration)).append("\n");
    sb.append("    billingAccount: ").append(toIndentedString(billingAccount)).append("\n");
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
