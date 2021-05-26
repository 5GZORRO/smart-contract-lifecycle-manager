package eu._5gzorro.manager.api.controller.dto.requests;

import eu._5gzorro.manager.domain.Invitation;
import eu._5gzorro.manager.domain.ProductOrderDetails;
import eu._5gzorro.manager.domain.VerifiableCredential;
import eu._5gzorro.tm_forum.models.TimePeriod;
import eu._5gzorro.tm_forum.models.product_order.ProductOrder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Map;

public class PublishProductOrderRequest {
  @NotNull private ProductOrder productOrder;
  private Map<String, Invitation> invitations;
  private Collection<VerifiableCredential> verifiableCredentials;
  @NotBlank private String did;
  private String supplierDid;
  private TimePeriod validFor;

  public ProductOrder getProductOrder() {
    return productOrder;
  }

  public PublishProductOrderRequest setProductOrder(ProductOrder productOrder) {
    this.productOrder = productOrder;
    return this;
  }

  public Map<String, Invitation> getInvitations() {
    return invitations;
  }

  public PublishProductOrderRequest setInvitations(Map<String, Invitation> invitations) {
    this.invitations = invitations;
    return this;
  }

  public Collection<VerifiableCredential> getVerifiableCredentials() {
    return verifiableCredentials;
  }

  public PublishProductOrderRequest setVerifiableCredentials(
      Collection<VerifiableCredential> verifiableCredentials) {
    this.verifiableCredentials = verifiableCredentials;
    return this;
  }

  public String getDid() {
    return did;
  }

  public PublishProductOrderRequest setDid(String did) {
    this.did = did;
    return this;
  }

  public String getSupplierDid() {
    return supplierDid;
  }

  public PublishProductOrderRequest setSupplierDid(String supplierDid) {
    this.supplierDid = supplierDid;
    return this;
  }

  public TimePeriod getValidFor() {
    return validFor;
  }

  public PublishProductOrderRequest setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  public ProductOrderDetails toOrderDetails() {
    return new ProductOrderDetails()
        .setProductOrder(productOrder)
        .setSupplierDid(supplierDid)
        .setValidFor(validFor)
        .setOfferDid(did);
  }
}
