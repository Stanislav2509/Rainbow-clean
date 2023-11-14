package com.example.Rainbow.clean.service.impl;

import com.example.Rainbow.clean.model.dto.EditPriceBindingModel;
import com.example.Rainbow.clean.model.dto.OptionAddBindingModel;
import com.example.Rainbow.clean.model.entity.Category;
import com.example.Rainbow.clean.model.entity.Option;
import com.example.Rainbow.clean.model.entity.Type;
import com.example.Rainbow.clean.repo.CategoryRepository;
import com.example.Rainbow.clean.repo.OptionRepository;
import com.example.Rainbow.clean.repo.TypeRepository;
import com.example.Rainbow.clean.service.OptionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OptionServiceImpl implements OptionService {
    public final OptionRepository optionRepository;
    public final CategoryRepository categoryRepository;
    public final TypeRepository typeRepository;

    public OptionServiceImpl(OptionRepository optionRepository, CategoryRepository categoryRepository, TypeRepository typeRepository) {
        this.optionRepository = optionRepository;
        this.categoryRepository = categoryRepository;
        this.typeRepository = typeRepository;
    }

    @Override
    public List<Option> getAllOptions() {
        return optionRepository.findAll();
    }

    @Override
    public boolean add(OptionAddBindingModel optionAddBindingModel) {
        String categoryName = optionAddBindingModel.getCategory();
        Category category = categoryRepository.findByName(categoryName);

        if(category == null){
            return false;
        }

        Type type = typeRepository.findByName(optionAddBindingModel.getType());

        if(type == null){
            return false;
        }
        Set<Type> typeSet;
        Option option = new Option();

        if(option.getType() == null) {
            typeSet = Set.of(type);
        } else {
            typeSet = option.getType();
            typeSet.add(type);
        }

        Set<Category> categorySet;
        if(option.getCategory() == null) {
            categorySet = Set.of(category);
        } else {
            categorySet = option.getCategory();
            categorySet.add(category);
        }

        option.setType(typeSet);
        option.setCategory(categorySet);
        option.setPrice(optionAddBindingModel.getPrice());

        optionRepository.save(option);

        return true;
    }

    @Override
    public List<Option> getAllOptionsByCategoryId(long id) {
        return optionRepository.findAllByCategoryId(id);
    }

    @Override
    public void deleteOptions(List<Option> options) {
        optionRepository.deleteAll(options);
    }

    @Override
    public Option getByCategoryId(long categoryId) {
        return optionRepository.findByCategoryId(categoryId);
    }

    @Override
    public void deleteOption(Optional<Option> option) {
        option.ifPresent(value -> optionRepository.deleteById(value.getId()));

    }

    @Override
    public Optional<Option> getById(long id) {
        return optionRepository.findById(id);
    }

    @Override
    public void save(Option option) {
        optionRepository.save(option);
    }

    @Override
    public void saveOptions(List<Option> options) {
        optionRepository.saveAll(options);
    }


}
