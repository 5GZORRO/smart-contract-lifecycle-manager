package eu._5gzorro.tm_forum.models.product;

import java.util.Objects;

/**
 * The event data structure
 */







public class ProductSpecificationDeleteEventPayload   {
 
  private ProductSpecification productSpecification = null;

  public ProductSpecificationDeleteEventPayload productSpecification(ProductSpecification productSpecification) {
    this.productSpecification = productSpecification;
    return this;
  }

  /**
   * The involved resource data for the event
   *
  **/
 

 

  public ProductSpecification getProductSpecification() {
    return productSpecification;
  }

  public void setProductSpecification(ProductSpecification productSpecification) {
    this.productSpecification = productSpecification;
  }


 
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductSpecificationDeleteEventPayload productSpecificationDeleteEventPayload = (ProductSpecificationDeleteEventPayload) o;
    return Objects.equals(this.productSpecification, productSpecificationDeleteEventPayload.productSpecification);
  }

 
  public int hashCode() {
    return Objects.hash(productSpecification);
  }

 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductSpecificationDeleteEventPayload {\n");
    
    sb.append("    productSpecification: ").append(toIndentedString(productSpecification)).append("\n");
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

