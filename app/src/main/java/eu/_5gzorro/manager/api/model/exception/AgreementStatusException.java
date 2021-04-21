package eu._5gzorro.manager.api.model.exception;

import eu._5gzorro.manager.api.model.enumureration.EntityStatus;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AgreementStatusException extends RuntimeException {

    private final Set<EntityStatus> permittedStatuses;
    private final EntityStatus actualStatus;

    /**
     * Create a AgreementStatusException with a collection of permitted target states
     * @param permittedStatuses
     * @param actualStatus
     */
    public AgreementStatusException(Collection<EntityStatus> permittedStatuses, EntityStatus actualStatus) {
        this.permittedStatuses = new HashSet<>(permittedStatuses);
        this.actualStatus = actualStatus;
    }

    /**
     * Create a AgreementStatusException with a single permitted target state
     * @param permittedStatus
     * @param actualStatus
     */
    public AgreementStatusException(EntityStatus permittedStatus, EntityStatus actualStatus) {
        this(new HashSet<>(Collections.singleton(permittedStatus)), actualStatus);
    }

    @Override
    public String getMessage() {
        return String.format("This operation is not permitted on an Agreement in %s state. Permitted states: %s", actualStatus, permittedStatuses);
    }
}
