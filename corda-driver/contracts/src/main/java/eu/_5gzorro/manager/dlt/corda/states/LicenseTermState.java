package eu._5gzorro.manager.dlt.corda.states;

import eu._5gzorro.elicense.models.LicenseTerm;
import eu._5gzorro.manager.dlt.corda.contracts.LicenseTermContract;
import eu._5gzorro.manager.dlt.corda.models.types.LTState;
import eu._5gzorro.manager.dlt.corda.states.schemes.LicenseTermSchemaV1;
import net.corda.core.contracts.BelongsToContract;
import net.corda.core.contracts.ContractState;
import net.corda.core.contracts.LinearState;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import net.corda.core.schemas.MappedSchema;
import net.corda.core.schemas.PersistentState;
import net.corda.core.schemas.QueryableState;
import net.corda.core.serialization.CordaSerializable;
import org.jetbrains.annotations.NotNull;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@BelongsToContract(LicenseTermContract.class)
@CordaSerializable
public class LicenseTermState implements ContractState, LinearState, QueryableState {

    private final UniqueIdentifier identifier;

    private LicenseTerm licenseTerm;
    private LTState licenseTermState;

    private final String productOrderDID;
    private final String productOfferingDID;

    private final Party buyer;
    private final Party seller;
    private final Party governanceParty;

    public LicenseTermState(
            @NotNull UniqueIdentifier identifier,
            @NotNull LicenseTerm licenseTerm,
            @NotNull LTState licenseTermState,
            @NotNull String productOrderDID,
            @NotNull String productOfferingDID,
            @NotNull Party buyer,
            @NotNull Party seller,
            @NotNull Party governanceParty) {
        this.identifier         = identifier;
        this.licenseTerm        = licenseTerm;
        this.licenseTermState   = licenseTermState;
        this.productOrderDID    = productOrderDID;
        this.productOfferingDID = productOfferingDID;
        this.buyer              = buyer;
        this.seller             = seller;
        this.governanceParty    = governanceParty;
    }

    @NotNull
    @Override
    public UniqueIdentifier getLinearId() {
        return identifier;
    }

    public LicenseTerm getLicenseTerm() { return licenseTerm; }

    public void setLicenseTerm(LicenseTerm licenseTerm) { this.licenseTerm = licenseTerm; }

    public LTState getLicenseTermState() { return licenseTermState; }

    public void setLicenseTermState(LTState licenseTermState) { this.licenseTermState = licenseTermState; }

    public String getProductOrderDID() { return productOrderDID; }

    public String getProductOfferingDID() { return productOfferingDID; }

    public Party getBuyer() { return buyer; }

    public Party getSeller() { return seller; }

    public Party getGovernanceParty() { return governanceParty; }

    @NotNull
    @Override
    public List<AbstractParty> getParticipants() {
        return Arrays.asList(buyer, seller, governanceParty);
    }

    public List<PublicKey> getRequiredSigners() {
        return getParticipants().stream()
                .map(AbstractParty::getOwningKey)
                .collect(Collectors.toList());
    }

    @NotNull
    @Override
    public PersistentState generateMappedObject(@NotNull MappedSchema schema) {
        if(schema instanceof LicenseTermSchemaV1)
            return new LicenseTermSchemaV1.LicenseTerm(identifier.getId(),
                    productOrderDID, productOfferingDID, licenseTerm.getId());
        else
            throw new IllegalArgumentException("Unrecognised schema " + schema);
    }

    @NotNull
    @Override
    public Iterable<MappedSchema> supportedSchemas() {
        return Arrays.asList(new LicenseTermSchemaV1());
    }
}
