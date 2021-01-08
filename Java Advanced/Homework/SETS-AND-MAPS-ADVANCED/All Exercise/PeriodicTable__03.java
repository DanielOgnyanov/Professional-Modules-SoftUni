import java.util.*;

public class PeriodicTable__03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        Set<String> allElements = new LinkedHashSet<>();

        for (int i = 0; i < count; i++) {
            String[] elements = scanner.nextLine().split("\\s+");
            allElements.addAll(Arrays.asList(elements));


        }
        List<String> toReverse = new ArrayList<>(allElements);
        Collections.sort(toReverse);

        for (String print : toReverse) {
            System.out.print(print + " ");
        }
    }
}
