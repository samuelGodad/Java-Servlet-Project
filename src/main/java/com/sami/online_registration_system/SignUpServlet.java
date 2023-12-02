package com.sami.online_registration_system;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "SignUpServlet", value = "/signup")
public class SignUpServlet extends HttpServlet {
	private UserDao userDao;

	@Override
	public void init() throws ServletException {
		// Initialize UserDao with the database connection
		userDao = new UserDao(DataBaseConnection.getConnection());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (userDao.userExists(email)) {
			request.setAttribute("signupError", "Email already exists. Instead Please try to  log in.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("back?showLogin=true");
			dispatcher.forward(request, response);
		} else {
			User user = new User(name, email, password);
			userDao.saveUser(user);
			// After saving the user to the database
			String userName = user.getName();
			HttpSession session = request.getSession();

			session.setAttribute("userName", userName);
			session.setAttribute("signup", true);
			response.sendRedirect("welcome");
		}
	}
}

