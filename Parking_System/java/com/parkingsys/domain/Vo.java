package com.parkingsys.domain;

public class Vo {

	public Vo() {}

	private int floor_id;
	
	private int cap_Bike;
	
	private int cap_Car;
	
	private int cap_heavyVehicle;

	public int getFloor_id() {
		return floor_id;
	}

	public void setFloor_id(int floor_id) {
		this.floor_id = floor_id;
	}

	public int getCap_Bike() {
		return cap_Bike;
	}

	public void setCap_Bike(int cap_Bike) {
		this.cap_Bike = cap_Bike;
	}

	public int getCap_Car() {
		return cap_Car;
	}

	public void setCap_Car(int cap_Car) {
		this.cap_Car = cap_Car;
	}

	public int getCap_heavyVehicle() {
		return cap_heavyVehicle;
	}

	public void setCap_heavyVehicle(int cap_heavyVehicle) {
		this.cap_heavyVehicle = cap_heavyVehicle;
	}
	
	public Vo(int floor_id ,int cap_Bike ,int cap_Car ,int cap_heavyVehicle) {
		this.floor_id = floor_id;
		this.cap_Bike = cap_Bike;
		this.cap_Car =  cap_Car;
		this.cap_heavyVehicle = cap_heavyVehicle;
	}
	
}
