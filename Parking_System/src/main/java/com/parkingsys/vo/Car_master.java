package com.parkingsys.vo;

public class Car_master {
	private int floor_id;
	private String parking_bay;
	private String parked;
	private String car_reg;
	public int getFloor_id() {
		return floor_id;
	}
	public void setFloor_id(int floor_id) {
		this.floor_id = floor_id;
	}
	public String getParking_bay() {
		return parking_bay;
	}
	public void setParking_bay(String parking_bay) {
		this.parking_bay = parking_bay;
	}
	public String getParked() {
		return parked;
	}
	public void setParked(String parked) {
		this.parked = parked;
	}
	public String getCar_reg() {
		return car_reg;
	}
	public void setCar_reg(String car_reg) {
		this.car_reg = car_reg;
	}

}