package com.upgrad.Hirewheels;

import com.upgrad.Hirewheels.dao.RoleDAO;
import com.upgrad.Hirewheels.dao.UserDAO;
import com.upgrad.Hirewheels.entities.Role;
import com.upgrad.Hirewheels.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HireWheelsApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(HireWheelsApplication.class, args);
		UserDAO userDAO = context.getBean(UserDAO.class);
		RoleDAO roleDAO = context.getBean(RoleDAO.class);

	}

}
