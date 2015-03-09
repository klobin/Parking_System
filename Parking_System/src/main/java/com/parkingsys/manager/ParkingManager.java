package com.parkingsys.manager;

import java.util.HashMap;
import java.util.List;

import com.parkingsys.vo.ParkingMaster;

public interface ParkingManager {

	boolean add(int bike_count, int car_count, int hv_count) throws Exception;
	
	List<ParkingMaster> overview() throws Exception;
	
	HashMap<Integer, List> availabilty() throws Exception;
	
	boolean manage_Parking(int floor_no, String parkin_bay, String reg_no, String vehicle_type,boolean park_unpark_flag) throws Exception;
	
	List locate(String reg_no) throws Exception;

	boolean remove() throws Exception;
}
