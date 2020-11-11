package com.upgrad.Hirewheels.controllers;
import com.upgrad.Hirewheels.dto.BookingDTO;
import com.upgrad.Hirewheels.entities.Booking;
import com.upgrad.Hirewheels.services.AdminService;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping(value="/Hirewheels/v1")
public class BookingController
{
    private static  final Logger logger= (Logger) LoggerFactory.getLogger(AdminController.class);

    @Autowired
    ModelMapper modelmapper;

    @Autowired
    AdminService adminService;

    @PostMapping(value="/bookings", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addBooking(@RequestBody BookingDTO bookingDTO)
    {
        Booking addBooking=modelmapper.map(bookingDTO,Booking.class);
        Booking saveBooking=adminService.acceptBookingDetails(addBooking);
        logger.debug("New Booking added", bookingDTO);
        return new ResponseEntity<>(saveBooking, HttpStatus.CREATED);
    }
}

