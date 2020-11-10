package com.upgrad.Hirewheels.services;

import com.upgrad.Hirewheels.dao.VehicleDAO;
import com.upgrad.Hirewheels.entities.User;
import com.upgrad.Hirewheels.entities.Vehicle;
import com.upgrad.Hirewheels.exceptions.UnauthorizedUserException;
import com.upgrad.Hirewheels.exceptions.UserNotRegisteredException;
import com.upgrad.Hirewheels.exceptions.VehicleAlreadyExistsException;
import com.upgrad.Hirewheels.exceptions.VehicleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private VehicleDAO vehicleDAO;

    @Autowired
    private UserService userService;

    public Vehicle registerVehicle(
            Vehicle vehicle,
            User user)
            throws UserNotRegisteredException, UnauthorizedUserException, VehicleAlreadyExistsException {

        if (userService.getUser(user).getRole().getRoleName().equals("ADMIN")) {
            if (vehicleDAO.findByVehicleNumber(vehicle.getVehicleNumber()).isPresent()) {
                throw new VehicleAlreadyExistsException("Vehicle Already exists");
            }
            vehicle.setAvailableStatus(1);
            return vehicleDAO.save(vehicle);
        } else {
            throw new UnauthorizedUserException("You are unauthorized to register vehicle");
        }
    }

    @Override
    public Vehicle changeAvailability(
            Vehicle vehicle,
            int status,
            User user)
            throws UserNotRegisteredException, UnauthorizedUserException, VehicleNotFoundException {


        if (userService.getUser(user).getRole().getRoleName().equals("ADMIN")) {
            Vehicle updatedVehicle = vehicleDAO.findById(vehicle.getVehicleId()).orElseThrow(() -> new VehicleNotFoundException("Vehicle not found"));
            updatedVehicle.setAvailableStatus(status);
            return vehicleDAO.save(updatedVehicle);
        } else {
            throw new UnauthorizedUserException("You are unauthorized to change the status");
        }

    }
}
