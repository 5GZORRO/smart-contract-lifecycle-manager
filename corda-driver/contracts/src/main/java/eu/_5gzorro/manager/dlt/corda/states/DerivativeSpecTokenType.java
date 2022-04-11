package eu._5gzorro.manager.dlt.corda.states;

import com.r3.corda.lib.tokens.contracts.types.TokenPointer;
import eu._5gzorro.manager.dlt.corda.contracts.DerivativeSpecTokenContract;
import eu._5gzorro.manager.dlt.corda.contracts.PrimitiveSpecTokenContract;
import eu._5gzorro.tm_forum.models.GeographicAddress;
import net.corda.core.contracts.BelongsToContract;
import net.corda.core.contracts.LinearPointer;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.Party;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.List;

@BelongsToContract(DerivativeSpecTokenContract.class)
public class DerivativeSpecTokenType extends SpecTokenType {

    @NotNull
    private final String primitiveDid;

    public DerivativeSpecTokenType(@NotNull List<Party> maintainers, @NotNull UniqueIdentifier uniqueIdentifier, @NotNull String did, @NotNull Double startDl, @NotNull Double endDl, @NotNull Double startUl, @NotNull Double endUl, @NotNull Date startDate, @NotNull Date endDate, @NotNull String duplexMode, @NotNull Integer band, @NotNull String technology, @NotNull String country, String ownerDid, String primitiveDid) {
        super(maintainers, uniqueIdentifier, did, startDl, endDl, startUl, endUl, startDate, endDate, duplexMode, band, technology, country, ownerDid);
        this.primitiveDid = primitiveDid;
    }

    @NotNull
    public String getPrimitiveDid() {
        return primitiveDid;
    }

    public TokenPointer<DerivativeSpecTokenType> toPointer(){
        LinearPointer<DerivativeSpecTokenType> linearPointer = new LinearPointer<>(getLinearId(), DerivativeSpecTokenType.class);
        return new TokenPointer<>(linearPointer, FRACTION_DIGITS);
    }

}
