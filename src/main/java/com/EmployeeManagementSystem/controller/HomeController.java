package com.EmployeeManagementSystem.controller;

import java.net.http.HttpResponse;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.EmployeeManagementSystem.entity.Employee;

@Controller
public class HomeController {

//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		HttpSession session = request.getSession(false);
//
//		if (session != null) {
//			Employee employee = (Employee) session.getAttribute("employee");
//
//			if (employee != null) {
//				RequestDispatcher rd = request.getRequestDispatcher("/JSPFILES/signInSuccess.jsp");
//				rd.forward(request, response);
//				return;
//			}
//		}
//
//		RequestDispatcher rd = request.getRequestDispatcher("/HTML/homePage.html");
//		rd.forward(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doGet(request, response);
//	}/
	
	
	@GetMapping("/")
	public String homePage () {
		return "homePage";
	}
	
	@GetMapping("/home")
	public String homePage(HttpSession session, Model model,HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	    response.setHeader("Pragma", "no-cache");
	    response.setDateHeader("Expires", 0);

	    Employee emp = (Employee) session.getAttribute("employee");

	    if (emp == null) {
	        return "redirect:/"; // not logged in
	    }

	    model.addAttribute("name", emp.getEmployeName());
	    return "signInSuccess"; // or your home page JSP
	}
	
	

}
