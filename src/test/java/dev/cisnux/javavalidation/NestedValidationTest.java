package dev.cisnux.javavalidation;

import dev.cisnux.javavalidation.data.Address;
import dev.cisnux.javavalidation.data.Person;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NestedValidationTest {
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
    void testNested() {
        final var hobbies = new ArrayList<>(List.of("", ""));
        final var person = new Person("sdjf09jspfspduf-jsdpfj-s0udfjsdopf0uds-fjnpsjf[jhsd0fs", "risqulla", new Address(), hobbies);
        final var violations = validator.validate(person);

        for (final var violation : violations) {
            System.out.println("Bean : " + violation.getLeafBean());
            System.out.println("Message : " + violation.getMessage());
            System.out.println("Invalid Value : " + violation.getInvalidValue());
            System.out.println("Path : " + violation.getPropertyPath());
            System.out.println();
        }
        Assertions.assertEquals(3, violations.size());
    }
}
