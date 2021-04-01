package Inheritance.Restaurant;

import java.math.BigDecimal;

public class Cake extends  Dessert {
     protected  double grams = 250;
     protected double calories = 1000;
     protected  BigDecimal price = BigDecimal.valueOf(5);

    public Cake(String name) {
        super(name, BigDecimal.valueOf(5), 0, 0);
        super.setGrams(250);
        super.setCalories(1000);

    }


}
