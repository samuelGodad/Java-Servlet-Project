package com.example.javaservletfourth;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
@WebServlet(name="BookShoppingWebApp",value="/register")
public  class RegisterServlet extends HttpServlet{
	private static final String query = "insert into books(id,bookname, bookedition, bookprice)values(DEFAULT,?, ?, ?)";
	@Override
	protected void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException {
		String password = "20082011ec!";
		String userName = "postgres";
		String dbUrl = "jdbc:postgresql://localhost:5432/bookregister";
		String bookName = req.getParameter("bookName");
		String bookEdition = req.getParameter("bookEdition");
		float bookPrice = Float.parseFloat(req.getParameter("bookPrice"));
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection connection = DriverManager.getConnection(dbUrl, userName, password);
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, bookName);
			ps.setString(2, bookEdition);
			ps.setFloat(3, bookPrice);
			int count = ps.executeUpdate();
			if(count == 1) {
				pw.println("<h2> Book registered successfully.</h2");
			}
			else {
				pw.println("<h2> Book Not registered successfully.</h2");
			}
		} catch (Exception e) {
			e.printStackTrace();
			pw.println("<h1>" + e.getMessage() + "</h1>");
		}
		pw.println("<a href='Home.html'>Home</a>");
		pw.print("<br>");
		pw.println("<a href='booklist'>Book List</a>");

	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		try {
			doGet(req, res);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}


	}

}

























