package com.shreedhar.restaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shreedhar.restaurant.dao.UserDao;
import com.shreedhar.restaurant.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired 
	private UserDao dao;
	
	@Override
	public User validateUser(String emailId) {
		User localUser = dao.findByEmail(emailId);
		
		if(localUser == null){
			System.out.println("User is Null because Inavalid Email ID: "+ emailId);
			return null;
		}
		
		System.out.println(localUser);
		return localUser;
	}

	@Override
	public void createUser(User user) {
		dao.saveUser(user);		
	}
}
