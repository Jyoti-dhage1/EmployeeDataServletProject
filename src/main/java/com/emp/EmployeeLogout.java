package com.emp;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class EmployeeLogout extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Get Session instance
		HttpSession session = req.getSession();

		req.setAttribute("successMessage","Logged Out Successfully");
		
		//Redirect to login page
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		rd.include(req, resp);
		//Close session
		session.invalidate();
	
	}

}
