package dev.cisnux.javavalidation;

import dev.cisnux.javavalidation.data.Payment;
import dev.cisnux.javavalidation.groups.PaymentGroup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupSequenceTest extends AbstractValidatorTest {
    @Test
    void testGroupSequence() {
        final var payment = new Payment("001", "4433322211111155", 10_000L);
        final var violations = validate(payment, PaymentGroup.class);

        Assertions.assertEquals(1, violations.size());
    }
}
