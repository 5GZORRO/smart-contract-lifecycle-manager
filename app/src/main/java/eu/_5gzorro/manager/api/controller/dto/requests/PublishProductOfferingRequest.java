package eu._5gzorro.manager.api.controller.dto.requests;

import eu._5gzorro.manager.domain.Invitation;
import eu._5gzorro.manager.domain.ProductOfferDetails;
import eu._5gzorro.manager.domain.VerifiableCredential;
import eu._5gzorro.tm_forum.models.product.ProductOffering;
import eu._5gzorro.tm_forum.models.product.ProductOfferingPrice;
import eu._5gzorro.tm_forum.models.product.ProductSpecification;
import eu._5gzorro.tm_forum.models.resource.ResourceSpecification;
import eu._5gzorro.tm_forum.models.service.ServiceSpecification;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class PublishProductOfferingRequest {
  @NotNull
  private ProductOffering productOffering;
  private Map<String, Invitation> invitations;
  private Collection<VerifiableCredential> verifiableCredentials;
  private String did;
  private List<ProductOfferingPrice> productOfferingPrices;
  private ProductSpecification productSpecification;
  private List<ResourceSpecification> resourceSpecifications;
  private List<ServiceSpecification> serviceSpecifications;

  public ProductOffering getProductOffering() {
    return productOffering;
  }

  public PublishProductOfferingRequest setProductOffering(
      ProductOffering productOffering) {
    this.productOffering = productOffering;
    return this;
  }

  public Map<String, Invitation> getInvitations() {
    return invitations;
  }

  public PublishProductOfferingRequest setInvitations(
      Map<String, Invitation> invitations) {
    this.invitations = invitations;
    return this;
  }

  public Collection<VerifiableCredential> getVerifiableCredentials() {
    return verifiableCredentials;
  }

  public PublishProductOfferingRequest setVerifiableCredentials(
      Collection<VerifiableCredential> verifiableCredentials) {
    this.verifiableCredentials = verifiableCredentials;
    return this;
  }

  public String getDid() {
    return did;
  }

  public PublishProductOfferingRequest setDid(String did) {
    this.did = did;
    return this;
  }

  public List<ProductOfferingPrice> getProductOfferingPrices() {
    return productOfferingPrices;
  }

  public PublishProductOfferingRequest setProductOfferingPrices(List<ProductOfferingPrice> productOfferingPrices) {
    this.productOfferingPrices = productOfferingPrices;
    return this;
  }

  public ProductSpecification getProductSpecification() {
    return productSpecification;
  }

  public PublishProductOfferingRequest setProductSpecification(ProductSpecification productSpecification) {
    this.productSpecification = productSpecification;
    return this;
  }

  public List<ResourceSpecification> getResourceSpecifications() {
    return resourceSpecifications;
  }

  public PublishProductOfferingRequest setResourceSpecifications(List<ResourceSpecification> resourceSpecifications) {
    this.resourceSpecifications = resourceSpecifications;
    return this;
  }

  public List<ServiceSpecification> getServiceSpecifications() {
    return serviceSpecifications;
  }

  public PublishProductOfferingRequest setServiceSpecifications(List<ServiceSpecification> serviceSpecifications) {
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
