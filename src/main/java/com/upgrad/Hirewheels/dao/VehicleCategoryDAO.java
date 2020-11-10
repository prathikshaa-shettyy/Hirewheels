package com.upgrad.Hirewheels.dao;

import com.upgrad.Hirewheels.entities.VehicleCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("vehicleCategoryDAO")
public interface VehicleCategoryDAO extends JpaRepository<VehicleCategory,Integer> {

}
