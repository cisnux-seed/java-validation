package dev.cisnux.javavalidation;

import dev.cisnux.javavalidation.data.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MethodValidationTest extends AbstractValidatorTest {
    @Test
    void testGreeting() throws NoSuchMethodException {
        final var person = new Person("Fajra", "Risqulla");
        final var name = "";
        final var greeting = Person.class.getMethod("greeting", String.class);

        final var violations = executableValidator.validateParameters(person, greeting, new Object[]{name});
        violations.forEach(violation -> {
            System.out.println("Message : " + violation.getMessage());
            System.out.println("Bean : " + violation.getLeafBean());
            System.out.println("Constraint : " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid Value : " + violation.getInvalidValue());
            System.out.println("Path : " + violation.getPropertyPath());
            System.out.println("===============");
            System.out.println();
        });

        Assertions.assertEquals(1, violations.size());
    }

    @Test
    void testFulName()throws NoSuchMethodException {
        final var person = new Person("", "");
        final var returnValue = person.fullName();
        final var fullName = Person.class.getMethod("fullName");

        final var violations = executableValidator.validateReturnValue(person, fullName, returnValue);

        violations.forEach(violation -> {
            System.out.println("Message : " + violation.getMessage());
            System.out.println("Bean : " + violation.getLeafBean());
            System.out.println("Constraint : " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid Value : " + violation.getInvalidValue());
            System.out.println("Path : " + violation.getPropertyPath());
            System.out.println("===============");
            System.out.println();
        });

        Assertions.assertEquals(1, violations.size());
    }
}
