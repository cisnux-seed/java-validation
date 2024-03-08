package dev.cisnux.javavalidation.services;

import dev.cisnux.javavalidation.contraints.CheckPasswordParameter;
import jakarta.validation.constraints.NotBlank;

public class UserService {

    @CheckPasswordParameter(
            password = 1,
            retypePassword = 2,
            message = "the password and retype password should be same"
    )
    public void register(
            @NotBlank(message = "username must be filled") String username,
            @NotBlank(message = "password must be filled") String password,
            @NotBlank(message = "retype password must be filled") String retypePassword
    ) {

    }
}
