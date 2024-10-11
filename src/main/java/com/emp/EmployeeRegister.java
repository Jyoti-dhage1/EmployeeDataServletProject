package com.emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/empregister")
public class EmployeeRegister extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Retrieve username and password from frontend
			
			resp.setContentType("text/html");
		
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
				
				
				
				
				
				System.out.println(first_name+" "+last_name);
				System.out.println(first_name+" "+last_name);
				System.out.println(email+" "+pass);
				System.out.println(mobile_no+" "+dob);
				System.out.println(passing_yr+" "+specia);
				System.out.println(semester+" "+ten_percentage);
				System.out.println(twelth_percentage+" "+graduation_per);
				System.out.println(fresher_experience+" "+gender);



				
				
						
				try {
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
						PrintWriter out =resp.getWriter();
						out.println("Registration Completed");
						out.println("<a href='index.html'></a>");
						
					}
					else {
						PrintWriter out =resp.getWriter();
						out.println("Registration falied");
					}
				} catch (Exception e) {
						e.printStackTrace();
				}
						
			}
		
	}


