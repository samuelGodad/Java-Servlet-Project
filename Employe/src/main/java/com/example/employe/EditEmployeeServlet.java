package com.example.employe;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// EditEmployeeServlet.java
@WebServlet(name="EditEmployeeServlet",value="/editEmployee")
public class EditEmployeeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve the employee ID from the request parameter
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("here we call him");

		// Retrieve the employee object from your data source using the ID
		Employee employee = EmployeeDAO.getEmployeeById(id);

		// Check if the employee object is not null
		if (employee != null) {
			// Set the employee attribute in the request
			request.setAttribute("employee", employee);

			// Forward the request to the editEmployee.jsp page
			RequestDispatcher dispatcher = request.getRequestDispatcher("editEmployee.jsp");
			dispatcher.forward(request, response);
		} else {
			// Handle the case when the employee object is null
			response.getWriter().println("Employee not found");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String designation = request.getParameter("designation");
		double salary = Double.parseDouble(request.getParameter("salary"));

		// Update the employee in the database
		EmployeeDAO.updateEmployee(new Employee(id, name, designation, salary));

		// Redirect to the employee list page
		response.sendRedirect("employeeList");
	}

}

