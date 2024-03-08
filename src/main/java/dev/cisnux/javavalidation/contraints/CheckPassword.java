package dev.cisnux.javavalidation.contraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.TYPE;

@Documented
@Constraint(validatedBy = {CheckPasswordValidator.class})
@Target({TYPE})
@Retention(RUNTIME)
public @interface CheckPassword {
    String message() default "invalid password";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
