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
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "options_categories",
            joinColumns = {@JoinColumn(name = "option_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "id")}
    )
    private Set<Category> category;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "options_types",
            joinColumns = {@JoinColumn(name = "option_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "type_id", referencedColumnName = "id")}
    )
    private Set<Type> type;
    @NotNull
    private Double price;


}
