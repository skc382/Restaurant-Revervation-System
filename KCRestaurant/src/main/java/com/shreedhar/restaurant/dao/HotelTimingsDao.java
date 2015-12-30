package com.shreedhar.restaurant.dao;

import java.util.List;

import com.shreedhar.restaurant.model.HotelTimings;

public interface HotelTimingsDao {

	List<HotelTimings> getHotelAllTimings();
	
	void updateHotelTimings(HotelTimings timings);
}
