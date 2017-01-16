package jbreathe.fandinista;

import jbreathe.fandinista.dto.Musician;
import org.junit.Test;
import org.springframework.util.Assert;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class ValidationTest {

    private ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private Validator validator = validatorFactory.getValidator();

    @Test
    public void validateEmailTest() {
        Musician musician = new Musician("asd", "asd", "123", "123");
        Set<ConstraintViolation<Musician>> violations = validator.validate(musician);
        Assert.notNull(violations);
        Assert.notEmpty(violations);
    }

    @Test
    public void validatePasswordConfirmationTest() {
        Musician musician = new Musician("asd", "asd@mail.ru", "123", "1234");
        Set<ConstraintViolation<Musician>> violations = validator.validate(musician);
        Assert.notNull(violations);
        Assert.notEmpty(violations);
    }

    @Test
    public void successTest() {
        Musician musician = new Musician("asd", "asd@mail.ru", "123", "123");
        Set<ConstraintViolation<Musician>> violations = validator.validate(musician);
        Assert.isTrue(violations.isEmpty());
    }
}
