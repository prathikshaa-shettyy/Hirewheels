package com.upgrad.Hirewheels.dto;

import com.upgrad.Hirewheels.entities.Location;
import com.upgrad.Hirewheels.entities.User;
import com.upgrad.Hirewheels.entities.Vehicle;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class BookingDTO {

    private int bookingId;
    private LocalDateTime pickUpDate;
    private LocalDateTime dropOffDate;
    private LocalDateTime bookingDate;
    private double amount;
    private Location location;
    private Vehicle vehicle;
    private User user;

    public int getBookingId() {
        return bookingId;
    }

    public LocalDateTime getPickUpDate() {
        return pickUpDate;
    }

    public LocalDateTime getDropOffDate() {
        return dropOffDate;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public double getAmount() {
        return amount;
    }

    public Location getLocation() {
        return location;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public User getUser() {
        return user;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setPickUpDate(LocalDateTime pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public void setDropOffDate(LocalDateTime dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
