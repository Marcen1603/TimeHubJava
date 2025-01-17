package com.timehub.exceptions;

/**
 * Exception handling to get good information about what happens to the code. In this class the
 * needed exceptions for a not reachable database are located.
 */
public class DatabaseConnectionException extends RuntimeException {

  public DatabaseConnectionException(String message, Throwable cause) {
    super(message, cause);
  }
}
