package eu._5gzorro.tm_forum.models.product_order;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import eu._5gzorro.tm_forum.models.product.Money;

/**
 * Provides all amounts (tax included, duty free, tax rate), used currency and percentage to apply
 * for Price Alteration.
 */
public class Price {
  private Money taxIncludedAmount;
  private Money dutyFreeAmount;
  private Float taxRate;
  private Float percentage;
  private String atType;
  private String atSchemaLocation;

  public Price taxIncludedAmount(Money taxIncludedAmount) {
    this.taxIncludedAmount = taxIncludedAmount;
    return this;
  }

  /**
   * Get taxIncludedAmount
   *
   * @return taxIncludedAmount
   */
  public Money getTaxIncludedAmount() {
    return taxIncludedAmount;
  }

  public void setTaxIncludedAmount(Money taxIncludedAmount) {
    this.taxIncludedAmount = taxIncludedAmount;
  }

  public Price dutyFreeAmount(Money dutyFreeAmount) {
    this.dutyFreeAmount = dutyFreeAmount;
    return this;
  }

  /**
   * Get dutyFreeAmount
   *
   * @return dutyFreeAmount
   */
  public Money getDutyFreeAmount() {
    return dutyFreeAmount;
  }

  public void setDutyFreeAmount(Money dutyFreeAmount) {
    this.dutyFreeAmount = dutyFreeAmount;
  }

  public Price taxRate(Float taxRate) {
    this.taxRate = taxRate;
    return this;
  }

  /**
   * Tax rate.
   *
   * @return taxRate
   */
  public Float getTaxRate() {
    return taxRate;
  }

  public void setTaxRate(Float taxRate) {
    this.taxRate = taxRate;
  }

  public Price percentage(Float percentage) {
    this.percentage = percentage;
    return this;
  }

  /**
   * Percentage to apply for ProdOfferPriceAlteration.
   *
   * @return percentage
   */
  public Float getPercentage() {
    return percentage;
  }

  public void setPercentage(Float percentage) {
    this.percentage = percentage;
  }

  public Price atType(String atType) {
    this.atType = atType;
    return this;
  }

  /**
   * Indicates the (class) type of the price.
   *
   * @return atType
   */
  public String getAtType() {
    return atType;
  }

  public void setAtType(String atType) {
    this.atType = atType;
  }

  public Price atSchemaLocation(String atSchemaLocation) {
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

  /** Return true if this Price object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Price price = (Price) o;
    return Objects.equals(this.taxIncludedAmount, price.taxIncludedAmount)
        && Objects.equals(this.dutyFreeAmount, price.dutyFreeAmount)
        && Objects.equals(this.taxRate, price.taxRate)
        && Objects.equals(this.percentage, price.percentage)
        && Objects.equals(this.atType, price.atType)
        && Objects.equals(this.atSchemaLocation, price.atSchemaLocation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        taxIncludedAmount, dutyFreeAmount, taxRate, percentage, atType, atSchemaLocation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Price {\n");
    sb.append("    taxIncludedAmount: ").append(toIndentedString(taxIncludedAmount)).append("\n");
    sb.append("    dutyFreeAmount: ").append(toIndentedString(dutyFreeAmount)).append("\n");
    sb.append("    taxRate: ").append(toIndentedString(taxRate)).append("\n");
    sb.append("    percentage: ").append(toIndentedString(percentage)).append("\n");
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
