package com.example.Rainbow.clean.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TypeAddBindingModel {
    @NotNull
    private String  name;
}
