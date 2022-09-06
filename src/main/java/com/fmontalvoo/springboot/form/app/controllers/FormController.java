package com.fmontalvoo.springboot.form.app.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.fmontalvoo.springboot.form.app.models.UserForm;

@Controller
public class FormController {

	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("userForm", new UserForm("", ""));
		return "form";
	}

	@PostMapping("/form")
	public String submit(@Valid UserForm userForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "form";
		}

		model.addAttribute("user", userForm);
		return "submit";
	}

}
