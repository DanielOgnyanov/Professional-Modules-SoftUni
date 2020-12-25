import java.util.*;
import java.util.stream.Collectors;

public class ReverseNumbersWithAStack__01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> num = Arrays.stream(scanner.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        Iterator reverse = num.descendingIterator();

        while (reverse.hasNext()) {
            System.out.printf(reverse.next() + " ");
        }


    }
}
