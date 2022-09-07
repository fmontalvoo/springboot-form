package com.fmontalvoo.springboot.form.app.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.fmontalvoo.springboot.form.app.editors.CapitalizeNameEditor;
import com.fmontalvoo.springboot.form.app.editors.PaisPropertyEditor;
import com.fmontalvoo.springboot.form.app.models.Pais;
import com.fmontalvoo.springboot.form.app.models.UserForm;
import com.fmontalvoo.springboot.form.app.services.IPaisService;
import com.fmontalvoo.springboot.form.app.validators.UserFormValidator;

@Controller
@SessionAttributes("userForm")
public class FormController {

	@Autowired
	private UserFormValidator validator;

	@Autowired
	private IPaisService paisService;

	@Autowired
	private PaisPropertyEditor paisEditor;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
//		binder.setValidator(validator);
		binder.addValidators(validator);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(false);
		binder.registerCustomEditor(Date.class, "fechaNacimiento", new CustomDateEditor(format, true));

		binder.registerCustomEditor(String.class, "username", new CapitalizeNameEditor());

		binder.registerCustomEditor(Pais.class, "pais", paisEditor);
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

	@ModelAttribute("listaRoles")
	public List<String> listaRoles() {
		List<String> roles = new ArrayList<>();
		roles.add("ROLE_USER");
		roles.add("ROLE_ADMIN");
		roles.add("ROLE_EDITOR");
		return roles;
	}

	@ModelAttribute("listaPaises")
	public List<Pais> listaPaises() {
		return paisService.listar();
	}

	@ModelAttribute("paises")
	public List<String> paises() {
		return Arrays.asList("Ecuador", "Colombia", "Perú", "Bolivia", "Venezuela");
	}

	@ModelAttribute("paisesMap")
	public Map<String, String> paisesMap() {
		Map<String, String> paises = new HashMap<>();
		paises.put("EC", "Ecuador");
		paises.put("CO", "Colombia");
		paises.put("PE", "Perú");
		paises.put("BO", "Bolivia");
		paises.put("VE", "Venezuela");
		return paises;
	}

}
