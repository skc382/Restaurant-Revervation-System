package com.shreedhar.restaurant.dao;

import java.util.List;

import com.shreedhar.restaurant.model.User;

public interface UserDao {

	User findByEmail(String email);
	
	void saveUser(User user);
	
	List<User> findAllUsers();
}
