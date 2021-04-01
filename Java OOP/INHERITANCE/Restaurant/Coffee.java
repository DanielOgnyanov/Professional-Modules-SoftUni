package Inheritance.Restaurant;

import java.math.BigDecimal;

public class Coffee extends HotBeverage {
    protected double caffeine;


    public Coffee(String name, double caffeine) {
        super(name, BigDecimal.valueOf(0.0), 0);
        super.setPrice(BigDecimal.valueOf(3.50));
        super.setMilliliters(50);
        this.caffeine = caffeine;

    }

    public double getCaffeine() {
        return caffeine;
    }

}
