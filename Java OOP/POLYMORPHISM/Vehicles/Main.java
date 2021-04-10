package Polymorphism.Vehicles;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        Vehicles car = new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));


        tokens = scanner.nextLine().split("\\s+");

        Vehicles truck = new Truck(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));

        int commandCount = Integer.parseInt(scanner.nextLine());

        while (commandCount-- > 0) {

            String command = scanner.nextLine();
            String[] operations = command.split("\\s+");
            double distance = Double.parseDouble(operations[2]);

            if(command.contains("Drive")) {
                if(operations[1].equals("Car")) {
                    System.out.println(car.drive(distance));
                } else {
                    System.out.println(truck.drive(distance));
                }


            } else {
                if(operations[1].equals("Car")) {
                   car.refuel(distance);
                } else {
                  truck.refuel(distance);
                }
            }
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
    }
}
