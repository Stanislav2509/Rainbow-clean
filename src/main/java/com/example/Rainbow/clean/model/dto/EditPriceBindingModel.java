package com.example.Rainbow.clean.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EditPriceBindingModel {
    private Long id;
    private Double price;
    private String category;
    private String type;
}
