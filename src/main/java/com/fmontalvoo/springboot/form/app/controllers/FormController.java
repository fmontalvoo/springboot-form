package com.fmontalvoo.springboot.form.app.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.fmontalvoo.springboot.form.app.models.UserForm;
import com.fmontalvoo.springboot.form.app.validators.UserFormValidator;

@Controller
@SessionAttributes("userForm")
public class FormController {

	@Autowired
	private UserFormValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
//		binder.setValidator(validator);
		binder.addValidators(validator);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(false);
		binder.registerCustomEditor(Date.class, "fechaNacimiento", new CustomDateEditor(format, true));
	}

	@GetMapping("/form")
	public String form(Model model) {
		UserForm userForm = new UserForm("", "");
		userForm.setId("012");
		model.addAttribute("userForm", userForm);
		return "form";
	}

	@PostMapping("/form")
	public String submit(@Valid UserForm userForm, BindingResult result, Model model, SessionStatus status) {
//		validator.validate(userForm, result);
		if (result.hasErrors()) {
			return "form";
		}

		model.addAttribute("user", userForm);
		status.setComplete();
		return "submit";
	}

}
