package com.shreedhar.restaurant.model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hotel_timings")
public class HotelTimings {
	
	@Id
	@GeneratedValue
	@Column(name = "htl_tmng_id")
	private Integer hotelTimingId;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="rstnt_id", referencedColumnName = "id")
	private RestaurantDetails restaurant;
	
	@Column(name = "day")
	private String day;
	
	@Column(name = "strt_time")
	private Time startTime;
	
	@Column(name = "end_time")
	private Time endTime;

	public HotelTimings(){
		
	}
	
	public HotelTimings(String day, Time startTime,
			Time endTime) {
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Integer getHotelTimingId() {
		return hotelTimingId;
	}

	public void setHotelTimingId(Integer hotelTimingId) {
		this.hotelTimingId = hotelTimingId;
	}

	public RestaurantDetails getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(RestaurantDetails restaurant) {
		this.restaurant = restaurant;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "HotelTimings [hotelTimingId=" + hotelTimingId + ", restaurant="
				+ restaurant + ", day=" + day + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}
}
