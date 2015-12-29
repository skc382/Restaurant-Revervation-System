package com.shreedhar.restaurant.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.shreedhar.restaurant.model.HotelTimings;

@Repository("HotelTimings")
public class HotelTimingsDaoImpl extends AbstractDao<Integer, HotelTimings> implements HotelTimingsDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<HotelTimings> getHotelAllTimings() {
		Criteria criteria = createEntityCriteria();
		return (List<HotelTimings>) criteria.list();
	}

	@Override
	public void updateHotelTimings(HotelTimings timings) {
		// TODO Auto-generated method stub
		
	}

}
