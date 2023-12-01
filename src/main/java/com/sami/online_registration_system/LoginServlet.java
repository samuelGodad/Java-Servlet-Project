package com.sami.online_registration_system;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
	private UserDao userDao;

	@Override
	public void init() throws ServletException {
		// Initialize UserDao with the database connection
		userDao = new UserDao(DataBaseConnection.getConnection());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");


		if (isValidUser(email, password)) {
			// Valid user, set session attribute and redirect to the welcome page
			String name = userDao.getUserName(email);
			request.getSession().setAttribute("userName", name);
			request.getSession().setAttribute("userEmail", email);
			try {
				response.sendRedirect("welcome");
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		} else {
			// Invalid user, display an error message or redirect to the login page
			request.setAttribute("message", "Invalid credentials. Please try again.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("back?showLogin=true");
			dispatcher.forward(request, response);
		}
	}
	private boolean isValidUser(String email, String password) {
		return userDao.isValidUser(email, password);
	}
}
