package com.upgrad.Hirewheels.services;

import com.upgrad.Hirewheels.entities.Booking;
import com.upgrad.Hirewheels.entities.User;
import com.upgrad.Hirewheels.entities.Vehicle;
import com.upgrad.Hirewheels.entities.VehicleSubCategory;

import java.util.List;

public interface VehicleService {

    List<Vehicle> getAllVehicles();
    List<Vehicle> getVehicleByUserId(User user);
    List<Vehicle> getAvailableVehicles(VehicleSubCategory vehicleSubcategory, Booking booking);
    public Vehicle acceptVehicleDetails(Vehicle vehicle);



}
