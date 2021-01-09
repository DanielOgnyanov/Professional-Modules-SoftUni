import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols__04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("");

        Map<String, Integer> elements = new TreeMap<>();
        if (input[0].equals("")) {
            return;
        }

        for (int i = 0; i < input.length; i++) {
            String currElements = input[i];

            elements.putIfAbsent(currElements, 0);
            elements.put(currElements, elements.get(currElements) + 1);


        }

        for (Map.Entry<String, Integer> print : elements.entrySet()) {
            System.out.printf("%s: %d time/s\n", print.getKey(), print.getValue());
        }
    }
}
