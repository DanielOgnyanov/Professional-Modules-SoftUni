package IteratorsAndComparators.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        List<String> allPeople = new ArrayList<>();
        while (!command.equals("END")) {
            allPeople.add(command);
            command = scanner.nextLine();
        }

        int indexToCompare = Integer.parseInt(scanner.nextLine());
        String nameToCompare = allPeople.get(indexToCompare - 1);
        if (allPeople.size() - 1 < 2) {
            allPeople.remove(nameToCompare);
        }
        int size = allPeople.size();
        Person<String> person = new Person<>();
        int countEquals = person.comparing(allPeople, nameToCompare);

        if (countEquals != 0) {
            System.out.print(countEquals + " ");
            System.out.print(size - countEquals + " ");
            System.out.print(size);
        } else {
            System.out.println("No matches");
        }

    }
}
