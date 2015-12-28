package com.shreedhar.restaurant.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.shreedhar.restaurant.model.Reservations;

@Repository("Reservations")
public class ReservationsDaoImpl extends AbstractDao<Integer, Reservations> implements ReservationsDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Reservations> getAllReservations() {
		Criteria criteria = createEntityCriteria();
		return (List<Reservations>) criteria.list();
	}

	@Override
	public Reservations getReservationByConfirmationNumber(
			String confirmationNumber) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("confirmationId", confirmationNumber));
		return (Reservations) crit.uniqueResult();
	}
	
	@Override
	public void createReservation(Reservations reservationObj)
	{
		persist(reservationObj);
	}

}
