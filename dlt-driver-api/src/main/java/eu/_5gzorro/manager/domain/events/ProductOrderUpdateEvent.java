package eu._5gzorro.manager.domain.events;

import eu._5gzorro.manager.domain.Invitation;
import eu._5gzorro.manager.domain.VerifiableCredential;
import eu._5gzorro.manager.domain.events.enums.OrderUpdateType;
import eu._5gzorro.tm_forum.models.product_order.ProductOrder;

import java.util.Collection;
import java.util.Map;

public class ProductOrderUpdateEvent {
    private String identifier;
    private ProductOrder productOrder;
    private Map<String, Invitation> invitations;
    private Collection<VerifiableCredential> verifiableCredentials;
    private String did;
    private OrderUpdateType updateType;
    private String deduplicationId;
    private boolean deleted;
    private boolean spectrum;
    private String sellerName;

    public String getIdentifier() {
        return identifier;
    }

    public ProductOrder getProductOrder() {
        return productOrder;
    }

    public ProductOrderUpdateEvent setProductOrder(ProductOrder productOrder) {
        this.productOrder = productOrder;
        return this;
    }

    public ProductOrderUpdateEvent setIdentifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    public Map<String, Invitation> getInvitations() {
        return invitations;
    }

    public ProductOrderUpdateEvent setInvitations(
        Map<String, Invitation> invitations) {
        this.invitations = invitations;
        return this;
    }

    public OrderUpdateType getUpdateType() {
        return updateType;
    }

    public ProductOrderUpdateEvent setUpdateType(OrderUpdateType updateType) {
        this.updateType = updateType;
        return this;
    }

    public String getDeduplicationId() {
        return deduplicationId;
    }

    public ProductOrderUpdateEvent setDeduplicationId(String deduplicationId) {
        this.deduplicationId = deduplicationId;
        return this;
    }

    public String getDid() {
        return did;
    }

    public ProductOrderUpdateEvent setDid(String did) {
        this.did = did;
        return this;
    }

    public Collection<VerifiableCredential> getVerifiableCredentials() {
        return verifiableCredentials;
    }

    public ProductOrderUpdateEvent setVerifiableCredentials(Collection<VerifiableCredential> verifiableCredentials) {
        this.verifiableCredentials = verifiableCredentials;
        return this;
    }

    public ProductOrderUpdateEvent setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public boolean isSpectrum() {
        return spectrum;
    }

    public ProductOrderUpdateEvent setSpectrum(boolean spectrum) {
        this.spectrum = spectrum;
        return this;
    }

    public String getSellerName() {
        return sellerName;
    }

    public ProductOrderUpdateEvent setSellerName(String sellerName) {
        this.sellerName = sellerName;
        return this;
    }

    @Override
    public String toString() {
        return "ProductOrderUpdateEvent{" +
            "identifier='" + identifier + '\'' +
            ", productOrder=" + productOrder +
            ", invitations=" + invitations +
            ", verifiableCredentials=" + verifiableCredentials +
            ", did='" + did + '\'' +
            ", updateType=" + updateType +
            ", deduplicationId='" + deduplicationId + '\'' +
            ", deleted=" + deleted +
            ", spectrum=" + spectrum +
            ", seller=" + sellerName +
            '}';
    }
}
