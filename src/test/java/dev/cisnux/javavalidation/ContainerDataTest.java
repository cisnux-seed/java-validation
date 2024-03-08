package dev.cisnux.javavalidation;

import dev.cisnux.javavalidation.data.Address;
import dev.cisnux.javavalidation.data.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ContainerDataTest extends AbstractValidatorTest{
    @Test
    void testContainerData() {
        final var person = new Person("Fajra", "Risqulla", new Address("said", "Jakarta Selatan", "Indonesia"), new ArrayList<>(List.of("foodie", "gaming", "")));
        final var violations = validate(person);

        Assertions.assertEquals(1, violations.size());
    }

    @Test
    void testContainerData_WhenValid() {
        final var person = new Person("Fajra", "Risqulla", new Address("said", "Jakarta Selatan", "Indonesia"), new ArrayList<>(List.of("foodie", "gaming", "football")));
        final var violations = validate(person);

        Assertions.assertEquals(0, violations.size());
    }
}
