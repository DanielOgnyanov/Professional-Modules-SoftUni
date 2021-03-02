package EXAM.Exam22Feb2020;

import java.util.*;
import java.util.stream.Collectors;

public class Lootbox__01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> first = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::new).collect(Collectors.toCollection(ArrayList::new));

        List<Integer> second = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::new).collect(Collectors.toCollection(ArrayList::new));

        int valueToPrint = 0;
        for (int i = 0; i < first.size(); i++) {
            int curr = first.get(i);
            for (int j = second.size() - 1; j >= 0; j--) {
                int currTwo = second.get(j);
                int sum = first.get(i) + second.get(j);
                if (sum % 2 == 0) {
                    valueToPrint += sum;
                    first.remove(i);
                    second.remove(j);
                    i--;
                    break;
                } else {
                    int valueToAddInTheFirst = second.get(j);
                    first.add(first.size() - 1, valueToAddInTheFirst);
                    Collections.swap(first, first.size() - 2, first.size() - 1);
                    second.remove(j);
                    i--;
                    break;
                }

            }

        }

        if (first.isEmpty()) {
            System.out.println("First lootbox is empty");
            if (valueToPrint >= 100) {
                System.out.printf("Your loot was epic! Value: %d\n", valueToPrint);
            } else {
                System.out.printf("Your loot was poor... Value: %d\n", valueToPrint);
            }
        } else if (second.isEmpty()) {
            System.out.println("Second lootbox is empty");
            if (valueToPrint >= 100) {
                System.out.printf("Your loot was epic! Value: %d\n", valueToPrint);
            } else {
                System.out.printf("Your loot was poor... Value: %d\n", valueToPrint);
            }
        }
    }
}
