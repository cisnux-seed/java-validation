package dev.cisnux.javavalidation.data;

import dev.cisnux.javavalidation.contraints.CheckPassword;
import jakarta.validation.constraints.NotBlank;


@CheckPassword(message = "the password and retype password should be same")
public record Register(@NotBlank(message = "username must be filled") String username,
                       @NotBlank(message = "password must be filled") String password,
                       @NotBlank(message = "tje retype password must be filled") String retypePassword) {
}
