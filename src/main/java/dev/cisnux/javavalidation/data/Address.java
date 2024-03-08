package dev.cisnux.javavalidation.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record Address(
        @NotBlank(message = "the address's street can not be blank")
        String street,
        @Size(max = 20, message = "the address's city length should not be greater than 20")
        String city,
        @NotBlank(message = "the address's country can not be blank")
        String country
) {
    public Address() {
        this("", "", "");
    }

    public Address(String street) {
        this(street, "", "");
    }

    public Address(String street, String city) {
        this(street, city, "");
    }
}
