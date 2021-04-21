package eu._5gzorro.manager.api.model.exception;

import javax.persistence.EntityNotFoundException;

public class AgreementNotFoundException extends EntityNotFoundException {

    private final String id;

    public AgreementNotFoundException(String id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return String.format("Agreement with id '%s' not found", id);
    }
}
