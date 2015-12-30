package com.shreedhar.restaurant.services;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.UUID;

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
	public Reservations createReservations(User userInput, Reservations reservationInput, Integer seatinSize) {

		List<RestaurantTable> listOfReservationsTables, tableList;
		if(userService.validateUser(userInput.getEmailId()) == null)
		{
			userService.createUser(userInput);
			userInput = userService.validateUser(userInput.getEmailId());
		}
		
		listOfReservationsTables = reservationsDao.getReservations(reservationInput.getDate(), reservationInput.getStartTime(), reservationInput.getEndTime());
		
		if(listOfReservationsTables == null || listOfReservationsTables.isEmpty()) // There are no reservations
		{
			return createNewReservation(reservationInput.getDate(), reservationInput.getStartTime(), 
					reservationInput.getEndTime(), seatinSize, userInput);
		}
		
		// Get the tables which are not reserved for that time
		tableList = tableDao.getTableListNotInList(listOfReservationsTables);
		
		// No tables so return No_RESERVATION object
		if(tableList == null || tableList.isEmpty()){
			return Reservations.NO_RESERVATION;
		}
		
		return createNewReservationExistingTable(tableList.get(0), reservationInput.getDate(), reservationInput.getStartTime(), 
				reservationInput.getEndTime(), seatinSize, userInput);		
	}
	
	// Create reservation with a existings table
	private Reservations createNewReservationExistingTable(RestaurantTable existigTable, Date date, Time startTime, Time endTime, Integer seatingSize, User userInput){
		String confimationId;
		Reservations newReservation, retReservation;
		User user;
		Integer isActive = 1;
		
		//Create confirmation id
		confimationId = UUID.randomUUID().toString();
		//get the User
		user = userService.validateUser(userInput.getEmailId());
		
		//Create reservation
		newReservation = new Reservations(confimationId, date, startTime, endTime, isActive);
		newReservation.setRestaurantTable(existigTable);
		newReservation.setUser(user);
	
		reservationsDao.createReservation(newReservation);
		retReservation = reservationsDao.getReservationByConfirmationNumber(newReservation.getConfirmationId());
		
		return retReservation;
	}
	
	
	
	// Create reservation with a new table
	private Reservations createNewReservation(Date date, Time startTime, Time endTime, Integer seatingSize, User userInput){
		List<RestaurantTable> tableList;
		String confimationId;
		Reservations newReservation, retReservation;
		User user;
		Integer isActive = 1;
		
		//Create confirmation id
		confimationId = UUID.randomUUID().toString();
		//Get tables greater than seating size
		tableList = tableDao.getTableListGreaterThanSize(seatingSize);
		//get the User
		user = userService.validateUser(userInput.getEmailId());
		//Create reservation
		newReservation = new Reservations(confimationId, date, startTime, endTime, isActive);
		newReservation.setRestaurantTable(tableList.get(0));
		newReservation.setUser(user);
	
		reservationsDao.createReservation(newReservation);
		retReservation = reservationsDao.getReservationByConfirmationNumber(newReservation.getConfirmationId());
		
		return retReservation;
	}
}
























