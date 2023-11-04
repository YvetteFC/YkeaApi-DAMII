package com.ykeas.ykeasmsprincipal.controller;

import com.ykeas.ykeasmsprincipal.model.entity.Category;
import com.ykeas.ykeasmsprincipal.service.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/categoria")
public class CategoryController {

    private ICategoryService categoryService;

    @GetMapping("/listado")
    public List<Category> index() {
        return categoryService.index();
    }
}
