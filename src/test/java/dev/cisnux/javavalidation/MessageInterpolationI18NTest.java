package dev.cisnux.javavalidation;

import dev.cisnux.javavalidation.data.Payment;
import dev.cisnux.javavalidation.groups.VirtualAccountPaymentGroup;
import jakarta.validation.MessageInterpolator;
import org.hibernate.validator.internal.engine.MessageInterpolatorContext;
import org.hibernate.validator.messageinterpolation.ExpressionLanguageFeatureLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class MessageInterpolationI18NTest extends AbstractValidatorTest {
    @Test
    void testI8N() {
        Locale.setDefault(Locale.of("id", "ID"));

        final var payment = new Payment("10238138193810312938", 1L, "123324");
        final var violations = validate(payment, VirtualAccountPaymentGroup.class);

        Assertions.assertEquals(3, violations.size());
    }

    @Test
    void testMessageInterpolator() {
        final var locale = Locale.of("id", "ID");
        final var payment = new Payment("10238138193810312938", 1L, "123324");

        final var violations = validator.validate(payment, VirtualAccountPaymentGroup.class);
        violations.forEach((violation) -> {
            MessageInterpolator.Context context = new MessageInterpolatorContext(
                    violation.getConstraintDescriptor(), violation.getInvalidValue(), violation.getRootBeanClass(),
                    violation.getPropertyPath(), violation.getConstraintDescriptor().getAttributes(),
                    violation.getConstraintDescriptor().getAttributes(), ExpressionLanguageFeatureLevel.VARIABLES, true
            );
            System.out.println("Message : " + messageInterpolator.interpolate(violation.getMessageTemplate(), context, locale));
            System.out.println("Bean : " + violation.getLeafBean());
            System.out.println("Constraint : " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid Value : " + violation.getInvalidValue());
            System.out.println("Path : " + violation.getPropertyPath());
            System.out.println("===============");
            System.out.println();
        });

        Assertions.assertEquals(3, violations.size());
    }
}
