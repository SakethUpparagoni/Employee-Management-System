package com.EmployeeManagementSystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.EmployeeManagementSystem.dto.EmailDto;
import com.EmployeeManagementSystem.dto.PasswordDto;
import com.EmployeeManagementSystem.service.EmployeeService;

@Controller
public class EmailUpdateController {

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		RequestDispatcher reqDispatch = request.getRequestDispatcher("/HTML/ChangePassword.html");
//		reqDispatch.forward(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		RequestDispatcher reqDispatch;
//		
//		String email = request.getParameter("emadd");
//		String password = request.getParameter("oldpass");
//		String newPassword = request.getParameter("newPass");
//		
//		EmployeeService empService = EmployeeService.getInstance();
//		Employee employee = new Employee();
//		employee.setEmployeMail(email);
//		employee.setLoginPassword(password);
//		
//		boolean changedStatus = empService.changeEmployeePassword(employee, newPassword);
//		
//		request.setAttribute("employee", employee);
//		
//		if (changedStatus) {
//			reqDispatch = request.getRequestDispatcher("/JSPFILES/passwordUpdateSuccess.jsp");
//		}
//		else {
//			reqDispatch = request.getRequestDispatcher("/JSPFILES/passwordUpdateFailur.jsp");
//		}
//		reqDispatch.forward(request, response);
//	}

	private EmployeeService employeeService;

	@Autowired
	public EmailUpdateController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/emailUpdate")
	public String updateForm(Model model) {

		model.addAttribute("emailDto", new EmailDto());

		return "ChangeEmail";
	}

	@PostMapping("/emailUpdate")
	public String updateUserEmail(@ModelAttribute EmailDto dto, Model model, HttpSession session, HttpServletRequest request) {

		boolean updateStatus = employeeService.updateEmail(dto);

		if (updateStatus) {

			session.invalidate();
			session = request.getSession(true);
			session.setAttribute("msg", "Email changed. Please login again.");
			
			return "redirect:/login";

		} else {

			model.addAttribute("message", "Invalid Email or Password !");
			model.addAttribute("status", "error");

			return "ChangeEmail";

		}

	}

}
