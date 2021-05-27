package eu._5gzorro.manager.api.dto.requests;

import eu._5gzorro.manager.domain.Invitation;
import eu._5gzorro.manager.domain.ProductOfferDetails;
import eu._5gzorro.tm_forum.models.product.ProductOffering;
import eu._5gzorro.tm_forum.models.product.ProductOfferingPrice;
import eu._5gzorro.tm_forum.models.product.ProductSpecification;
import eu._5gzorro.tm_forum.models.resource.ResourceSpecification;
import eu._5gzorro.tm_forum.models.service.ServiceSpecification;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

public class UpdateProductOfferingRequest {
  @NotNull private ProductOffering productOffering;
  private Map<String, Invitation> invitations;
  @NotBlank private String did;
  @NotNull private List<ProductOfferingPrice> productOfferingPrices;
  @NotNull private ProductSpecification productSpecification;
  @NotNull private List<ResourceSpecification> resourceSpecifications;
  @NotNull private List<ServiceSpecification> serviceSpecifications;

  public ProductOffering getProductOffering() {
    return productOffering;
  }

  public UpdateProductOfferingRequest setProductOffering(
      ProductOffering productOffering) {
    this.productOffering = productOffering;
    return this;
  }

  public Map<String, Invitation> getInvitations() {
    return invitations;
  }

  public UpdateProductOfferingRequest setInvitations(
      Map<String, Invitation> invitations) {
    this.invitations = invitations;
    return this;
  }

  public String getDid() {
    return did;
  }

  public UpdateProductOfferingRequest setDid(String did) {
    this.did = did;
    return this;
  }

  public List<ProductOfferingPrice> getProductOfferingPrices() {
    return productOfferingPrices;
  }

  public UpdateProductOfferingRequest setProductOfferingPrices(List<ProductOfferingPrice> productOfferingPrices) {
    this.productOfferingPrices = productOfferingPrices;
    return this;
  }

  public ProductSpecification getProductSpecification() {
    return productSpecification;
  }

  public UpdateProductOfferingRequest setProductSpecification(ProductSpecification productSpecification) {
    this.productSpecification = productSpecification;
    return this;
  }

  public List<ResourceSpecification> getResourceSpecifications() {
    return resourceSpecifications;
  }

  public UpdateProductOfferingRequest setResourceSpecifications(List<ResourceSpecification> resourceSpecifications) {
    this.resourceSpecifications = resourceSpecifications;
    return this;
  }

  public List<ServiceSpecification> getServiceSpecifications() {
    return serviceSpecifications;
  }

  public UpdateProductOfferingRequest setServiceSpecifications(List<ServiceSpecification> serviceSpecifications) {
    this.serviceSpecifications = serviceSpecifications;
    return this;
  }

  public ProductOfferDetails toOfferDetails() {
    return new ProductOfferDetails()
        .setProductOffering(productOffering)
        .setProductSpecification(productSpecification)
        .setResourceSpecifications(resourceSpecifications)
        .setServiceSpecifications(serviceSpecifications)
        .setProductOfferingPrices(productOfferingPrices)
        .setDid(did);
  }
}
