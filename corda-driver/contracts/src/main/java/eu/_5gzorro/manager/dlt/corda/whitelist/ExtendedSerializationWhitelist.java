package eu._5gzorro.manager.dlt.corda.whitelist;

import static kotlin.collections.CollectionsKt.listOf;

import eu._5gzorro.manager.domain.Invitation;
import eu._5gzorro.manager.domain.Place;
import eu._5gzorro.manager.domain.ProductOfferTerm;
import eu._5gzorro.manager.domain.ServiceCandidate;
import eu._5gzorro.manager.domain.ServiceLevelAgreement;
import java.util.List;
import net.corda.core.serialization.SerializationWhitelist;
import org.jetbrains.annotations.NotNull;

public class ExtendedSerializationWhitelist implements SerializationWhitelist {
    @NotNull
    @Override
    public List<Class<?>> getWhitelist() {
        return listOf(
            Invitation.class,
            Place.class,
            ProductOfferTerm.class,
            ServiceCandidate.class,
            ServiceLevelAgreement.class
        );
    }
}
