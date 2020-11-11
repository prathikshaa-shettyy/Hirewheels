package com.upgrad.Hirewheels.controllers;

import com.upgrad.Hirewheels.dao.VehicleCategoryDAO;
import com.upgrad.Hirewheels.exceptions.VehicleNotFoundException;
import org.modelmapper.ModelMapper;
import com.upgrad.Hirewheels.dto.VehicleDTO;
import com.upgrad.Hirewheels.entities.Vehicle;
import com.upgrad.Hirewheels.services.VehicleService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


@RestController
public class VehicleController
{
    private static  final Logger logger= (Logger) LoggerFactory.getLogger(AdminController.class);

    @Autowired
    VehicleService vehicleService;
    @Autowired
    VehicleCategoryDAO vehicleCategoryDao;
    @Autowired
    ModelMapper modelMapper;
    @GetMapping(value= {"/Hirewheels/v1/vehicles"}, produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity getVehicles(@RequestParam(name = "categoryName") String categoryName, @RequestParam(name="pickUpDate") LocalDateTime pickUpDate, @RequestParam(name="dropDate")LocalDateTime dropDate, @RequestParam(name="locationId") int locationId) throws VehicleNotFoundException
    {
        List<Vehicle> vehicleList=vehicleService.getAllVehicles();
        List<VehicleDTO> vehicleDTOList=new ArrayList<>();
        for(Vehicle vehicle:vehicleList){
            if(vehicle.getVehicleSubcategory().equals(categoryName)&& vehicle.getLocation().equals(locationId) && vehicle.getBooking().equals(pickUpDate) && vehicle.getBooking().equals(dropDate)) {
                vehicleDTOList.add(modelMapper.map(vehicle, VehicleDTO.class));
            }
            else
                {
                    return null;
                }
            }
        logger.debug("Vehicle list returned", vehicleDTOList);
        return new ResponseEntity<>(vehicleDTOList,HttpStatus.OK);
    }
}

