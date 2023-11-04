package com.example.Rainbow.clean.model.enums;

public enum Status {
    NEW("New"),
    PROCESSED("Processed"),
    COMPLETED("Completed");

    private final String displayValue;

    private Status(String displayValue){
        this.displayValue=displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
