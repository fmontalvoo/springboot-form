package com.fmontalvoo.springboot.form.app.validators;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = IdentifierRegexValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface IdentifierRegex {
	String message() default "{IdentifierRegex.userForm.id}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
