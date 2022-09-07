package com.fmontalvoo.springboot.form.app.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdentifierRegexValidator implements ConstraintValidator<IdentifierRegex, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value.matches("^0[\\d]{9}"))
			return true;
		return false;
	}

}
