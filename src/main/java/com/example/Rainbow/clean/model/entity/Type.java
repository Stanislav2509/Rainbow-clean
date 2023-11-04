package com.example.Rainbow.clean.model.entity;

import com.example.Rainbow.clean.model.enums.TypeName;
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
    @NotNull
    private TypeName name;
}
