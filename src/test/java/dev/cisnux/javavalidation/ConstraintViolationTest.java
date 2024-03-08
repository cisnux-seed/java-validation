package dev.cisnux.javavalidation;

import dev.cisnux.javavalidation.data.Person;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ConstraintViolationTest {
    private Validator validator;
    private ValidatorFactory validatorFactory;

    @BeforeAll
    void beforeAll() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterAll
    void afterAll() {
        validatorFactory.close();
    }

    @Test
    void tesValidation_WhenAllFieldIsBlank() {
        final var person = new Person();
        final var violations = validator.validate(person);

        for (final var violation : violations) {
            System.out.println("Message : " + violation.getMessage());
            System.out.println("Bean : " + violation.getLeafBean());
            System.out.println("Constraint : " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid Value : " + violation.getInvalidValue());
            System.out.println("Path : " + violation.getPropertyPath());
        }
        Assertions.assertEquals(2, violations.size());
    }

    @Test
    void tesValidation_WhenLastNameIsBlank() {
        final var person = new Person("Fajra");
        final var violations = validator.validate(person);

        for (final var violation : violations) {
            System.out.println("Message : " + violation.getMessage());
            System.out.println("Bean : " + violation.getLeafBean());
            System.out.println("Constraint : " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid Value : " + violation.getInvalidValue());
            System.out.println("Path : " + violation.getPropertyPath());
        }
        Assertions.assertEquals(1, violations.size());
    }
}
