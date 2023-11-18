package com.calculatore.calculatore_project;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="MultiplicationServlet",value="/multiplication")
public class MultiplicationServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		int result = num1 * num2;
		try {
			response.getWriter().print("Result of Multiplication: " + result);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

