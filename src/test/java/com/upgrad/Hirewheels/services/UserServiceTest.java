package com.upgrad.Hirewheels.services;
import com.upgrad.Hirewheels.dao.RoleDAO;
import com.upgrad.Hirewheels.dao.UserDAO;
import com.upgrad.Hirewheels.entities.Role;
import com.upgrad.Hirewheels.entities.User;
import com.upgrad.Hirewheels.exceptions.UserNotRegisteredException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserDAO userDAO;
    private RoleDAO roleDAO;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setupMockito() {
        Mockito.when(userDAO.save(new User("Save", "Test", "prathi@16","prathi@gmail.com", "8971698236", 1100, roleDAO.findById(1).get())))
                    .thenReturn(new User("Save", "Test", "prathi@16", "prathi@gmail.com", "8971698236", 1100, roleDAO.findById(1).get()));

        Mockito.when(userDAO.findById(1)).thenReturn(Optional.of(new User("Save", "test", "prathi@16", "prathi@gmail.com", "8971698236", 1100, roleDAO.findById(1).get())));
        Mockito.when(userDAO.save(new User("Update", "test", "prathi@16", "prathi@gmail.com", "8971698236", 1100, roleDAO.findById(1).get())))
                    .thenReturn(new User("Update", "test", "prathi@16", "prathi@gmail.com", "8971698236", 1100, roleDAO.findById(1).get()));

        Mockito.when(userDAO.save(new User("Get", "test", "prathi@16", "prathi@gmail.com", "8971698236", 1100, roleDAO.findById(1).get())))
                    .thenReturn(new User("Get", "test", "prathi@16", "prathi@gmail.com", "8971698236", 1100, roleDAO.findById(1).get()));
        Mockito.when(userDAO.findByFirstNameIgnoreCase("Get")).thenReturn((List<User>)new User("Get", "test", "prathi@16", "prathi@gmail.com", "8971698236", 1100, roleDAO.findById(1).get()));

        Mockito.when(roleDAO.findById(1)).thenReturn(Optional.of(new Role(1, "Admin")));

        }

        @Test
        public void testCreateUser() {

            User user = new User();
            user.setFirstName("Save");
            user.setLastName("Test");
            user.setPassword("kaps#120");
            user.setEmail("kaps@mail.com");
            user.setWalletMoney(556);
            user.setRole(roleDAO.findById(1).get());
            userDAO.save(user);

        }

        @Test
        public void testGetUsers() throws UserNotRegisteredException {

            User user = new User();
            user.setFirstName("Save");
            user.setLastName("Test");
            user.setPassword("prathi@16");
            user.setEmail("prathi@gmail.com");
            user.setWalletMoney(1100);
            user.setRole(roleDAO.findById(1).get());
            userDAO.save(user);

            User savedUser = (User) userDAO.findByFirstNameIgnoreCase("Get");
            Assertions.assertNotNull(savedUser);
            Assertions.assertTrue(savedUser.getUserId() != 0);
            Assertions.assertEquals("Get", savedUser.getFirstName());

        }
    }

