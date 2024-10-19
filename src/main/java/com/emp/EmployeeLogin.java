package com.emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Enumeration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/emplogin")
public class EmployeeLogin extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Get Session Object
		HttpSession session = req.getSession();
		System.out.println(session.isNew());
		
		/***Check Session new
		 * If new session then validate user
		 * If user refresh page user need to login again***/
		
		if(session.isNew()) {
			
			//Get print writer object and fetch details
			PrintWriter out =resp.getWriter();
			resp.setContentType("text/html");
			
			String name=req.getParameter("name1");
			String pass=req.getParameter("pass1");
			
			//Add user credentials in session
			session.setAttribute("username", name);
			session.setAttribute("userpass", pass);
			System.out.println(1);
			//Check user valid or not
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
				PreparedStatement ps = con.prepareStatement("select * from employeeinfo where first_name=? and password=?");
				ps.setString(1, name);
				ps.setString(2, pass);
				ResultSet rs = ps.executeQuery();
				System.out.println(2);

				if(rs.next()) {
					
					//When user is valid then fetch details and set to request setAttribute				
					session.setAttribute("first_name", rs.getString(2));
					session.setAttribute("last_name", rs.getString(3));
					session.setAttribute("gender", rs.getString(4));
					session.setAttribute("email", rs.getString(5));
					session.setAttribute("mobile_no", rs.getString(7));
					session.setAttribute("dob", rs.getString(8));
					session.setAttribute("passing_yr", rs.getString(9));
					session.setAttribute("specia", rs.getString(10));
					session.setAttribute("semester", rs.getString(11));
					session.setAttribute("ten_percentage", rs.getString(12));
					session.setAttribute("twelth_percentage", rs.getString(13));
					session.setAttribute("graduation_per", rs.getString(14));
					session.setAttribute("fresher_experience", rs.getString(15));	
					System.out.println(3);
		
					//Include profile jsp page and show output to  user 
					RequestDispatcher rd = req.getRequestDispatcher("profile.jsp");
					rd.include(req, resp);
				
				}
				else {
					
					System.out.println(4);
					//If user credential mismatched, Show msg and then again go back to index page 

					req.setAttribute("errorMessage","Invalid Credentials");
					RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
					rd.include(req, resp);
					//Close session
					session.invalidate();

				
				}
			} catch (Exception e) {
				System.out.println(5);
				out.print("Server error");
				//If any exception occur, close session
				e.printStackTrace();
				session.invalidate();

			}
		}
		else {
			//When Old session or refresh home page by user then show profile page directly  
			
			System.out.println(6);
			RequestDispatcher rd = req.getRequestDispatcher("profile.jsp");
			rd.include(req, resp);
		}
	}
}
