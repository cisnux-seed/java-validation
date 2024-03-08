package dev.cisnux.javavalidation.contraints;

import dev.cisnux.javavalidation.groups.CreditCardPaymentGroup;
import dev.cisnux.javavalidation.groups.VirtualAccountPaymentGroup;
import dev.cisnux.javavalidation.utils.CaseMode;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@NotBlank(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, message = "{order.id.not.blank}")
@Size(min = 1, max = 10, groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, message = "{order.id.size}")
@CheckCase(mode = CaseMode.UPPER, groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, message = "{order.id.check.case}")
@Documented
@Constraint(validatedBy = {})
@Target({FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@ReportAsSingleViolation
public @interface CheckOrderId {
    String message() default "invalid order id";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
