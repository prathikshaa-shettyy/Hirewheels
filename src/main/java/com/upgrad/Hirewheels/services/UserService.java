package com.upgrad.Hirewheels.services;

import com.upgrad.Hirewheels.entities.User;
import com.upgrad.Hirewheels.exceptions.MobileNoAlreadyExists;
import com.upgrad.Hirewheels.exceptions.UnauthorizedUserException;
import com.upgrad.Hirewheels.exceptions.UserAlreadyExistsException;
import com.upgrad.Hirewheels.exceptions.UserNotRegisteredException;

public interface UserService {

    User createUser(User user) throws UserAlreadyExistsException, MobileNoAlreadyExists;
    User getUser(User user) throws UserNotRegisteredException, UnauthorizedUserException;

}
