package com.parkingsys.service;

import java.util.ArrayList;
import java.util.List;

import com.parkingsys.dao.ParkingDao;
import com.parkingsys.dao.ParkingDaoImpl;
import com.parkingsys.vo.Intermident_values;
import com.parkingsys.vo.ParkingMaster;

public class ParkingServiceImpl implements ParkingService {

	private ParkingDao parkingDao;
	
	private ParkingMaster parkingMaster = new ParkingMaster();
	private ParkingMaster parkingMaster1 = new ParkingMaster();
	private ParkingMaster parkingMaster2 = new ParkingMaster();
	private ParkingMaster parkingMaster3 = new ParkingMaster();
	
	public ParkingServiceImpl() throws Exception{
		init();
	}
	public void init() throws Exception {
		parkingDao = new ParkingDaoImpl();
	}
	
	public void addLevel(int bike_count, int car_count, int hv_count) {
		
		parkingDao.addFloor(bike_count,car_count,hv_count);
	}
	public List<ParkingMaster> showOverview() {
		List jasjd = new ArrayList<ParkingMaster>();
		parkingMaster.setFloor_id(0);
		parkingMaster.setCap_bike(54);
		parkingMaster.setCap_car(4);
		parkingMaster.setCap_heavyVehicle(4);
		jasjd.add(parkingMaster);
		parkingMaster1.setFloor_id(1);
		parkingMaster1.setCap_bike(24);
		parkingMaster1.setCap_car(8);
		parkingMaster1.setCap_heavyVehicle(2);
		jasjd.add(parkingMaster1);
		return jasjd;
	}
	
	public List<Intermident_values> showAvailibity() {
		
		List<Intermident_values> result_parkingSpace = parkingDao.getAvailibilty();
		return result_parkingSpace;
	}

}
