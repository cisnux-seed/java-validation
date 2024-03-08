package dev.cisnux.javavalidation;

import dev.cisnux.javavalidation.data.Payment;
import dev.cisnux.javavalidation.groups.CreditCardPaymentGroup;
import dev.cisnux.javavalidation.groups.VirtualAccountPaymentGroup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupTest extends AbstractValidatorTest {
    @Test
    void testCreditCardGroup() {
        final var payment = new Payment("011", "41222",10_000L);
        final var violations = validate(payment, CreditCardPaymentGroup.class);
        Assertions.assertEquals(1, violations.size());
    }

    @Test
    void testVirtualAccountGroup() {
        final var payment = new Payment("011", 10_000L, "");
        final var violations = validate(payment, VirtualAccountPaymentGroup.class);
        Assertions.assertEquals(1, violations.size());
    }
}
