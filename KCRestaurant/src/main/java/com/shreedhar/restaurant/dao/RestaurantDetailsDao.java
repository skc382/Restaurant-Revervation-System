package com.shreedhar.restaurant.dao;

import com.shreedhar.restaurant.model.RestaurantDetails;

public interface RestaurantDetailsDao {

	RestaurantDetails getRestaurantDetails();
	
	void saveRestaurantDetails(RestaurantDetails restaurantDetails);
}
