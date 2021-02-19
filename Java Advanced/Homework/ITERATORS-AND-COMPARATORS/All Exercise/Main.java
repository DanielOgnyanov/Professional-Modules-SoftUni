package IteratorsAndComparators.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elements = Arrays.stream(scanner.nextLine().split("\\s+"))
                .skip(1).collect(Collectors.toCollection(ArrayList::new));

        Collection collection = new Collection(elements);
        String command = scanner.nextLine();

        while (!command.equals("END")) {

            switch (command) {

                case "Move":
                    System.out.println(collection.move());
                    break;
                case "Print":
                    System.out.println(collection.print());
                    break;
                case "HasNext":
                    System.out.println(collection.hasNext());
                    break;

                case "PrintAll":
                    collection.printAll();
            }


            command = scanner.nextLine();
        }
    }
}
