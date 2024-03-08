package dev.cisnux.javavalidation;

import dev.cisnux.javavalidation.data.Payment;
import dev.cisnux.javavalidation.groups.VirtualAccountPaymentGroup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MessageInterpolationTest extends AbstractValidatorTest {
    @Test
    void testMessage() {
        final var payment = new Payment("10238138193810312938", 1L, "123324");
        final var violations = validate(payment, VirtualAccountPaymentGroup.class);

        Assertions.assertEquals(3, violations.size());
    }
}
