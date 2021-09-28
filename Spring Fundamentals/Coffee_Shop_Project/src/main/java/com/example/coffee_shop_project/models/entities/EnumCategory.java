package com.example.coffee_shop_project.models.entities;

public enum EnumCategory {
    COFFEE (2),
    CAKE (10),
    DRINK (1),
    OTHER (5);


    private int value;

    EnumCategory(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
