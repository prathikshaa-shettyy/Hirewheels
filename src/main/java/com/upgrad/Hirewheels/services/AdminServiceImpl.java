package com.upgrad.Hirewheels.services;

import com.upgrad.Hirewheels.dao.BookingDAO;
import com.upgrad.Hirewheels.dao.VehicleDAO;
import com.upgrad.Hirewheels.entities.Booking;
import com.upgrad.Hirewheels.entities.Vehicle;
import com.upgrad.Hirewheels.exceptions.VehicleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminService adminService;

    @Qualifier("vehicleDao")
    @Autowired
    VehicleDAO vehicleDao;

    @Qualifier("bookingDao")
    @Autowired
    BookingDAO bookingDao;

    @Override
    public Vehicle registerVehicle(Vehicle vehicle) {
        vehicle.setAvailableStatus(1);
        return vehicleDao.save(vehicle);
    }
    @Override
    public Vehicle getVehicleDetails(int id) throws VehicleNotFoundException {
        return vehicleDao.findById(id)
                .orElseThrow(
                        () -> new VehicleNotFoundException("Vehicle not found for id: " + id)
                );
    }

    @Override
    public Vehicle changeAvailabilty(int id) throws VehicleNotFoundException {

        Vehicle savedVehicle=getVehicleDetails(id);
        if (savedVehicle.getAvailableStatus() == 0) {
            savedVehicle.setAvailableStatus(1);
        }
        else {
            savedVehicle.setAvailableStatus(0);
        }
        return vehicleDao.save(savedVehicle);
    }

    @Override
    public Vehicle acceptVehicleDetails(Vehicle vehicle) {
        return vehicleDao.save(vehicle);
    }

    @Override
    public Booking acceptBookingDetails(Booking booking) {
        return bookingDao.save(booking);
    }

}
