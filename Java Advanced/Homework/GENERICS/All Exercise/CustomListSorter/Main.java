package Generics.CustomListSorter;

import Generics.CustomListSorter.CustomListSorter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomListSorter<String> stringCustomListSorter = new CustomListSorter<String>();
        String command = scanner.nextLine();

        while (!command.equals("END")) {
            String[] operations = command.split("\\s+");
            String typeCommand = operations[0];

            switch (typeCommand) {

                case "Add":
                    String elementToAdd = operations[1];
                    stringCustomListSorter.add(elementToAdd);
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(operations[1]);
                    stringCustomListSorter.remove(indexToRemove);
                    break;
                case "Contains":
                    String checkContain = operations[1];
                    stringCustomListSorter.contains(checkContain);
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(operations[1]);
                    int secondIndex = Integer.parseInt(operations[2]);
                    stringCustomListSorter.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    String findGreater = operations[1];
                    stringCustomListSorter.greater(stringCustomListSorter.list, findGreater);
                    break;
                case "Max":
                    stringCustomListSorter.maxValue(stringCustomListSorter.list);
                    break;
                case "Min":
                    stringCustomListSorter.minValue(stringCustomListSorter.list);
                    break;
                case "Print":
                    stringCustomListSorter.print();
                    break;
                case "Sort":
                    stringCustomListSorter.sorter();
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
