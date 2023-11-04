package com.example.Rainbow.clean.model.entity;

import com.example.Rainbow.clean.model.enums.CategoryName;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends BaseEntity{
    @Enumerated(EnumType.STRING)
    @NotNull
    private CategoryName name;
}
