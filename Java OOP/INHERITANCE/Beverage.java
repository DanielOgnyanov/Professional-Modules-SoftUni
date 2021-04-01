package Inheritance.Restaurant;

import java.math.BigDecimal;

public class Beverage extends  Product{
    public void setMilliliters(double milliliters) {
        this.milliliters = milliliters;
    }

    protected double milliliters;

    public Beverage(String name, BigDecimal price, double milliliters) {
        super(name, price);
        this.milliliters = milliliters;
    }

    public double getMilliliters() {
        return milliliters;
    }


}
