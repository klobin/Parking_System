package com.parkingsys.vo;

import java.util.List;

public class Intermident_values {
	private List<Bike_master> bike_list; 
	private List<Car_master>  car_list;
	private List<HV_master> h_list;
	
	public List<Bike_master> getBike_list() {
		return bike_list;
	}
	public void setBike_list(List<Bike_master> bike_list) {
		this.bike_list = bike_list;
	}
	public List<Car_master> getCar_list() {
		return car_list;
	}
	public void setCar_list(List<Car_master> car_list) {
		this.car_list = car_list;
	}
	public List<HV_master> getH_list() {
		return h_list;
	}
	public void setH_list(List<HV_master> h_list) {
		this.h_list = h_list;
	}
}
