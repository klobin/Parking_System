package com.parkingsys.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connectkon {  
	private Connection con = null;
	private InputStream input;
	Properties properties = new Properties();
	private String driver;
	private String connectionURL;

	public Connection giveMeConnection() throws SQLException, IOException{  
		try{
//			input = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
//			properties.load(input);
//			driver = properties.getProperty("driver");
//			connectionURL = properties.getProperty("url");

			Class.forName("org.hsqldb.jdbcDriver");  
			con=DriverManager.getConnection("jdbc:hsqldb:file:C:/Users/g97158/Documents/TestDb", "SA", "");

			if(con!=null)
			{
				return con;
			}   
			System.out.println("Connection not establieshed...!!");
		}catch(Exception e){ System.out.println(e);}
		return con;
	}
}  