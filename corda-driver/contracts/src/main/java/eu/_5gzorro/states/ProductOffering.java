package eu._5gzorro.states;

import eu._5gzorro.contracts.ProductOfferingContract;
import eu._5gzorro.models.types.OfferStatus;
import eu._5gzorro.models.types.OfferType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import net.corda.core.contracts.BelongsToContract;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import net.corda.core.serialization.CordaSerializable;
import org.jetbrains.annotations.NotNull;

@BelongsToContract(ProductOfferingContract.class)
@CordaSerializable
public class ProductOffering extends PublicState {

  private OfferStatus offerStatus;
  private OfferType offerType;
  private String name;
  private List<Object> places; // TODO type: PlaceModel
  private List<Object> productOfferTerms; // TODO type: PlaceModel
  private Object serviceCandidate; // TODO type: ServiceCandidate
  private List<Object> serviceLevelAgreements; // TODO type: SLA
  private Map<Object, Object> didInvitations; // TODO type: DID + Invitation

  private final Party governanceOracle;
  private final Party spectrumOracle;

  // TODO Use ProductOffering model class for most parameters in constructor
  public ProductOffering(
      @NotNull UniqueIdentifier id,
      @NotNull OfferStatus offerStatus,
      @NotNull OfferType offerType,
      @NotNull String name,
      @NotNull Party owner,
      List<Object> places,
      List<Object> productOfferTerms,
      Object serviceCandidate,
      List<Object> serviceLevelAgreements,
      Map<Object, Object> didInvitations,
      @NotNull Party governanceOracle,
      Party spectrumOracle
  ) {
    super(id, owner);
    this.offerStatus = offerStatus;
    this.offerType = offerType;
    this.name = name;
    this.places = places;
    this.productOfferTerms = productOfferTerms;
    this.serviceCandidate = serviceCandidate;
    this.serviceLevelAgreements = serviceLevelAgreements;
    this.didInvitations = didInvitations;
    this.governanceOracle = governanceOracle;
    this.spectrumOracle = spectrumOracle;
  }

  public OfferType getOfferType() {
    return offerType;
  }

  public String getName() {
    return name;
  }

  public List<Object> getPlaces() {
    return places;
  }

  public List<Object> getProductOfferTerms() {
    return productOfferTerms;
  }

  public Object getServiceCandidate() {
    return serviceCandidate;
  }

  public List<Object> getServiceLevelAgreements() {
    return serviceLevelAgreements;
  }

  public Map<Object, Object> getDidInvitations() {
    return didInvitations;
  }

  public Party getGovernanceOracle() {
    return governanceOracle;
  }

  public Party getSpectrumOracle() {
    return spectrumOracle;
  }

  public OfferStatus getOfferStatus() {
    return offerStatus;
  }

  public ProductOffering setOfferType(OfferType offerType) {
    this.offerType = offerType;
    return this;
  }

  public ProductOffering setOfferStatus(OfferStatus offerStatus) {
    this.offerStatus = offerStatus;
    return this;
  }

  public ProductOffering setName(String name) {
    this.name = name;
    return this;
  }

  public ProductOffering setPlaces(List<Object> places) {
    this.places = places;
    return this;
  }

  public ProductOffering setProductOfferTerms(List<Object> productOfferTerms) {
    this.productOfferTerms = productOfferTerms;
    return this;
  }

  public ProductOffering setServiceCandidate(Object serviceCandidate) {
    this.serviceCandidate = serviceCandidate;
    return this;
  }

  public ProductOffering setServiceLevelAgreements(List<Object> serviceLevelAgreements) {
    this.serviceLevelAgreements = serviceLevelAgreements;
    return this;
  }

  public ProductOffering setDidInvitations(Map<Object, Object> didInvitations) {
    this.didInvitations = didInvitations;
    return this;
  }

  @NotNull
  @Override
  public List<AbstractParty> getParticipants() {
    List<AbstractParty> parties = Arrays.asList(super.getOwner(), governanceOracle);

    if(offerType == OfferType.SPECTRUM) {
      parties.add(spectrumOracle);
    }

    return parties;
  }
}
