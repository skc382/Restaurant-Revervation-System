package com.shreedhar.restaurant.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservations")
public class Reservations {
	
	public static final Reservations NO_RESERVATION = null;
	
	@Id
	@GeneratedValue
	@Column(name = "id")	
	private Integer id;
	
	@Column(name = "confirmation_id")
	private String confirmationId;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "start_time")
	private Time startTime;
	
	@Column(name = "end_time")
	private Time endTime;
	
	@ManyToOne
	@JoinColumn(name = "email_id", referencedColumnName = "email_id")
	private User user;
	
	@Column(name = "active")
	private Integer active;
	
	@ManyToOne
	@JoinColumn(name = "table_id", referencedColumnName = "id")
	private RestaurantTable restaurantTable;
	
	public Reservations(){
		
	}

	public Reservations(String confirmationId, Date date, Time startTime,
			Time endTime, Integer active) {
		super();
		this.confirmationId = confirmationId;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.active = active;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConfirmationId() {
		return confirmationId;
	}

	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public RestaurantTable getRestaurantTable() {
		return restaurantTable;
	}

	public void setRestaurantTable(RestaurantTable restaurantTable) {
		this.restaurantTable = restaurantTable;
	}

	@Override
	public String toString() {
		return "Reservations [id=" + id + ", confirmationId=" + confirmationId
				+ ", date=" + date + ", startTime=" + startTime + ", endTime="
				+ endTime + ", user=" + user + ", active=" + active
				+ ", restaurantTable=" + restaurantTable + "]";
	}

}
