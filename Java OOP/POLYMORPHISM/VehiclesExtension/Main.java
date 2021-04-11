package Polymorphism.VehiclesExtension;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicles> vehiclesMap = new LinkedHashMap<>();

        vehiclesMap.put("Car", createVehicle(scanner.nextLine().split("\\s+")));
        vehiclesMap.put("Truck", createVehicle(scanner.nextLine().split("\\s+")));


        Bus bus = createBus(scanner.nextLine().split("\\s+"));
        vehiclesMap.put("Bus", bus);
        int commandCount = Integer.parseInt(scanner.nextLine());

        while (commandCount-- > 0) {

            String command = scanner.nextLine();
            String[] operations = command.split("\\s+");
            double distance = Double.parseDouble(operations[2]);

            if (command.contains("Drive") && command.contains("Bus")) {
                System.out.println(bus.driveWithPeople(distance));
            } else if (command.contains("Drive")) {
                System.out.println(vehiclesMap.get(operations[1]).drive(distance));
            } else {
                try {
                    vehiclesMap.get(operations[1]).refuel(distance);
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

        for (Vehicles print : vehiclesMap.values()) {
            System.out.println(print.toString());
        }


    }

    private static Bus createBus(String[] tokens) {

        return  new Bus(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]),
                Double.parseDouble(tokens[3]));
    }

    private static Vehicles createVehicle(String[] tokens) {


        switch (tokens[0]) {

            case "Car":
                return new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]),
                        Double.parseDouble(tokens[3]));

            case "Truck":
                return new Truck(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]),
                        Double.parseDouble(tokens[3]));
            case "Bus":
                return createBus(tokens);
            default:
                throw new IllegalStateException("Unknown Polymorphism.Vehicles type for " + tokens[0]);

        }


    }
}
