package com.upgrad.Hirewheels.dao;

import com.upgrad.Hirewheels.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("bookingDAO")
public interface BookingDAO extends JpaRepository<Booking,Integer> {

}
