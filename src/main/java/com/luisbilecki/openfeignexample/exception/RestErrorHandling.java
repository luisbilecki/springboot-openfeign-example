package com.luisbilecki.openfeignexample.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestErrorHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IntegrationException.class)
    public ResponseEntity<Object> handleIntegrationException(Exception ex) {
        return buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, "Integration Exception", ex);
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleAll(Exception ex) {
        return buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", ex);
    }

    private ResponseEntity<Object> buildResponseEntity(HttpStatus httpStatus, String message, Exception ex) {
        RestErrorResponse response = new RestErrorResponse(httpStatus, message, ex);
        return new ResponseEntity<Object>(response, new HttpHeaders(), response.getStatus());
    }

}
