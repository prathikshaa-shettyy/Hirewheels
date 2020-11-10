package com.upgrad.Hirewheels.dao;

import com.upgrad.Hirewheels.entities.Vehicle;
import com.upgrad.Hirewheels.entities.VehicleSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("vehicleDAO")
public interface VehicleDAO extends JpaRepository<Vehicle,Integer> {
    List<Vehicle> findByVehicleSubcategory(VehicleSubCategory.VehicleSubcategory vehicleSubcategory);

    Optional<Vehicle> findByVehicleNumber(String vehicleNumber);

    Optional<Vehicle> findByAvailableStatus(Integer integer);
}
