package com.example.Rainbow.clean.service;

import com.example.Rainbow.clean.model.dto.TypeAddBindingModel;
import com.example.Rainbow.clean.model.entity.Type;

import java.util.List;

public interface TypeService {
    void add(TypeAddBindingModel typeAddBindingModel);

    List<Type> getAllTypes();
}
