package eu._5gzorro.manager.domain;

import eu._5gzorro.tm_forum.models.TimePeriod;
import eu._5gzorro.tm_forum.models.product_order.ProductOrder;

public class ProductOrderDetails {
  private ProductOrder productOrder;
  private String supplierDid;
  private String offerDid; // Offer order is based off did
  private TimePeriod validFor;

  public ProductOrder getProductOrder() {
    return productOrder;
  }

  public ProductOrderDetails setProductOrder(ProductOrder productOrder) {
    this.productOrder = productOrder;
    return this;
  }

  public String getSupplierDid() {
    return supplierDid;
  }

  public ProductOrderDetails setSupplierDid(String supplierDid) {
    this.supplierDid = supplierDid;
    return this;
  }

  public String getOfferDid() {
    return offerDid;
  }

  public ProductOrderDetails setOfferDid(String offerDid) {
    this.offerDid = offerDid;
    return this;
  }

  public TimePeriod getValidFor() {
    return validFor;
  }

  public ProductOrderDetails setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }
}
