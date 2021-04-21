package bakery.entities;

import bakery.entities.drinks.interfaces.BaseDrink;

public class Drink extends BaseDrink implements bakery.entities.drinks.interfaces.Drink {

    public Drink(String name, int portion, double price, String brand) {
        super(name, portion, price, brand);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getPortion() {
        return super.getPortion();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public String getBrand() {
        return super.getBrand();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
