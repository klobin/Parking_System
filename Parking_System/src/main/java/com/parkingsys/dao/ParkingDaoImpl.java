package com.parkingsys.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.parkingsys.connection.*;
import com.parkingsys.vo.Bike_master;
import com.parkingsys.vo.Car_master;
import com.parkingsys.vo.HV_master;
import com.parkingsys.vo.ParkingMaster;

public class ParkingDaoImpl implements ParkingDao{

	private Connectkon connectkon = null;
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private ResultSet rs1 = null;
	private ResultSet rs2 = null;
	private ResultSet rs3 = null;
	private Bike_master bike_master = null;
	private Car_master car_master = null;
	private HV_master hv_master = null;
	private List<Bike_master> list_bike = null;
	private List<Car_master> list_car = null;
	private List<HV_master> list_hv = null;
	private List result_list = null;


	private void declarations() {
		connectkon = new Connectkon();
		try{
			con = connectkon.giveMeConnection();
			con.setAutoCommit(true);
			stmt = con.createStatement();
		}catch(SQLException e){
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addFloor(int floor_no,int bike_count, int car_count, int hv_count) {
		declarations();
		try{
			stmt.executeQuery("insert into parking_master values("+floor_no+","+bike_count+","+car_count+","+hv_count+")");
		}catch(SQLException e)
		{
			rollback();
		}finally{
			closeConnection();
		}
	}

	private void closeConnection() {
		try {
			if(con!=null){
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			System.out.println("Connection not closed...!!");
			e.printStackTrace();
		}
	}

	private void rollback() {
		try {
			con.rollback();
			System.out.println("Roll back done normally..!!");
		} catch (SQLException e1) {
			System.out.println("Roll back not done....!!");
			e1.printStackTrace();
		}
	}


	public void showList() throws Exception{

	}


	public int checkNoOffloors() throws Exception {
		declarations();
		List<Integer> list = new ArrayList<Integer>(); 
		rs = stmt.executeQuery("select floor_no from parking_master");
		while(rs.next())
		{
			list.add(rs.getInt("floor_no"));
		}
		con.close();
		con = null;
		int no = 0;
		if(!list.isEmpty()){
		no = Collections.max(list);
		}
		return no;
	}


	public void createMapping_for_bikes(int floor_no,int no_of_bikes) throws Exception {
		declarations();
		for(int i=1;i<=no_of_bikes;i++){
			stmt.executeQuery("insert into bike_master values("+floor_no+",'B"+i+"','N','')");	
		}
		con.close();
		con = null;
	}

	public void createMapping_for_cars(int floor_no,int no_of_cars) throws Exception {
		declarations();
		for(int i=1;i<=no_of_cars;i++){
			stmt.executeQuery("insert into car_master values("+floor_no+",'C"+i+"','N','')");	
		}
		con.close();
		con = null;
	}


	public void createMapping_for_heavy_vehicles(int floor_no,int no_of_hvs) throws Exception {
		declarations();
		for(int i=1;i<=no_of_hvs;i++){
			stmt.executeQuery("insert into hv_master values("+floor_no+",'T"+i+"','N','')");	
		}
		con.close();
		con = null;
	}

	public List getAvailabilty() throws Exception {
		declarations();
		rs = stmt.executeQuery("select floor_no from parking_master");
//		bike_master = new Bike_master();
		car_master = new Car_master();
		hv_master = new HV_master();
		list_bike = new ArrayList<Bike_master>();
		list_car = new ArrayList<Car_master>();
		list_hv = new ArrayList<HV_master>();
		result_list = new ArrayList();
		List master_list = new ArrayList();
		while(rs.next())
		{
			if(rs.getInt("floor_no")!=0)
			{
				rs1 = stmt.executeQuery("select floor_no,parking_bay from bike_master where floor_no ="+rs.getInt("floor_no")+"");
				while (rs1.next()) {
					Bike_master bike_master = new Bike_master();
					bike_master.setFloor_id(rs1.getInt(1));
					bike_master.setParking_bay(rs1.getString(2));
					list_bike.add(bike_master);
				}

				rs2 = stmt.executeQuery("select floor_no,parking_bay from car_master where floor_no ="+rs.getInt("floor_no")+"");
				while (rs2.next()) {
					Car_master car_master = new Car_master();
					car_master.setFloor_id(rs2.getInt(1));
					car_master.setParking_bay(rs2.getString(2));
					list_car.add(car_master);
				}

				rs3 = stmt.executeQuery("select floor_no,parking_bay from hv_master where floor_no ="+rs.getInt("floor_no")+"");
				while (rs3.next()) {
					HV_master hv_master = new HV_master();
					hv_master.setFloor_id(rs3.getInt(1));
					hv_master.setParking_bay(rs3.getString(2));
					list_hv.add(hv_master);
				}

				result_list.add(list_bike);
				result_list.add(list_car);
				result_list.add(hv_master);
				
				master_list.add(result_list);
				
			}
		}
		return master_list;
	}

	public List getOverview() throws Exception {
		List<ParkingMaster> pList = new ArrayList<ParkingMaster>();
		declarations();
		rs = stmt.executeQuery("select * from parking_master");
		while(rs.next())
		{
			ParkingMaster parkingMaster = new ParkingMaster();
			parkingMaster.setFloor_id(rs.getInt(1));
			parkingMaster.setCap_bike(rs.getInt(2));
			parkingMaster.setCap_car(rs.getInt(3));
			parkingMaster.setCap_heavyVehicle(rs.getInt(4));
			pList.add(parkingMaster);
		}
		return pList;
	}

}
