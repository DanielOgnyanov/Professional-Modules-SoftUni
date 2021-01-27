package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> num = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Function<Integer, Integer> plus = e -> e + 1;
        Function<Integer, Integer> minus = e -> e - 1;
        Function<Integer, Integer> multi = e -> e * 2;
        Consumer<Integer> print = e -> System.out.printf("%d ", e);

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            switch (command) {

                case "add":
                    for (int i = 0; i < num.size(); i++) {
                        num.set(i, plus.apply(num.get(i)));
                    }
                    break;

                case "subtract":
                    for (int i = 0; i < num.size(); i++) {
                        num.set(i, minus.apply(num.get(i)));
                    }
                    break;

                case "multiply":
                    for (int i = 0; i < num.size(); i++) {
                        num.set(i, multi.apply(num.get(i)));
                    }
                    break;

                case "print":
                    for (int i = 0; i < num.size(); i++) {
                        print.accept(num.get(i));
                    }
                    System.out.println();

                    break;
            }

            command = scanner.nextLine();
        }
    }
}
