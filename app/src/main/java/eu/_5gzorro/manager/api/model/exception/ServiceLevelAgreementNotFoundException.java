package eu._5gzorro.manager.api.model.exception;

import javax.persistence.EntityNotFoundException;

public class ServiceLevelAgreementNotFoundException extends EntityNotFoundException {

    private final String id;

    public ServiceLevelAgreementNotFoundException(String id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return String.format("SLA with id '%s' not found", id);
    }
}
