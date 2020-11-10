package com.upgrad.Hirewheels.services;

import com.upgrad.Hirewheels.entities.User;
import com.upgrad.Hirewheels.entities.Vehicle;
import com.upgrad.Hirewheels.exceptions.UnauthorizedUserException;
import com.upgrad.Hirewheels.exceptions.UserNotRegisteredException;
import com.upgrad.Hirewheels.exceptions.VehicleAlreadyExistsException;
import com.upgrad.Hirewheels.exceptions.VehicleNotFoundException;

public interface AdminService {

    Vehicle registerVehicle(Vehicle vehicle, User user) throws UserNotRegisteredException, UnauthorizedUserException, VehicleAlreadyExistsException;

    public Vehicle changeAvailability(Vehicle vehicle, int status, User user) throws VehicleNotFoundException, UserNotRegisteredException, UnauthorizedUserException;
}
