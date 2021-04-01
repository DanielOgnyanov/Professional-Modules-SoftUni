package Inheritance.Restaurant;

import java.math.BigDecimal;

public class Salmon extends MainDish {
    public Salmon(String name, BigDecimal price, double grams) {
        super(name, price, grams);
        this.grams = 22;
    }
}
