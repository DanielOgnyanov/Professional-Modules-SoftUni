import java.util.*;
import java.util.stream.Collectors;

public class BasicQueueOperations__04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> elements = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int numToAdd = elements.get(0);
        int numToRemove = elements.get(1);
        int numToCheck = elements.get(2);

        ArrayDeque<Integer> num = Arrays.stream(scanner.nextLine().split("\\s+")).
                map(Integer::parseInt).limit(numToAdd).collect(Collectors.toCollection(ArrayDeque::new));

        for (int i = 0; i < numToRemove; i++) {
            num.remove();
        }
        if (num.isEmpty()) {
            System.out.println(0);
            return;
        }

        if (num.contains(numToCheck)) {
            System.out.println("true");
            return;
        } else {
            List<Integer> allNum = new ArrayList<>(num);
            int min = allNum.stream().min(Comparator.naturalOrder()).get();

            System.out.println(min);

        }
    }
}
