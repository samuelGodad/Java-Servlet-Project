package com.calculatore.calculatore_project;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="DivisionServlet",value="/division")
public class DivisionServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		if (num2 != 0) {
			double result = (double) num1 / num2;
			try {
				response.getWriter().print("Result of Division: " + result);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		} else {
			response.getWriter().print("Cannot divide by zero.");
		}
	}
}
