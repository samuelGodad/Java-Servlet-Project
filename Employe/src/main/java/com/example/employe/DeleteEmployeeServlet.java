package com.example.employe;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// DeleteEmployeeServlet.java
@WebServlet(name="DeleteEmployeeServlet", value="/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		// Perform deletion based on the employee ID
		EmployeeDAO.deleteEmployee(id);

		response.sendRedirect("employeeList"); // Redirect to employee list page
	}
}
