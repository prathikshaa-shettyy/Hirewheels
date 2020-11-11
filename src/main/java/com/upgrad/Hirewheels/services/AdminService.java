package com.upgrad.Hirewheels.services;

import com.upgrad.Hirewheels.entities.Booking;
import com.upgrad.Hirewheels.entities.User;
import com.upgrad.Hirewheels.entities.Vehicle;
import com.upgrad.Hirewheels.exceptions.UnauthorizedUserException;
import com.upgrad.Hirewheels.exceptions.UserNotRegisteredException;
import com.upgrad.Hirewheels.exceptions.VehicleAlreadyExistsException;
import com.upgrad.Hirewheels.exceptions.VehicleNotFoundException;

public interface AdminService {

    public Vehicle registerVehicle(Vehicle vehicle);
    public Vehicle getVehicleDetails(int id) throws VehicleNotFoundException;
    public Vehicle changeAvailabilty(int id) throws VehicleNotFoundException;
    public Vehicle acceptVehicleDetails(Vehicle vehicle);
    public Booking acceptBookingDetails(Booking booking);

}
