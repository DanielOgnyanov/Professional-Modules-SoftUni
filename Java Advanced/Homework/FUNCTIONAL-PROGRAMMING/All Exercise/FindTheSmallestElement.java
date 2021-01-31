package FunctionalProgramming;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> num = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::new).collect(Collectors.toList());


        Function<List<Integer>, Integer> findMinValueIndex = e -> {
            Iterator<Integer> iterator = num.iterator();
            int min = iterator.next();
            int index = num.lastIndexOf(min);
            while (iterator.hasNext()) {
                int curr = iterator.next();
                if (curr < min) {
                    min = curr;
                }
            }
            return index;
        };
        System.out.println(findMinValueIndex.apply(num));
    }
}
