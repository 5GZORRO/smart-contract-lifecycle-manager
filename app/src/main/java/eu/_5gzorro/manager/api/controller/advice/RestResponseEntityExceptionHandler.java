package eu._5gzorro.manager.api.controller.advice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value= { IllegalArgumentException.class, IllegalStateException.class })
  protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {

    ApiErrorResponse responseBody = new ApiErrorResponse(HttpStatus.CONFLICT.value(), "");

    return handleExceptionInternal(ex, responseBody,
        new HttpHeaders(), HttpStatus.CONFLICT, request);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  protected ApiErrorResponse onConstraintValidationException(ConstraintViolationException e) {
    ApiErrorResponse response = new ApiErrorResponse(HttpStatus.BAD_REQUEST.value(), "The request contained invalid parameters");

    for (ConstraintViolation violation : e.getConstraintViolations()) {
      response.getErrors().put(violation.getPropertyPath().toString(), violation.getMessage());
    }

    return response;
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

    ApiErrorResponse response = new ApiErrorResponse(HttpStatus.BAD_REQUEST.value(), "The request contained invalid parameters");

    for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
      response.getErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
    }

    return super.handleExceptionInternal(ex, response, headers, status, request);
  }
}
