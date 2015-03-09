package com.parkingsys.controller;

import java.util.HashMap;
import java.util.List;

import com.parkingsys.service.ParkingService;
import com.parkingsys.service.ParkingServiceImpl;
import com.parkingsys.vo.ParkingMaster;

public class Controller {

	private ParkingService parkingService;

	public Controller() throws Exception {
		init();
	}

	public  void init() throws Exception {
		parkingService = new ParkingServiceImpl();
	}

	public boolean AddZone(int bike_count,int car_count,int hv_count) throws Exception {
		return parkingService.addLevel(bike_count,car_count,hv_count);
	}

	public HashMap<Integer, List> showAvailability() throws Exception {
		return parkingService.availabilty();
	}

	public List<ParkingMaster> showOverview() throws Exception {
		return parkingService.getOverview();
	}

	public boolean manage_Parking(int floor_no, String parkin_bay, String reg_no, String vehicle_type,boolean park_unpark_flag) {
		return parkingService.manage_Parking(floor_no,parkin_bay,reg_no,vehicle_type,park_unpark_flag);
	}

	public List locateVehcile(String reg_no) {
		return parkingService.locateVehcile(reg_no);
	}

	public boolean remove() {
		return parkingService.remove();
	}
}
