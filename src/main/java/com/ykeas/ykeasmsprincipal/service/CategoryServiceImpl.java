package com.ykeas.ykeasmsprincipal.service;

import com.ykeas.ykeasmsprincipal.model.entity.Category;
import com.ykeas.ykeasmsprincipal.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements ICategoryService{

    private CategoryRepository categoryRepository;
    @Override
    public List<Category> index() {
        return categoryRepository.findAll();
    }
}
