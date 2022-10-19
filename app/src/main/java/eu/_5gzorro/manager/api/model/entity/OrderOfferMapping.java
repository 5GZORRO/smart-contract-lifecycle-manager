package eu._5gzorro.manager.api.model.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "order_offer_mappings")
public class OrderOfferMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private UUID id;

    @JsonProperty("offerDid")
    private String offerDid;

    @JsonProperty("orderDid")
    private String orderDid;

    public OrderOfferMapping() {
    }

    @JsonCreator
    public OrderOfferMapping(@JsonProperty("offerDid") String offerDid,
                             @JsonProperty("orderDid") String orderDid) {
        this.offerDid = offerDid;
        this.orderDid = orderDid;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getOfferDid() {
        return offerDid;
    }

    public void setOfferDid(String offerDid) {
        this.offerDid = offerDid;
    }

    public String getOrderDid() {
        return orderDid;
    }

    public void setOrderDid(String orderDid) {
        this.orderDid = orderDid;
    }

}
