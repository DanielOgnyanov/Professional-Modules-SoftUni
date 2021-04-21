package bakery.entities.bakedFoods.interfaces;

import bakery.entities.BakedFood;

public class Bread extends BakedFood{
    private static final double PORTION = 200;

    public Bread(String name,  double price) {
        super(name, PORTION, price);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getPortion() {
        return super.getPortion();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
