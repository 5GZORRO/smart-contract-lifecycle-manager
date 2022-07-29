package eu._5gzorro.manager.dlt.corda.states;

import eu._5gzorro.manager.dlt.corda.contracts.PrimitiveSpecTokenContract;
import net.corda.core.contracts.BelongsToContract;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.Party;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.List;

@BelongsToContract(PrimitiveSpecTokenContract.class)
public class PrimitiveSpecTokenType extends SpecTokenType {

    @NotNull
    private final String license;

    private final String ownerDid;

    public PrimitiveSpecTokenType(@NotNull List<Party> maintainers, @NotNull UniqueIdentifier uniqueIdentifier, @NotNull Double startDl, @NotNull Double endDl, @NotNull Double startUl, @NotNull Double endUl, @NotNull Date startDate, @NotNull Date endDate, @NotNull String duplexMode, @NotNull Integer band, @NotNull String technology, @NotNull String country, @NotNull String license, String ownerDid) {
        super(maintainers, uniqueIdentifier, startDl, endDl, startUl, endUl, startDate, endDate, duplexMode, band, technology, country);
        this.license = license;
        this.ownerDid = ownerDid;
    }

    @NotNull
    public String getLicense() {
        return license;
    }

    public String getOwnerDid() {
        return ownerDid;
    }
}
