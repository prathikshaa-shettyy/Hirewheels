package com.upgrad.Hirewheels.controllers;
import com.upgrad.Hirewheels.dto.VehicleDTO;
import com.upgrad.Hirewheels.entities.Vehicle;
import com.upgrad.Hirewheels.exceptions.VehicleNotFoundException;
import com.upgrad.Hirewheels.services.AdminService;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;


@RestController
@RequestMapping(value="/Hirewheels/v1")
public class AdminController {

    private static  final Logger logger= (Logger) LoggerFactory.getLogger(AdminController.class);

    @Autowired
    ModelMapper modelmapper;

    @Autowired
    AdminService adminService;

    @PostMapping(value="/vehicles", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addVehicle(@RequestBody VehicleDTO vehicleDTO){
        Vehicle addVehicle=modelmapper.map(vehicleDTO,Vehicle.class);
        Vehicle saveVehicle=adminService.acceptVehicleDetails(addVehicle);
        logger.debug("Accepted new vehicle details",vehicleDTO);
        return new ResponseEntity<>(saveVehicle, HttpStatus.CREATED);
    }

    @PutMapping(value = "/vehicles/{vehicleid}")
    public ResponseEntity changeVehicleAvailability(@PathVariable(name = "vehicleid")int id,@RequestBody VehicleDTO vehicleDTO) throws VehicleNotFoundException {
        Vehicle vehicle=modelmapper.map(vehicleDTO,Vehicle.class);
        Vehicle updateVehicle=adminService.changeAvailabilty(id);
        logger.debug("Updated availability status for id:"+id, vehicleDTO);
        return new ResponseEntity<>(updateVehicle,HttpStatus.OK);
    }

}
