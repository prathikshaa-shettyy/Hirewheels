package com.upgrad.Hirewheels.dao;

import com.upgrad.Hirewheels.entities.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("fuelTypeDAO")
public interface FuelTypeDAO extends JpaRepository<FuelType,Integer> {
}
