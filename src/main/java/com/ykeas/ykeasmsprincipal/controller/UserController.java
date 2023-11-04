package com.ykeas.ykeasmsprincipal.controller;

import com.ykeas.ykeasmsprincipal.model.dto.UserCreateDto;
import com.ykeas.ykeasmsprincipal.model.entity.User;
import com.ykeas.ykeasmsprincipal.model.request.LoginRequest;
import com.ykeas.ykeasmsprincipal.model.request.UserCreateRequest;
import com.ykeas.ykeasmsprincipal.model.response.LoginResponse;
import com.ykeas.ykeasmsprincipal.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/usuario")
public class UserController {

    private IUserService userService;

    @PostMapping("/registrar")
    public ResponseEntity<User> save(@Validated @RequestBody UserCreateRequest request) {
        User newUser = userService.save(UserCreateDto.builder()
                .name(request.getName())
                .phone(request.getPhone())
                .email(request.getEmail())
                .user(request.getUser())
                .password(request.getPassword())
                .build());

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> verifyAccess(@Validated @RequestBody LoginRequest request) {
        Boolean access = userService.verifyAccess(request.getEmail(), request.getPassword());

        if(access.equals(Boolean.FALSE)) {
            return new ResponseEntity<>(LoginResponse.IS_NOT_VALID.getValue(), HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(LoginResponse.IS_VALID.getValue(), HttpStatus.OK);
    }
}
