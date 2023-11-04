package com.example.Rainbow.clean.model.enums;

public enum CategoryName {
    LITTLE_MATTRESS("little_mattress"),
    MEDIUM_MATTRESS("medium_mattress"),
    BIG_MATTRESS("big_mattress"),
    CARPET("carpet"),
    A_STOOL("a stool"),
    SOFA("sofa"),
    A_CHAIR("a chair");

    private final String displayValue;


     CategoryName(String displayValue){
        this.displayValue=displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
