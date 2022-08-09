package eu._5gzorro.manager.dlt.corda.states;

import eu._5gzorro.manager.dlt.corda.contracts.ProductOrderContract;
import eu._5gzorro.manager.dlt.corda.models.types.OfferType;
import eu._5gzorro.manager.dlt.corda.models.types.OrderState;
import eu._5gzorro.manager.domain.Invitation;
import eu._5gzorro.tm_forum.models.TimePeriod;
import net.corda.core.contracts.*;
import net.corda.core.crypto.SecureHash;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import net.corda.core.serialization.ConstructorForDeserialization;
import net.corda.core.serialization.CordaSerializable;
import org.jetbrains.annotations.NotNull;

import java.security.PublicKey;
import java.util.*;
import java.util.stream.Collectors;

@BelongsToContract(ProductOrderContract.class)
@CordaSerializable
public class ProductOrder implements ContractState, LinearState {
  private final UniqueIdentifier identifier;

  private final Party buyer;
  private final Party seller;

  private Party governanceParty;
  private Party spectrumRegulator;

  private StaticPointer<ProductOffering> offerRef;

  private SecureHash model;
  private SecureHash proposedModel;

  private OrderState state;
  private OfferType offerType;
  private TimePeriod validFor;
  private Map<String, Invitation> didInvitations;

  @ConstructorForDeserialization
  public ProductOrder(UniqueIdentifier identifier, Party buyer, Party seller, Party governanceParty, Party spectrumRegulator, StaticPointer<ProductOffering> offerRef, SecureHash model, SecureHash proposedModel, OrderState state, OfferType offerType, TimePeriod validFor, Map<String, Invitation> didInvitations) {
    this.identifier = identifier;
    this.buyer = buyer;
    this.seller = seller;
    this.governanceParty = governanceParty;
    this.spectrumRegulator = spectrumRegulator;
    this.offerRef = offerRef;
    this.model = model;
    this.proposedModel = proposedModel;
    this.state = state;
    this.offerType = offerType;
    this.validFor = validFor;
    this.didInvitations = didInvitations;
  }

  public ProductOrder(ProductOrder other) {
    this.identifier = other.identifier;
    this.buyer = other.buyer;
    this.seller = other.seller;
    this.governanceParty = other.governanceParty;
    this.spectrumRegulator = other.spectrumRegulator;
    this.offerRef = other.offerRef;
    this.model = other.model;
    this.proposedModel = other.proposedModel;
    this.offerType = other.offerType;
    this.validFor = other.validFor;
    this.didInvitations = other.didInvitations;
    this.state = other.state;
  }

  public ProductOrder(UniqueIdentifier identifier) {
    this.identifier = identifier;
    this.buyer = null;
    this.seller = null;
  }

  public List<PublicKey> getRequiredSigners() {
    return getParticipants().stream()
        .map(AbstractParty::getOwningKey)
        .collect(Collectors.toList());
  }

  public boolean partiesNotChanged(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ProductOrder offering = (ProductOrder) o;

    if (!Objects.equals(seller.getOwningKey(), offering.getSeller().getOwningKey())) {
      return false;
    }

    if (!Objects.equals(buyer.getOwningKey(), offering.getBuyer().getOwningKey())) {
      return false;
    }

    if (!Objects.equals(governanceParty.getOwningKey(), offering.governanceParty.getOwningKey())) {
      return false;
    }

    if(offerType == OfferType.SPECTRUM && //NOSONAR
        !Objects.equals(spectrumRegulator.getOwningKey(), offering.spectrumRegulator.getOwningKey())) {
      return false;
    }

    return true;
  }

  @NotNull
  @Override
  public List<AbstractParty> getParticipants() {
    List<AbstractParty> parties = new ArrayList<>();
    parties.add(buyer);
    parties.add(seller);
    parties.add(governanceParty);

    if(offerType == OfferType.SPECTRUM) {
      parties.add(spectrumRegulator);
    }

    return parties;
  }

  @NotNull
  @Override
  public UniqueIdentifier getLinearId() {
    return identifier;
  }

  public UniqueIdentifier getIdentifier() {
    return identifier;
  }

  public OfferType getOfferType() {
    return offerType;
  }

  public Party getBuyer() {
    return buyer;
  }

  public Party getSeller() {
    return seller;
  }

  public Party getGovernanceParty() {
    return governanceParty;
  }

  public Party getSpectrumRegulator() {
    return spectrumRegulator;
  }

  public StaticPointer<ProductOffering> getOfferRef() {
    return offerRef;
  }

  public SecureHash getModel() {
    return model;
  }

  public SecureHash getProposedModel() {
    return proposedModel;
  }

  public TimePeriod getValidFor() {
    return validFor;
  }

  public Map<String, Invitation> getDidInvitations() {
    return didInvitations;
  }

  public OrderState getState() {
    return state;
  }

  public ProductOrder setGovernanceParty(Party governanceParty) {
    this.governanceParty = governanceParty;
    return this;
  }

  public ProductOrder setSpectrumRegulator(Party spectrumRegulator) {
    this.spectrumRegulator = spectrumRegulator;
    return this;
  }

  public ProductOrder setOfferRef(StaticPointer<ProductOffering> offerRef) {
    this.offerRef = offerRef;
    return this;
  }

  public ProductOrder setModel(SecureHash model) {
    this.model = model;
    return this;
  }

  public ProductOrder setProposedModel(SecureHash proposedModel) {
    this.proposedModel = proposedModel;
    return this;
  }

  public ProductOrder setOfferType(OfferType offerType) {
    this.offerType = offerType;
    return this;
  }

  public ProductOrder setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  public ProductOrder setDidInvitations(Map<String, Invitation> didInvitations) {
    this.didInvitations = didInvitations;
    return this;
  }

  public ProductOrder setState(OrderState state) {
    this.state = state;
    return this;
  }

  /**
   * Utility function to return a list of the buyer and seller parties in the ContractState
   * @return List of the buyer and seller
   */
  public List<AbstractParty> getOrderBilateralParties() {
    return Arrays.asList(buyer, seller);
  }
}
