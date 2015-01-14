package com.parkingsys.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.parkingsys.dao.ParkingDao;
import com.parkingsys.dao.ParkingDaoImpl;
import com.parkingsys.vo.Bike_master;
import com.parkingsys.vo.Car_master;
import com.parkingsys.vo.Heavy_vehicle;
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
	
	public void addLevel(int bike_count, int car_count, int hv_count) {
		
		parkingDao.addFloor(bike_count,car_count,hv_count);
	}
	public List<ParkingMaster> showOverview() {
//		parkingDao.showList();
		
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
		
//		List<Intermident_values> result_parkingSpace = parkingDao.getAvailibilty();
		
		List<Intermident_values> result_parkingSpace = new ArrayList<Intermident_values>();
		for(int i=1;i<8;i++){
			list0.add(new Random().nextInt());
			list1.add(new Random().nextInt());
			list2.add(new Random().nextInt());
		}
		result_parkingSpace.add(list0);
		return result_parkingSpace;
	}

}
