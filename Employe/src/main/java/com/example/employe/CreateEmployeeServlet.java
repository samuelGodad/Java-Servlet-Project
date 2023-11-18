package com.example.employe;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

import static com.example.employe.EmployeeDAO.createEmployee;

// CreateEmployeeServlet.java
@WebServlet(name="CreateEmployeeServlet",value="/createEmployee")
public class CreateEmployeeServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		// Retrieve form data
		String name = request.getParameter("name");
		String designation = request.getParameter("designation");
		double salary = Double.parseDouble(request.getParameter("salary"));
		// Create Employee object
		Employee employee = new Employee();
		employee.setName(name);
		employee.setDesignation(designation);
		employee.setSalary(salary);
		// Call method to insert into the database
		createEmployee(employee);
		System.out.println("this is the create method ");

		try {
			response.sendRedirect("employeeList"); // Redirect to employee list page
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

