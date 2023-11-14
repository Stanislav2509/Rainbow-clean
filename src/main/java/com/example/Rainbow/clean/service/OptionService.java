package com.example.Rainbow.clean.service;

import com.example.Rainbow.clean.model.dto.EditPriceBindingModel;
import com.example.Rainbow.clean.model.dto.OptionAddBindingModel;
import com.example.Rainbow.clean.model.entity.Option;

import java.util.List;
import java.util.Optional;

public interface OptionService {
    List<Option> getAllOptions();

    boolean add(OptionAddBindingModel optionAddBindingModel);

    List<Option> getAllOptionsByCategoryId(long id);

    void deleteOptions(List<Option> options);

    Option getByCategoryId(long categoryId);

    void deleteOption(Optional<Option> categoryId);

    Optional<Option> getById(long id);

    void save(Option option);

    void saveOptions(List<Option> options);
}
