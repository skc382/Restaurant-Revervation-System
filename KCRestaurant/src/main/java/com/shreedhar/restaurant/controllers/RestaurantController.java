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

	@RequestMapping(value="/loginn", method = RequestMethod.POST)
	public ResponseEntity<User> ownerLogin(@RequestBody User user) {
		User retUser = service.validateOwner(user.getEmailId());
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

	@RequestMapping(value = "/owner/reservations/details", method = RequestMethod.GET)
	public ResponseEntity<Reservations> reservationDetails(@RequestParam("conf_number") String confirmationNumber) {
		Reservations reservations = reservationsService.getReservationByConfimationNumber(confirmationNumber);	
		System.out.println("Reservation is: "+ reservations);
		return new ResponseEntity<Reservations>(reservations, HttpStatus.OK);
	}
	
	@RequestMapping(value="/access_denied", method = RequestMethod.POST)
	public ResponseEntity<String> ownerAccessDenied() {
		return new ResponseEntity<String>("Got Fucked", HttpStatus.OK);
	}
}

