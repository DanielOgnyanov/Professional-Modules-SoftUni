package FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int range = Integer.parseInt(scanner.nextLine());

        List<Integer> sequenceOfDivisible = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::new).collect(Collectors.toList());
        List<Integer> divisibleNumSave = new ArrayList<>();

        int count = 0;
        for (int i = 1; i <= range; i++) {
            for (int j = 0; j < sequenceOfDivisible.size(); j++) {
                if (i % sequenceOfDivisible.get(j) == 0) {
                    count++;
                }

                if (count == sequenceOfDivisible.size()) {
                    divisibleNumSave.add(i);
                    count = 0;
                }
            }
            count = 0;
        }

        divisibleNumSave.forEach(e -> System.out.print(e + " "));
    }
}
