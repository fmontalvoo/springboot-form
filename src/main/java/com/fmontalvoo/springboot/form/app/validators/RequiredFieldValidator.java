package com.fmontalvoo.springboot.form.app.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class RequiredFieldValidator implements ConstraintValidator<RequiredField, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
//		if (value == null || value.isEmpty() || value.isBlank())
		if (value == null || !StringUtils.hasText(value))
			return false;
		return true;
	}

}
