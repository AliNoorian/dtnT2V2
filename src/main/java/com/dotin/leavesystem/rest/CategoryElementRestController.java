package com.dotin.leavesystem.rest;

import com.dotin.leavesystem.models.CategoryElement;
import com.dotin.leavesystem.service.CategoryElementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class CategoryElementRestController {

    private final CategoryElementService categoryElementService;

    public CategoryElementRestController(CategoryElementService categoryElementService) {
        this.categoryElementService = categoryElementService;
    }

    @GetMapping("/categoryElement")
    public List<CategoryElement> findAll() {
        return categoryElementService.findAll();
    }



}
