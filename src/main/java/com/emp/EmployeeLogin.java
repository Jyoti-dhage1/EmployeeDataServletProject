package com.emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/emplogin")
public class EmployeeLogin extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		String name=req.getParameter("name1");
		String pass=req.getParameter("pass1");
		System.out.println(name+" "+pass);
				
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
			PreparedStatement ps = con.prepareStatement("select * from employeeinfo where first_name=? and password=?");
			ps.setString(1, name);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println("Success");
				PrintWriter out =resp.getWriter();
				out.println("Welcome "+name);
			}
			else {
				PrintWriter out =resp.getWriter();
				out.println("<p style='color:Red;font-size:20px'><b><i>!Incorrect login credentials</i></b></p>");
				RequestDispatcher rd = req.getRequestDispatcher("index.html");
				rd.include(req, resp);
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
				

	}

}
