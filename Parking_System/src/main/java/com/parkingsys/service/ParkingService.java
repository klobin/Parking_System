package com.parkingsys.service;

import java.sql.SQLException;
import java.util.List;

import com.parkingsys.vo.Intermident_values;

public interface ParkingService {

	void addLevel(int bike_count, int car_count, int hv_count) throws SQLException, Exception;

	List showOverview();

	List<Intermident_values> showAvailibity() throws Exception;

}
