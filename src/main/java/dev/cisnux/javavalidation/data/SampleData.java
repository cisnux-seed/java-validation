package dev.cisnux.javavalidation.data;

import dev.cisnux.javavalidation.containers.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SampleData(
        Data<@NotBlank(message = "data must be filled") @Size(min = 10, message = "the length of data should be greater than or equal to {min}") String> data
) {
}
