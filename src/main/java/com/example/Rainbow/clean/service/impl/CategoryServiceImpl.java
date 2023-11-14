package com.example.Rainbow.clean.service.impl;

import com.example.Rainbow.clean.model.dto.CategoryAddBindingModel;
import com.example.Rainbow.clean.model.entity.Category;
import com.example.Rainbow.clean.repo.CategoryRepository;
import com.example.Rainbow.clean.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void add(CategoryAddBindingModel categoryAddBindingModel) {
        Category category = new Category();
        category.setName(categoryAddBindingModel.getName());
        categoryRepository.save(category);
    }

    @Override
    public Category getCategory(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }
}
