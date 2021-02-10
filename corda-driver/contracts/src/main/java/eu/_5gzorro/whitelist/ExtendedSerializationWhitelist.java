package eu._5gzorro.whitelist;

import static kotlin.collections.CollectionsKt.listOf;

import eu._5gzorro.lifecycle.manager.domain.Invitation;
import java.util.List;
import net.corda.core.serialization.SerializationWhitelist;
import org.jetbrains.annotations.NotNull;

public class ExtendedSerializationWhitelist implements SerializationWhitelist {
    @NotNull
    @Override
    public List<Class<?>> getWhitelist() {
        return listOf(Invitation.class);
    }
}
