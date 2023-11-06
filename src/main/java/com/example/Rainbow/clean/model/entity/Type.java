package com.example.Rainbow.clean.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name= "types")
public class Type extends BaseEntity {
    @NotNull
    private String  name;

    @Override
    public String toString() {
        return name;
    }
}
