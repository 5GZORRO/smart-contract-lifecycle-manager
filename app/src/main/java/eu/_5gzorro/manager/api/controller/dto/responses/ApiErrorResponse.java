package eu._5gzorro.manager.api.controller.dto;

import java.util.HashMap;

public class ApiErrorResponse {

    private final int status;
    private final String message;
    private HashMap<String, String> errors;

    public ApiErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
        this.errors = new HashMap<>();
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }
}
