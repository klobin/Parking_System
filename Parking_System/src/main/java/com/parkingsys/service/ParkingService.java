package com.parkingsys.service;

import java.util.List;

import com.parkingsys.vo.Intermident_values;

public interface ParkingService {

	void addLevel(int bike_count, int car_count, int hv_count);

	List showOverview();

	List<Intermident_values> showAvailibity();

}
