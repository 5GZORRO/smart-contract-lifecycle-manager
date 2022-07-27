package eu._5gzorro.manager.api.model.exception;

import eu._5gzorro.manager.api.model.enumureration.EntityStatus;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LicenseTermStatusException extends RuntimeException {

    private final Set<EntityStatus> permittedStatuses;
    private final EntityStatus actualStatus;

    public LicenseTermStatusException(Collection<EntityStatus> permittedStatuses, EntityStatus actualStatus) {
        this.permittedStatuses = new HashSet<>(permittedStatuses);
        this.actualStatus = actualStatus;
    }

    public LicenseTermStatusException(EntityStatus permittedStatus, EntityStatus actualStatus) {
        this(new HashSet<>(Collections.singleton(permittedStatus)), actualStatus);
    }

    @Override
    public String getMessage() {
        return String.format("This operation is not permitted on a License Term" +
                " in %s state. Permitted states: %s", actualStatus, permittedStatuses);
    }
}
