package dev.cisnux.javavalidation.contraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraintvalidation.SupportedValidationTarget;
import jakarta.validation.constraintvalidation.ValidationTarget;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class CheckPasswordParameterValidator implements ConstraintValidator<CheckPasswordParameter, Object[]> {
    private int password;
    private int retypePassword;

    @Override
    public void initialize(CheckPasswordParameter constraintAnnotation) {
        this.password = constraintAnnotation.password();
        this.retypePassword = constraintAnnotation.retypePassword();
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        String password = (String) value[this.password];
        String retypePassword = (String) value[this.retypePassword];

        if(password == null || retypePassword == null)
            return true;

        return password.equals(retypePassword);
    }
}
