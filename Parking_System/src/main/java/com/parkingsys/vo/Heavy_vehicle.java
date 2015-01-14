package com.parkingsys.vo;

public class Heavy_vehicle {
	private int bay_no;
	private boolean parked;
	private String hv_id;
	private int extern_id;
	
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

	public String getHv_id() {
		return hv_id;
	}

	public void setHv_id(String hv_id) {
		this.hv_id = hv_id;
	}

	public int getExtern_id() {
		return extern_id;
	}

	public void setExtern_id(int extern_id) {
		this.extern_id = extern_id;
	}

	public Heavy_vehicle(int bay_no, boolean parked, String hv_id, int extern_id) {
		super();
		this.bay_no = bay_no;
		this.parked = parked;
		this.hv_id = hv_id;
		this.extern_id = extern_id;
	}
	
}
