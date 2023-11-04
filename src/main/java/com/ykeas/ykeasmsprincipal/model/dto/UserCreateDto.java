package com.ykeas.ykeasmsprincipal.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserCreateDto {

    private String name;

    private String phone;

    private String email;

    private String user;

    private String password;
}
