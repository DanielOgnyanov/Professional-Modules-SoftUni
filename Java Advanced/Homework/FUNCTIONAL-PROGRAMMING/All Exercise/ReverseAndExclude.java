package FunctionalProgramming;

import java.util.*;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::new).collect(Collectors.toList());

        int divisible = Integer.parseInt(scanner.nextLine());

        List<Integer> toPrint = input
                .stream()
                .collect(Collectors.toList())
                .stream()
                .filter(e -> e % divisible != 0)
                .collect(Collectors.toList());
                 Collections.reverse(toPrint);

        toPrint.forEach(e -> System.out.print(e + " "));
    }
}
