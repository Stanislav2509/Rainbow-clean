package com.example.Rainbow.clean.service;

import com.example.Rainbow.clean.model.dto.CategoryAddBindingModel;
import com.example.Rainbow.clean.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    void add(CategoryAddBindingModel categoryAddBindingModel);

    Category getCategory(String categoryName);
}
