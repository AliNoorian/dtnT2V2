package com.dotin.leavesystem.dao;

import com.dotin.leavesystem.models.CategoryElement;

import java.util.List;


public interface CategoryElementDAO {

    List<CategoryElement> findAll();
    CategoryElement findById(int Id);
    void save(CategoryElement categoryElement);
    void deleteById(int id);
}
