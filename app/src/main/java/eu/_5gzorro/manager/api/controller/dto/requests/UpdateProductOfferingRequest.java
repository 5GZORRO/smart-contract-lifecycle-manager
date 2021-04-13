package eu._5gzorro.manager.api.controller.dto.requests;

import eu._5gzorro.manager.domain.Invitation;
import eu._5gzorro.manager.domain.VerifiableCredential;
import eu._5gzorro.tm_forum.models.product.ProductOffering;
import java.util.Map;
import javax.validation.constraints.NotNull;

public class UpdateProductOfferingRequest {
  @NotNull
  private ProductOffering productOffering;
  private Map<String, Invitation> invitations;
  private VerifiableCredential verifiableCredentials;

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

  public VerifiableCredential getVerifiableCredentials() {
    return verifiableCredentials;
  }

  public UpdateProductOfferingRequest setVerifiableCredentials(
      VerifiableCredential verifiableCredentials) {
    this.verifiableCredentials = verifiableCredentials;
    return this;
  }
}