package com.shreedhar.restaurant.services;

import com.shreedhar.restaurant.model.User;


public interface UserService {

	User validateUser(String user);
	
	void createUser(User user);
}
