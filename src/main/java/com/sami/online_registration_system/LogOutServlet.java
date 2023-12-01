package com.sami.online_registration_system;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogOutServlet", value = "/logout")
public class LogOutServlet extends HttpServlet {
	private UserDao userDao;

	@Override
	public void init() throws ServletException {
		// Initialize UserDao with the database connection
		userDao = new UserDao(DataBaseConnection.getConnection());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Perform logout logic
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		// Include a parameter to indicate that the login form should be shown
		response.sendRedirect("back?showLogin=true");
	}
}
