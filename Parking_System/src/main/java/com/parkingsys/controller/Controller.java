package com.parkingsys.controller;

import java.util.List;

import com.parkingsys.service.ParkingService;
import com.parkingsys.service.ParkingServiceImpl;

public class Controller {

	private ParkingService parkingService;

	public Controller() throws Exception {
		init();
	}

	public  void init() throws Exception {
		parkingService = new ParkingServiceImpl();
	}

	public void AddZone(int bike_count,int car_count,int hv_count) throws Exception {
		parkingService.addLevel(bike_count,car_count,hv_count);
	}

	public List showAvailability() throws Exception {
		return parkingService.availabilty();
	}

	public List showOverview() throws Exception {
		return parkingService.getOverview();
	}

	public boolean manage_Parking(String floor_no, String parkin_bay, String reg_no, String vehicle_type,boolean park_unpark_flag) {
		return parkingService.manage_Parking(floor_no,parkin_bay,reg_no,vehicle_type,park_unpark_flag);
	}
}
