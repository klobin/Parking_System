package com.parkingsys.service;

import java.sql.SQLException;
import java.util.List;

public interface ParkingService {

	void addLevel(int bike_count, int car_count, int hv_count) throws SQLException, Exception;

	List availabilty() throws Exception;

	List getOverview() throws Exception;

	boolean manage_Parking(String floor_no, String parkin_bay, String reg_no, String vehicle_type, boolean park_unpark_flag);

	List locateVehcile(String reg_no);

	void remove();

}
