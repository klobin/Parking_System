package com.parkingsys.service;

import com.parkingsys.dao.ParkingDao;
import com.parkingsys.dao.ParkingDaoImpl;

public class ParkingServiceImpl implements ParkingService {

	private ParkingDao parkingDao;
	
	public ParkingServiceImpl() throws Exception{
		init();
	}
	public void init() throws Exception {
		parkingDao = new ParkingDaoImpl();
	}
	
	public void addLevel(int bike_count, int car_count, int hv_count) {
		
		parkingDao.addFloor(bike_count,car_count,hv_count);
	}

}
