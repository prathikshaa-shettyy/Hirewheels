package com.upgrad.Hirewheels.aspect;

import com.upgrad.Hirewheels.exceptions.InsufficientBalanceException;
import com.upgrad.Hirewheels.responses.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;


@ControllerAdvice
public class InsufficientBalanceExceptionAspect {
    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<CustomResponse> handleInsufficientBalanceException(Exception e) {
        CustomResponse response = new CustomResponse(LocalDateTime.MAX,e.getMessage(), HttpStatus.NOT_FOUND.value());
        return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
