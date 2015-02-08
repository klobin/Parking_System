package com.parkingsys.dao;

import java.sql.SQLException;
import java.util.List;

import com.parkingsys.vo.Intermident_values;

public interface ParkingDao {

	void addFloor(int floor_no,int bike_count, int car_count, int hv_count) throws SQLException;


	List getAvailabilty() throws Exception;


	int checkNoOffloors() throws Exception;


	void createMapping_for_bikes(int floor_to_added, int bike_count) throws Exception;


	void createMapping_for_cars(int floor_to_added, int car_count) throws Exception;


	void createMapping_for_heavy_vehicles(int floor_to_added, int hv_count) throws Exception;

	
}
