package com.example.Rainbow.clean.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "options")
public class Option extends BaseEntity{
    @NotNull
    @OneToOne
    private Category category;
    @NotNull
    @OneToOne
    private Type type;
    @NotNull
    private Double price;

}
