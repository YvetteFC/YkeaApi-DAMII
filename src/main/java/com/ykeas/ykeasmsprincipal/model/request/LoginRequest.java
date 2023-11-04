package com.ykeas.ykeasmsprincipal.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    @NotBlank(message = "email is required")
    @Email(message = "email is incorrect")
    public String email;

    @NotBlank(message = "password is required")
    public String password;
}
