package com.shreedhar.restaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shreedhar.restaurant.dao.ReservationsDao;
import com.shreedhar.restaurant.model.Reservations;

@Service("reservationsService")
@Transactional
public class ReservationsServicesImpl implements ReservationsServices {

	@Autowired
	ReservationsDao reservationsDao;
	
	@Override
	public List<Reservations> getAllReservations() {
		return reservationsDao.getAllReservations();
	}

	@Override
	public Reservations getReservationByConfimationNumber(
			String ConfirmationNumber) {
		return reservationsDao.getReservationByConfirmationNumber(ConfirmationNumber);
	}

}
