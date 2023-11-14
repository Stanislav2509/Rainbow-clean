package com.example.Rainbow.clean.service.impl;

import com.example.Rainbow.clean.model.dto.TypeAddBindingModel;
import com.example.Rainbow.clean.model.entity.Type;
import com.example.Rainbow.clean.repo.TypeRepository;
import com.example.Rainbow.clean.service.TypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    private final TypeRepository typeRepository;

    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }


    @Override
    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }
}
