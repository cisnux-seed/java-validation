package dev.cisnux.javavalidation.extractors;

import dev.cisnux.javavalidation.containers.Data;
import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.ValueExtractor;

public class DataValueExtractor implements ValueExtractor<Data<@ExtractedValue ?>> {
    @Override
    public void extractValues(Data<?> originalValue, ValueReceiver receiver) {
        final var data = originalValue.data();

        receiver.value(null, data);
    }
}
