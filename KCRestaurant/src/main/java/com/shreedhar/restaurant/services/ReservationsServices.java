package com.shreedhar.restaurant.services;

import java.util.List;

import com.shreedhar.restaurant.model.Reservations;
import com.shreedhar.restaurant.model.User;

public interface ReservationsServices {
	
	List<Reservations> getAllReservations();
		
	Reservations getReservationByConfimationNumber(String ConfirmationNumber);
	
	Reservations createReservations(User user, Reservations reservation, Integer seatinSize);
	
}
