package eu._5gzorro.manager.dlt.corda.states;

import eu._5gzorro.manager.dlt.corda.contracts.DerivativeSpecTokenContract;
import net.corda.core.contracts.BelongsToContract;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.Party;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@BelongsToContract(DerivativeSpecTokenContract.class)
public class DerivativeSpecTokenType extends SpecTokenType {

    private final Float price;

    @NotNull
    private final String primitiveId;

    @NotNull
    private final String offerDid;

    public DerivativeSpecTokenType(@NotNull List<Party> maintainers, @NotNull UniqueIdentifier uniqueIdentifier, @NotNull Double startDl, @NotNull Double endDl, @NotNull Double startUl, @NotNull Double endUl, Date startDate, Date endDate, @NotNull String duplexMode, @NotNull Integer band, @NotNull String technology, @NotNull String country, boolean valid, @NotNull String primitiveId, Float price, @NotNull String offerDid) {
        super(maintainers, uniqueIdentifier, startDl, endDl, startUl, endUl, startDate, endDate, duplexMode, band, technology, country, valid);
        this.primitiveId = primitiveId;
        this.price = price;
        this.offerDid = offerDid;
    }

    @NotNull
    public String getPrimitiveId() {
        return primitiveId;
    }

    public Float getPrice() {
        return price;
    }

    @NotNull
    public String getOfferDid() {
        return offerDid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DerivativeSpecTokenType that = (DerivativeSpecTokenType) o;
        return Objects.equals(getPrice(), that.getPrice()) && getPrimitiveId().equals(that.getPrimitiveId()) && getOfferDid().equals(that.getOfferDid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrice(), getPrimitiveId(), getOfferDid());
    }
}
