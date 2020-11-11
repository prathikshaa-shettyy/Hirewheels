package com.upgrad.Hirewheels.services;
import com.upgrad.Hirewheels.dao.*;
import com.upgrad.Hirewheels.entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class VehicleServiceTest {

    @Mock
    private VehicleDAO vehicleDAO;
    private FuelTypeDAO fuelTypeDAO;
    private LocationDAO locationDAO;
    private VehicleSubCategory vehicleSubCategory;
    private VehicleCategory vehicleCategory;
    private CityDAO cityDAO;
    private VehicleCategoryDAO vehicleCategoryDAO;
    private VehicleSubCategoryDAO vehicleSubCategoryDAO;

    @InjectMocks
    private VehicleService vehicleService;

    @BeforeEach
    public void setupMockito()
    {

        Mockito.when(cityDAO.findById(1)).thenReturn(Optional.of(new City(1, "City Name")));

        Mockito.when(vehicleCategoryDAO.findById(1)).thenReturn(Optional.of(new VehicleCategory(1, "Car")));

        //Mockito.when(vehicleSubCategoryDAO.findById(1)).thenReturn(Optional.of(new VehicleSubCategory(1, "Sedan", 600, (VehicleCategory) vehicleCategoryDAO.findById(1).get())));

        Mockito.when(locationDAO.findById(1)).thenReturn(Optional.of(new Location(1, "Mangalore", "church gate", cityDAO.findById(1).get(), "575016")));

        Mockito.when(vehicleDAO.save(new Vehicle("mode", "v0001" ,(VehicleSubCategory)vehicleSubCategoryDAO.findById(1).get(), "blue", locationDAO.findById(1).get(), fuelTypeDAO.findById(1).get(), 1, "url"))).thenReturn(new Vehicle("mode", "v0001" ,(VehicleSubCategory)vehicleSubCategoryDAO.findById(1).get(), "blue", locationDAO.findById(1).get(), fuelTypeDAO.findById(1).get(), 1, "url"));

        Mockito.when(vehicleDAO.findAll()).thenReturn((List<Vehicle>)new Vehicle("mode", "v0001" ,(VehicleSubCategory)vehicleSubCategoryDAO.findById(1).get(), "blue", locationDAO.findById(1).get(), fuelTypeDAO.findById(1).get(), 1, "url"));

        Mockito.when(vehicleDAO.findByAvailableStatus(1)).thenReturn(Optional.of(new Vehicle("mode", "v0001", (VehicleSubCategory)vehicleSubCategoryDAO.findById(1).get(), "blue", locationDAO.findById(1).get(), fuelTypeDAO.findById(1).get(), 1, "url")));

    }
    @Test
    public void testGetAllVehicles()
    {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleModel("mode");
        vehicle.setVehicleNumber("v0001");
        vehicle.setVehicleSubcategory((VehicleSubCategory)vehicleSubCategoryDAO.findById(1).get());
        vehicle.setColor("blue");
        vehicle.setLocation(locationDAO.findById(1).get());
        vehicle.setFuelType(fuelTypeDAO.findById(1).get());
        vehicle.setAvailableStatus(1);
        vehicle.setVehicleImageUrl("url");
        vehicleDAO.save(vehicle);

        vehicleDAO.findAll();
        Assertions.assertNotNull(vehicle);
        Assertions.assertTrue(vehicle.getVehicleId() != 0);
        Assertions.assertEquals("mode", vehicle.getVehicleModel());
        Assertions.assertEquals(vehicleSubCategoryDAO.findById(1).get(), vehicle.getVehicleSubcategory());
        Assertions.assertEquals("blue", vehicle.getColor());
        Assertions.assertEquals(locationDAO.findById(1).get(), vehicle.getLocation());
        Assertions.assertEquals(fuelTypeDAO.findById(1).get(), vehicle.getFuelType());
        Assertions.assertEquals(1, vehicle.getAvailableStatus());
        Assertions.assertEquals("url", vehicle.getVehicleImageUrl());

    }

    @Test
    public void testGetAvailableVehicles()
    {

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleModel("mode");
        vehicle.setVehicleNumber("v0001");
        vehicle.setVehicleSubcategory((VehicleSubCategory) vehicleSubCategoryDAO.findById(1).get());
        vehicle.setColor("blue");
        vehicle.setLocation(locationDAO.findById(1).get());
        vehicle.setFuelType(fuelTypeDAO.findById(1).get());
        vehicle.setAvailableStatus(1);
        vehicle.setVehicleImageUrl("url");
        vehicleDAO.save(vehicle);

        vehicleDAO.findByAvailableStatus(1);

        Assertions.assertNotNull(vehicle);
        Assertions.assertTrue(vehicle.getVehicleId() != 0);
        Assertions.assertEquals("mode", vehicle.getVehicleModel());
        Assertions.assertEquals(vehicleSubCategoryDAO.findById(1).get(), vehicle.getVehicleSubcategory());
        Assertions.assertEquals("blue", vehicle.getColor());
        Assertions.assertEquals(locationDAO.findById(1).get(), vehicle.getLocation());
        Assertions.assertEquals(fuelTypeDAO.findById(1).get(), vehicle.getFuelType());
        Assertions.assertEquals(1, vehicle.getAvailableStatus());
        Assertions.assertEquals("url", vehicle.getVehicleImageUrl());
    }
}

