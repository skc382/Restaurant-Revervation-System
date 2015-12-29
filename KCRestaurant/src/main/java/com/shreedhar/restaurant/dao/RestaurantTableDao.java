package com.shreedhar.restaurant.dao;



import java.util.List;

import com.shreedhar.restaurant.model.RestaurantTable;

public interface RestaurantTableDao {
	
	List<RestaurantTable> getTableListGreaterThanSize(Integer size);
	
	List<RestaurantTable> getTableListNotInList(List<RestaurantTable> listOfReservationsTables);

}
