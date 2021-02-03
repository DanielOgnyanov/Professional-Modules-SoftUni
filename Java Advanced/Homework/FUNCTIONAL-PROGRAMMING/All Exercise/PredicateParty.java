package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Party!")) {
            String[] operations = command.split("\\s+");
            String typeCommand = operations[0];

            switch (typeCommand) {
                case "Remove":
                    String typeOfChangesToDo = operations[1];
                    String criteria = operations[2];

                    if (typeOfChangesToDo.equals("StartsWith")) {
                        for (int i = 0; i < input.size(); i++) {
                            if (input.get(i).startsWith(criteria)) {
                                input.remove(i);
                                i--;
                            }
                        }
                    } else if (typeOfChangesToDo.equals("EndsWith")) {
                        for (int i = 0; i < input.size(); i++) {
                            if (input.get(i).endsWith(criteria)) {
                                input.remove(i);
                                i--;
                            }
                        }
                    } else {
                        int len = Integer.parseInt(criteria);
                        for (int i = 0; i < input.size(); i++) {
                            if (len == input.get(i).length()) {
                                input.remove(i);
                                i--;
                            }
                        }

                    }
                    break;

                case "Double":
                    typeOfChangesToDo = operations[1];
                    criteria = operations[2];
                    int size = input.size();
                    if (typeOfChangesToDo.equals("StartsWith")) {
                        for (int i = 0; i < size; i++) {
                            String currInput = input.get(i);
                            if (input.get(i).startsWith(criteria)) {
                                input.add(currInput);
                            }
                        }
                    } else if (typeOfChangesToDo.equals("EndsWith")) {
                        for (int i = 0; i < size; i++) {
                            String currInput = input.get(i);
                            if (input.get(i).endsWith(criteria)) {
                                input.add(currInput);
                            }
                        }
                    } else {
                        int len = Integer.parseInt(criteria);
                        for (int i = 0; i < size; i++) {
                            String currInput = input.get(i);
                            if (len == input.get(i).length()) {
                                input.add(currInput);
                            }
                        }
                    }

                    break;
            }


            command = scanner.nextLine();
        }

        if (!input.isEmpty()) {
            Collections.sort(input);
            for (int i = 0; i < input.size(); i++) {
                if (input.size() - 1 == i) {
                    System.out.print(input.get(i));
                } else {
                    System.out.print(input.get(i) + ", ");
                }
            }
            System.out.print(" are going to the party!");
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }
}
