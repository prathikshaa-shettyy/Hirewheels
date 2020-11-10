package com.upgrad.Hirewheels;

import com.upgrad.Hirewheels.dao.UserDAO;
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
		UserDAO userDAO =context.getBean(UserDAO.class);


		//Inserting users in the database
		User user1 = new User();
		user1.setFirstName("Prathi");
		user1.setLastName("shetty");
		user1.setEmail("prathishetty@gmail.com");
		user1.setMobileNo("897169836");
		user1.setPassword("pra");
		user1.setWalletMoney(10000);

		User user2 = new User();
		user2.setFirstName("krithi");
		user2.setLastName("k");
		user2.setEmail("krithi@gmail.com");
		user2.setMobileNo("897169826");
		user2.setPassword("kri");
		user2.setWalletMoney(10000);

		User user3 = new User();
		user3.setFirstName("Swathi");
		user3.setLastName("S");
		user3.setEmail("Swathi@gmail.com");
		user3.setMobileNo("897169816");
		user3.setPassword("swa");
		user3.setWalletMoney(10000);

		User user4 = new User();
		user4.setFirstName("Ruthu");
		user4.setLastName("R");
		user4.setEmail("Ruthu@gmail.com");
		user4.setMobileNo("897169835");
		user4.setPassword("ruthu");
		user4.setWalletMoney(10000);

		User user5 = new User();
		user5.setFirstName("Kishor");
		user5.setLastName("kumar");
		user5.setEmail("Kishor@gmail.com");
		user5.setMobileNo("897169835");
		user5.setPassword("Kishor");
		user5.setWalletMoney(10000);

		//Saving all users
		List<User> userLists= new ArrayList<>();
		userLists.add(user1);
		userLists.add(user2);
		userLists.add(user3);
		userLists.add(user4);
		userLists.add(user5);
		userDAO.saveAll(userLists);

		//printing user details on console
		userDAO.findAll().forEach(user -> System.out.println(user.toString()));

		//paginated request to fetch a page with 2 users using the UserDao interface
		Page<User> page0 = userDAO.findAll(PageRequest.of(0,2));
		page0.stream().forEach(user -> System.out.println(user.toString()));

		// custom query methods to fetch the users using the UserDao
		userDAO.findByFirstNameIgnoreCase("Prathi").forEach(user -> System.out.println(user.toString()));
		userDAO.findByFirstNameOrLastNameIgnoreCase("Swathi","S").forEach(user -> System.out.println(user.toString()));
		userDAO.findByEmailIgnoreCase("prathishetty@gmail.com").ifPresent(user -> System.out.println(user.toString()));
	}

}
