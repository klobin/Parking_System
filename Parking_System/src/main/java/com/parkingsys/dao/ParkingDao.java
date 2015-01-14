package com.parkingsys.dao;

import java.util.List;

import com.parkingsys.vo.Intermident_values;

public interface ParkingDao {

	void addFloor(int bike_count, int car_count, int hv_count);


	List<Intermident_values> getAvailibilty();


	void showList();


}
