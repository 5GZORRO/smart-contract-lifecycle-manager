package eu._5gzorro.manager.domain;

import eu._5gzorro.tm_forum.models.product.ProductOffering;
import eu._5gzorro.tm_forum.models.product.ProductOfferingPrice;
import eu._5gzorro.tm_forum.models.product.ProductSpecification;
import eu._5gzorro.tm_forum.models.resource.ResourceSpecification;
import eu._5gzorro.tm_forum.models.service.ServiceSpecification;

import java.util.Collection;
import java.util.List;

public class ProductOfferDetails {
  private ProductOffering productOffering;
  private List<ProductOfferingPrice> productOfferingPrices;
  private ProductSpecification productSpecification;
  private List<ResourceSpecification> resourceSpecifications;
  private List<ServiceSpecification> serviceSpecifications;
  private String did;

  public ProductOffering getProductOffering() {
    return productOffering;
  }

  public ProductOfferDetails setProductOffering(ProductOffering productOffering) {
    this.productOffering = productOffering;
    return this;
  }

  public List<ProductOfferingPrice> getProductOfferingPrices() {
    return productOfferingPrices;
  }

  public ProductOfferDetails setProductOfferingPrices(List<ProductOfferingPrice> productOfferingPrices) {
    this.productOfferingPrices = productOfferingPrices;
    return this;
  }

  public ProductSpecification getProductSpecification() {
    return productSpecification;
  }

  public ProductOfferDetails setProductSpecification(ProductSpecification productSpecification) {
    this.productSpecification = productSpecification;
    return this;
  }

  public List<ResourceSpecification> getResourceSpecifications() {
    return resourceSpecifications;
  }

  public ProductOfferDetails setResourceSpecifications(List<ResourceSpecification> resourceSpecifications) {
    this.resourceSpecifications = resourceSpecifications;
    return this;
  }

  public List<ServiceSpecification> getServiceSpecifications() {
    return serviceSpecifications;
  }

  public ProductOfferDetails setServiceSpecifications(List<ServiceSpecification> serviceSpecifications) {
    this.serviceSpecifications = serviceSpecifications;
    return this;
  }

  public String getDid() {
    return did;
  }

  public ProductOfferDetails setDid(String did) {
    this.did = did;
    return this;
  }
}
