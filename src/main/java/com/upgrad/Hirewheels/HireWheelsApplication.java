package com.upgrad.Hirewheels;

import com.upgrad.Hirewheels.dao.RoleDAO;
import com.upgrad.Hirewheels.dao.UserDAO;
import com.upgrad.Hirewheels.entities.Role;
import com.upgrad.Hirewheels.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HireWheelsApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(HireWheelsApplication.class, args);


	}

}
