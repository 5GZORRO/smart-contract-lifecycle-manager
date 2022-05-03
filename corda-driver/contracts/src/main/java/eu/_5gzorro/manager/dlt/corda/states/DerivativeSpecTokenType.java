package eu._5gzorro.manager.dlt.corda.states;

import eu._5gzorro.manager.dlt.corda.contracts.DerivativeSpecTokenContract;
import net.corda.core.contracts.BelongsToContract;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.Party;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.List;

@BelongsToContract(DerivativeSpecTokenContract.class)
public class DerivativeSpecTokenType extends SpecTokenType {

    private final Float price;

    @NotNull
    private final String primitiveDid;

    public DerivativeSpecTokenType(@NotNull List<Party> maintainers, @NotNull UniqueIdentifier uniqueIdentifier, @NotNull Double startDl, @NotNull Double endDl, @NotNull Double startUl, @NotNull Double endUl, @NotNull Date startDate, @NotNull Date endDate, @NotNull String duplexMode, @NotNull Integer band, @NotNull String technology, @NotNull String country, String ownerDid, String primitiveDid, Float price) {
        super(maintainers, uniqueIdentifier, startDl, endDl, startUl, endUl, startDate, endDate, duplexMode, band, technology, country, ownerDid);
        this.primitiveDid = primitiveDid;
        this.price = price;
    }

    @NotNull
    public String getPrimitiveDid() {
        return primitiveDid;
    }

    public Float getPrice() {
        return price;
    }

}
