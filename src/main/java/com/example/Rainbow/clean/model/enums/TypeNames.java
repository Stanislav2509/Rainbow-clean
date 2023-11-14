package com.example.Rainbow.clean.model.enums;

public enum TypeNames {
    WASHING("Washing"),
    PATTING("Patting"),
    COMBINED("Combined");

    private final String displayValue;

    TypeNames(String displayValue) {
        this.displayValue=displayValue;
    }

    public String getDisplayValue(){return  displayValue;}
}
