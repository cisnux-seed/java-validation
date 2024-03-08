package dev.cisnux.javavalidation;

import dev.cisnux.javavalidation.data.Register;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClassLevelConstraintTest extends AbstractValidatorTest {
    @Test
    void testClassLevel() {
        final var register = new Register("cisnux", "fajra123", "fajra12");
        final var violations = validate(register);
        Assertions.assertEquals(2, violations.size());
    }

    @Test
    void testClassLevel_WhenValid() {
        final var register = new Register("cisnux", "fajra123", "fajra123");
        final var violations = validate(register);
        Assertions.assertEquals(0, violations.size());
    }
}
