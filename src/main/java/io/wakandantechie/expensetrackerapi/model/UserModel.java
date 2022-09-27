package io.wakandantechie.expensetrackerapi.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserModel {

    @NotBlank(message = "Please enter a name")
    private String name;

    @NotNull(message = "Please enter your email address")
    @Email(message = "Please enter a valid email address")
    private String email;

    @NotNull(message = "Please enter a password")
    @Size(min = 5, message = "Password should be at least 5 characters")
    private String password;

    private Long age = 0L;
}
