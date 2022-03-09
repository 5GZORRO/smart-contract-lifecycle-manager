package eu._5gzorro.manager.dlt.corda.models.types;

import eu._5gzorro.tm_forum.models.GeographicAddress;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.Party;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.List;

public class DerivativeSpecTokenType extends SpecTokenType {

    public DerivativeSpecTokenType(@NotNull List<Party> maintainers, @NotNull UniqueIdentifier uniqueIdentifier, @NotNull String did, @NotNull Double startDl, @NotNull Double endDl, @NotNull Double startUl, @NotNull Double endUl, @NotNull Date startDate, @NotNull Date endDate, @NotNull String duplexMode, @NotNull Integer band, @NotNull String technology, @NotNull GeographicAddress geographicAddress, String ownerDid) {
        super(maintainers, uniqueIdentifier, did, startDl, endDl, startUl, endUl, startDate, endDate, duplexMode, band, technology, geographicAddress, ownerDid);
    }

}
