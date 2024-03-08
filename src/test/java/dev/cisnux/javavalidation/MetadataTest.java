package dev.cisnux.javavalidation;

import dev.cisnux.javavalidation.data.Person;
import org.junit.jupiter.api.Test;

public class MetadataTest extends AbstractValidatorTest {
    @Test
    void testPerson() {
        final var beanDescriptor = validator.getConstraintsForClass(Person.class);

        beanDescriptor.getConstrainedProperties().forEach(propertyDescriptor -> {
            System.out.println("property name: "+ propertyDescriptor.getPropertyName());
            propertyDescriptor.getConstraintDescriptors().forEach(System.out::println);
            System.out.println();
        });
    }
}
