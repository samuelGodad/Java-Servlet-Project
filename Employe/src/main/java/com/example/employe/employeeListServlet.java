package com.example.employe;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name="EmployeeListServlet",value="employeeList")
public class employeeListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Retrieve all employees from the database
			List<Employee> employees = EmployeeDAO.getAllEmployees();

			// Set the employee data as an attribute of the request object
			request.setAttribute("employees", employees);

			// Forward the request to the JSP page
			RequestDispatcher dispatcher = request.getRequestDispatcher("employeeList.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

