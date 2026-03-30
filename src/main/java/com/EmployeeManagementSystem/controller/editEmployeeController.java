package com.EmployeeManagementSystem.controller;

import javax.servlet.http.HttpServlet;
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
public class editEmployeeController extends HttpServlet {

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		RequestDispatcher reqDispatch = request.getRequestDispatcher("/JSPFILES/EmployeeList.jsp");
//		reqDispatch.forward(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	}
	@Autowired
	private EmployeeService empService;

	@GetMapping("/editEmployee")
	public String editEmployee(HttpSession session, @RequestParam("empId") int Id, Model model) {

		Employee loggedUser = (Employee) session.getAttribute("employee");

		if (loggedUser == null) {
			return "redirect:/login";
		}

		if (!"Admin".equals(loggedUser.getRoleOfEmployee())) {
			return "redirect:/home";
		}

		Employee emp = (Employee) empService.getEmployeeById(Id);

		if (!"Admin".equals(loggedUser.getRoleOfEmployee()) && loggedUser.getEmployeId() != Id) {

			return "redirect:/home"; // blocked
		}

		model.addAttribute("employee", emp);
		model.addAttribute("loggedUser", loggedUser);

		return "editEmployee";
	}

	@PostMapping("/updateEmployee")
	public String updateEmployee(@RequestParam("name") String name, @RequestParam("id") int id,
			@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam(value = "role", required = false) String role, HttpSession session) {
		
		Employee loggedInUser = (Employee) session.getAttribute("employee");

		if (!"Admin".equals(loggedInUser.getRoleOfEmployee()) && loggedInUser.getEmployeId() != id) {

			return "redirect:/home";
		}

		Employee emp = empService.getEmployeeById(id);

		emp.setEmployeName(name);
		emp.setEmployeMail(email);
		emp.setLoginPassword(password);

		if ("Admin".equals(loggedInUser.getRoleOfEmployee())) {
			emp.setRoleOfEmployee(role);
		}

		empService.updateEmployee(emp);

		return "redirect:/empList";
	}

}
