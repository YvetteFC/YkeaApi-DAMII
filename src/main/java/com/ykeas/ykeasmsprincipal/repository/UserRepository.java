package com.ykeas.ykeasmsprincipal.repository;

import com.ykeas.ykeasmsprincipal.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailAndPassword(String email, String password);
}
