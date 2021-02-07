package DefiningClasses.CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int motorCount = Integer.parseInt(scanner.nextLine());
        List<Car.Engine> engines = new ArrayList<>();

        for (int i = 0; i < motorCount; i++) {
            String command = scanner.nextLine();
            String[] operations = command.split("\\s+");

            String model = operations[0];
            String power = operations[1];
            String displacement = "";
            String efficiency = "";

            if (operations.length - 1 == 2) {
                if (Character.isDigit(operations[2].charAt(0))) {
                    displacement = operations[2];
                    efficiency = "n/a";
                } else {
                    efficiency = operations[2];
                    displacement = "n/a";
                }
            } else if (operations.length - 1 == 3) {
                displacement = operations[2];
                efficiency = operations[3];
            } else {
                displacement = "n/a";
                efficiency = "n/a";
            }

            Car.Engine currEngine = new Car.Engine(model, power, displacement, efficiency);
            engines.add(currEngine);

        }

        int countCar = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < countCar; i++) {
            String command = scanner.nextLine();
            String[] operations = command.split("\\s+");

            String model = operations[0];
            String engine = operations[1];
            String weight = "";
            String color = "";

            if (operations.length - 1 == 2) {
                if (Character.isDigit(operations[2].charAt(0))) {
                    weight = operations[2];
                    color = "n/a";

                } else {
                    color = operations[2];
                    weight = "n/a";
                }
            } else if (operations.length - 1 == 3) {
                weight = operations[2];
                color = operations[3];
            } else {
                weight = "n/a";
                color = "n/a";
            }

            Car currCar = new Car(model, engine, weight, color);
            cars.add(currCar);

        }

        for (Car toPrintCar : cars) {
            System.out.printf("%s:\n", toPrintCar.model);
            System.out.printf("%s:\n", toPrintCar.engine);
            for (Car.Engine engineToPrint : engines) {
                if (toPrintCar.engine.equals(engineToPrint.model)) {
                    System.out.printf("Power: %s\n", engineToPrint.power);
                    System.out.printf("Displacement: %s\n", engineToPrint.displacement);
                    System.out.printf("Efficiency: %s\n", engineToPrint.efficiency);
                }
            }
            System.out.printf("Weight: %s\n", toPrintCar.weight);
            System.out.printf("Color: %s\n", toPrintCar.color);
        }
    }
}
