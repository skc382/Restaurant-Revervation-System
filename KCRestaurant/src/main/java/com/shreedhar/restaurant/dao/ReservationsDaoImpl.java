package com.shreedhar.restaurant.dao;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.shreedhar.restaurant.model.Reservations;
import com.shreedhar.restaurant.model.RestaurantTable;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<RestaurantTable> getReservations(Date date, Time startTime,
			Time endTime) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("date", date));
		criteria.add(Restrictions.eq("startTime", startTime));
		criteria.add(Restrictions.eq("endTime", endTime));
		criteria.setProjection(Projections.property("restaurantTable"));
		List<Object> list = criteria.list();
		return criteria.list();
	}


}
