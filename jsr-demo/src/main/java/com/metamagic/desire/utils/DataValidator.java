package com.metamagic.desire.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class DataValidator {

	public static final List<String> validate(CommonValidator bean) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<CommonValidator>> violations = validator.validate(bean);

		List<String> errors = new ArrayList<String>();

		for (ConstraintViolation<CommonValidator> violation : violations) {
			String propertyPath = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			errors.add(message);
		}

		return errors;
	}
}
