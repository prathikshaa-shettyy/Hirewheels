package com.upgrad.Hirewheels.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "BOOKING")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingId;

    @Column(nullable = false)
    private LocalDateTime pickUpDate;

    @Column(nullable = false)
    private LocalDateTime dropOffDate;

    @Column(nullable = false)
    private LocalDateTime bookingDate;

    @Column(length = 10, precision = 2, nullable = false)
    private double amount;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Booking() {
    }

    public Booking(LocalDateTime pickupDate, LocalDateTime dropoffDate, LocalDateTime bookingDate, double amount, Location location, Vehicle vehicle, User user) {
        this.pickUpDate = pickupDate;
        this.dropOffDate = dropoffDate;
        this.bookingDate = bookingDate;
        this.amount = amount;
        this.location = location;
        this.vehicle = vehicle;
        this.user = user;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDateTime getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDateTime pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public LocalDateTime getDropOffDate() {
        return dropOffDate;
    }

    public void setDropOffDate(LocalDateTime dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public User getUsers() {
        return user;
    }

    public void setUsers(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Booking{" + "bookingId=" + bookingId + ", pickUpDate=" + pickUpDate + ", dropOffDate=" + dropOffDate + ", bookingDate=" + bookingDate + ", amount=" + amount + ", location=" + location + ", vehicle=" + vehicle + ", user=" + user + '}';
    }
}
