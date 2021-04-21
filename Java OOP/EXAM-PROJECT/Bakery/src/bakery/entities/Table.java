package bakery.entities;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.interfaces.BaseTable;

public class Table extends BaseTable implements bakery.entities.tables.interfaces.Table {
    public Table(int tableNumber, int capacity, double pricePerPerson) {
        super(tableNumber, capacity, pricePerPerson);
    }

    @Override
    public int getTableNumber() {
        return super.getTableNumber();
    }

    @Override
    public int getCapacity() {
        return super.getCapacity();
    }

    @Override
    public int getNumberOfPeople() {
        return super.getNumberOfPeople();
    }

    @Override
    public double getPricePerPerson() {
        return super.getPricePerPerson();
    }

    @Override
    public boolean isReserved() {
        return super.isReserved();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public void reserve(int numberOfPeople) {
        super.reserve(numberOfPeople);
    }

    @Override
    public void orderFood(BakedFood food) {
        super.orderFood(food);
    }

    @Override
    public void orderDrink(Drink drink) {
        super.orderDrink(drink);
    }

    @Override
    public double getBill() {
        return super.getBill();
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public String getFreeTableInfo() {
        return super.getFreeTableInfo();
    }
}
