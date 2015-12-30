package com.shreedhar.restaurant.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.shreedhar.restaurant.model.RestaurantTable;

@Repository("RestaurantTable")
public class RestaurantTableDaoImpl extends AbstractDao<Integer, RestaurantTable> implements RestaurantTableDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<RestaurantTable> getTableListGreaterThanSize(Integer size) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.ge("seatinSize", size));
		crit.addOrder(Order.asc("seatinSize"));
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RestaurantTable> getTableListNotInList(List<RestaurantTable> listOfReservationsTables) {
		List<Integer> listOfTableIds = getArrayOfTableIds(listOfReservationsTables);

		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.not(
				Restrictions.in("id", listOfTableIds)));
		return criteria.list();
	} 

	private List<Integer> getArrayOfTableIds(List<RestaurantTable> listOfReservationsTables){
		List<Integer> retList = new ArrayList<Integer>();

		for(RestaurantTable table : listOfReservationsTables){
			retList.add(table.getId());
		}
		return retList;
	}

}