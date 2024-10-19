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

@WebServlet("/empregister")
public class EmployeeRegister extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			resp.setContentType("text/html"); //set content type html
			PrintWriter out =resp.getWriter(); // get PrintWriter object
			HttpSession session = req.getSession();// Get session

			//Fetch register form data
			String first_name=req.getParameter("fname1");
			String last_name=req.getParameter("lname1");
			String gender= req.getParameter("gender");
			String email=req.getParameter("email");
			String pass=req.getParameter("pass1");
			String mobile_no=req.getParameter("mobileno");
			String dob=req.getParameter("dob");
			String passing_yr=req.getParameter("passingyr");
			String specia=req.getParameter("specia");
			String semester=req.getParameter("sem");
			String ten_percentage=req.getParameter("ten");
			String twelth_percentage=req.getParameter("twelth");
			String graduation_per=req.getParameter("grad");
			String fresher_experience=req.getParameter("freshexp");
			String condition=req.getParameter("condition");

			//Save user details into database table		
			try {
				//Create database connection
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
				PreparedStatement ps = con.prepareStatement("insert into employeeinfo(first_name,last_name,gender,Email,password,Mobile_No,dob,Degree_passing_year,Specialization,semester,tenth_percentage,twelth_percentage,Graduation_percentage,Fresher_Exp) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1, first_name);
				ps.setString(2, last_name);
				ps.setString(3, gender);
				ps.setString(4, email);
				ps.setString(5, pass);
				ps.setString(6, mobile_no);
				ps.setString(7, dob);
				ps.setString(8, passing_yr);
				ps.setString(9, specia);
				ps.setString(10, semester);
				ps.setString(11, ten_percentage);
				ps.setString(12, twelth_percentage);
				ps.setString(13, graduation_per);
				ps.setString(14, fresher_experience);
				int success = ps.executeUpdate();
				if(success>0) {
					System.out.println("Registration Completed");
					
					//Send response back to user
					if(condition.equals("checked")) {
						//Once user register , provide login page to login
						req.setAttribute("successMessage","Successfully Registered");
						RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
						rd.include(req, resp);
						session.invalidate();
					}
			
				}
				else {
					//If registration failed Send response back to user
					out.println("Server error");
					out.println("Registration falied");

				}
			} catch (Exception e) {
				//If exception occur while registration Send response back to user
				out.println("Server error");
				out.println("Registration falied");
				e.printStackTrace();
			}
						
		}
		
}


