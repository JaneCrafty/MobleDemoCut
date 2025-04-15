package com.example.JMobile.framework.Enums;

public enum Countries {
    THAILAND("Thailand"),
    VIETNAM("Vietnam"),
    COOK_ISLANDS("Cook Islands"),
    CUBA("Cuba");

    private final String name;

    Countries(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
