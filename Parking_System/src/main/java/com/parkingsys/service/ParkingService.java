package com.parkingsys.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.parkingsys.vo.ParkingMaster;

public interface ParkingService {

	boolean addLevel(int bike_count, int car_count, int hv_count) throws SQLException, Exception;

	HashMap<Integer, List> availabilty() throws Exception;

	List<ParkingMaster> getOverview() throws Exception;

	boolean manage_Parking(int floor_no, String parking_bay, String reg_no, String vehicle_type, boolean park_unpark_flag);

	List locateVehcile(String reg_no);

	boolean remove();

}
