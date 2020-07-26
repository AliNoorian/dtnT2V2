package com.dotin.leavesystem.service;

import com.dotin.leavesystem.dao.CategoryService;
import com.dotin.leavesystem.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryServiceImpl implements com.dotin.leavesystem.service.CategoryService {


    private final CategoryService categoryDAO;

    @Autowired
    public CategoryServiceImpl(CategoryService categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    @Transactional
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    @Transactional
    public Category findById(int Id) {
        return categoryDAO.findById(Id);
    }

    @Override
    @Transactional
    public void save(Category category) {
        categoryDAO.save(category);
    }

    @Override
    @Transactional
    public void deleteById(int Id) {
        categoryDAO.deleteById(Id);
    }
}
