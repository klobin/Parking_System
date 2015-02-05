package com.parkingsys.dao;

import java.sql.SQLException;
import java.util.List;

import com.parkingsys.vo.Intermident_values;

public interface ParkingDao {

	void addFloor(int floor_no,int bike_count, int car_count, int hv_count) throws SQLException;


	List<Intermident_values> getAvailibilty() throws Exception;


	void showList() throws Exception;


	int checkNoOffloors() throws Exception;


}
