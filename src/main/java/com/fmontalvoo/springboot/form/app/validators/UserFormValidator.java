package com.fmontalvoo.springboot.form.app.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.fmontalvoo.springboot.form.app.models.UserForm;

@Component
public class UserFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserForm form = (UserForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotBlank.userForm.username");

		if (!form.getId().matches("^0[\\d]{9}")) {
			errors.rejectValue("id", "Pattern.userForm.id");
		}
	}

}
