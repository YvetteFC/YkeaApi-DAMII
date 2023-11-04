package com.ykeas.ykeasmsprincipal.repository;

import com.ykeas.ykeasmsprincipal.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
