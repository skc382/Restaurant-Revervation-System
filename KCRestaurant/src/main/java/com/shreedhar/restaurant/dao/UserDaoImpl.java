package com.shreedhar.restaurant.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.shreedhar.restaurant.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<String, User> implements UserDao{

	@Override
	public User findByEmail(String email) {
		return getByKey(email);
	}

	@Override
	public void saveUser(User user) {
		persist(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() {
		Criteria criteria = createEntityCriteria();
		return (List<User>) criteria.list();

	}


}
