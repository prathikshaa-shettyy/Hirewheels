package com.upgrad.Hirewheels.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("vehicleSubcategoryDAO")
public interface VehicleSubCategoryDAO extends JpaRepository<VehicleSubCategoryDAO,Integer> {
}
