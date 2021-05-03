package com.isolutions4u.onlineshopping.test;


import com.isolutions4u.onlineshopping.model.User;
import com.isolutions4u.onlineshopping.repository.AddressRepository;
import com.isolutions4u.onlineshopping.repository.UserRepository;
import com.isolutions4u.onlineshopping.service.UserService;
import com.isolutions4u.onlineshopping.service.UserServiceImpl;
import org.hamcrest.Matchers;
import org.hibernate.validator.internal.constraintvalidators.EmailValidator;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

public class UserRepositoryTest {

    @Autowired
    private UserRepository repo;
    @Autowired
    private TestEntityManager entityManager;



    @Test
    public void testcreateuser_failsifalreadyexist() {
        User user = new User();
        user.setId(5);
        user.setContactNumber("1234567890");
        user.setEmail("ss@gmail.com");
        user.setFirstName("SK");
        user.setLastName("Patel");
        user.setPassword("1234");
        user.setEnabled(true);
        user.setRole("User");

        User savedUser =repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());

    }
    @Test
    public void testUserByEmail(){
        User user = new User();
        user.setEmail("shivanippatel25@gmail.com");


        assertThat(user).isNotNull().satisfies(user1 -> {
            assertThat(user.getEmail()).isEqualTo("shivanippatel25@gmail.com");
        });


    }
    @Test
    public void userNotInitiallyRegistered() {

        assertNull(repo.findUserByEmail("Shivanipatel@gmail.com"));
    }
    @Test
    public void testGetUserByFirstname() {

        User user = new User();
        user.setFirstName("Shivani");

        assertThat(user).isNotNull().satisfies(user1 -> {
            assertThat(user.getFirstName()).isEqualTo("Shivani");
        });


    }



}

