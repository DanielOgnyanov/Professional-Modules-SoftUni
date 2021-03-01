package dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    public String name;
    public int capacity;
    public List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }


    public void add(Car car) {
        if (this.capacity > this.data.size()) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                this.data.remove(car);
                return true;
            }

        }
        return false;
    }

    public Car getLatestCar() {
        Car result = null;

        for (Car car : data) {
            if (result == null || car.getYear() > result.getYear()) {
                result = car;
            }
        }
        return result;
    }

    public Car getCar(String manufacturer, String model) {
        Car result = null;
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                result = car;
            }

        }
        return result;

    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("The cars are in a car dealership %s:", name))
                .append(System.lineSeparator());

        for (Car car : data) {
            output.append(car).append(System.lineSeparator());

        }
        return output.toString().trim();
    }
}
