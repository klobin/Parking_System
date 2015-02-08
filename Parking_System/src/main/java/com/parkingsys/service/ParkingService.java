package com.parkingsys.service;

import java.sql.SQLException;
import java.util.List;

public interface ParkingService {

	void addLevel(int bike_count, int car_count, int hv_count) throws SQLException, Exception;

	List availabilty() throws Exception;

}
