package com.parkingsys.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.parkingsys.vo.Intermident_values;

public class ParkingDaoImpl implements ParkingDao{

	private Connectkon connectkon = null;
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	public static void main(String args[]) throws Exception{
		ParkingDaoImpl parkingDaoImpl = new ParkingDaoImpl();
		parkingDaoImpl.getAvailibilty();

	}


	public void addFloor(int floor_no,int bike_count, int car_count, int hv_count) throws SQLException {
		declarations();
		stmt.executeQuery("insert into parking_master values("+floor_no+","+bike_count+","+car_count+","+hv_count+")");
		con.close();
		con = null;
	}

	public void getAvailibilty() throws Exception {
		connectkon = new Connectkon();

		try {

			con= connectkon.giveMeConnection();

			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from  employees");  
			System.out.println(rs);

			while(rs.next())  {
				System.out.println(rs.getInt(1)+"  "+rs.getString(2));  
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			con.close(); 
			con=null;
		}
	}


	public void showList() throws Exception{

	}


	public List<Intermident_values> getAvailibilty() throws Exception {
		// TODO Auto-generated method stub
		return null;
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


	private void declarations() throws SQLException {
		connectkon = new Connectkon();
		con = connectkon.giveMeConnection();
		stmt = con.createStatement();
	}

}
