package com.upgrad.Hirewheels.services;

import com.upgrad.Hirewheels.dao.BookingDAO;
import com.upgrad.Hirewheels.dao.UserDAO;
import com.upgrad.Hirewheels.entities.Booking;
import com.upgrad.Hirewheels.entities.User;
import com.upgrad.Hirewheels.exceptions.InsufficientBalanceException;
import com.upgrad.Hirewheels.exceptions.UnauthorizedUserException;
import com.upgrad.Hirewheels.exceptions.UserNotRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;

public class BookingServiceImpl implements BookingService {

    @Autowired
    private UserService userService;

    @Autowired
    private BookingDAO bookingDAO;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private UserDAO userDAO;

    @Override
    public Booking addBooking(Booking booking) throws UserNotRegisteredException, UnauthorizedUserException, InsufficientBalanceException {
        User user  = userService.getUser(booking.getUsers());
        if (user.getWalletMoney() < booking.getAmount()) {
            throw new InsufficientBalanceException("Insufficient balance");
        } else {
            Booking bookingMade = bookingDAO.save(booking);
            user.setWalletMoney((float)(user.getWalletMoney() - booking.getAmount()));
            userDAO.save(user);
            return bookingMade;
        }
    }
}
