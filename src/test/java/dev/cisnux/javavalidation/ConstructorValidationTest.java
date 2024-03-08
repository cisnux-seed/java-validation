package dev.cisnux.javavalidation;

import dev.cisnux.javavalidation.data.Address;
import dev.cisnux.javavalidation.data.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ConstructorValidationTest extends AbstractValidatorTest {
    @Test
    void testValidateConstructorParameter() throws NoSuchMethodException {
        final var firstName = "";
        final var lastName = "";
        final var address = new Address();

        final var constructor = Person.class.getConstructor(String.class, String.class, Address.class);
        final var violations = executableValidator.validateConstructorParameters(constructor, new Object[]{firstName, lastName, address});

        violations.forEach(violation -> {
            System.out.println("Message : " + violation.getMessage());
            System.out.println("Bean : " + violation.getLeafBean());
            System.out.println("Constraint : " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid Value : " + violation.getInvalidValue());
            System.out.println("Path : " + violation.getPropertyPath());
            System.out.println("===============");
            System.out.println();
        });

        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    void testValidateConstructorReturnValue() throws NoSuchMethodException {
        final var firstName = "";
        final var lastName = "";
        final var hobbies = new ArrayList<>(List.of("test1", "test2"));
        final var person = new Person(firstName, lastName, hobbies);

        final var constructor = Person.class.getConstructor(String.class, String.class, List.class);
        final var violations = executableValidator.validateConstructorReturnValue(constructor, person);

        violations.forEach(violation -> {
            System.out.println("Message : " + violation.getMessage());
            System.out.println("Bean : " + violation.getLeafBean());
            System.out.println("Constraint : " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid Value : " + violation.getInvalidValue());
            System.out.println("Path : " + violation.getPropertyPath());
            System.out.println("===============");
            System.out.println();
        });
        Assertions.assertFalse(violations.isEmpty());
    }
}
