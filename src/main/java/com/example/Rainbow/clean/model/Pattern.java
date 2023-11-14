package com.example.Rainbow.clean.model;

import com.example.Rainbow.clean.model.entity.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Pattern {
    private Long categoryId;
    private Long washingOptionId;
    private Double washingPrice;
    private Long pattingOptionId;
    private Double pattingPrice;
    private Long combinedOptionId;
    private Double combinedPrice;

}
