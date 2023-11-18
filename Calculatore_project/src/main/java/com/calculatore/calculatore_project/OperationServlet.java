package com.calculatore.calculatore_project;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "OperationServlet", value = "/operation")
public class OperationServlet extends HttpServlet {

	public static String getOperationText(String operation) {
		switch (operation) {
			case "add":
				return " + ";
			case "subtract":
				return " - ";
			case "multiply":
				return " * ";
			case "divide":
				return " / ";
			default:
				return " ";
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");

		switch (operation) {
			case "add":
			case "subtract":
			case "multiply":
				try {
					int num1 = Integer.parseInt(request.getParameter("num1"));
					int num2 = Integer.parseInt(request.getParameter("num2"));
					int result;
					String operationText = getOperationText(operation);

					if (operation.equals("add")) {
						result = num1 + num2;
					} else if (operation.equals("subtract")) {
						result = num1 - num2;
					} else {
						result = num1 * num2;
					}

					request.setAttribute("result", num1 + operationText + num2 +"    =    " + result);
				} catch (NumberFormatException e) {
					request.setAttribute("result", "Invalid number format");
				}
				break;

			case "divide":
				try {
					int num1 = Integer.parseInt(request.getParameter("num1"));
					int num2 = Integer.parseInt(request.getParameter("num2"));
					double result = (double) num1 / num2;
					String operationText = getOperationText(operation);
					request.setAttribute("result", num1 + operationText + num2 + " = " + result);
				} catch (NumberFormatException e) {
					request.setAttribute("result", "Invalid number format");
				} catch (ArithmeticException e) {
					request.setAttribute("result", "Cannot divide by zero");
				}
				break;

			default:
				request.setAttribute("result", "Invalid operation");
		}

		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}