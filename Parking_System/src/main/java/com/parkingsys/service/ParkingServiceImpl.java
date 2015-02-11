package com.parkingsys.service;

import java.util.ArrayList;
import java.util.List;

import com.parkingsys.dao.ParkingDao;
import com.parkingsys.dao.ParkingDaoImpl;

public class ParkingServiceImpl implements ParkingService {

	private ParkingDao parkingDao;

	List<Integer> list0 = new ArrayList<Integer>();
	List<Integer> list1 = new ArrayList<Integer>();
	List<Integer> list2 = new ArrayList<Integer>();

	public ParkingServiceImpl() throws Exception{
		init();
	}
	public void init() throws Exception {
		parkingDao = new ParkingDaoImpl();
	}

	public void addLevel(int bike_count, int car_count, int hv_count) throws Exception {
		int floor_to_added = 0 ;
		int existing_floor_no = parkingDao.checkNoOffloors();
		floor_to_added = existing_floor_no + 1;
		parkingDao.addFloor(floor_to_added,bike_count,car_count,hv_count);		
		parkingDao.createMapping_for_bikes(floor_to_added,bike_count);
		parkingDao.createMapping_for_cars(floor_to_added,car_count);
		parkingDao.createMapping_for_heavy_vehicles(floor_to_added,hv_count);
	}

	public List availabilty() throws Exception {
		return parkingDao.getAvailabilty();
	}
	
	public List getOverview() throws Exception {
		
		return parkingDao.getOverview();
	}
	public boolean park(String floor_no, String parking_bay, String reg_no,String vehicle_type) {
		return parkingDao.park(floor_no, parking_bay, reg_no, vehicle_type);
	}

}
