package com.shreedhar.restaurant.dao;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.shreedhar.restaurant.model.Reservations;
import com.shreedhar.restaurant.model.RestaurantTable;

public interface ReservationsDao {

	List<Reservations> getAllReservations();	
	
	Reservations getReservationByConfirmationNumber(String confirmationNumber);
	
	void createReservation(Reservations reservationObj);
	
	List<RestaurantTable> getReservations(Date date, Time startTime, Time endTime);
}
