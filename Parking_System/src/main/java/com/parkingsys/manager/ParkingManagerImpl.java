package com.parkingsys.manager;

import java.util.HashMap;
import java.util.List;

import com.parkingsys.service.ParkingService;
import com.parkingsys.service.ParkingServiceImpl;
import com.parkingsys.vo.ParkingMaster;

public class ParkingManagerImpl implements ParkingManager {

	private ParkingService parkingService;
	
	public ParkingManagerImpl() throws Exception {
		init();
	}

	public  void init() throws Exception {
		parkingService = new ParkingServiceImpl();
	}

	
	public boolean add(int bike_count, int car_count, int hv_count)
			throws Exception {
		return parkingService.addLevel(bike_count,car_count,hv_count);
	}

	public List<ParkingMaster> overview() throws Exception {
		return parkingService.getOverview();
	}

	public HashMap<Integer, List> availabilty() throws Exception {
		return parkingService.availabilty();
	}

	public boolean manage_Parking(String floor_no, String parkin_bay,
			String reg_no, String vehicle_type, boolean park_unpark_flag)
			throws Exception {
		return parkingService.manage_Parking(floor_no,parkin_bay,reg_no,vehicle_type,park_unpark_flag);
	}

	public List locate(String reg_no) throws Exception {
		return parkingService.locateVehcile(reg_no);
	}

	public boolean remove() throws Exception {
		return parkingService.remove();
	}


}
