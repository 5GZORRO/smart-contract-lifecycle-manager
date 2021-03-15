package eu._5gzorro.manager.domain.events;

import eu._5gzorro.manager.domain.Invitation;
import it.nextworks.tmf_offering_catalog.information_models.product.ProductOffering;
import java.util.Map;

public class ProductOfferingUpdateEvent {
  private String identifier;
  private ProductOffering productOffering;
  private Map<String, Invitation> didInvitations;

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

  public Map<String, Invitation> getDidInvitations() {
    return didInvitations;
  }

  public ProductOfferingUpdateEvent setDidInvitations(
      Map<String, Invitation> didInvitations) {
    this.didInvitations = didInvitations;
    return this;
  }

  @Override
  public String toString() {
    return "ProductOfferingUpdateEvent{" +
        "identifier='" + identifier + '\'' +
        ", productOffering=" + productOffering +
        ", didInvitations=" + didInvitations +
        '}';
  }
}
