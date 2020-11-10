package com.upgrad.Hirewheels.dao;

import com.upgrad.Hirewheels.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("userDAO")
public interface UserDAO extends JpaRepository<User,Integer> {

    public List<User> findByFirstNameIgnoreCase(String firstName);

    public List<User> findByFirstNameOrLastNameIgnoreCase(String firstName, String lastName);

    public Optional<User> findByEmailIgnoreCase(String email);

    public Optional<User> findByMobileNo(String mobileNo);

    Optional<User> findByEmailAndPassword(String email, String password);

}
