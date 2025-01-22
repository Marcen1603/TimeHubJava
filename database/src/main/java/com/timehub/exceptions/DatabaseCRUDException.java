package com.timehub.exceptions;

public class DatabaseCRUDException extends RuntimeException {

    public DatabaseCRUDException(String message, Throwable cause) {
        super(message, cause);
    }
}
