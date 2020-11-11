package com.upgrad.Hirewheels.controllers;
import com.upgrad.Hirewheels.dao.VehicleCategoryDAO;
import com.upgrad.Hirewheels.exceptions.APIException;
import com.upgrad.Hirewheels.exceptions.VehicleNotFoundException;
import org.modelmapper.ModelMapper;
import com.upgrad.Hirewheels.dto.VehicleDTO;
import com.upgrad.Hirewheels.entities.Vehicle;
import com.upgrad.Hirewheels.services.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value ="/hirewheels/v1")
public class VehicleController {

    private static  final Logger logger= LoggerFactory.getLogger(AdminController.class);

    @Autowired
    VehicleService vehicleService;

    @Autowired
    VehicleCategoryDAO vehicleCategoryDao;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping(value="/vehicles/{vehicleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getVehicles(@PathVariable("vehicleId") int vehicleId) throws APIException, VehicleNotFoundException {
        logger.debug("Searching vehicle for id :", vehicleId);
        List<Vehicle> vehicleList=vehicleService.getAllVehicles();
        List<VehicleDTO> vehicleDTOList=new ArrayList<>();
        for(Vehicle vehicle : vehicleList){
            if(vehicle.getVehicleId()==vehicleId) {
                vehicleDTOList.add(modelMapper.map(vehicle, VehicleDTO.class));
            }
            else {
                return null;
            }
        }
        logger.debug("Vehicle list returned", vehicleDTOList);
        return new ResponseEntity<>(vehicleDTOList,HttpStatus.OK);
    }

    @GetMapping(value = "/vehicles",produces= MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
    public ResponseEntity findAllAvailablevehicles() {
        List<Vehicle> vehicleList = vehicleService.getAllVehicles();
        return new ResponseEntity<>(vehicleList, HttpStatus.OK);
    }
}

