package com.example.Rainbow.clean.model.dto;

import com.example.Rainbow.clean.model.entity.Category;
import com.example.Rainbow.clean.model.entity.Type;
import com.example.Rainbow.clean.model.enums.TypeNames;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OptionAddBindingModel {
    @NotNull
    private String category;
    @Enumerated(EnumType.STRING)
    private TypeNames type;
    @NotNull
    @Positive
    private Double price;
}
