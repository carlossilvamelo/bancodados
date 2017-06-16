package com.bancodados.DAOs;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionManager {
	
	
	private static Connection connection =  null;
	
	private ConnectionManager(){
		// TODO Auto-generated constructor stub
	
	}

	public synchronized static Connection getConnection() throws SQLException{
		
		if((connection == null)||(connection.isClosed())){
			try{
				
				connection = DriverManager.
						getConnection("jdbc:mysql://localhost/mydb"
								,"root","root");
			System.out.println("Conectado!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}	
		}
		
		return connection; 
	}
	
	public static void setConnection(Connection con) {
		connection = con;
	}

	
	
	
	
}
