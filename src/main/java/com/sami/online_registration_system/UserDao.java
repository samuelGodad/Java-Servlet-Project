package com.sami.online_registration_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	private Connection connection;

	public UserDao(Connection connection) {
		this.connection = connection;
	}

	public boolean userExists(String email) {
		try {
			String query = "SELECT COUNT(*) FROM users WHERE email=?";
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setString(1, email);
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					if (resultSet.next()) {
						int count = resultSet.getInt(1);
						return count == 1;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return false;
	}

	public void saveUser(User user) {
		try {
			String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setString(1, user.getName());
				preparedStatement.setString(2, user.getEmail());
				preparedStatement.setString(3, user.getPassword());

				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean logoutUser(String email) {
		// Implement logout user logic (e.g., remove from active sessions, etc.)
		// This method may not necessarily involve database operations, but it depends on your requirements.
		return true;
	}

	public boolean isValidUser(String email, String password) {
		try {
			String query = "SELECT * FROM users WHERE email=? AND password=?";
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setString(1, email);
				preparedStatement.setString(2, password);

				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					return resultSet.next();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public String getUserName(String email) {
		String name = null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT name FROM users WHERE email = ?");
			statement.setString(1, email);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				name = result.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}
}
