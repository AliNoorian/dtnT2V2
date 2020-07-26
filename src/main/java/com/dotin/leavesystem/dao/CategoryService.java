package com.dotin.leavesystem.dao;

import com.dotin.leavesystem.models.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();
    Category findById(int Id);
    void save(Category category);
    void deleteById(int id);
}
