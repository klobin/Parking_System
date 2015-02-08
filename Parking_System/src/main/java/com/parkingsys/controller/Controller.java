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
		List returnList = parkingService.availabilty();
		return returnList;
	}
}
