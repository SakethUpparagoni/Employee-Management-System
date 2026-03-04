package com.EmployeeManagementSystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.EmployeeManagementSystem.entity.Employee;
import com.EmployeeManagementSystem.service.EmployeeService;

public class LoginProcessServlet extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher reqDispatch = request.getRequestDispatcher("/HTML/Login.html");
		reqDispatch.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher reqDispatch;
		
		String email = request.getParameter("emadd");
		String password = request.getParameter("pass");
		
		EmployeeService empService = EmployeeService.getInstance();
		Employee employee = new Employee();
		employee.setEmployeMail(email);
		employee.setLoginPassword(password);;
		
		boolean sinInStatus = empService.loginEmployee(employee);
		
		if (sinInStatus) {
			
			HttpSession session = request.getSession();
			session.setAttribute("employee", employee);
			
			response.sendRedirect(request.getContextPath() + "/home");
		}
		else {
			reqDispatch = request.getRequestDispatcher("/JSPFILES/signInFailur.jsp");
			reqDispatch.forward(request, response);
		}
		
	}

}
