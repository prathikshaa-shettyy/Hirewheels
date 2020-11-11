package com.upgrad.Hirewheels.aspect;

import com.upgrad.Hirewheels.exceptions.MobileNoAlreadyExists;
import com.upgrad.Hirewheels.exceptions.UnauthorizedUserException;
import com.upgrad.Hirewheels.responses.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;

@ControllerAdvice
public class UnauthorizedUserExceptionAspect {
    @ExceptionHandler(UnauthorizedUserException.class)
    public ResponseEntity<CustomResponse> handleUnauthorizedUserException(Exception e) {
        CustomResponse response = new CustomResponse(LocalDateTime.MAX,e.getMessage(), HttpStatus.NOT_FOUND.value());
        return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
