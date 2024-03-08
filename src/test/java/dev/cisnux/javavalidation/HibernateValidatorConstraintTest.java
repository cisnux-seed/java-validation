package dev.cisnux.javavalidation;

import dev.cisnux.javavalidation.data.Payment;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.*;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class HibernateValidatorConstraintTest {
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
    void testHibernateValidator_WhenInvalid() {
        final var payment = new Payment("p1", 1000L, "433");
        final var violations = validator.validate(payment);

        for (final var violation : violations) {
            System.out.println("Message : " + violation.getMessage());
            System.out.println("Bean : " + violation.getLeafBean());
            System.out.println("Constraint : " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid Value : " + violation.getInvalidValue());
            System.out.println("Path : " + violation.getPropertyPath());
            System.out.println();
        }
        Assertions.assertEquals(2, violations.size());
    }

    @Test
    void testHibernateValidator_WhenValid() {
        final var payment = new Payment("p1", 10_000L, "4433322211111155");
        final var violations = validator.validate(payment);

        for (final var violation : violations) {
            System.out.println("Message : " + violation.getMessage());
            System.out.println("Bean : " + violation.getLeafBean());
            System.out.println("Constraint : " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid Value : " + violation.getInvalidValue());
            System.out.println("Path : " + violation.getPropertyPath());
            System.out.println();
        }
        Assertions.assertEquals(0, violations.size());
    }
}
