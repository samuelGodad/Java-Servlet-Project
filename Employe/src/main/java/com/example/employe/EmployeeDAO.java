package com.example.employe;

// EmployeeDAO.java
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	public static void createEmployee(Employee employee) {
		try (Connection conn = DbUtile.getConnection()) {
			// Disable auto-commit
			conn.setAutoCommit(false);

			try (PreparedStatement ps = conn.prepareStatement("INSERT INTO employees (id, name, designation, salary) VALUES (DEFAULT, ?, ?, ?)")) {
				ps.setString(1, employee.getName());
				ps.setString(2, employee.getDesignation());
				ps.setDouble(3, employee.getSalary());
				ps.executeUpdate();
			}

			// Commit the transaction
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle exceptions
		}
	}
	public static List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();

		try (Connection conn = DbUtile.getConnection();
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery("SELECT * FROM employees")) {

			while (rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt("id"));
				employee.setName(rs.getString("name"));
				employee.setDesignation(rs.getString("designation"));
				employee.setSalary(rs.getDouble("salary"));
				employees.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			// Handle exceptions
		}

		return employees;
	}

	public static Employee getEmployeeById(int id) {
		Employee employee = new Employee();

		try (Connection conn = DbUtile.getConnection();
			 PreparedStatement ps = conn.prepareStatement("SELECT * FROM employees WHERE id = ?")) {

			ps.setInt(1, id);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					employee.setId(rs.getInt("id"));
					employee.setName(rs.getString("name"));
					employee.setDesignation(rs.getString("designation"));
					employee.setSalary(rs.getDouble("salary"));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			// Handle exceptions
		}

		return employee;
	}

	public static void updateEmployee(Employee employee) {
		try (Connection conn = DbUtile.getConnection();
			 PreparedStatement ps = conn.prepareStatement("UPDATE employees SET name = ?, designation = ?, salary = ? WHERE id = ?")) {

			ps.setString(1, employee.getName());
			ps.setString(2, employee.getDesignation());
			ps.setDouble(3, employee.getSalary());
			ps.setInt(4, employee.getId());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			// Handle exceptions
		}
	}

	public static void deleteEmployee(int id) {
		try (Connection conn = DbUtile.getConnection();
			 PreparedStatement ps = conn.prepareStatement("DELETE FROM employees WHERE id = ?")) {

			ps.setInt(1, id);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
}

