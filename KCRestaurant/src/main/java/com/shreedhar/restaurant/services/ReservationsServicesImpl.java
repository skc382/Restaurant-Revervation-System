package com.shreedhar.restaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shreedhar.restaurant.dao.ReservationsDao;
import com.shreedhar.restaurant.dao.RestaurantTableDao;
import com.shreedhar.restaurant.model.Reservations;
import com.shreedhar.restaurant.model.RestaurantTable;
import com.shreedhar.restaurant.model.User;

@Service("reservationsService")
@Transactional
public class ReservationsServicesImpl implements ReservationsServices {

	@Autowired
	ReservationsDao reservationsDao;
	
	@Autowired
	RestaurantTableDao tableDao;
	
	@Autowired
	UserService userService;
	
	@Override
	public List<Reservations> getAllReservations() {
		return reservationsDao.getAllReservations();
	}

	@Override
	public Reservations getReservationByConfimationNumber(
			String ConfirmationNumber) {
		return reservationsDao.getReservationByConfirmationNumber(ConfirmationNumber);
	}

	
	
	@Override
	public void createReservations(User user, Reservations reservation, Integer seatinSize) {

		List<RestaurantTable> tableList;
		if(userService.validateUser(user.getEmailId()) == null)
		{
			userService.createUser(user);
			user = userService.validateUser(user.getEmailId());
		}
		
		tableList = tableDao.getTableListGreaterThanSize(seatinSize);
		
		reservation.setUser(user);
		reservationsDao.createReservation(reservation);
		
	}

}
