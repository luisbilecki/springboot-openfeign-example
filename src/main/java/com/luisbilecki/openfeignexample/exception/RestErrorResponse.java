package com.luisbilecki.openfeignexample.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class RestErrorResponse {

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String details;

    private RestErrorResponse() {
        timestamp = LocalDateTime.now();
    }

    public RestErrorResponse(HttpStatus status) {
        this();
        this.status = status;
    }

    public RestErrorResponse(HttpStatus status, Throwable ex) {
        this();
        this.status = status;
        this.message = "Unexpected error";
        this.details = ex.getLocalizedMessage();
    }

    public RestErrorResponse(HttpStatus status, String message, Throwable ex) {
        this();
        this.status = status;
        this.message = message;
        this.details = ex.getLocalizedMessage();
    }

}
