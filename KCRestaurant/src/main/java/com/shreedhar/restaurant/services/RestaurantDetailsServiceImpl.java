package com.shreedhar.restaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shreedhar.restaurant.dao.HotelTimingsDao;
import com.shreedhar.restaurant.model.HotelTimings;

@Service("restaurantDetailsService")
@Transactional
public class RestaurantDetailsServiceImpl implements RestaurantDetailsService{

	@Autowired
	HotelTimingsDao timingsDao;

	@Override
	public List<HotelTimings> getRestaurantDetails() {
		return timingsDao.getHotelAllTimings();
	}
	
}
