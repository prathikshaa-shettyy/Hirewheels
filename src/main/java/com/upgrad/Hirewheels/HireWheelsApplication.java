package com.upgrad.Hirewheels;

import com.upgrad.Hirewheels.dao.*;
import com.upgrad.Hirewheels.entities.Role;
import com.upgrad.Hirewheels.entities.User;
import com.upgrad.Hirewheels.entities.Vehicle;
import com.upgrad.Hirewheels.entities.VehicleSubCategory;
import com.upgrad.Hirewheels.services.InitService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@SpringBootApplication
public class HireWheelsApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(HireWheelsApplication.class, args);
		InitService initService = context.getBean(InitService.class);
		initService.start();
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
