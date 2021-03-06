package com.upgrad.Hirewheels.aspect;

import com.upgrad.Hirewheels.exceptions.UserNotRegisteredException;
import com.upgrad.Hirewheels.exceptions.VehicleAlreadyExistsException;
import com.upgrad.Hirewheels.responses.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;

@ControllerAdvice
public class VehicleAlreadyExistsExceptionAspect {
    @ExceptionHandler(VehicleAlreadyExistsException.class)
    public ResponseEntity<CustomResponse> handleVehicleAlreadyExistsException(Exception e) {
        CustomResponse response = new CustomResponse(LocalDateTime.MAX,e.getMessage(), HttpStatus.NOT_FOUND.value());
        return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
