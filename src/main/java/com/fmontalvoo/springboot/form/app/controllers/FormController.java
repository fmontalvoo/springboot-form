package com.fmontalvoo.springboot.form.app.controllers;

import java.util.HashMap;
import java.util.Map;

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
		System.out.println(result.hasErrors());
		if (result.hasErrors()) {
			Map<String, String> error = new HashMap<>();
			result.getFieldErrors().forEach(err -> {
				String key = err.getField();
				String value = "El campo ".concat(key).concat(" presenta errores");
				error.put(key, value);
			});
			model.addAttribute("error", error);
			return "form";
		}

		model.addAttribute("user", userForm);
		return "submit";
	}

}
