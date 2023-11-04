package com.ykeas.ykeasmsprincipal.service;

import com.ykeas.ykeasmsprincipal.model.dto.UserCreateDto;
import com.ykeas.ykeasmsprincipal.model.entity.User;
import com.ykeas.ykeasmsprincipal.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService{

    private UserRepository userRepository;

    @Override
    public User save(UserCreateDto request) {
        User user = new User();
        user.setName(request.getName());
        user.setPhone(request.getPhone());
        user.setEmail(request.getEmail());
        user.setUser(request.getUser());
        user.setPassword(request.getPassword());

        return userRepository.save(user);
    }

    @Override
    public Boolean verifyAccess(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        if(user == null) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
