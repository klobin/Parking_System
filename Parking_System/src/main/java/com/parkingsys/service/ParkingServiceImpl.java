package com.parkingsys.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.parkingsys.dao.ParkingDao;
import com.parkingsys.dao.ParkingDaoImpl;
import com.parkingsys.vo.ParkingMaster;

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

	public boolean addLevel(int bike_count, int car_count, int hv_count) throws Exception {
		int floor_to_added = 0 ;
		int existing_floor_no = parkingDao.checkNoOffloors();
		floor_to_added = existing_floor_no + 1;
		boolean flag1 = parkingDao.addFloor(floor_to_added,bike_count,car_count,hv_count);		
		boolean flag2 = parkingDao.createMapping_for_bikes(floor_to_added,bike_count);
		boolean flag3 = parkingDao.createMapping_for_cars(floor_to_added,car_count);
		boolean flag4 = parkingDao.createMapping_for_heavy_vehicles(floor_to_added,hv_count);
		if(flag1 && flag2 && flag3 && flag4){
			return true;
		}
		return false;
	}

	public HashMap<Integer, List> availabilty() throws Exception {
		return parkingDao.getAvailabilty();
	}

	public List<ParkingMaster> getOverview() throws Exception {

		return parkingDao.getOverview();
	}
	public boolean manage_Parking(int floor_no, String parking_bay, String reg_no,String vehicle_type, boolean park_unpark_flag) {
		return parkingDao.manage_Parking(floor_no, parking_bay, reg_no, vehicle_type,park_unpark_flag);
	}
	public List locateVehcile(String reg_no) {
		return parkingDao.locateVehicle(reg_no);
	}
	public boolean remove() {
		boolean deleteFlag = false;
		boolean checkParkingOnFloor = false;
		try {
			int no = parkingDao.checkNoOffloors();
			if(no!=0){
				checkParkingOnFloor = parkingDao.isParkingVacant(no);
				if(checkParkingOnFloor){
					deleteFlag = parkingDao.remove(no);
				}
			}else{
				System.out.println("\n************************************\n");
				System.out.println(" WARNING -> All zones removed !\n");
				System.out.println("**************************************\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteFlag;
	}
}
