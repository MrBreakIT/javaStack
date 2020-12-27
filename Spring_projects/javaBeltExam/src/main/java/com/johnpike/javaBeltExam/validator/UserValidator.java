package com.johnpike.javaBeltExam.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.johnpike.javaBeltExam.models.User;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;

		if (!user.getConfirmPW().equals(user.getPassword())) {

			errors.rejectValue("passwordConfirmation", "Match");
		}
	}

}
