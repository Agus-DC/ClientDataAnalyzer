package com.challenge.client.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(EmptyDataBaseException.class)
    public ResponseEntity<String> emptyDataBaseHandle(EmptyDataBaseException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SaveEntityFailException.class)
    public ResponseEntity<String> saveEntityFailHandle(SaveEntityFailException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SendMessageFailException.class)
    public ResponseEntity<String> sendMessageFailHandle(SendMessageFailException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
