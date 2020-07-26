package com.dotin.leavesystem.service;

import com.dotin.leavesystem.dao.CategoryElementDAO;
import com.dotin.leavesystem.models.CategoryElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryElementServiceImpl implements CategoryElementService {

    private final CategoryElementDAO categoryElementDAO;

    @Autowired
    public CategoryElementServiceImpl(CategoryElementDAO categoryElementDAO) {
        this.categoryElementDAO = categoryElementDAO;
    }

    @Override
    @Transactional
    public List<CategoryElement> findAll() {
        return categoryElementDAO.findAll();
    }

    @Override
    @Transactional
    public CategoryElement findById(int Id) {
        return categoryElementDAO.findById(Id);
    }

    @Override
    @Transactional
    public void save(CategoryElement categoryElement) {
         categoryElementDAO.save(categoryElement);
    }

    @Override
    @Transactional
    public void deleteById(int Id) {
      categoryElementDAO.deleteById(Id);
    }
}
