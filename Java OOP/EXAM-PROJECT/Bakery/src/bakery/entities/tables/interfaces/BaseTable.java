package bakery.entities.tables.interfaces;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;

import java.util.ArrayList;
import java.util.Collection;

import static bakery.common.ExceptionMessages.*;

public abstract  class BaseTable implements Table {

   private Collection<BakedFood> foodOrders;
   private Collection<Drink> drinkOrders;

    private int tableNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved = false;
    private double price;

    protected BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        this.tableNumber = tableNumber;
        this.setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;

        this.foodOrders = new ArrayList<>();
        this.drinkOrders = new ArrayList<>();
    }



    private void setCapacity(int capacity) {
        if(capacity <= 0) {
            throw  new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw  new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }


    private void setPrice(double price) {
        this.price = price;
    }

    private void setReserved(boolean reserved) {
        this.isReserved = reserved;
    }



    @Override
    public int getTableNumber() {
        return this.tableNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void reserve(int numberOfPeople) {
      setReserved(true);
      setNumberOfPeople(numberOfPeople);
      setPrice(this.pricePerPerson * this.numberOfPeople);
    }

    @Override
    public void orderFood(BakedFood food) {
        foodOrders.add(food);
    }

    @Override
    public void orderDrink(Drink drink) {
       drinkOrders.add(drink);
    }

    @Override
    public double getBill() {
        double result = 0;

        for (BakedFood food : foodOrders) {
            result += food.getPrice();
        }

        for (Drink drink : drinkOrders) {
            result += drink.getPrice();
        }


        return result;
    }

    @Override
    public void clear() {
        foodOrders.removeAll(foodOrders);
        drinkOrders.removeAll(drinkOrders);
        setReserved(false);
        this.price = 0;
        this.numberOfPeople = 0;



    }

    @Override
    public String getFreeTableInfo() {
        StringBuilder out = new StringBuilder();

        out.append(String.format("Table: %d",this.tableNumber))
                .append(System.lineSeparator())
                .append(String.format("Type: %s",getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("Capacity: %d",this.capacity))
                .append(System.lineSeparator())
                .append(String.format("Price per Person: %.2f",this.pricePerPerson))
                .append(System.lineSeparator());


        return out.toString().trim();
    }
}
