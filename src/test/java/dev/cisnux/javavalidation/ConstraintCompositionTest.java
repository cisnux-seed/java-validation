package dev.cisnux.javavalidation;

import dev.cisnux.javavalidation.data.Payment;
import dev.cisnux.javavalidation.groups.CreditCardPaymentGroup;
import org.junit.jupiter.api.Test;

public class ConstraintCompositionTest extends AbstractValidatorTest{
    @Test
    void testComposition() {
        final var payment = new Payment("29852309850238529589akjkjdsak");
        validate(payment, CreditCardPaymentGroup.class);
    }
}
