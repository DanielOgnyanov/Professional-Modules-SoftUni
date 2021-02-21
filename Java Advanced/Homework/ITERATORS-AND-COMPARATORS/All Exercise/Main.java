package IteratorsAndComparators.Froggy;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> allNumbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::new).collect(Collectors.toList());

        String command = scanner.nextLine();
        Lake lake = new Lake(allNumbers);

        if (command.equals("END")) {
            lake.fillTheList();
            lake.toPrint();
        }
    }
}
