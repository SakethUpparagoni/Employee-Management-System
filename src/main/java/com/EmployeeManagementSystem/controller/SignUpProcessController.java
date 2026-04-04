package com.EmployeeManagementSystem.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.EmployeeManagementSystem.entity.Employee;
import com.EmployeeManagementSystem.service.EmployeeService;

@Controller
public class SignUpProcessController {

//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		RequestDispatcher reqDispatch = request.getRequestDispatcher("/HTML/signUp.html");
//		reqDispatch.forward(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		RequestDispatcher reqDispatch;
//		
//		String email = request.getParameter("emadd");
//		String password = request.getParameter("pass");
//		String name = request.getParameter("empName");
//		String role = request.getParameter("emprole");
//		
//		EmployeeService empService = EmployeeService.getInstance();
//		Employee employee = new Employee();
//		employee.setEmployeMail(email);
//		employee.setLoginPassword(password);
//		employee.setEmployeName(name);
//		employee.setRoleOfEmployee(role);
//		
//		boolean signUpStatus = empService.signUpEmployee(employee);
//		
//		request.setAttribute("employee", employee);
//		
//		if (signUpStatus) {
//			reqDispatch = request.getRequestDispatcher("/JSPFILES/signUpSuccess.jsp");
//		}
//		else {
//			reqDispatch = request.getRequestDispatcher("/JSPFILES/signUpFailur.jsp");
//		}
//		reqDispatch.forward(request, response);
//	}

	// Spring Annotations Based Controller

	private EmployeeService empService;

	@Autowired
	public SignUpProcessController(EmployeeService empService) {
		this.empService = empService;
	}

	@GetMapping("/signUp")
	public String signUpPage() {

		return "signUpForm";
	}

	@PostMapping("/signUp")
	public String signingIn(HttpServletRequest request, Model model) {

		String email = request.getParameter("emadd");
		String password = request.getParameter("pass");
		String name = request.getParameter("empName");
		String role = request.getParameter("emprole");

		Employee employee = new Employee(name, email, password, role);

		boolean singUpStatus = empService.signUpEmployee(employee);

		request.setAttribute("employee", employee);

		if (singUpStatus) {

			request.getSession().setAttribute("msg", "Signup successful! Please login.");
			request.getSession().setAttribute("email", email);

			return "redirect:/login";
		}
		
		model.addAttribute("message", "User already exists! Please login.");
		model.addAttribute("status", "error");

		return "signUpForm";

	}

}
