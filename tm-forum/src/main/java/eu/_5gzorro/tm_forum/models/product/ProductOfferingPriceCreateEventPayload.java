package eu._5gzorro.tm_forum.models.product;

import java.util.Objects;

/**
 * The event data structure
 */







public class ProductOfferingPriceCreateEventPayload   {

  private ProductOfferingPrice productOfferingPrice = null;

  public ProductOfferingPriceCreateEventPayload productOfferingPrice(ProductOfferingPrice productOfferingPrice) {
    this.productOfferingPrice = productOfferingPrice;
    return this;
  }

  /**
   * The involved resource data for the event
   *
  **/




  public ProductOfferingPrice getProductOfferingPrice() {
    return productOfferingPrice;
  }

  public void setProductOfferingPrice(ProductOfferingPrice productOfferingPrice) {
    this.productOfferingPrice = productOfferingPrice;
  }



  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductOfferingPriceCreateEventPayload productOfferingPriceCreateEventPayload = (ProductOfferingPriceCreateEventPayload) o;
    return Objects.equals(this.productOfferingPrice, productOfferingPriceCreateEventPayload.productOfferingPrice);
  }


  public int hashCode() {
    return Objects.hash(productOfferingPrice);
  }


  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductOfferingPriceCreateEventPayload {\n");
    
    sb.append("    productOfferingPrice: ").append(toIndentedString(productOfferingPrice)).append("\n");
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

