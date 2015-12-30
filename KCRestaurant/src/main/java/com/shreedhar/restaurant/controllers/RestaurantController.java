package com.shreedhar.restaurant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shreedhar.restaurant.model.HotelTimings;
import com.shreedhar.restaurant.model.Reservations;
import com.shreedhar.restaurant.model.User;
import com.shreedhar.restaurant.services.ReservationsServices;
import com.shreedhar.restaurant.services.RestaurantDetailsService;
import com.shreedhar.restaurant.services.UserService;

@Controller
@RequestMapping("/rest/api")
public class RestaurantController {

	@Autowired
	UserService service;

	@Autowired
	RestaurantDetailsService restaurantService;

	@Autowired
	ReservationsServices reservationsService;

	/*
	 * Owner Api's
	 */
	@RequestMapping(value="/loginn", method = RequestMethod.POST)
	public ResponseEntity<User> ownerLogin(@RequestBody User user) {
		User retUser = service.validateUser(user.getEmailId());
		if(retUser == null){
			return new ResponseEntity<User>(new User(), HttpStatus.FORBIDDEN);
		}
		System.out.println("I am at the Login. User is: "+ user+ "and ret User is: "+ retUser);
		return new ResponseEntity<User>(retUser, HttpStatus.OK);
	}

	@RequestMapping(value = "/owner/restaurant/details", method = RequestMethod.GET)
	public ResponseEntity<List<HotelTimings>> restaurantDetails() {
		List<HotelTimings> timings = restaurantService.getRestaurantDetails();	
		return new ResponseEntity<List<HotelTimings>>(timings, HttpStatus.OK);
	}

	@RequestMapping(value = "/owner/reservations", method = RequestMethod.GET)
	public ResponseEntity<List<Reservations>> reservations() {
		List<Reservations> reservations = reservationsService.getAllReservations();	
		return new ResponseEntity<List<Reservations>>(reservations, HttpStatus.OK);
	}

	// Multiple paths mapped to this handler one for owner and one for customer
	@RequestMapping(value = {"/owner/reservations/details", "reservations/details"}, method = RequestMethod.GET)
	public ResponseEntity<Object> reservationDetails(@RequestParam("conf_number") String confirmationNumber) {
		Reservations retReservation = reservationsService.getReservationByConfimationNumber(confirmationNumber);	
		System.out.println("Reservation is: "+ retReservation);
		if(retReservation == null){
			return new ResponseEntity<Object>("NO_RESERVATIONS", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Object>(retReservation, HttpStatus.OK);
	}
	
	/*
	 * General api's
	 */
	@RequestMapping(value = "/reservations/create", method = RequestMethod.POST)
	public ResponseEntity<Object> createReservation(@RequestBody String reservationString) {
		ObjectMapper mapper = new ObjectMapper();
		User user;
		Reservations reservation, retReservation;
		Integer seatinSize;
		JsonNode requestNode;
		try {
			requestNode = mapper.readTree(reservationString);
			user = mapper.convertValue(requestNode.get("user"), User.class);
			
			reservation = mapper.convertValue(requestNode.get("reservation"), Reservations.class);
			seatinSize = mapper.convertValue(requestNode.get("seatinSize"), Integer.class);
			
			retReservation = reservationsService.createReservations(user, reservation, seatinSize);
			
			if(retReservation == null){
				return new ResponseEntity<Object>("NO_RESERVATIONS", HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<Object>(retReservation, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}	
	
}

