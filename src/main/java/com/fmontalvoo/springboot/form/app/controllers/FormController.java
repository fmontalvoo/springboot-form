package com.fmontalvoo.springboot.form.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

	@GetMapping("/form")
	public String form(Model model) {
		return "form";
	}

	@PostMapping("/form")
	public String submit(HttpServletRequest request, Model model) {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(username + ',' + email + ',' + password);
		model.addAttribute("username", username);
		model.addAttribute("email", email);
		model.addAttribute("password", password);
		return "submit";
	}

}
