package com.parkingsys.connection;

import java.io.FileNotFoundException;
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
	private String driver="";
	private String connectionURL="";

	public Connection giveMeConnection() throws SQLException, IOException{  
		try{
//			input = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
			input = getClass().getClassLoader().getResourceAsStream("properties/config.properties");
			if(input!=null){
				properties.load(input);
			}else{
				throw new FileNotFoundException("property file: config properties not found in the classpath !");
			}
			driver = properties.getProperty("driver");
			connectionURL = properties.getProperty("url");

			Class.forName(driver);  
			con=DriverManager.getConnection(connectionURL);

			//			Class.forName("oracle.jdbc.driver.OracleDriver");  
			//			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");


			if(con!=null)
			{
				return con;
			}   
			System.out.println("Connection not establieshed...!!");
		}catch(Exception e){ System.out.println(e);}
		return con;
	}
}  