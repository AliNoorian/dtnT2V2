package com.dotin.leavesystem.rest;

import com.dotin.leavesystem.dao.CategoryDAO;
import com.dotin.leavesystem.models.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class CategoryRestController {

    private final CategoryDAO categoryService;

    public CategoryRestController(CategoryDAO categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public List<Category> findAll() {
        return categoryService.findAll();
    }



}
