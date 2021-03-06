package com.upgrad.Hirewheels.services;

import com.upgrad.Hirewheels.dao.VehicleDAO;
import com.upgrad.Hirewheels.entities.Booking;
import com.upgrad.Hirewheels.entities.User;
import com.upgrad.Hirewheels.entities.Vehicle;
import com.upgrad.Hirewheels.entities.VehicleSubCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleDAO vehicleDAO;


    @Override
    public Vehicle acceptVehicleDetails(Vehicle vehicle) {
        return vehicleDAO.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleDAO.findAll();
    }

    @Override
    public List<Vehicle> getVehicleByUserId(User user) {
        return null;
    }

    @Override
    public List<Vehicle> getAvailableVehicles(VehicleSubCategory vehicleSubcategory, Booking booking) {
        List<Vehicle> vehicles = vehicleDAO.findByVehicleSubcategory(vehicleSubcategory);
        return vehicles.stream().filter(
                vehicle -> vehicle.getAvailableStatus() == 1 && booking.getLocation().equals(vehicle.getLocation())).collect(Collectors.toList());
    }

}