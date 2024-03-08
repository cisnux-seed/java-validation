package dev.cisnux.javavalidation;

import dev.cisnux.javavalidation.data.Customer;
import dev.cisnux.javavalidation.data.Payment;
import dev.cisnux.javavalidation.groups.CreditCardPaymentGroup;
import dev.cisnux.javavalidation.groups.VirtualAccountPaymentGroup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupConvertTest extends AbstractValidatorTest {
    @Test
    void testGroupConvert() {
        final var payment = new Payment("001", "4433322211111155", 10_000L, new Customer());
        final var  violations = validate(payment, CreditCardPaymentGroup.class);

        Assertions.assertEquals(2, violations.size());
    }

    @Test
    void testOtherGroupConvert() {
        final var payment = new Payment("001",  10_000L, "443331228999155", new Customer());
        final var  violations = validate(payment, VirtualAccountPaymentGroup.class);

        Assertions.assertEquals(2, violations.size());
    }
}
