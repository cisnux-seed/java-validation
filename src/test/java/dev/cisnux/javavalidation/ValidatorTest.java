package dev.cisnux.javavalidation;

import jakarta.validation.Validation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Test
    void testCreateValidator() {
        try (var validatorFactory = Validation.buildDefaultValidatorFactory()) {
            final var validator = validatorFactory.getValidator();
            Assertions.assertNotNull(validator);
        }
    }
}
