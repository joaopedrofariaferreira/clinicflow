package com.clinicflow.exception;

public class ClinicAlreadyExistsException extends RuntimeException {
  public ClinicAlreadyExistsException(String message) {
    super(message);
  }
}
