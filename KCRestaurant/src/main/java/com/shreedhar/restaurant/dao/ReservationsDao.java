package com.shreedhar.restaurant.dao;

import java.util.List;

import com.shreedhar.restaurant.model.Reservations;

public interface ReservationsDao {

	List<Reservations> getAllReservations();	
	
	Reservations getReservationByConfirmationNumber(String confirmationNumber);
}
