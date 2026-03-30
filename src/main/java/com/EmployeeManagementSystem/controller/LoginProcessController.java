package com.EmployeeManagementSystem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.EmployeeManagementSystem.entity.Employee;
import com.EmployeeManagementSystem.service.EmployeeService;

@Controller
public class LoginProcessController {

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		RequestDispatcher reqDispatch = request.getRequestDispatcher("/HTML/Login.html");
//		reqDispatch.forward(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		RequestDispatcher reqDispatch;
//		
//		String email = request.getParameter("emadd");
//		String password = request.getParameter("pass");
//		
//		EmployeeService empService = EmployeeService.getInstance();
//		Employee employee = new Employee();
//		employee.setEmployeMail(email);
//		employee.setLoginPassword(password);;
//		
//		Employee emp = empService.loginEmployee(employee);
//		
//		if (emp != null) {
//			
//			HttpSession session = request.getSession();
//			session.setAttribute("employee", emp);
//			
//			response.sendRedirect(request.getContextPath() + "/home");
//		}
//		else {
//			reqDispatch = request.getRequestDispatcher("/JSPFILES/signInFailur.jsp");
//			reqDispatch.forward(request, response);
//		}
//		
//	}

	private EmployeeService empService;

	@Autowired
	public LoginProcessController(EmployeeService empService) {
		this.empService = empService;
	}

	@GetMapping("/login")
	public String loginPage() {

		return "Login";
	}

	@PostMapping("/login")
	public String login(@RequestParam("emadd") String emailAddress ,@RequestParam("pass") String password, Model model, HttpSession session) {

		Employee employee = new Employee();

		employee.setEmployeMail(emailAddress);
		employee.setLoginPassword(password);

		Employee emp = empService.loginEmployee(employee);

		if (emp != null) {

			session.setAttribute("employee", emp);
			
			model.addAttribute("name", emp.getEmployeName());


			return "signInSuccess";
		}

		model.addAttribute("message", "Invalid Email or Password !");
		model.addAttribute("status", "error");

		return "Login";
	}

}
