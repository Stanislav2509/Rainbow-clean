package com.example.Rainbow.clean.model.entity;

import com.example.Rainbow.clean.model.enums.TypeNames;
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
    @Enumerated(EnumType.STRING)
    private TypeNames name;

    @Override
    public String toString() {
        return name.getDisplayValue();
    }
}
