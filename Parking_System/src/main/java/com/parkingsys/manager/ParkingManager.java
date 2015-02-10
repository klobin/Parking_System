package com.parkingsys.manager;

import java.util.List;

import com.parkingsys.vo.ParkingMaster;

public interface ParkingManager {

	void add() throws Exception;
	
	List<ParkingMaster> overview() throws Exception;
	
	List avilabilty() throws Exception;
	
	void park(int floor_no, String parking_bay, String reg_no) throws Exception;
	
	Object locate(String reg_no) throws Exception;
	
	void Unpark(String reg_no) throws Exception;
	
}
