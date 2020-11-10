package com.upgrad.Hirewheels.services;

import com.upgrad.Hirewheels.dao.UserDAO;
import com.upgrad.Hirewheels.entities.User;
import com.upgrad.Hirewheels.exceptions.MobileNoAlreadyExists;
import com.upgrad.Hirewheels.exceptions.UnauthorizedUserException;
import com.upgrad.Hirewheels.exceptions.UserAlreadyExistsException;
import com.upgrad.Hirewheels.exceptions.UserNotRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDAO userDao;


    @Override
    public User createUser(User user) throws UserAlreadyExistsException, MobileNoAlreadyExists {
        if (userDao.findByEmailIgnoreCase(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("Email Already Exists");
        }
        if (userDao.findByMobileNo(user.getMobileNo()).isPresent()) {
            throw new MobileNoAlreadyExists("Mobile Number Already Exists");
        }
        return userDao.save(user);
    }

    public User getUser(User user) throws UserNotRegisteredException, UnauthorizedUserException {
        User loggedUser = userDao.findByEmailIgnoreCase(user.getEmail()).orElseThrow(
                () -> new UserNotRegisteredException("User not Registered"));

        if (loggedUser.getPassword().equals(user.getPassword())) {
            return loggedUser;
        } else {
            throw new UnauthorizedUserException("Unauthorized User");
        }
    }
}
