package dev.cisnux.javavalidation;

import dev.cisnux.javavalidation.data.Payment;
import dev.cisnux.javavalidation.groups.VirtualAccountPaymentGroup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class CustomConstraintTest extends AbstractValidatorTest{
    @Test
    void testCustomConstraint() {
        Locale.setDefault(Locale.of("id", "ID"));

        final var payment = new Payment("abc", 1L, "123324");
        final var violations = validate(payment, VirtualAccountPaymentGroup.class);

        Assertions.assertEquals(3, violations.size());
    }

    @Test
    void testCustomConstraint_WhenValid() {
        Locale.setDefault(Locale.of("id", "ID"));

        final var payment = new Payment("ABC", 1L, "123324");
        final var violations = validate(payment, VirtualAccountPaymentGroup.class);

        Assertions.assertEquals(2, violations.size());
    }
}
