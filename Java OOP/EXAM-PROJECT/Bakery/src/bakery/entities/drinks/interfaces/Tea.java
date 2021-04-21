package bakery.entities.drinks.interfaces;

import bakery.entities.Drink;

public class Tea extends Drink implements bakery.entities.drinks.interfaces.Drink {
    public Tea(String name, int portion, double price, String brand) {
        super(name, portion, 2.50, brand);
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
