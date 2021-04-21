package bakery.entities;

import bakery.entities.bakedFoods.interfaces.BaseFood;

public class BakedFood extends BaseFood implements bakery.entities.bakedFoods.interfaces.BakedFood {

    public BakedFood(String name, double portion, double price) {
        super(name, portion, price);
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
