package com.parkingsys.vo;

public class Vo {

	private int floor_id;

	private int cap_bike;

	private int cap_car;

	private int cap_heavyVehicle;

	public int getFloor_id() {
		return floor_id;
	}

	public void setFloor_id(int floor_id) {
		this.floor_id = floor_id;
	}

	public int getCap_bike() {
		return cap_bike;
	}

	public void setCap_bike(int cap_bike) {
		this.cap_bike = cap_bike;
	}

	public int getCap_car() {
		return cap_car;
	}

	public void setCap_car(int cap_car) {
		this.cap_car = cap_car;
	}

	public int getCap_heavyVehicle() {
		return cap_heavyVehicle;
	}

	public void setCap_heavyVehicle(int cap_heavyVehicle) {
		this.cap_heavyVehicle = cap_heavyVehicle;
	}

	public Vo(int floor_id, int cap_bike, int cap_car, int cap_heavyVehicle) {
		this.floor_id = floor_id;
		this.cap_bike = cap_bike;
		this.cap_car = cap_car;
		this.cap_heavyVehicle = cap_heavyVehicle;
	}


}
