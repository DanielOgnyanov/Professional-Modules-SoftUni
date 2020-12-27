import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class BasicStackOperations__02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> elements = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int pushNum = elements.get(0);
        int removeNum = elements.get(1);
        int toCheck = elements.get(2);

        ArrayDeque<Integer> num = Arrays.stream(scanner.nextLine().split("\\s+")).
                map(Integer::parseInt).limit(pushNum).collect(Collectors.toCollection(ArrayDeque::new));

        for (int i = 0; i < removeNum; i++) {
            num.removeLast();
        }

        if (num.isEmpty()) {
            System.out.println(0);
            return;
        }

        if (num.contains(toCheck)) {
            System.out.println("true");
        }
        if (!num.contains(toCheck)) {
            List<Integer> allNum = new ArrayList<>(num);
            int min = allNum.stream().min(Comparator.naturalOrder()).get();

            System.out.println(min);
        }
    }
}
