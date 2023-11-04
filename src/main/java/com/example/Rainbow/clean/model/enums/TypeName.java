package com.example.Rainbow.clean.model.enums;

public enum TypeName {
    WASHING("washing"),
    PATTING("patting"),
    COMBINED("combined");

    private final String displayValue;

    private TypeName(String displayValue){
        this.displayValue=displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
