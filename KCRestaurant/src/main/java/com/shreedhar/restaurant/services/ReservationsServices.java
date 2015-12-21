package com.shreedhar.restaurant.services;

import java.util.List;

import com.shreedhar.restaurant.model.Reservations;

public interface ReservationsServices {
	
	List<Reservations> getAllReservations();
		
	Reservations getReservationByConfimationNumber(String ConfirmationNumber);
	
}
