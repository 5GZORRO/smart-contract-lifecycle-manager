package eu._5gzorro.manager.api.model.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "bundled_offer_mappings")
public class BundledOfferMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private UUID id;

    @JsonProperty("bundleOfferDID")
    @Column(unique = true)
    private String bundleOfferDID;

    @JsonProperty("bundledOrderDIDs")
    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<String> bundledOrderDIDs;

    @JsonCreator
    public BundledOfferMapping(@JsonProperty("bundleOfferDID") String bundleOfferDID,
                               @JsonProperty("bundledOrderDIDs") List<String> bundledOrderDIDs) {
        this.bundleOfferDID = bundleOfferDID;
        this.bundledOrderDIDs = bundledOrderDIDs;
    }

    public BundledOfferMapping() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getBundleOfferDID() {
        return bundleOfferDID;
    }

    public void setBundleOfferDID(String bundleOfferDID) {
        this.bundleOfferDID = bundleOfferDID;
    }

    public List<String> getBundledOrderDIDs() {
        return bundledOrderDIDs;
    }

    public void setBundledOrderDIDs(List<String> bundledOrderDIDs) {
        this.bundledOrderDIDs = bundledOrderDIDs;
    }
}
