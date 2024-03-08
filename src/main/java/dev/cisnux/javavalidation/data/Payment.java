package dev.cisnux.javavalidation.data;

import dev.cisnux.javavalidation.contraints.CheckOrderId;
import dev.cisnux.javavalidation.payload.EmailErrorPayload;
import dev.cisnux.javavalidation.groups.CreditCardPaymentGroup;
import dev.cisnux.javavalidation.groups.VirtualAccountPaymentGroup;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;

public record Payment(
        @CheckOrderId(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, message = "{order.id.invalid}")
        String orderId,
        @NotNull(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, message = "{amount.not.null}")
        @Range(min = 10_000L, max = 100_000_000L, message = "{amount.range}", groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class})
        long amount,
        @LuhnCheck(groups = {CreditCardPaymentGroup.class}, message = "{credit.card.luhn.check}", payload = {EmailErrorPayload.class})
        @NotBlank(groups = {CreditCardPaymentGroup.class}, message = "{credit.card.not.blank}")
        String creditCard,

        @NotBlank(groups = {VirtualAccountPaymentGroup.class}, message = "{virtual.account.not.blank}")
        String virtualAccount,
        @NotNull(message = "{customer.not.null}", groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class})
        @ConvertGroup(from = CreditCardPaymentGroup.class, to = Default.class)
        @ConvertGroup(from = VirtualAccountPaymentGroup.class, to = Default.class)
        @Valid
        Customer customer
) {
    public Payment() {
        this(null, 0, null, null, null);
    }

    public Payment(String orderId) {
        this(orderId, 0, null, null, null);
    }

    public Payment(String orderId, long amount) {
        this(orderId, amount, null, null, null);
    }

    public Payment(String orderId, long amount, String virtualAccount) {
        this(orderId, amount, null, virtualAccount, null);
    }

    public Payment(String orderId, long amount, String virtualAccount, Customer customer) {
        this(orderId, amount, null, virtualAccount, customer);
    }

    public Payment(String orderId, String creditCard, long amount) {
        this(orderId, amount, creditCard, null, null);
    }

    public Payment(String orderId, String creditCard, long amount, Customer customer) {
        this(orderId, amount, creditCard, null, customer);
    }
}
