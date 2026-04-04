package com.EmployeeManagementSystem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		HttpSession session = request.getSession(false);
//
//		if(session != null){
//			session.invalidate();   // destroy session
//		}
//
//		response.sendRedirect("home"); // go back to homepage
//	}
	
	@GetMapping("/logout")
	public String logoutUser(HttpSession session, Model model) {
		
		session.invalidate();
		
		model.addAttribute("msg", "User Logedout Successfully!");
		return "redirect:/login";
		
	}
	
	
	
}