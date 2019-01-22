package com.future.ojekonline.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class InvalidValueException extends RuntimeException{
    public InvalidValueException(String msg) {
        super(msg);
    }
}
