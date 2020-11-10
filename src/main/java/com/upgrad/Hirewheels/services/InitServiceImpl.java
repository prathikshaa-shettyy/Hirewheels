package com.upgrad.Hirewheels.services;

import com.upgrad.Hirewheels.dao.*;
import com.upgrad.Hirewheels.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class InitServiceImpl implements InitService {

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private VehicleCategoryDAO vehicleCategoryDAO;

    @Autowired
    private VehicleSubCategoryDAO vehicleSubCategoryDAO;

    @Autowired
    private CityDAO cityDAO;

    @Autowired
    private FuelTypeDAO fuelTypeDAO;

    @Autowired
    private LocationDAO locationDAO;


    public void start() {
        addUserRole();
        addUser();
        addVehicleCategory();
        addVehicleSubCategory();
        addCity();
        addFuelType();
        addLocation();
    }

    private void addLocation() {
        Location location = new Location(1, "Worli",
                "Dr E Moses Rd, Worli Naka, Upper Worli", cityDAO.findById(11).get(), "400018");
        locationDAO.save(location);
        location = new Location(2, "Chembur",
                "Optic Complex", cityDAO.findById(11).get(), "400019");
        locationDAO.save(location);
        location = new Location(3, "Powai",
                "Hiranandani Tower", cityDAO.findById(11).get(), "400020");
        locationDAO.save(location);
    }

    private void addFuelType() {
        List<FuelType> fuelTypeList = Arrays.asList(new FuelType(1, "Petrol"), new FuelType(2, "Diesel"));
        fuelTypeDAO.saveAll(fuelTypeList);
    }

    private void addCity() {
        cityDAO.save(new City(11, "Mumbai"));
    }

    private void addVehicleCategory() {
        List<VehicleCategory> vehicleCategoryList = Arrays.asList(new VehicleCategory(2, "CAR"),
                new VehicleCategory(1, "BIKE"));
        vehicleCategoryDAO.saveAll(vehicleCategoryList);
    }

    private void addVehicleSubCategory() {
        List<VehicleSubCategory> vehicleSubCategories = new ArrayList<>();

        vehicleSubCategories.add(new VehicleSubCategory(1, "SUV",
                300, vehicleCategoryDAO.findById(4).get()));

        vehicleSubCategories.add(new VehicleSubCategory(2, "SEDAN",
                350, vehicleCategoryDAO.findById(4).get()));

        vehicleSubCategories.add(new VehicleSubCategory(3, "HATCHBACK",
                250, vehicleCategoryDAO.findById(4).get()));

        vehicleSubCategories.add(new VehicleSubCategory(4, "CRUISER",
                200, vehicleCategoryDAO.findById(5).get()));

        vehicleSubCategories.add(new VehicleSubCategory(5, "DIRT BIKE",
                200, vehicleCategoryDAO.findById(5).get()));

        vehicleSubCategories.add(new VehicleSubCategory(6, "SPORTS BIKE",
                150, vehicleCategoryDAO.findById(5).get()));

//        vehicleSubCategoryDAO.saveAll(vehicleSubCategories);
    }

    private void addUserRole() {

        List<Role> userRoleList = Arrays.asList(new Role(1, "Admin"),
                new Role(2, "User"));
        roleDAO.saveAll(userRoleList);
    }


    private void addUser() {
        User adminUser = new User("Upgrad", "Admin", "admin@123", "upgrad@gmail.com",
                "9999999999", 10000, roleDAO.findById(1).get());
        userDAO.save(adminUser);
    }

}
