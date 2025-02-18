package com.challenge.client.exception;

public class EmptyDataBaseException extends RuntimeException {
    public EmptyDataBaseException(String message) {
        super(message);
    }
}