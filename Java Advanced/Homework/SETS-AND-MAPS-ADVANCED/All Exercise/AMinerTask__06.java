import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask__06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> allResources = new LinkedHashMap<>();
        while (true) {
            String resourceName = scanner.nextLine();
            if (resourceName.equals("stop")) {
                break;
            }
            int quantity = Integer.parseInt(scanner.nextLine());
            if (allResources.containsKey(resourceName)) {
                allResources.put(resourceName, allResources.get(resourceName) + quantity);
            } else {
                allResources.put(resourceName, quantity);
            }

        }

        for (Map.Entry<String, Integer> print : allResources.entrySet()) {
            System.out.printf("%s -> %s\n", print.getKey(), print.getValue());
        }
    }
}
