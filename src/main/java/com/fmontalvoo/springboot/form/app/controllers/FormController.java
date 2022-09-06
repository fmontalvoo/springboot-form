package com.fmontalvoo.springboot.form.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.fmontalvoo.springboot.form.app.models.UserForm;

@Controller
public class FormController {

	@GetMapping("/form")
	public String form(Model model) {
		return "form";
	}

	@PostMapping("/form")
	public String submit(UserForm userForm, Model model) {
		
		model.addAttribute("user", userForm);
		return "submit";
	}

}
