package eu._5gzorro.controller.dto;

import eu._5gzorro.lifecycle.manager.domain.Invitation;
import eu._5gzorro.lifecycle.manager.domain.ProductOffering;
import eu._5gzorro.lifecycle.manager.domain.VerifiableCredential;
import java.util.Collection;
import java.util.Map;
import javax.validation.constraints.NotNull;

public class PublishProductOfferingRequest {
  @NotNull
  private ProductOffering productOffering;
  private Map<String, Invitation> invitations;
  private Collection<VerifiableCredential> verifiableCredentials;

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
}