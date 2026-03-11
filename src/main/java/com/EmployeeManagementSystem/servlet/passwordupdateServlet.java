package com.EmployeeManagementSystem.servlet;

import java.io.IOException; 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EmployeeManagementSystem.entity.Employee;
import com.EmployeeManagementSystem.service.EmployeeService;

public class PasswordupdateServlet extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher reqDispatch = request.getRequestDispatcher("/HTML/ChangePassword.html");
		reqDispatch.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher reqDispatch;
		
		String email = request.getParameter("emadd");
		String password = request.getParameter("oldpass");
		String newPassword = request.getParameter("newPass");
		
		EmployeeService empService = EmployeeService.getInstance();
		Employee employee = new Employee();
		employee.setEmployeMail(email);
		employee.setLoginPassword(password);
		
		boolean changedStatus = empService.changeEmployeePassword(employee, newPassword);
		
		request.setAttribute("employee", employee);
		
		if (changedStatus) {
			reqDispatch = request.getRequestDispatcher("/JSPFILES/passwordUpdateSuccess.jsp");
		}
		else {
			reqDispatch = request.getRequestDispatcher("/JSPFILES/passwordUpdateFailur.jsp");
		}
		reqDispatch.forward(request, response);
	}

}
