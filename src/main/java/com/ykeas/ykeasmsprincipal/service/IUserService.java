package com.ykeas.ykeasmsprincipal.service;

import com.ykeas.ykeasmsprincipal.model.dto.UserCreateDto;
import com.ykeas.ykeasmsprincipal.model.entity.User;

public interface IUserService {
    User save(UserCreateDto request);
    Boolean verifyAccess(String email, String password);
}
