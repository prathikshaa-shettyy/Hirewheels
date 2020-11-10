package com.upgrad.Hirewheels.entities;

import javax.persistence.*;
import java.util.Set;

public class VehicleSubCategory {

    @Entity
    public class VehicleSubcategory {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int vehicleSubcategoryId;

        @Column(length = 50, nullable = false, unique = true)
        private String vehicleSubcategoryName;

        @Column(length = 10, precision = 2, nullable = false)
        private double pricePerDay;

        @OneToMany(mappedBy = "vehicleSubcategory")
        private Set<Vehicle> vehicle;

        @ManyToOne
        @JoinColumn(name= "vehicleCategory_id", nullable = false )
        private VehicleCategory vehicleCategory;

        public VehicleSubcategory(int vehicleSubcategoryId, String vehicleSubcategoryName, double pricePerDay, VehicleCategory vehicleCategory) {
            this.vehicleSubcategoryId = vehicleSubcategoryId;
            this.vehicleSubcategoryName = vehicleSubcategoryName;
            this.pricePerDay = pricePerDay;
            this.vehicleCategory = vehicleCategory;
        }

        public VehicleSubcategory() {
        }

        public int getVehicleSubcategoryId() {
            return vehicleSubcategoryId;
        }

        public void setVehicleSubcategoryId(int vehicleSubcategoryId) {
            this.vehicleSubcategoryId = vehicleSubcategoryId;
        }

        public String getVehicleSubcategoryName() {
            return vehicleSubcategoryName;
        }

        public void setVehicleSubcategoryName(String vehicleSubcategoryName) {
            this.vehicleSubcategoryName = vehicleSubcategoryName;
        }

        public double getPricePerDay() {
            return pricePerDay;
        }

        public void setPricePerDay(double pricePerDay) {
            this.pricePerDay = pricePerDay;
        }


        public VehicleCategory getVehicleCategory() {
            return vehicleCategory;
        }

        public void setVehicleCategory(VehicleCategory vehicleCategory) {
            this.vehicleCategory = vehicleCategory;
        }

        @Override
        public String toString() {
            return "VehicleSubcategory{" +
                    "vehicleSubcategoryId=" + vehicleSubcategoryId +
                    ", vehicleSubcategoryName='" + vehicleSubcategoryName + '\'' +
                    ", pricePerDay=" + pricePerDay +
                    ", vehicleCategory=" + vehicleCategory +
                    '}';
        }
    }
}
