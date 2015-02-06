package com.parkingsys.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import com.parkingsys.vo.Intermident_values;

public class ParkingDaoImpl implements ParkingDao{

	private Connectkon connectkon = null;
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;


	private void declarations() throws SQLException {
		connectkon = new Connectkon();
		con = connectkon.giveMeConnection();
		stmt = con.createStatement();
	}

	public void addFloor(int floor_no,int bike_count, int car_count, int hv_count) throws SQLException {
		declarations();
		stmt.executeQuery("insert into parking_master values("+floor_no+","+bike_count+","+car_count+","+hv_count+")");
		con.close();
		con = null;
	}


	public void showList() throws Exception{

	}


	public int checkNoOffloors() throws Exception {
		declarations();
		List<Integer> list = new ArrayList<Integer>(); 
		rs = stmt.executeQuery("select floor_no from parking_master");
		while(rs.next())
		{
			System.out.println(rs.getInt("floor_no"));
			list.add(rs.getInt("floor_no"));
		}
		con.close();
		con = null;

		int no = Collections.max(list);
		return no;
	}


	public void createMapping_for_bikes(int floor_no,int no_of_bikes) throws Exception {
		declarations();
		for(int i=1;i<=no_of_bikes;i++){
			stmt.executeQuery("insert into bike_master values("+floor_no+",B"+i+",'no','')");	
		}
		con.close();
		con = null;
	}

	public void createMapping_for_cars(int floor_no,int no_of_cars) throws Exception {
		declarations();
		for(int i=1;i<=no_of_cars;i++){
			stmt.executeQuery("insert into car_master values("+floor_no+",C"+i+",'no','')");	
		}
		con.close();
		con = null;
	}


	public void createMapping_for_heavy_vehicles(int floor_no,int no_of_hvs) throws Exception {
		declarations();
		for(int i=1;i<=no_of_hvs;i++){
			stmt.executeQuery("insert into hv_master values("+floor_no+",T"+i+",'no','')");	
		}
		con.close();
		con = null;
	}


	public List<Intermident_values> getAvailibilty() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
