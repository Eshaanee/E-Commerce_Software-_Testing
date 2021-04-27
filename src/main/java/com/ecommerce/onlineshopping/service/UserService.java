package com.ecommerce.onlineshopping.service;

import com.ecommerce.onlineshopping.model.User;

public interface UserService {

	boolean saveUser(User user);

	User findUserByEmail(String email);

}
