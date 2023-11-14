package com.example.Rainbow.clean.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryAddBindingModel {
    @NotBlank
    private String name;
}
