package com.challenge.client.exception;

public class SendMessageFailException extends RuntimeException {
    public SendMessageFailException(String message) {
        super(message);
    }
}