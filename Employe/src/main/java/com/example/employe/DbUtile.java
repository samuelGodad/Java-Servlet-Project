package com.example.employe;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtile {
	static {
		try {
			// Explicitly load the PostgreSQL JDBC driver
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load PostgreSQL JDBC driver");
		}
	}

	private static final String DB_URL = "jdbc:postgresql://localhost:5432/employee_management";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "20082011ec!";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}
}
