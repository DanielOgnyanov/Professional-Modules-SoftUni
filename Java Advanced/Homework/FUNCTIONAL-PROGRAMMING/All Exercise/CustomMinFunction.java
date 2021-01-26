package FunctionalProgramming;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> num = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::new).collect(Collectors.toSet());

        Function<Set<Integer>, Integer> minValue = e -> {
            Iterator<Integer> iterator = num.iterator();
            int min = iterator.next();

            while (iterator.hasNext()) {
                int curr = iterator.next();
                if (curr < min) {
                    min = curr;
                }
            }
            return min;
        };

        System.out.println(minValue.apply(num));
    }
}
