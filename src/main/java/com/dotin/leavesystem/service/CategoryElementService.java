package com.dotin.leavesystem.service;


import com.dotin.leavesystem.models.CategoryElement;

import java.util.List;

public interface CategoryElementService {

    List<CategoryElement> findAll();

    CategoryElement findById(int Id);

    void save(CategoryElement categoryElement);

    void deleteById(int Id);
}
