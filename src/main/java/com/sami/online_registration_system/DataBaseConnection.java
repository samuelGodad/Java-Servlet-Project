package com.sami.online_registration_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// this class is used to connect to the database
public class DataBaseConnection {

	private  static Connection connection= null;
	// this method is used to connect to the database
	public static Connection getConnection(){

		if (connection==null){

			try {
				Class.forName("org.postgresql.Driver");
				try {

					connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/online_registeration","postgres","20082011ec!");
					System.out.println("connected successfully");

				} catch (SQLException e) {
					System.out.println("you cannot connect");
					throw new RuntimeException(e);
				}
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}
		return  connection;
	}
}

