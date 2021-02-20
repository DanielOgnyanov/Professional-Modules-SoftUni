package IteratorsAndComparators.StackIterator;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.stream(scanner.nextLine().split(" |, ")).skip(1)
                .collect(Collectors.toCollection(ArrayList::new));

        ArrayDeque<String> elements = new ArrayDeque<>();

        for (String toAdd : input) {
            elements.push(toAdd);
        }

        String command = scanner.nextLine();
        Stack stack = new Stack(elements);
        while (!command.equals("END")) {
            String[] operations = command.split("\\s+");
            String typeOfOperationToDo = operations[0];
            switch (typeOfOperationToDo) {
                case "Pop":
                    stack.pop();
                    break;
                case "Push":
                    stack.elementToPush = operations[1];
                    stack.push();
                    break;
            }

            command = scanner.nextLine();
        }

        stack.toPrint();
        stack.toPrint();
    }
}
