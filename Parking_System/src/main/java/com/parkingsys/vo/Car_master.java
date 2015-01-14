package com.parkingsys.vo;

public class Car_master {
	private int bay_no;
	private boolean parked;
	private String car_id;
	private int extern_id;
	public Car_master(int bay_no, boolean parked, String car_id, int extern_id) {
		super();
		this.bay_no = bay_no;
		this.parked = parked;
		this.car_id = car_id;
		this.extern_id = extern_id;
	}
	public int getBay_no() {
		return bay_no;
	}
	public void setBay_no(int bay_no) {
		this.bay_no = bay_no;
	}
	public boolean isParked() {
		return parked;
	}
	public void setParked(boolean parked) {
		this.parked = parked;
	}
	public String getCar_id() {
		return car_id;
	}
	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}
	public int getExtern_id() {
		return extern_id;
	}
	public void setExtern_id(int extern_id) {
		this.extern_id = extern_id;
	}
}
