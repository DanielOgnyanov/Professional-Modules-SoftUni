import java.util.*;
import java.util.stream.Collectors;

public class MaximumElement__03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int command = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> num = new ArrayDeque<>();

        for (int i = 0; i < command; i++) {
            String currNumOperations = scanner.nextLine();
            String[] index = currNumOperations.split("\\s+");
            String nameOperations = index[0];

            switch (nameOperations) {
                case "1":
                    int numToPush = Integer.parseInt(index[1]);
                    num.push(numToPush);
                    break;

                case "2":
                    num.removeFirst();
                    break;

                case "3":
                    List<Integer> max = new ArrayList<>(num);
                    int maxNum = max.stream().max(Comparator.naturalOrder()).get();
                    System.out.println(maxNum);
                    break;
            }
        }
    }
}
