package dev.cisnux.javavalidation.contraints;

import dev.cisnux.javavalidation.data.Register;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckPasswordValidator implements ConstraintValidator<CheckPassword, Register> {
    private String messageTemplate;

    @Override
    public void initialize(CheckPassword constraintAnnotation) {
        this.messageTemplate = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Register value, ConstraintValidatorContext context) {
        if (value.password() == null || value.retypePassword() == null)
            return true;

        final var isValid = value.password().equals(value.retypePassword());

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(messageTemplate)
                    .addPropertyNode("password")
                    .addConstraintViolation();
            context.buildConstraintViolationWithTemplate(messageTemplate)
                    .addPropertyNode("retypePassword")
                    .addConstraintViolation();
        }

        return isValid;
    }
}
