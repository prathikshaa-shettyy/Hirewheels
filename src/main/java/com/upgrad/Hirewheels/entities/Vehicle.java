package com.upgrad.Hirewheels.entities;

import javax.persistence.*;
import java.util.Set;

public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleId;

    @Column(length = 50, nullable = false)
    private String vehicleModel;

    @Column(length = 10, nullable = false)
    private String vehicleNumber;

    @Column(length = 50, nullable = false)
    private String color;

    @Column(length = 1, nullable = false)
    private int availableStatus;

    @Column(length = 500, nullable = false)
    private String vehicleImageUrl;

    @OneToMany(mappedBy = "vehicle")
    private Set<Booking> booking;

    @ManyToOne
    @JoinColumn(name = "fuelType_id", nullable = false)
    private FuelType fuelType;


    @ManyToOne
    @JoinColumn(name= "location_id", nullable = false)
    private Location location;

    @ManyToOne
    @JoinColumn(name = "vehicleSubcategory_id", nullable = false)
    private VehicleSubCategory vehicleSubcategory;

    public Vehicle() {
    }

    public Vehicle(String vehicleModel, String vehicleNumber, VehicleSubCategory vehicleSubcategory, String color, Location location, FuelType fuelType, int availabilityStatus, String vehicleImageUrl) {
        this.vehicleModel = vehicleModel;
        this.vehicleNumber = vehicleNumber;
        this.vehicleSubcategory = vehicleSubcategory;
        this.color = color;
        this.location = location;
        this.fuelType = fuelType;
        this.availableStatus = availabilityStatus;
        this.vehicleImageUrl = vehicleImageUrl;
    }

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

    @Override
    public String toString() {
        return "Vehicle{" + "vehicleId=" + vehicleId + ", vehicleModel='" + vehicleModel + '\'' + ", vehicleNumber=" + vehicleNumber + ", color='" + color + '\'' + ", availableStatus=" + availableStatus + ", vehicleImageUrl='" + vehicleImageUrl + '\'' + ", fuelType=" + fuelType + ", location=" + location + ", vehicleSubcategory=" + vehicleSubcategory + '}';
    }
    }

