package com.clinicflow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ClinicAlreadyExistsException extends RuntimeException {
    public ClinicAlreadyExistsException(String message) {
        super(message);
    }
}
