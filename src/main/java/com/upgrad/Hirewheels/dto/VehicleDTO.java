package com.upgrad.Hirewheels.dto;

import com.upgrad.Hirewheels.entities.FuelType;
import com.upgrad.Hirewheels.entities.Location;
import com.upgrad.Hirewheels.entities.VehicleSubCategory;
import java.util.Set;
public class VehicleDTO {
    private int vehicleId;
    private String vehicleModel;
    private String vehicleNumber;
    private String color;
    private int availableStatus;
    private String vehicleImageUrl;
    private FuelType fuelType;
    private Location location;
    private VehicleSubCategory vehicleSubcategory;
    public int getVehicleId() {
        return vehicleId;
    }
    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
    public String getVehicleModel() {
        return vehicleModel;
    }
    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getAvailableStatus() {
        return availableStatus;
    }
    public void setAvailableStatus(int availableStatus) {
        this.availableStatus = availableStatus;
    }
    public String getVehicleImageUrl() {
        return vehicleImageUrl;
    }
    public void setVehicleImageUrl(String vehicleImageUrl) {
        this.vehicleImageUrl = vehicleImageUrl;
    }
    public FuelType getFuelType() {
        return fuelType;
    }
    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public VehicleSubCategory getVehicleSubcategory() {
        return vehicleSubcategory;
    }
    public void setVehicleSubcategory(VehicleSubCategory vehicleSubcategory) {
        this.vehicleSubcategory = vehicleSubcategory;
    }
}



