package com.example.Rainbow.clean.service;

import com.example.Rainbow.clean.model.dto.binding.CategoryAddBindingModel;
import com.example.Rainbow.clean.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllTypes();

    void add(CategoryAddBindingModel categoryAddBindingModel);
}
