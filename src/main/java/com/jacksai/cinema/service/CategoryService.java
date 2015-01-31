package com.jacksai.cinema.service;

import com.jacksai.cinema.model.Category;
import com.jacksai.cinema.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    public Category findOne(long id) {
        return categoryRepository.findOne(id);
    }

    public void delete(Category category) {
        categoryRepository.delete(category.getId());
    }
}
