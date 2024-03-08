package dev.cisnux.javavalidation.data;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Collections;
import java.util.List;

public record Person(
        @NotBlank(message = "the first name must be filled")
        @Size(max = 20, message = "the first name must be less than 20")
        String firstName,
        @NotBlank(message = "the last name must be filled")
        @Size(max = 20, message = "the last name must be less than 20")
        String lastName,
        @NotNull(message = "the address must be filled")
        @Valid
        Address address,
        @NotEmpty(message = "the hobbies must be filled")
        List<@NotBlank(message = "hobby must be filled") String> hobbies
) {
    public Person() {
        this("", "", null, null);
    }

    public Person(
            String firstName
    ) {
        this(firstName, "", null, null);
    }

    public Person(
            String firstName, String lastName
    ) {
        this(firstName, lastName, null, null);
    }

    @Valid
    public Person(
            @NotBlank(message = "the first name must be filled")
            @Size(max = 20, message = "the first name must be less than 20")
            String firstName,
            @NotBlank(message = "the last name must be filled")
            @Size(max = 20, message = "the last name must be less than 20")
            String lastName,
            @NotNull(message = "the address must be filled")
            @Valid
            Address address
    ) {
        this(firstName, lastName, address, null);
    }

    @Valid
    public Person(
            @NotBlank(message = "the first name must be filled")
            @Size(max = 20, message = "the first name must be less than 20")
            String firstName,
            @NotBlank(message = "the last name must be filled")
            @Size(max = 20, message = "the last name must be less than 20")
            String lastName,
            @NotEmpty(message = "the hobbies must be filled")
            List<String> hobbies
    ){
        this(firstName, lastName, null, hobbies);
    }

    @Override
    public List<String> hobbies() {
        return Collections.unmodifiableList(hobbies);
    }

    public void greeting(@NotBlank(message = "name can not be blank") String name) {
        System.out.println("Hi " + name + '!' + "my name is " + fullName());
    }

    @NotBlank(message = "full name can not be blank")
    public String fullName() {
        return firstName + ' ' + lastName;
    }
}
