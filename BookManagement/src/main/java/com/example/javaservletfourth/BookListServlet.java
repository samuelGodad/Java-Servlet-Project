package com.example.javaservletfourth;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/booklist")
public class BookListServlet extends HttpServlet {
	private static final String query = "select id, bookname, bookedition, bookprice from books";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String password = "20082011ec!";
		String userName = "postgres";
		String dbUrl = "jdbc:postgresql://localhost:5432/bookregister";

		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");

		try {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}

			Connection connection = DriverManager.getConnection(dbUrl, userName, password);
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			pw.println("<table border='1'>");
			pw.println("<tr>");
			pw.println("<th>Book Id</th>");
			pw.println("<th>Book Name</th>");
			pw.println("<th>Book Edition</th>");
			pw.println("<th>Book Price</th>");
			pw.println("<th>Edit</th>");
			pw.println("<th>Delete</th>");
			pw.println("</tr>");

			while (rs.next()) {
				pw.println("<tr>");
				pw.println("<td>" + rs.getInt(1) + "</td>");
				pw.println("<td>" + rs.getString(2) + "</td>");
				pw.println("<td>" + rs.getString(3) + "</td>");
				pw.println("<td>" + rs.getFloat(4) + "</td>");
				pw.println("<td><a href='editScreen?id=" + rs.getInt(1) + "'>edit</a></td>");
				pw.println("<td><a href='deleteurl?id=" + rs.getInt(1) + "'>delete</a></td>");
				pw.println("</tr>");
			}


			pw.println("</table>");

		} catch (Exception e) {
			e.printStackTrace();
			pw.println("<h1>" + e.getMessage() + "</h1>");
		}

		pw.println("<a href='Home.html'>Home</a>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		// Handle POST requests if needed
		doGet(req, res);
	}
}
