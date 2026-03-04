package com.EmployeeManagementSystem.servlet;

import java.io.IOException; 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EmployeeManagementSystem.entity.Employee;
import com.EmployeeManagementSystem.service.EmployeeService;


public class SignUpProcessServlet extends HttpServlet {
    
    
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher reqDispatch = request.getRequestDispatcher("/HTML/signUp.html");
		reqDispatch.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher reqDispatch;
		
		String email = request.getParameter("emadd");
		String password = request.getParameter("pass");
		String name = request.getParameter("empName");
		String role = request.getParameter("emprole");
		
		EmployeeService empService = EmployeeService.getInstance();
		Employee employee = new Employee();
		employee.setEmployeMail(email);
		employee.setLoginPassword(password);
		employee.setEmployeName(name);
		employee.setRoleOfEmployee(role);
		
		boolean signUpStatus = empService.signUpEmployee(employee);
		
		request.setAttribute("employee", employee);
		
		if (signUpStatus) {
			reqDispatch = request.getRequestDispatcher("/JSPFILES/signUpSuccess.jsp");
		}
		else {
			reqDispatch = request.getRequestDispatcher("/JSPFILES/signUpFailur.jsp");
		}
		reqDispatch.forward(request, response);
	}

}
