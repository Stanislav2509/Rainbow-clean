package com.example.Rainbow.clean.controller;

import com.example.Rainbow.clean.model.Pattern;
import com.example.Rainbow.clean.model.dto.EditAllCategoryPricesDTO;
import com.example.Rainbow.clean.model.dto.EditPriceBindingModel;
import com.example.Rainbow.clean.model.dto.OptionAddBindingModel;
import com.example.Rainbow.clean.model.entity.Category;
import com.example.Rainbow.clean.model.entity.Option;
import com.example.Rainbow.clean.model.entity.Type;
import com.example.Rainbow.clean.service.CategoryService;
import com.example.Rainbow.clean.service.OptionService;
import com.example.Rainbow.clean.service.TypeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.*;
import java.util.stream.Collectors;

@Controller
public class OptionController {
    public final OptionService optionService;
    public final CategoryService categoryService;
    public final TypeService typeService;

    public OptionController(OptionService optionService, CategoryService categoryService, TypeService typeService) {
        this.optionService = optionService;
        this.categoryService = categoryService;
        this.typeService = typeService;
    }

    @GetMapping("/add-options")
    public ModelAndView addOptions(){
        ModelAndView modelAndView = new ModelAndView("add-option");

        List<Option> options = optionService.getAllOptions();
        List<Type> types = typeService.getAllTypes();
        List<Category> categories = categoryService.getAllCategories();
        Map<String,Pattern> info = new LinkedHashMap<>();

        for (Option option: options) {
            String categoryName = option.getCategory().stream().collect(Collectors.toList()).get(0).getName();
            String typeName = option.getType().stream().collect(Collectors.toList()).get(0).getName().getDisplayValue();
            double price = option.getPrice();

            info.putIfAbsent(categoryName,new Pattern());
            Category category = categoryService.getCategory(categoryName);
            info.get(categoryName).setCategoryId(category.getId());


            if(typeName.equals("Washing")) {
                info.get(categoryName).setWashingPrice(price);
                info.get(categoryName).setWashingOptionId(option.getId());
            } else if (typeName.equals("Patting")) {
                info.get(categoryName).setPattingPrice(price);
                info.get(categoryName).setPattingOptionId(option.getId());
            } else if (typeName.equals("Combined")) {
                info.get(categoryName).setCombinedPrice(price);
                info.get(categoryName).setCombinedOptionId(option.getId());
            }

        }

        modelAndView.addObject("options", options);
        modelAndView.addObject("types", types);
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("info", info);

        return modelAndView;
    }

    @PostMapping("/add-options")
    public ModelAndView addOptions(OptionAddBindingModel optionAddBindingModel){
        boolean hasSuccessfullyAdded = optionService.add(optionAddBindingModel);

        if(!hasSuccessfullyAdded){
            ModelAndView modelAndView = new ModelAndView("add-option");
            List<Option> options = optionService.getAllOptions();
            List<Type> types = typeService.getAllTypes();
            List<Category> categories = categoryService.getAllCategories();

            modelAndView.addObject("options", options);
            modelAndView.addObject("types", types);
            modelAndView.addObject("categories", categories);

            modelAndView.addObject("hasError", true);
            return modelAndView;
        }

        return new ModelAndView( "redirect:/add-options");
    }

    @PostMapping("/delete-price/{id}")
    public ModelAndView deletePrice(@PathVariable long id){
        Optional<Option> option = optionService.getById(id);

        if(option.isPresent()) {
            optionService.deleteOption(option);
        }

        return new ModelAndView("redirect:/add-options");
    }

    @GetMapping("/edit-price/{id}")
    public ModelAndView editPrice(@PathVariable long id, @ModelAttribute("editPriceBindingModel")EditPriceBindingModel editPriceBindingModel){
        ModelAndView modelAndView = new ModelAndView("edit-price");
        Optional<Option> option = optionService.getById(id);
        if(option.isPresent()) {
            editPriceBindingModel.setPrice(option.get().getPrice());
            editPriceBindingModel.setId(option.get().getId());
            editPriceBindingModel.setCategory(option.get().getCategory().stream().collect(Collectors.toList()).get(0).getName());
            editPriceBindingModel.setType(option.get().getType().stream().collect(Collectors.toList()).get(0).getName().getDisplayValue());
           // modelAndView.addObject("option",option.get().);
            return modelAndView;
        }

        return modelAndView;
    }

    @PostMapping("/edit-price/{id}") //TODO: Patch
    public ModelAndView editPrice(@PathVariable long id,
                                    @ModelAttribute("editPriceBindingModel") @Valid EditPriceBindingModel editPriceBindingModel,
                                    BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return new ModelAndView("edit-price");
        }

        Optional<Option> option = optionService.getById(id);
        if(option.isPresent()){
            Option option1 = option.get();
            option.get().setPrice(editPriceBindingModel.getPrice());
            optionService.save(option1);
        }

        return new ModelAndView("redirect:/add-options");
    }

    @PostMapping("/delete-option/{id}")
    public ModelAndView deleteOption(@PathVariable long id){
        List<Option> options = optionService.getAllOptionsByCategoryId(id);
        optionService.deleteOptions(options);

        return new ModelAndView("redirect:/add-options");
    }

    @GetMapping("/edit-option/{id}")
    public ModelAndView editOption(@PathVariable long id,
                                   @ModelAttribute("editAllCategoryPricesDTO") EditAllCategoryPricesDTO editAllCategoryPricesDTO){

        //EditAllCategoryPricesBindingModel viewModel = new EditAllCategoryPricesBindingModel();
        editAllCategoryPricesDTO.setCategoryID(id);
        ModelAndView modelAndView = new ModelAndView("edit-option");
        List<Option> options = optionService.getAllOptionsByCategoryId(id);


        for (Option option : options) {
            String categoryName = option.getCategory().stream().collect(Collectors.toList()).get(0).getName();
            editAllCategoryPricesDTO.setCategoryName(categoryName);

            String typeName = option.getType().stream().collect(Collectors.toList()).get(0).getName().getDisplayValue();
            double price = option.getPrice();

            if(typeName.equals("Washing")) {
                editAllCategoryPricesDTO.setWashingPrice(price);
            } else if (typeName.equals("Patting")) {
                editAllCategoryPricesDTO.setPattingPrice(price);
            } else if (typeName.equals("Combined")) {
                editAllCategoryPricesDTO.setCombinedPrice(price);
            }
        }


        return modelAndView;
    }

    @PostMapping("/edit-option/{id}")
    public ModelAndView editOption(@PathVariable long id,
                                  @ModelAttribute("editAllCategoryPricesDTO") @Valid EditAllCategoryPricesDTO editAllCategoryPricesDTO,
                                  BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return new ModelAndView("edit-option");
        }

        List<Option> options = optionService.getAllOptionsByCategoryId(id);
        for (Option option : options) {
            String typeName = option.getType().stream().collect(Collectors.toList()).get(0).getName().getDisplayValue();

            if(typeName.equals("Washing")){
                option.setPrice(editAllCategoryPricesDTO.getWashingPrice());
            } else if (typeName.equals("Patting")) {
                option.setPrice(editAllCategoryPricesDTO.getPattingPrice());
            } else if (typeName.equals("Combined")) {
                option.setPrice(editAllCategoryPricesDTO.getCombinedPrice());
            }

        }
        optionService.saveOptions(options);


        return new ModelAndView("redirect:/add-options");
    }
}