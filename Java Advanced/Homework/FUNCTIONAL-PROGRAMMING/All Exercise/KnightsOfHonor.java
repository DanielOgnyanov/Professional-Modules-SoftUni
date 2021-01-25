package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> print = e -> System.out.printf("Sir %s\n", e);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(print);
    }
}
