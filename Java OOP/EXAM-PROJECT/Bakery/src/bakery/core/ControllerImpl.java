package bakery.core;

import bakery.common.ExceptionMessages;
import bakery.common.OutputMessages;
import bakery.core.interfaces.Controller;
import bakery.entities.BakedFood;
import bakery.entities.Drink;
import bakery.entities.Table;
import bakery.entities.bakedFoods.interfaces.Bread;
import bakery.entities.bakedFoods.interfaces.Cake;
import bakery.entities.drinks.interfaces.Tea;
import bakery.entities.drinks.interfaces.Water;
import bakery.entities.tables.interfaces.InsideTable;
import bakery.entities.tables.interfaces.OutsideTable;
import bakery.repositories.interfaces.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static bakery.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;
import static bakery.common.ExceptionMessages.TABLE_EXIST;
import static bakery.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private FoodRepository<BakedFood> food;
    private DrinkRepository<Drink> drink;
    private TableRepository<Table> table;
    private double totalIncome = 0;

    // FoodRepository<BakedFood> food, DrinkRepository<Drink> drink,TableRepository<Table> table

    public ControllerImpl(FoodRepository<BakedFood> food, DrinkRepository<Drink> drink, TableRepository<Table> table) {
        this.food = new FoodRepositoryImpl<>();
        this.drink = new DrinkRepositoryImpl<>();
        this.table = new TableRepositoryImpl<>();

    }


    @Override
    public String addFood(String type, String name, double price) {
        BakedFood bakedFood;

        List<BakedFood> foodCheckIfExist = this.food.getAll().stream().filter(f -> f.getName().equals(name))
                .collect(Collectors.toList());

        if (!foodCheckIfExist.isEmpty()) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }

        switch (type) {
            case "Bread": {
                bakedFood = new Bread(name, price);

                food.add(bakedFood);

                break;
            }
            case "Cake": {
                bakedFood = new Cake(name, price);

                food.add(bakedFood);

                break;
            }
        }

        return String.format(FOOD_ADDED, name, type);
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        Drink drinkType;

        List<Drink> drinkCheckIfExist = this.drink.getAll().stream().filter(f -> f.getName().equals(name))
                .collect(Collectors.toList());

        if (!drinkCheckIfExist.isEmpty()) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }

        switch (type) {
            case "Tea": {
                drinkType = new Tea(name, portion, 2.50, brand);

                drink.add(drinkType);

                break;
            }
            case "Water": {
                drinkType = new Water(name, portion, 1.50, brand);

                drink.add(drinkType);

                break;
            }
        }
        return String.format(DRINK_ADDED, name, brand);

    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table tableType;

        List<Table> checkIfTableExist = this.table.getAll().stream().filter(f -> f.getTableNumber() == tableNumber)
                .collect(Collectors.toList());

        if (!checkIfTableExist.isEmpty()) {
            throw new IllegalArgumentException(String.format(TABLE_EXIST, tableNumber));
        }
        switch (type) {
            case "InsideTable": {
                tableType = new InsideTable(tableNumber, capacity, 2.50);

                table.add(tableType);

                break;
            }
            case "OutsideTable": {
                tableType = new OutsideTable(tableNumber, capacity, 3.50);

                table.add(tableType);

                break;
            }
        }

        return String.format(TABLE_ADDED, tableNumber);

    }

    @Override
    public String reserveTable(int numberOfPeople) {
        Table tableType;

        List<Table> findTableForXPeople = this.table.getAll().stream().filter(f -> f.getCapacity() >= numberOfPeople
                && !f.isReserved())
                .collect(Collectors.toList());

        if (findTableForXPeople.isEmpty()) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }
        findTableForXPeople.get(0).reserve(numberOfPeople);

        int numOfTableToReserve = findTableForXPeople.get(0).getTableNumber();

        return String.format(TABLE_RESERVED, numOfTableToReserve, numberOfPeople);

    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        BakedFood currFood;
        Table tableType;

        List<Table> findIfTableExist = this.table.getAll().stream().filter(f -> f.getTableNumber() == tableNumber
                && f.isReserved())
                .collect(Collectors.toList());

        if (findIfTableExist.isEmpty()) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        List<BakedFood> findFoodIfExist = this.food.getAll().stream().filter(f -> f.getName().equals(foodName))
                .collect(Collectors.toList());

        if (findFoodIfExist.isEmpty()) {
            return String.format(NONE_EXISTENT_FOOD, foodName);
        }

        findIfTableExist.get(0).orderFood(findFoodIfExist.get(0));

        return String.format(FOOD_ORDER_SUCCESSFUL, tableNumber, foodName);

    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {

        List<Table> findIfTableExist = this.table.getAll().stream().filter(f -> f.getTableNumber() == tableNumber
                && f.isReserved())
                .collect(Collectors.toList());

        if (findIfTableExist.isEmpty()) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        List<Drink> findIfDrinkExist = this.drink.getAll().stream().filter(f -> f.getName().equals(drinkName))
                .collect(Collectors.toList());

        if (findIfDrinkExist.isEmpty()) {
            return String.format(NON_EXISTENT_DRINK, drinkName, drinkBrand);
        }

        findIfTableExist.get(0).orderDrink(findIfDrinkExist.get(0));


        return String.format(DRINK_ORDER_SUCCESSFUL, tableNumber, drinkName, drinkBrand);

    }

    @Override
    public String leaveTable(int tableNumber) {

        List<Table> findTableForLeave = this.table.getAll().stream().filter(f -> f.getTableNumber() == tableNumber
                && f.isReserved())
                .collect(Collectors.toList());

        double result = findTableForLeave.get(0).getBill();
        double allPersonPriceCalc = findTableForLeave.get(0).getPrice();


        totalIncome += (result + allPersonPriceCalc);

        findTableForLeave.get(0).clear();
        return String.format(BILL, tableNumber, result + allPersonPriceCalc);

    }

    @Override
    public String getFreeTablesInfo() {
        List<Table> notReservedTable = this.table.getAll().stream().filter(f -> !f.isReserved())
                .collect(Collectors.toList());

        notReservedTable.get(0).getFreeTableInfo();

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < notReservedTable.size() ; i++) {
            output.append(notReservedTable.get(i).getFreeTableInfo());
        }
        return output.toString().trim();

    }

    @Override
    public String getTotalIncome() {

        return String.format(TOTAL_INCOME, totalIncome);

    }
}
