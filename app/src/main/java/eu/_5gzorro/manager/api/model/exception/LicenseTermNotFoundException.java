package eu._5gzorro.manager.api.model.exception;

import javax.persistence.EntityNotFoundException;

public class LicenseTermNotFoundException extends EntityNotFoundException {

    private final String id;

    public LicenseTermNotFoundException(String id) { this.id = id; }

    @Override
    public String getMessage() { return String.format("License Term with id %s not found", id); }
}
