package DefiningClasses.RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCar = Integer.parseInt(scanner.nextLine());

        List<Car> allCars = new ArrayList<>();


        for (int i = 0; i < numCar; i++) {
            String command = scanner.nextLine();
            String[] operations = command.split("\\s+");

            String model = operations[0];
            String engineSpeed = operations[1];
            int enginePower = Integer.parseInt(operations[2]);
            String cargoWeight = operations[3];
            String cargoType = operations[4];

            double pressureOne = Double.parseDouble(operations[5]);
            int ageOne = Integer.parseInt(operations[6]);

            double pressureTwo = Double.parseDouble(operations[7]);
            int ageTwo = Integer.parseInt(operations[8]);

            double pressureThree = Double.parseDouble(operations[9]);
            int ageThree = Integer.parseInt(operations[10]);

            double pressureFour = Double.parseDouble(operations[11]);
            int ageFour = Integer.parseInt(operations[12]);

            Car car = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType, pressureOne,
                    pressureTwo, pressureThree, pressureFour);

            allCars.add(car);
        }

        String typeToCheck = scanner.next();

        if(typeToCheck.equals("fragile")){
            for (Car toPrint : allCars) {
                if(toPrint.cargoType.equals("fragile")){
                    if(toPrint.tireOnePressure < 1 || toPrint.tireTwoPressure < 1
                    || toPrint.tireThreePressure < 1 || toPrint.tireFourPressure < 1){
                        System.out.println(toPrint.model);
                    }
                }
            }

        } else if (typeToCheck.equals("flamable")){
            for (Car toPrint : allCars) {
                if(toPrint.cargoType.equals("flamable")){
                    if(toPrint.enginePower > 250){
                        System.out.println(toPrint.model);
                    }

                }
            }
        }
    }
}
