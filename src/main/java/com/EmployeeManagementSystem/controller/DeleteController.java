package com.EmployeeManagementSystem.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.EmployeeManagementSystem.entity.Employee;
import com.EmployeeManagementSystem.service.EmployeeService;

@Controller
public class DeleteController extends HttpServlet {

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

	@GetMapping("/deleteEmployee")
	public String deleteEmployee(HttpSession session, @RequestParam("empId") int Id,Model model) {

		Employee loggedUser = (Employee) session.getAttribute("employee");
		
		if (loggedUser == null) {
			return "redirect:/login";
		}
		
		if (!"Admin".equals(loggedUser.getRoleOfEmployee())) {
			return "redirect:/home";
		}
		
		empService.deleteEmployeeById(Id);
		return "redirect:/empList";
		
	}

}
