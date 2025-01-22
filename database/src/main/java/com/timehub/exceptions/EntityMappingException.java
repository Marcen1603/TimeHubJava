package com.timehub.exceptions;

public class EntityMappingException extends Exception {

    public EntityMappingException(String message) {
        super(message);
    }

    public EntityMappingException(String message, Throwable cause) {
        super(message, cause);
    }
}
