package Generics.CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> customList = new CustomList<>();
        List<String> listOfElements = new ArrayList<>();

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            String[] operations = command.split("\\s+");
            String typeCommand = operations[0];

            switch (typeCommand) {

                case "Add":
                    String elementToAdd = operations[1];
                    customList.add(elementToAdd);
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(operations[1]);
                    customList.remove(indexToRemove);
                    break;
                case "Contains":
                    String checkContain = operations[1];
                    customList.contains(checkContain);

                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(operations[1]);
                    int secondIndex = Integer.parseInt(operations[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    String findGreater = operations[1];
                    customList.greater(customList.list, findGreater);
                    break;
                case "Max":
                    customList.maxValue(customList.list);
                    break;
                case "Min":
                    customList.minValue(customList.list);
                    break;
                case "Print":
                    customList.print();
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
