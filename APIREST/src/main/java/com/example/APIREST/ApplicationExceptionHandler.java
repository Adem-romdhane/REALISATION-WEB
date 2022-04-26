package com.example.APIREST;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.hibernate.exception.ConstraintViolationException;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(
            value = HttpStatus.BAD_REQUEST,
            reason = "Ce email et/ou ce telephone ont deja été utilisés")
    @ExceptionHandler(ConstraintViolationException.class)
    public void handleException(ConstraintViolationException e) {
    }

}