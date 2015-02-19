package com.parkingsys.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.parkingsys.vo.ParkingMaster;

public interface ParkingDao {

	boolean addFloor(int floor_no,int bike_count, int car_count, int hv_count) throws SQLException;


	HashMap<Integer, List> getAvailabilty() throws Exception;


	int checkNoOffloors() throws Exception;


	boolean createMapping_for_bikes(int floor_to_added, int bike_count) throws Exception;


	boolean createMapping_for_cars(int floor_to_added, int car_count) throws Exception;


	boolean createMapping_for_heavy_vehicles(int floor_to_added, int hv_count) throws Exception;


	List<ParkingMaster> getOverview() throws Exception;


	boolean manage_Parking(String floor_no, String parking_bay, String reg_no,String vehicle_type, boolean park_unpark_flag);


	List locateVehicle(String reg_no);


	boolean remove(int no);


	boolean isParkingVacant(int no);
	
}
