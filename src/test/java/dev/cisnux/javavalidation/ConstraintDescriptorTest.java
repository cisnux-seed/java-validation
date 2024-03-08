package dev.cisnux.javavalidation;

import dev.cisnux.javavalidation.data.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConstraintDescriptorTest extends AbstractValidatorTest {
    @Test
    void testConstraintDescriptor() {
        final var person = new Person();
        final var violations = validator.validate(person);
        violations.forEach((violation) -> {
            final var descriptor = violation.getConstraintDescriptor();
            System.out.println(descriptor.getAnnotation());
            System.out.println(descriptor.getAttributes());
            System.out.println(descriptor.getPayload());
            System.out.println(descriptor.getGroups());
            System.out.println("===============");
            System.out.println();
        });

        Assertions.assertFalse(violations.isEmpty());
    }
}
