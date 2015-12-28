package com.shreedhar.restaurant.services;

import java.util.List;

import com.shreedhar.restaurant.model.HotelTimings;
import com.shreedhar.restaurant.model.Reservations;
import com.shreedhar.restaurant.model.User;

public interface RestaurantDetailsService {

	List<HotelTimings> getRestaurantDetails();

}
