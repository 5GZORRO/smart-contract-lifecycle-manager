package eu._5gzorro.manager.dlt.corda.whitelist;

import com.google.common.reflect.ClassPath;
import eu._5gzorro.manager.domain.Invitation;
import eu._5gzorro.manager.domain.Place;
import eu._5gzorro.manager.domain.ProductOfferTerm;
import eu._5gzorro.manager.domain.ServiceCandidate;
import eu._5gzorro.manager.domain.ServiceLevelAgreement;
import java.util.ArrayList;
import java.util.List;
import net.corda.core.serialization.SerializationWhitelist;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExtendedSerializationWhitelist implements SerializationWhitelist {
    private static final Logger log = LoggerFactory.getLogger(ExtendedSerializationWhitelist.class);

    @NotNull
    @Override
    public List<Class<?>> getWhitelist() {
        try {
            List<Class<?>> whitelist = new ArrayList<>();
            whitelist.add(Invitation.class);
            whitelist.add(Place.class);
            whitelist.add(ProductOfferTerm.class);
            whitelist.add(ServiceCandidate.class);
            whitelist.add(ServiceLevelAgreement.class);

            final ClassLoader loader = Thread.currentThread().getContextClassLoader();
            for (final ClassPath.ClassInfo info : ClassPath.from(loader).getTopLevelClasses()) {
                if (info.getName().startsWith("it.nextworks.tmf_offering_catalog.information_models.")) {
                    final Class<?> clazz = info.load();
                    whitelist.add(clazz);
                }
            }
            return whitelist;
        } catch (Exception e) {
            log.error("Failed to load nextworks info models", e);
            throw new IllegalStateException("Failed to load nextworks info models");
        }
    }
}
