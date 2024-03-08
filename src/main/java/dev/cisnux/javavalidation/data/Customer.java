package dev.cisnux.javavalidation.data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record Customer(
        @Email(message = "the email must be filled in valid format")
        @NotBlank(message = "the email must be filled")
        String email,
        @NotBlank(message = "the name must be filled")
        String name
) {
    public Customer() {
        this(null, null);
    }
}
