package com.example.Rainbow.clean.controller;

import com.example.Rainbow.clean.model.dto.CategoryAddBindingModel;
import com.example.Rainbow.clean.model.entity.Category;
import com.example.Rainbow.clean.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CategoryController {
    public final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/add-category")
    public ModelAndView addCategory(){
        ModelAndView modelAndView = new ModelAndView();
        List<Category> categories = categoryService.getAllCategories();
        modelAndView.addObject("categories", categories);
        modelAndView.setViewName("add-category");
        return modelAndView;
    }

    @PostMapping("/add-category")
    public String addCategory(CategoryAddBindingModel categoryAddBindingModel){
        categoryService.add(categoryAddBindingModel);
        return "redirect:/add-category";
    }
}
