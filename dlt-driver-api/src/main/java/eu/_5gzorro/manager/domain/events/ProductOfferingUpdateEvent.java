package eu._5gzorro.manager.domain.events;

import eu._5gzorro.manager.domain.Invitation;
import eu._5gzorro.manager.domain.events.enums.UpdateType;
import it.nextworks.tmf_offering_catalog.information_models.product.ProductOffering;
import java.util.Map;

public class ProductOfferingUpdateEvent {
  private String identifier;
  private ProductOffering productOffering;
  private Map<String, Invitation> didInvitations;
  private UpdateType updateType;
  private String deduplicationId;

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

  @Override
  public String toString() {
    return "ProductOfferingUpdateEvent{" +
            "identifier='" + identifier + '\'' +
            ", productOffering=" + productOffering +
            ", didInvitations=" + didInvitations +
            ", updateType=" + updateType +
            ", deduplicationId='" + deduplicationId + '\'' +
            '}';
  }
}
