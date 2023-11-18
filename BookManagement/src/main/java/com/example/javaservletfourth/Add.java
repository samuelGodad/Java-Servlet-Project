package com.example.javaservletfourth;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Add")
public class Add extends HttpServlet {

public void service(HttpServletRequest req,HttpServletResponse res){
	int num1 =Integer.parseInt(req.getParameter("num1"));
	int num2 =Integer.parseInt(req.getParameter("num1"));
	int sum=num1+num2;
	System.out.println(num1+num2);
	res.setContentType("text/html");

	PrintWriter out = null;
	try {
		out = res.getWriter();
	} catch (IOException e) {
		throw new RuntimeException(e);
	}
	out.println("<html><body>");
	out.println("<h1>Sum: " + sum + "</h1>");
	out.println("</body></html>");


}
}
