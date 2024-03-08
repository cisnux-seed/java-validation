package dev.cisnux.javavalidation.data;

import dev.cisnux.javavalidation.containers.Entry;
import jakarta.validation.constraints.NotBlank;

public record SampleEntry(
        Entry<@NotBlank(message = "key should be filled") String, @NotBlank(message = "value should be filled") String> entry) {
}
