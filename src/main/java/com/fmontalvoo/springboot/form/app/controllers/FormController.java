package com.fmontalvoo.springboot.form.app.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.fmontalvoo.springboot.form.app.models.UserForm;

@Controller
@SessionAttributes("userForm")
public class FormController {

	@GetMapping("/form")
	public String form(Model model) {
		UserForm userForm = new UserForm("", "");
		userForm.setId("012");
		model.addAttribute("userForm", userForm);
		return "form";
	}

	@PostMapping("/form")
	public String submit(@Valid UserForm userForm, BindingResult result, Model model, SessionStatus status) {
		if (result.hasErrors()) {
			return "form";
		}

		model.addAttribute("user", userForm);
		status.setComplete();
		return "submit";
	}

}
