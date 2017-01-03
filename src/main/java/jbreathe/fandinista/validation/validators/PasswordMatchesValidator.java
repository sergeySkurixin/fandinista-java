package jbreathe.fandinista.validation.validators;

import jbreathe.fandinista.dto.Fan;
import jbreathe.fandinista.validation.annotations.PasswordMatches;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

// todo: сделать не только для фанатов
public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches passwordMatches) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Fan fan = (Fan) o;
        return fan.getPassword().equals(fan.getPasswordConfirmation());
    }
}
