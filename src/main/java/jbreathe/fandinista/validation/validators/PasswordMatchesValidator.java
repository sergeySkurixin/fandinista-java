package jbreathe.fandinista.validation.validators;

import jbreathe.fandinista.dto.Fan;
import jbreathe.fandinista.dto.User;
import jbreathe.fandinista.validation.annotations.PasswordMatches;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches passwordMatches) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        User user = (User) o;
        return user.getPassword().equals(user.getPasswordConfirmation());
    }
}
