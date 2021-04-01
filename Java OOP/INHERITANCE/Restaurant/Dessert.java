package Inheritance.Restaurant;

import java.math.BigDecimal;

public class Dessert extends Food {

    public void setCalories(double calories) {
        this.calories = calories;
    }

    protected double calories;


    public Dessert(String name, BigDecimal price, double grams, double calories) {
        super(name, price, grams);
        this.calories = calories;
    }

    public double getCalories() {
        return calories;
    }




}
