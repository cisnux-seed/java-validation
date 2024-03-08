package dev.cisnux.javavalidation;

import dev.cisnux.javavalidation.extractors.DataIntegerValueExtractor;
import dev.cisnux.javavalidation.extractors.DataValueExtractor;
import dev.cisnux.javavalidation.extractors.EntryValueExtractorKey;
import dev.cisnux.javavalidation.extractors.EntryValueExtractorValue;
import jakarta.validation.*;
import jakarta.validation.executable.ExecutableValidator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import java.lang.reflect.Method;
import java.util.Set;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class AbstractValidatorTest {
    protected ValidatorFactory validatorFactory;

    protected Validator validator;
    protected ExecutableValidator executableValidator;
    protected MessageInterpolator messageInterpolator;

    @BeforeAll
    void beforeAll() {
//        validatorFactory = Validation.buildDefaultValidatorFactory();
        validatorFactory = Validation.byDefaultProvider()
                .configure()
                .addValueExtractor(new DataValueExtractor())
                .addValueExtractor(new EntryValueExtractorKey())
                .addValueExtractor(new EntryValueExtractorValue())
                .addValueExtractor(new DataIntegerValueExtractor())
                .buildValidatorFactory();
        validator = validatorFactory.getValidator();
        executableValidator = validator.forExecutables();
        messageInterpolator = validatorFactory.getMessageInterpolator();
    }

    @AfterAll
    void afterAll() {
        validatorFactory.close();
    }

    Set<ConstraintViolation<Object>> validate(Object o) {
        final var violations = validator.validate(o);
        for (final var violation : violations) {
            System.out.println("Message : " + violation.getMessage());
            System.out.println("Bean : " + violation.getLeafBean());
            System.out.println("Constraint : " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid Value : " + violation.getInvalidValue());
            System.out.println("Path : " + violation.getPropertyPath());
            System.out.println("===============");
            System.out.println();
        }
        return violations;
    }

    Set<ConstraintViolation<Object>> validate(Object o, Class<?>... groups) {
        final var violations = validator.validate(o, groups);
        for (final var violation : violations) {
            System.out.println("Message : " + violation.getMessage());
            System.out.println("Bean : " + violation.getLeafBean());
            System.out.println("Constraint : " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid Value : " + violation.getInvalidValue());
            System.out.println("Path : " + violation.getPropertyPath());
            System.out.println("===============");
            System.out.println();
        }
        return violations;
    }

    Set<ConstraintViolation<Object>> validateWithExceptions(Object o, Class<?>... groups) {
        final var violations = validator.validate(o, groups);
        for (final var violation : violations) {
            System.out.println("Message : " + violation.getMessage());
            System.out.println("Bean : " + violation.getLeafBean());
            System.out.println("Constraint : " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid Value : " + violation.getInvalidValue());
            System.out.println("Path : " + violation.getPropertyPath());
            System.out.println("===============");
            System.out.println();
        }
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);
        return violations;
    }

    Set<ConstraintViolation<Object>> validateParameters(Object o, Method method, Object[] parameterValues, Class<?>... groups) {
        final var violations = executableValidator.validateParameters(o, method, parameterValues, groups);
        for (final var violation : violations) {
            System.out.println("Message : " + violation.getMessage());
            System.out.println("Bean : " + violation.getLeafBean());
            System.out.println("Constraint : " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid Value : " + violation.getInvalidValue());
            System.out.println("Path : " + violation.getPropertyPath());
            System.out.println("===============");
            System.out.println();
        }
        return violations;
    }

    Set<ConstraintViolation<Object>> validateReturnValue(Object o, Method method, Object returnValue, Class<?>... groups) {
        final var violations = executableValidator.validateReturnValue(o, method, returnValue, groups);
        for (final var violation : violations) {
            System.out.println("Message : " + violation.getMessage());
            System.out.println("Bean : " + violation.getLeafBean());
            System.out.println("Constraint : " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid Value : " + violation.getInvalidValue());
            System.out.println("Path : " + violation.getPropertyPath());
            System.out.println("===============");
            System.out.println();
        }
        return violations;
    }
}
