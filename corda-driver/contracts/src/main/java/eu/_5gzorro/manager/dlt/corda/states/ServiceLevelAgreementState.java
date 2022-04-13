package eu._5gzorro.manager.dlt.corda.states;

import eu._5gzorro.manager.dlt.corda.contracts.ServiceLevelAgreementContract;
import eu._5gzorro.manager.dlt.corda.models.types.SLAState;
import eu._5gzorro.manager.dlt.corda.states.schemes.ServiceLevelAgreementSchemaV1;
import eu._5gzorro.tm_forum.models.sla.ServiceLevelAgreement;
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

@BelongsToContract(ServiceLevelAgreementContract.class)
@CordaSerializable
public class ServiceLevelAgreementState implements ContractState, LinearState, QueryableState {

    private final UniqueIdentifier identifier;

    private ServiceLevelAgreement serviceLevelAgreement;
    private SLAState serviceLevelAgreementState;
    private final String ProductOrderDID;

    private final Party buyer;
    private final Party seller;
    private final Party governanceParty;

    public ServiceLevelAgreementState(
            @NotNull UniqueIdentifier identifier,
            @NotNull ServiceLevelAgreement serviceLevelAgreement,
            @NotNull SLAState serviceLevelAgreementState,
            @NotNull String ProductOrderDID,
            @NotNull Party buyer,
            @NotNull Party seller,
            @NotNull Party governanceParty) {
        this.identifier = identifier;
        this.serviceLevelAgreement = serviceLevelAgreement;
        this.serviceLevelAgreementState = serviceLevelAgreementState;
        this.ProductOrderDID = ProductOrderDID;
        this.buyer = buyer;
        this.seller = seller;
        this.governanceParty = governanceParty;
    }

    @NotNull
    @Override
    public UniqueIdentifier getLinearId() {
        return identifier;
    }

    public ServiceLevelAgreement getServiceLevelAgreement() { return serviceLevelAgreement; }

    public void setServiceLevelAgreement(ServiceLevelAgreement serviceLevelAgreement) {
        this.serviceLevelAgreement = serviceLevelAgreement;
    }

    public ServiceLevelAgreementState serviceLevelAgreement(ServiceLevelAgreement serviceLevelAgreement) {
        this.serviceLevelAgreement = serviceLevelAgreement;
        return this;
    }

    public SLAState getServiceLevelAgreementState() { return serviceLevelAgreementState; }

    public void setServiceLevelAgreementState(SLAState serviceLevelAgreementState) {
        this.serviceLevelAgreementState = serviceLevelAgreementState;
    }

    public ServiceLevelAgreementState serviceLevelAgreementState(SLAState serviceLevelAgreementState) {
        this.serviceLevelAgreementState = serviceLevelAgreementState;
        return this;
    }

    public String getProductOrderDID() { return ProductOrderDID; }

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
        if(schema instanceof ServiceLevelAgreementSchemaV1)
            return new ServiceLevelAgreementSchemaV1.ServiceLevelAgreement(identifier.getId(),
                    ProductOrderDID, serviceLevelAgreement.getId());
        else
            throw new IllegalArgumentException("Unrecognised schema " + schema);
    }

    @NotNull
    @Override
    public Iterable<MappedSchema> supportedSchemas() {
        return Arrays.asList(new ServiceLevelAgreementSchemaV1());
    }
}
