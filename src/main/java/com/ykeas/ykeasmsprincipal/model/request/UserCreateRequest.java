package com.ykeas.ykeasmsprincipal.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateRequest {

    @NotBlank(message = "name is required")
    private String name;

    @NotNull(message = "phone is required")
    @Pattern(regexp = "^\\d{9}$")
    private String phone;

    @NotNull(message = "email is required")
    @Email(message = "email is incorrect")
    private String email;

    @NotNull(message = "user is required")
    private String user;

    @NotNull(message = "password is required")
    private String password;
}
