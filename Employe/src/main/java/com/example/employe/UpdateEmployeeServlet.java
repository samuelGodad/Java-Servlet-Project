package com.example.employe;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// UpdateEmployeeServlet.java
@WebServlet("/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String designation = request.getParameter("designation");
		double salary = Double.parseDouble(request.getParameter("salary"));

		Employee updatedEmployee = new Employee();
		updatedEmployee.setId(id);
		updatedEmployee.setName(name);
		updatedEmployee.setDesignation(designation);
		updatedEmployee.setSalary(salary);

		EmployeeDAO.updateEmployee(updatedEmployee);

		response.sendRedirect("employeeList.jsp"); // Redirect to employee list page
	}
}
