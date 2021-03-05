package eu._5gzorro.manager.dlt.corda.states;

import eu._5gzorro.manager.dlt.corda.contracts.ProductOfferingContract;
import eu._5gzorro.manager.domain.Invitation;
import eu._5gzorro.manager.dlt.corda.models.types.OfferType;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import net.corda.core.contracts.BelongsToContract;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import net.corda.core.serialization.CordaSerializable;
import org.jetbrains.annotations.NotNull;

@BelongsToContract(ProductOfferingContract.class)
@CordaSerializable
public class ProductOffering extends PublicState {
  private OfferType offerType;
  private String name;
  private it.nextworks.tmf_offering_catalog.information_models.product.ProductOffering productOffering;
  private Map<String, Invitation> didInvitations;

  private final Party governanceParty;
  private final Party spectrumOracle;

  public ProductOffering(
      @NotNull UniqueIdentifier id,
      @NotNull OfferType offerType,
      @NotNull String name,
      @NotNull Party owner,
      @NotNull it.nextworks.tmf_offering_catalog.information_models.product.ProductOffering productOffering,
      Map<String, Invitation> didInvitations,
      @NotNull Party governanceParty,
      Party spectrumOracle
  ) {
    super(id, owner);
    this.offerType = offerType;
    this.name = name;
    this.productOffering = productOffering;
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

  public it.nextworks.tmf_offering_catalog.information_models.product.ProductOffering getProductOffering() {
    return productOffering;
  }

  public ProductOffering setProductOffering(
      it.nextworks.tmf_offering_catalog.information_models.product.ProductOffering productOffering) {
    this.productOffering = productOffering;
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
        productOffering,
        didInvitations,
        governanceParty,
        spectrumOracle
    );
  }
}
