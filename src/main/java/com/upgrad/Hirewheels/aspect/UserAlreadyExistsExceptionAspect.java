package com.upgrad.Hirewheels.aspect;

import com.upgrad.Hirewheels.exceptions.UnauthorizedUserException;
import com.upgrad.Hirewheels.exceptions.UserAlreadyExistsException;
import com.upgrad.Hirewheels.responses.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;

@ControllerAdvice
public class UserAlreadyExistsExceptionAspect {
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<CustomResponse> handleUserAlreadyExistsException(Exception e) {
        CustomResponse response = new CustomResponse(LocalDateTime.MAX,e.getMessage(), HttpStatus.NOT_FOUND.value());
        return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
