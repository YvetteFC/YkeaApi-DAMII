package com.ykeas.ykeasmsprincipal.model.response;

import lombok.Getter;

@Getter
public enum LoginResponse {
    IS_VALID("Login valid"),
    IS_NOT_VALID("Email or password incorrect");

    private final String value;

    LoginResponse(String value) {
        this.value = value;
    }
}
