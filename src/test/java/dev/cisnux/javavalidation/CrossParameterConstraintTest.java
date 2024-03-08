package dev.cisnux.javavalidation;

import dev.cisnux.javavalidation.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CrossParameterConstraintTest extends AbstractValidatorTest {
    @Test
    void testCrossParameter() throws NoSuchMethodException {
        final var userService = new UserService();
        final var username = "cisnux";
        final var password = "fajra123";
        final var retypePassword = "fajra12";
        final var register = UserService.class.getMethod("register", String.class, String.class, String.class);

        final var validations = validateParameters(userService, register, new Object[]{username, password, retypePassword});

        Assertions.assertEquals(1, validations.size());
    }
}
