package com.shreedhar.restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "restaurant_table")
public class RestaurantTable {
	
	@Id
	@GeneratedValue
	@Column(name = "id")	
	private Integer id;
	
	@Column(name = "shape")
	private String shape;
	
	@Column(name = "seating_size")
	private Integer seatinSize;
	
	public RestaurantTable(){
		
	}

	public RestaurantTable(String shape, Integer seatinSize) {
		super();
		this.shape = shape;
		this.seatinSize = seatinSize;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public Integer getSeatinSize() {
		return seatinSize;
	}

	public void setSeatinSize(Integer seatinSize) {
		this.seatinSize = seatinSize;
	}

	@Override
	public String toString() {
		return "RestaurantTable [id=" + id + ", shape=" + shape
				+ ", seatinSize=" + seatinSize + "]";
	}
	
}
