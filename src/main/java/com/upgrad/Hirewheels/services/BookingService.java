package com.upgrad.Hirewheels.services;

import com.upgrad.Hirewheels.entities.Booking;
import com.upgrad.Hirewheels.exceptions.InsufficientBalanceException;
import com.upgrad.Hirewheels.exceptions.UnauthorizedUserException;
import com.upgrad.Hirewheels.exceptions.UserNotRegisteredException;

public interface BookingService {

    Booking addBooking(Booking booking) throws UserNotRegisteredException, UnauthorizedUserException, InsufficientBalanceException;

}
