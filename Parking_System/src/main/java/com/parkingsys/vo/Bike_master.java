package com.parkingsys.vo;

public class Bike_master {
	private int bay_no;
	private boolean parked;
	private String bike_id;
	private int extern_id;

	public Bike_master(int bay_no, boolean parked, String bike_id, int extern_id) {
		super();
		this.bay_no = bay_no;
		this.parked = parked;
		this.bike_id = bike_id;
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

	public String getBike_id() {
		return bike_id;
	}

	public void setBike_id(String bike_id) {
		this.bike_id = bike_id;
	}

	public int getExtern_id() {
		return extern_id;
	}

	public void setExtern_id(int extern_id) {
		this.extern_id = extern_id;
	} 
}
