package com.shreedhar.restaurant.dao;

import org.springframework.stereotype.Repository;

import com.shreedhar.restaurant.model.RestaurantDetails;

@Repository("RestaurantDetails")
public class RestaurantDetailsDaoImpl extends AbstractDao<Integer, RestaurantDetails> implements RestaurantDetailsDao{

	@Override
	public RestaurantDetails getRestaurantDetails() {
		int id = 1;
		return getByKey(id);
	}

	@Override
	public void saveRestaurantDetails(RestaurantDetails restaurantDetails) {
		// TODO Auto-generated method stub
		
	}

}
