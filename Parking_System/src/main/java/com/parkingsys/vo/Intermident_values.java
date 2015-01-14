package com.parkingsys.vo;

import java.util.List;

public class Intermident_values {
	private int floor_no;
	private List vacant_bike_space;
	private List vacant_car_space;
	private List vacant_HV_space;
	public Intermident_values(int floor_no, List vacant_bike_space,
			List vacant_car_space, List vacant_HV_space) {
		super();
		this.floor_no = floor_no;
		this.vacant_bike_space = vacant_bike_space;
		this.vacant_car_space = vacant_car_space;
		this.vacant_HV_space = vacant_HV_space;
	}
	public int getFloor_no() {
		return floor_no;
	}
	public void setFloor_no(int floor_no) {
		this.floor_no = floor_no;
	}
	public List getVacant_bike_space() {
		return vacant_bike_space;
	}
	public void setVacant_bike_space(List vacant_bike_space) {
		this.vacant_bike_space = vacant_bike_space;
	}
	public List getVacant_car_space() {
		return vacant_car_space;
	}
	public void setVacant_car_space(List vacant_car_space) {
		this.vacant_car_space = vacant_car_space;
	}
	public List getVacant_HV_space() {
		return vacant_HV_space;
	}
	public void setVacant_HV_space(List vacant_HV_space) {
		this.vacant_HV_space = vacant_HV_space;
	}
	
}
