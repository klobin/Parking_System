package com.parkingsys.service;

import java.util.ArrayList;
import java.util.List;

import com.parkingsys.dao.ParkingDao;
import com.parkingsys.dao.ParkingDaoImpl;
import com.parkingsys.vo.HV_master;
import com.parkingsys.vo.Intermident_values;
import com.parkingsys.vo.ParkingMaster;

public class ParkingServiceImpl implements ParkingService {

	private ParkingDao parkingDao;

	private ParkingMaster parkingMaster = new ParkingMaster();
	private ParkingMaster parkingMaster1 = new ParkingMaster();
	List<Integer> list0 = new ArrayList<Integer>();
	List<Integer> list1 = new ArrayList<Integer>();
	List<Integer> list2 = new ArrayList<Integer>();



	private Intermident_values intermident_values = new Intermident_values();

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

}
