package dev.cisnux.javavalidation;

import dev.cisnux.javavalidation.data.Payment;
import dev.cisnux.javavalidation.groups.CreditCardPaymentGroup;
import dev.cisnux.javavalidation.payload.EmailErrorPayload;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PayloadTest extends AbstractValidatorTest {
    @Test
    void testPayload() {
        final var payment = new Payment("0001", "31111", 20_000L);
        final var violations = validator.validate(payment, CreditCardPaymentGroup.class);
        violations.forEach(violation -> {
            System.out.println("Message : " + violation.getMessage());
            System.out.println("Bean : " + violation.getLeafBean());
            System.out.println("Constraint : " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid Value : " + violation.getInvalidValue());
            System.out.println("Path : " + violation.getPropertyPath());
            System.out.println("===============");
            violation.getConstraintDescriptor().getPayload().forEach(payload -> {
                if (payload == EmailErrorPayload.class) {
                    final var emailErrorPayload = new EmailErrorPayload();
                    emailErrorPayload.sendEmail(violation);
                }
            });
            System.out.println();
        });

        Assertions.assertFalse(violations.isEmpty());
    }
}
