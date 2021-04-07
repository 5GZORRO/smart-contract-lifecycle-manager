package eu._5gzorro.tm_forum.models.product;

import java.util.Objects;

/**
 * The event data structure
 */







public class ProductOfferingAttributeValueChangeEventPayload   {
 
  private ProductOffering productOffering = null;

  public ProductOfferingAttributeValueChangeEventPayload productOffering(ProductOffering productOffering) {
    this.productOffering = productOffering;
    return this;
  }

  /**
   * The involved resource data for the event
   *
  **/
 

 

  public ProductOffering getProductOffering() {
    return productOffering;
  }

  public void setProductOffering(ProductOffering productOffering) {
    this.productOffering = productOffering;
  }


 
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductOfferingAttributeValueChangeEventPayload productOfferingAttributeValueChangeEventPayload = (ProductOfferingAttributeValueChangeEventPayload) o;
    return Objects.equals(this.productOffering, productOfferingAttributeValueChangeEventPayload.productOffering);
  }

 
  public int hashCode() {
    return Objects.hash(productOffering);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductOfferingAttributeValueChangeEventPayload {\n");
    
    sb.append("    productOffering: ").append(toIndentedString(productOffering)).append("\n");
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

