package eu._5gzorro.manager.domain.events;

import eu._5gzorro.manager.domain.Invitation;
import eu._5gzorro.manager.domain.VerifiableCredential;
import eu._5gzorro.manager.domain.events.enums.UpdateType;
import eu._5gzorro.tm_forum.models.GeographicAddress;
import eu._5gzorro.tm_forum.models.product.ProductOffering;
import eu._5gzorro.tm_forum.models.product.ProductOfferingPrice;
import eu._5gzorro.tm_forum.models.product.ProductSpecification;
import eu._5gzorro.tm_forum.models.resource.ResourceSpecification;
import eu._5gzorro.tm_forum.models.service.ServiceSpecification;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ProductOfferingUpdateEvent {
  private String identifier;
  private ProductOffering productOffering;
  private Map<String, Invitation> invitations;
  private Collection<VerifiableCredential> verifiableCredentials;
  private String did;
  private List<ProductOfferingPrice> productOfferingPrices;
  private ProductSpecification productSpecification;
  private List<ResourceSpecification> resourceSpecifications;
  private List<ServiceSpecification> serviceSpecifications;
  private List<GeographicAddress> geographicAddresses;

  private UpdateType updateType;
  private String deduplicationId;
  private boolean deleted;

  public String getIdentifier() {
    return identifier;
  }

  public ProductOfferingUpdateEvent setIdentifier(String identifier) {
    this.identifier = identifier;
    return this;
  }

  public ProductOffering getProductOffering() {
    return productOffering;
  }

  public ProductOfferingUpdateEvent setProductOffering(
      ProductOffering productOffering) {
    this.productOffering = productOffering;
    return this;
  }

  public Map<String, Invitation> getInvitations() {
    return invitations;
  }

  public ProductOfferingUpdateEvent setInvitations(
      Map<String, Invitation> invitations) {
    this.invitations = invitations;
    return this;
  }

  public UpdateType getUpdateType() {
    return updateType;
  }

  public ProductOfferingUpdateEvent setUpdateType(UpdateType updateType) {
    this.updateType = updateType;
    return this;
  }

  public String getDeduplicationId() {
    return deduplicationId;
  }

  public ProductOfferingUpdateEvent setDeduplicationId(String deduplicationId) {
    this.deduplicationId = deduplicationId;
    return this;
  }

  public String getDid() {
    return did;
  }

  public ProductOfferingUpdateEvent setDid(String did) {
    this.did = did;
    return this;
  }

  public List<ProductOfferingPrice> getProductOfferingPrices() {
    return productOfferingPrices;
  }

  public ProductOfferingUpdateEvent setProductOfferingPrices(List<ProductOfferingPrice> productOfferingPrices) {
    this.productOfferingPrices = productOfferingPrices;
    return this;
  }

  public ProductSpecification getProductSpecification() {
    return productSpecification;
  }

  public ProductOfferingUpdateEvent setProductSpecification(ProductSpecification productSpecification) {
    this.productSpecification = productSpecification;
    return this;
  }

  public List<ResourceSpecification> getResourceSpecifications() {
    return resourceSpecifications;
  }

  public ProductOfferingUpdateEvent setResourceSpecifications(List<ResourceSpecification> resourceSpecifications) {
    this.resourceSpecifications = resourceSpecifications;
    return this;
  }

  public List<ServiceSpecification> getServiceSpecifications() {
    return serviceSpecifications;
  }

  public ProductOfferingUpdateEvent setServiceSpecifications(List<ServiceSpecification> serviceSpecifications) {
    this.serviceSpecifications = serviceSpecifications;
    return this;
  }

  public List<GeographicAddress> getGeographicAddresses() {
    return geographicAddresses;
  }

  public ProductOfferingUpdateEvent setGeographicAddresses(List<GeographicAddress> geographicAddresses) {
    this.geographicAddresses = geographicAddresses;
    return this;
  }

  public Collection<VerifiableCredential> getVerifiableCredentials() {
    return verifiableCredentials;
  }

  public ProductOfferingUpdateEvent setVerifiableCredentials(Collection<VerifiableCredential> verifiableCredentials) {
    this.verifiableCredentials = verifiableCredentials;
    return this;
  }

  public ProductOfferingUpdateEvent setDeleted(boolean deleted) {
    this.deleted = deleted;
    return this;
  }

  public boolean isDeleted() {
    return deleted;
  }

  @Override
  public String toString() {
    return "ProductOfferingUpdateEvent{" +
        "identifier='" + identifier + '\'' +
        ", productOffering=" + productOffering +
        ", invitations=" + invitations +
        ", verifiableCredentials=" + verifiableCredentials +
        ", did='" + did + '\'' +
        ", productOfferingPrices=" + productOfferingPrices +
        ", productSpecification=" + productSpecification +
        ", resourceSpecifications=" + resourceSpecifications +
        ", serviceSpecifications=" + serviceSpecifications +
        ", geographicAddresses=" + geographicAddresses +
        ", updateType=" + updateType +
        ", deduplicationId='" + deduplicationId + '\'' +
        ", deleted=" + deleted +
        '}';
  }
}
