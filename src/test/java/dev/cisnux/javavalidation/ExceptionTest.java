package dev.cisnux.javavalidation;

import dev.cisnux.javavalidation.data.Person;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionTest extends AbstractValidatorTest {
    @Test
    void testException() {
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            final var person = new Person();
            validateWithExceptions(person);
        });
    }
}
