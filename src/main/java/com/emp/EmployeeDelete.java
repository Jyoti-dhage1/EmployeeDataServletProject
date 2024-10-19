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
import jakarta.servlet.http.HttpSession;

@WebServlet("/delete")
public class EmployeeDelete extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Set content type
		resp.setContentType("text/html");
		//get data from delete page
		String email=req.getParameter("email");
		String pass=req.getParameter("pass1");
				
		//Get Print Writer object
		PrintWriter out =resp.getWriter();
		
		//Get session and fetch user credentials
		HttpSession session = req.getSession();
		String username = (String)session.getAttribute("username");
		String userpass = (String)session.getAttribute("userpass");
		
		//Compare user password with delete password
		if(!userpass.equals(pass)) {
			
			//If password does not match then redirect to login page
			req.setAttribute("errorMessage","Invalid password");
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.include(req, resp);
			//Close session
			session.invalidate();
		}
		else {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
				PreparedStatement ps1 = con.prepareStatement("delete from employeeinfo where Email=? and password=?");
				ps1.setString(1, email);
				ps1.setString(2, pass);
				int rs1 = ps1.executeUpdate();
				if(rs1>0) {
					System.out.println("Success");
					out.println("<h1 style='color:Green'>Your account has been deleted successfully</h1>");
					out.print("<br>");
					out.print("<br>");
					
					RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
					rd.include(req, resp);
					//Close session
					session.invalidate();
				}
				else {
					//If record does not find, redirect to login page
					req.setAttribute("errorMessage","Invalid password");
					RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
					rd.include(req, resp);
					//Close session
					session.invalidate();
				}
			} catch (Exception e) {
				//If any exception occur, close session
				out.print("Server error");
					e.printStackTrace();
					
			}
		}		
		
	}
}
