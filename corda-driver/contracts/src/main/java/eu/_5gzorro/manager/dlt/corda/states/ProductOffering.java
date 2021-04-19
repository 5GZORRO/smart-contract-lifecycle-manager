package eu._5gzorro.manager.dlt.corda.states;

import eu._5gzorro.manager.dlt.corda.contracts.ProductOfferingContract;
import eu._5gzorro.manager.dlt.corda.models.types.OfferType;
import eu._5gzorro.manager.domain.Invitation;
import eu._5gzorro.manager.domain.ProductOfferDetails;
import eu._5gzorro.manager.domain.VerifiableCredential;
import net.corda.core.contracts.BelongsToContract;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import net.corda.core.serialization.CordaSerializable;
import org.jetbrains.annotations.NotNull;

import java.security.PublicKey;
import java.util.*;
import java.util.stream.Collectors;

@BelongsToContract(ProductOfferingContract.class)
@CordaSerializable
public class ProductOffering extends PublicState {
  private OfferType offerType;
  private String name;
  private Map<String, Invitation> didInvitations;
  private Collection<VerifiableCredential> verifiableCredentials;
  private ProductOfferDetails offerDetails;

  private final Party governanceParty;
  private final Party spectrumOracle;

  public ProductOffering(
      @NotNull UniqueIdentifier id,
      @NotNull OfferType offerType,
      @NotNull String name,
      @NotNull Party owner,
      Map<String, Invitation> didInvitations,
      Collection<VerifiableCredential> verifiableCredentials,
      @NotNull Party governanceParty,
      Party spectrumOracle,
      @NotNull ProductOfferDetails offerDetails
  ) {
    super(id, owner);
    this.offerType = offerType;
    this.name = name;
    this.verifiableCredentials = verifiableCredentials;
    this.offerDetails = offerDetails;
    this.didInvitations = didInvitations;
    this.governanceParty = governanceParty;
    this.spectrumOracle = spectrumOracle;
  }

  public OfferType getOfferType() {
    return offerType;
  }

  public String getName() {
    return name;
  }

  public ProductOfferDetails getOfferDetails() {
    return offerDetails;
  }

  public ProductOffering setOfferDetails(ProductOfferDetails offerDetails) {
    this.offerDetails = offerDetails;
    return this;
  }

  public Map<String, Invitation> getDidInvitations() {
    return didInvitations;
  }

  public Party getGovernanceParty() {
    return governanceParty;
  }

  public Party getSpectrumOracle() {
    return spectrumOracle;
  }

  public ProductOffering setOfferType(OfferType offerType) {
    this.offerType = offerType;
    return this;
  }

  public ProductOffering setName(String name) {
    this.name = name;
    return this;
  }

  public ProductOffering setDidInvitations(Map<String, Invitation> didInvitations) {
    this.didInvitations = didInvitations;
    return this;
  }

  public Collection<VerifiableCredential> getVerifiableCredentials() {
    return verifiableCredentials;
  }

  public ProductOffering setVerifiableCredentials(Collection<VerifiableCredential> verifiableCredentials) {
    this.verifiableCredentials = verifiableCredentials;
    return this;
  }

  @NotNull
  @Override
  public List<AbstractParty> getParticipants() {
    List<AbstractParty> parties = Arrays.asList(super.getOwner(), governanceParty);

    if(offerType == OfferType.SPECTRUM) {
      parties.add(spectrumOracle);
    }

    return parties;
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

    ProductOffering offering = (ProductOffering) o;

    if (!Objects.equals(getOwner().getOwningKey(), offering.getOwner().getOwningKey())) {
      return false;
    }
    if (!Objects.equals(governanceParty.getOwningKey(), offering.governanceParty.getOwningKey())) {
      return false;
    }

    if(offerType == OfferType.SPECTRUM && //NOSONAR
        !Objects.equals(spectrumOracle.getOwningKey(), offering.spectrumOracle.getOwningKey())) {
      return false;
    }

    return true;
  }

  public ProductOffering copy() {
    return new ProductOffering(
        getLinearId(),
        offerType,
        name,
        getOwner(),
        didInvitations,
        verifiableCredentials,
        governanceParty,
        spectrumOracle,
        offerDetails
    );
  }
}
