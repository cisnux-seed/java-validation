package dev.cisnux.javavalidation;

import dev.cisnux.javavalidation.containers.Data;
import dev.cisnux.javavalidation.containers.DataInteger;
import dev.cisnux.javavalidation.containers.Entry;
import dev.cisnux.javavalidation.data.SampleData;
import dev.cisnux.javavalidation.data.SampleDataInteger;
import dev.cisnux.javavalidation.data.SampleEntry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValueExtractorTest extends AbstractValidatorTest{
    @Test
    void testSampleData() {
        final var sampleData = new SampleData(new Data<>("fajra"));
        final var violations = validate(sampleData);

        Assertions.assertEquals(1, violations.size());
    }

    @Test
    void testSampleEntry() {
        final var sampleEntry = new SampleEntry(new Entry<>("", ""));
        final var violations = validate(sampleEntry);

        Assertions.assertEquals(2, violations.size());
    }

    @Test
    void testSampleDataInteger() {
        final var sampleDataInteger = new SampleDataInteger(new DataInteger(2));
        final var violations = validate(sampleDataInteger);

        Assertions.assertEquals(1, violations.size());
    }
}
