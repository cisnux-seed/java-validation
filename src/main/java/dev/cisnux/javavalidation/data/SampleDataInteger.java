package dev.cisnux.javavalidation.data;

import dev.cisnux.javavalidation.containers.DataInteger;
import jakarta.validation.constraints.Min;

public record SampleDataInteger(@Min(value = 10, message = "the data should be greater than or equal to {value}") DataInteger data) {
}
