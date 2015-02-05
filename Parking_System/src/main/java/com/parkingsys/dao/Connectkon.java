package com.parkingsys.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
class Connectkon {  
	Connection con = null;

	public Connection giveMeConnection() throws SQLException{  
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			if(con!=null)
			{
				return con;
			}   
			System.out.println("Connection not establieshed...!!");
		}catch(Exception e){ System.out.println(e);}
		return con;
	}
}  